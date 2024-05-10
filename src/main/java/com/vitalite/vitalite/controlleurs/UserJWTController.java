package com.vitalite.vitalite.controlleurs;


import lombok.RequiredArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vitalite.vitalite.config.JwtAuthentificationFilter;
import com.vitalite.vitalite.config.JwtService;
import com.vitalite.vitalite.security.UserRepository;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserJWTController {


    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

   

    @PostMapping("/authenticate")
    public ResponseEntity<JWTToken> authorize(@Valid @RequestBody AuthenticationRequest loginVM) {

        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(loginVM.getEmail(), loginVM.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
       
       String jwtToken = jwtService.createToken(authentication, true);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwtToken);
      //  System.out.println("============================"+httpHeaders);
        return new ResponseEntity<>(new JWTToken(jwtToken), httpHeaders, HttpStatus.CREATED);
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class JWTToken {

        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }
}
