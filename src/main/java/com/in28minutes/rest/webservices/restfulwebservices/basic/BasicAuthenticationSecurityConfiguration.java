package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return
                http
                        .authorizeHttpRequests(
                                auth -> auth
                                        .mvcMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Everyone can send OPTIONS requests
                                        .anyRequest().authenticated() // All requests should be authenticated
                        )
                        .httpBasic(Customizer.withDefaults()) // Popup will come up instead of a web page, this is called basic authentication
                        .sessionManagement(
                                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        )
                        .csrf().disable()
                        .build();
    }

}
