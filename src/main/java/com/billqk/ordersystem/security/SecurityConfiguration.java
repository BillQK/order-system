package com.billqk.ordersystem.security;


import com.billqk.ordersystem.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable();
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/registration/**").permitAll();
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/order").permitAll()
                .antMatchers(HttpMethod.POST, "/api/pay").permitAll()
                .antMatchers(HttpMethod.POST, "/api/menu").hasAuthority(Constant.Roles.ADMIN.name())
                .antMatchers(HttpMethod.POST).authenticated();
        http
                .httpBasic();

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

}
