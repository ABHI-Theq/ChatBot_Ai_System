package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Appconfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.builder().
                username("Abhishek").
                password(passwordEncoder().encode("Abhishek")).roles("Admin").
                        build();

        UserDetails userDetails1 = User.builder().
                username("Abhishek1").
                password(passwordEncoder().encode("Abhishek1")).roles("Admin").
                build();
        UserDetails userDetails2 = User.builder().
                username("Abhishek2").
                password(passwordEncoder().encode("Abhishek2")).roles("Admin").
                build();
        UserDetails userDetails3 = User.builder().
                username("Abhishek3").
                password(passwordEncoder().encode("Abhishek3")).roles("Admin").
                build();
        return new InMemoryUserDetailsManager(userDetails,userDetails1,userDetails2,userDetails3);
    };

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
