package com.servicedto.techiteasy.config;


import com.servicedto.techiteasy.filter.JwtRequestFilter;
import com.servicedto.techiteasy.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;
    private final PasswordEncoder passwordEncoder;

    public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter, PasswordEncoder passwordEncoder) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.passwordEncoder = passwordEncoder;
    }


    // PasswordEncoderBean. Deze kun je overal in je applicatie injecteren waar nodig.
    // Je kunt dit ook in een aparte configuratie klasse zetten.
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    // Authenticatie met customUserDetailsService en passwordEncoder
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        var auth = new DaoAuthenticationProvider();
        auth.setPasswordEncoder(passwordEncoder);
        auth.setUserDetailsService(customUserDetailsService);
        return new ProviderManager(auth);
    }


    // Authorizatie met jwt
    @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception {

        //JWT token authentication
        http
                .csrf(csrf -> csrf.disable())
                .httpBasic(basic -> basic.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                        auth
                                // Wanneer je deze uncomments, staat je hele security open. Je hebt dan alleen nog een jwt nodig.
//                                .requestMatchers("/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/cimodules").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/cimodules/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/cimodules/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/remote-controllers").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/remote-controllers/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/remote-controllers/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/televisions").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/televisions/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/televisions/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/wall-brackets").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/wall-brackets/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/wall-brackets/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/users/**").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/cimodules").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/remote-controllers").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/televisions").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/wall-brackets").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/authenticated").authenticated()
                                .requestMatchers("/authenticate").permitAll()/*alleen dit punt mag toegankelijk zijn voor niet ingelogde gebruikers*/
                                .anyRequest().denyAll() /*Deze voeg je altijd als laatste toe, om een default beveiliging te hebben voor eventuele vergeten endpoints of endpoints die je later toevoegt. */
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}