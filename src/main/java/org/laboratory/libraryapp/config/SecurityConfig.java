package org.laboratory.libraryapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//
//import java.util.List;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig implements WebMvcConfigurer{

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        corsConfiguration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }



//    private final PasswordEncoder passwordEncoder;
//    private final UserDetailsService userDetailsService;
//
//    public SecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
//        this.passwordEncoder = passwordEncoder;
//        this.userDetailsService = userDetailsService;
//    }
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return authenticationManagerBean();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder);
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  {
//
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests( (requests) -> requests
//                        .anyRequest()
//                        .hasAnyRole("ADMIN", "USER", "LIBRARIAN")
//                )
//                .formLogin((form) -> form
//                        .permitAll()
//                        .failureUrl("/login?error=BadCredentials")
//                        .defaultSuccessUrl("/books", true)
//                )
//                .logout((logout) -> logout
//                        .logoutUrl("/logout")
//                        .clearAuthentication(true)
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID")
//                        .logoutSuccessUrl("/login")
//                )
//                .exceptionHandling((ex) -> ex
//                        .accessDeniedPage("/access_denied")
//                );
//
//        return http.build();
//    }
//
//
////     In Memory Authentication
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails librarian1 = User.builder()
//                .username("librarian1")
//                .password(passwordEncoder.encode("librarian1"))
//                .roles("LIBRARIAN")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user1 = User.builder()
//                .username("user1")
//                .password(passwordEncoder.encode("user1"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(librarian1, user1, admin);
//    }

}
