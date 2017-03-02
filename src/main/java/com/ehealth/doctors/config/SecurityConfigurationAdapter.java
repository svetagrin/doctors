package com.ehealth.doctors.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ehealth.doctors.security.provider.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Autowired
    protected void configureGlobalSecurity(
      AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

        .antMatchers("/login").anonymous()
        .antMatchers("/login").permitAll()
        .antMatchers("/home/logout").anonymous()
        .antMatchers("/home/logout").permitAll()
        .antMatchers("/secured/home").permitAll().anyRequest().authenticated()
        .antMatchers("/home/secured/home").permitAll().anyRequest().authenticated()
        .antMatchers("/secured/home").permitAll().anyRequest().authenticated()
        .anyRequest().authenticated() 
            .and()
            .httpBasic();
        http.csrf().disable();
        http.formLogin().permitAll()
            .and()
            .logout().deleteCookies("JSESSIONID")
            .invalidateHttpSession(true)
            .permitAll();
    }    
    
}
