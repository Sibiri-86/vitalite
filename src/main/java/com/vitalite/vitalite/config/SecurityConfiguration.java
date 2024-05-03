package com.vitalite.vitalite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import com.vitalite.vitalite.security.Role;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

	private final JwtAuthentificationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return	http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/api/register").permitAll()
            .requestMatchers("/api/activate").permitAll()
            .requestMatchers("/api/authenticate").permitAll()
            .requestMatchers("/api/account/reset-password/init").permitAll()
            .requestMatchers("/api/account/reset-password/finish").permitAll()
            .requestMatchers("/api/**").permitAll()
            .requestMatchers("/management/health").permitAll()
            .requestMatchers("/management/info").permitAll()
            .requestMatchers("/management/**").hasAuthority(Role.ADMIN.name())
            .anyRequest().authenticated()
            )
        
        .sessionManagement(httpSecuritySessionManagementConfig ->
        httpSecuritySessionManagementConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
        )
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
       
        
        
		
	}

   
}
