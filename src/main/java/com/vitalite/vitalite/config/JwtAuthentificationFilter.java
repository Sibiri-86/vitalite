package com.vitalite.vitalite.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class JwtAuthentificationFilter extends OncePerRequestFilter{


    private final JwtService jwtService;
    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    protected void doFilterInternal(
     @NonNull  HttpServletRequest request,
     @NonNull HttpServletResponse response, 
     @NonNull FilterChain filterChain)
            throws ServletException, IOException {
                final String jwt;




          HttpServletRequest httpServletRequest = (HttpServletRequest) request;
          jwt = resolveToken(httpServletRequest);
        if (StringUtils.hasText(jwt) && this.jwtService.validateToken(jwt)) {
            Authentication authentication = this.jwtService.getAuthentication(jwt);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }   
       filterChain.doFilter(request, response);
    }



    private String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
    

    
}
