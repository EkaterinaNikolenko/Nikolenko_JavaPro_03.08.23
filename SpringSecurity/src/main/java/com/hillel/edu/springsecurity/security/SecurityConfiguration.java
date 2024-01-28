package com.hillel.edu.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/ping").permitAll()
                .requestMatchers("/products").permitAll()
                .requestMatchers("/products/save").hasRole(Role.ADMIN.name())
                .requestMatchers("/products/remove/**").hasRole(Role.ADMIN.name())
                .requestMatchers("/products/getProduct/{id}").hasRole(Role.USER.name())
                .anyRequest().authenticated());

        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable);
        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = org.springframework.security.core.userdetails.User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .roles(Role.USER.name())
                .build();

        UserDetails admin = org.springframework.security.core.userdetails.User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles(Role.ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
