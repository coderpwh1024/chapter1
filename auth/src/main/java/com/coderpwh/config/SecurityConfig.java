package com.coderpwh.config;

import com.coderpwh.service.impl.JwtTokenUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Resource
    private JwtTokenUserDetailsService userDetailsService;

    /***
     * 表单提交
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .csrf()
                .disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return  super.authenticationManager();

    }


}
