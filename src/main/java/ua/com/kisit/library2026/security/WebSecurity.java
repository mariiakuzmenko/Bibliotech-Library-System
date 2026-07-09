package ua.com.kisit.library2026.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.com.kisit.library2026.service.UsersService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity {

    private final UsersService usersService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/login", "/registration", "/images/**", "/catalog/**", "/about-us", "/contacts")
                                .permitAll()
                                .requestMatchers("/order", "/cart/**", "/addPublicationToCart","/deleteFromCart" ).hasAuthority("ROLE_READER")
                                .requestMatchers("/librarian").hasAuthority("ROLE_LIBRARIAN")
                                .requestMatchers("/admin").hasAuthority("ROLE_ADMIN")
                                .anyRequest().authenticated()

                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .defaultSuccessUrl("/", true)
                                .permitAll())
                .logout(logout ->logout.permitAll().logoutSuccessUrl("/"));

        return http.build();
    }

}
