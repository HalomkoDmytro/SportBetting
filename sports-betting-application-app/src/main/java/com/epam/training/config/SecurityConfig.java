package com.epam.training.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user", "/user/**")
                .hasAnyRole("PLAYER")
                .anyRequest().permitAll()
                .and().cors().disable();

        http.formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/sign-in-handler")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/sportEvent/history")
                .failureUrl("/signin");

        http.logout()
                .logoutUrl("/sign-out")
                .logoutSuccessUrl("/signin")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user@a")
                .password("password")
                .roles("PLAYER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }
}
