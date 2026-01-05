package com.app.gestionreservationssalles.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                                // ADMIN seulement
                                .requestMatchers("/api/auth/register").hasRole("ADMIN")
//                              .requestMatchers("/api/auth/register").permitAll()

                                // SALLES
                                .requestMatchers(HttpMethod.GET, "/api/salles/**").hasAnyRole("ADMIN","EMPLOYE") // consulter
                                .requestMatchers(HttpMethod.POST, "/api/salles").hasRole("ADMIN") // créer
                                .requestMatchers(HttpMethod.PUT, "/api/salles/**").hasRole("ADMIN")  // modifier
                                .requestMatchers(HttpMethod.DELETE, "/api/salles/**").hasRole("ADMIN") // supprimer

                                // EQUIPEMENTS
                                .requestMatchers(HttpMethod.GET, "/api/equipements/**").hasAnyRole("ADMIN","EMPLOYE") // consulter
                                .requestMatchers(HttpMethod.POST, "/api/equipements/**").hasRole("ADMIN") // créer
                                .requestMatchers(HttpMethod.PATCH, "/api/equipements/**").hasRole("ADMIN")  // modifier
                                .requestMatchers(HttpMethod.DELETE, "/api/equipements/**").hasRole("ADMIN") // supprimer

                                // USERS (CRUD uniquement pour ADMIN)
                                .requestMatchers("/api/users/**").hasRole("ADMIN")

                                // RESERVATIONS
                                .requestMatchers(HttpMethod.POST,"/api/reservations").hasRole("EMPLOYE")
                                .requestMatchers(HttpMethod.GET,"/api/reservations/*").hasRole("EMPLOYE")
                                .requestMatchers(HttpMethod.GET,"/api/reservations").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/api/reservations/*/cancel").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/api/reservations/*/validate").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/api/reservations/*/reject").hasRole("ADMIN")

                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
