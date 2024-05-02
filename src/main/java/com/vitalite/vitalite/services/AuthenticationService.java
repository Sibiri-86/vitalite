package com.vitalite.vitalite.services;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vitalite.vitalite.config.ApplicationConfig;
import com.vitalite.vitalite.config.JwtService;
import com.vitalite.vitalite.controlleurs.AuthenticationRequest;
import com.vitalite.vitalite.controlleurs.AuthenticationResponse;
import com.vitalite.vitalite.controlleurs.RegisterRequest;
import com.vitalite.vitalite.security.Role;
import com.vitalite.vitalite.security.User;
import com.vitalite.vitalite.security.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private Authentication authenticationFinal;
    
    

    public AuthenticationResponse register(RegisterRequest request) {
       var user = User.builder()
       .firstname(request.getFirstname())
       .lastname(request.getLastname())
       .email(request.getEmail())
       .password(passwordEncoder.encode(request.getPassword()))
       .role(Role.USER)
       .build();
       repository.save(user); 
       var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
        .token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        
       
        Authentication authentication = authenticationManager.authenticate((
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
             request.getPassword()
            
             )
       ))
       ;
       var user = repository.findByEmail(request.getEmail())
       .orElseThrow();
       var jwtToken = jwtService.generateToken(user);
       authenticationFinal = authentication;
       return AuthenticationResponse.builder().token(jwtToken)
        .build();
    }


    /**
     * Get the login of the current user.
     *
     * @return the login of the current user
     */
   /*  public static Optional<String> getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
            .map(authentication -> {
                if (authentication.getPrincipal() instanceof UserDetails) {
                    UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                    return springSecurityUser.getUsername();
                } else if (authentication.getPrincipal() instanceof String) {
                    return (String) authentication.getPrincipal();
                }
                return null;
            });
    } */


    
    public Optional<User> getUserWithAuthorities() {

        SecurityContextHolder.getContext().setAuthentication(authenticationFinal);
        return ApplicationConfig.getCurrentUserLogin().flatMap(repository::findByEmail);
    }


   
    
   


}
