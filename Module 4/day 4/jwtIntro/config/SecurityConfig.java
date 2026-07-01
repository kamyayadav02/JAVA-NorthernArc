package org.northernarc.jwtdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    PasswordEncoder passwordEncoder;
//    @Bean
//    public UserDetailsService userDetailsService(){
//        System.err.println("User Details Service");
//        System.err.println("Encrypted password: " + passwordEncoder.encode("wowjava"));
//        UserDetails user2= User.builder()
//                .username("user")
//                .password(passwordEncoder.encode("hello"))
//                .roles("USER")
//                .build();
//        UserDetails admin=User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("hello"))
//                .roles("ADMIN","USER")
//                .build();
//        return new InMemoryUserDetailsManager(user2, admin);
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hello").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
