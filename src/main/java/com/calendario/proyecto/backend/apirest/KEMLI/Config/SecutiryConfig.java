package com.calendario.proyecto.backend.apirest.KEMLI.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.calendario.proyecto.backend.apirest.KEMLI.jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration // Indica que es una clase de configuración
@EnableWebSecurity
@RequiredArgsConstructor
public class SecutiryConfig {

    private final AuthenticationProvider authProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf ->
                    csrf.disable()
                )
                .authorizeHttpRequests(authReq ->
                    authReq
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/api/clientes/**").permitAll()
                        .requestMatchers("/api/empleados/**").permitAll()
                        .requestMatchers("/api/citas/**").permitAll()
                        .requestMatchers("/api/reportes/**").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager -> 
                    sessionManager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
