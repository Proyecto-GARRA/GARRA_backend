package com.calendario.proyecto.backend.apirest.KEMLI.Config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.calendario.proyecto.backend.apirest.KEMLI.jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration // Indica que es una clase de configuración
@EnableWebSecurity
@RequiredArgsConstructor
public class SecutiryConfig {

    private final AuthenticationProvider authProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authReq -> authReq
                        .requestMatchers(
                                "/auth/**",
                                "/api/clientes/**",
                                "/api/empleados/**",
                                "/api/citas/**",
                                "/api/reportes/**")
                        .permitAll()

                        // ROOT and ADMIN endpoints
                        // .requestMatchers("/api/config").hasRole("ROOT")
                        // .requestMatchers("/api/config").hasRole("ADMIN")

                        .anyRequest().authenticated())
                .sessionManagement(sessionManager -> sessionManager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
