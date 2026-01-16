package com.app.gestionreservationssalles.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final AuthTokenFilter authTokenFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                                // AUTH
                                .requestMatchers("/api/auth/login").permitAll()
                                .requestMatchers("/api/auth/refresh-token").permitAll()

                                // SALLES
                                .requestMatchers(HttpMethod.GET, "/api/salles/**").hasAnyRole("ADMIN","EMPLOYE")
                                .requestMatchers(HttpMethod.POST, "/api/salles").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/salles/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/salles/**").hasRole("ADMIN")

                                // EQUIPEMENTS
                                .requestMatchers(HttpMethod.GET, "/api/equipements/**").hasAnyRole("ADMIN","EMPLOYE")
                                .requestMatchers(HttpMethod.POST, "/api/equipements/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/equipements/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/equipements/**").hasRole("ADMIN")

                                // USERS
                                .requestMatchers("/api/users/**").hasRole("ADMIN")

                                // RESERVATIONS
                                .requestMatchers(HttpMethod.POST,"/api/reservations").hasRole("EMPLOYE")
                                .requestMatchers(HttpMethod.GET,"/api/reservations/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET,"/api/reservations").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/api/reservations/*/cancel").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/api/reservations/*/validate").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/api/reservations/*/reject").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
