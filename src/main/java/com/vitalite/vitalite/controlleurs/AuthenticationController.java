package com.vitalite.vitalite.controlleurs;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitalite.vitalite.security.User;
import com.vitalite.vitalite.services.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    @PostMapping("/register1")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody RegisterRequest request
    ) {

        return ResponseEntity.ok(service.register(request));
    }

     @PostMapping("/authenticate1")
    public ResponseEntity<AuthenticationResponse> authenticate(
        @RequestBody AuthenticationRequest request
    ) {

        
        return ResponseEntity.ok(service.authenticate(request));
    }
 
     /**
     * GET  /authenticate : check if the user is authenticated, and return its login.
     *
     * @param request the HTTP request
     * @return the login if the user is authenticated
     */
    @GetMapping("/authenticate1")
    public String isAuthenticated(HttpServletRequest request) {
        return request.getRemoteUser();
    }


    @GetMapping("/account1")
    public ResponseEntity<User> getAccount() {
        return ResponseEntity.ok(service.getUserWithAuthorities().get());
    }
}
