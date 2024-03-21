package com.capstone.notxapp.config;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSpringSecurity {

    private final UserDetailsService userDetailsService;

    public WebSpringSecurity(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf
//                        .ignoringRequestMatchers(
//                                // Specify the endpoints to ignore for CSRF protection
//                                new AntPathRequestMatcher("/resources/**"),
//                                new AntPathRequestMatcher("/register/**"),
//                                new AntPathRequestMatcher("/admin/**"),
//                                new AntPathRequestMatcher("/post/**")
//                        )
//                )
//                .authorizeRequests()
//                .antMatchers("/resources/**").permitAll()
//                .antMatchers("/register/**").permitAll()
//                .antMatchers("/").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN", "GUEST")
//                .antMatchers("/post/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/admin/posts", true)
//                .loginProcessingUrl("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/")
//                .permitAll();
//
//        return http.build();
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
