package com.sdu.spittr.config;

import com.sdu.spittr.service.SpitterMapperService;
import com.sdu.spittr.service.SpitterMapperServiceImp;
import com.sdu.spittr.service.SpitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



/**
 * Created by J on 2017/4/27.
 */
@Configuration
@EnableWebSecurity
@ComponentScan("com.sdu.spittr")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    SpitterMapperServiceImp spitterMapperServiceImp ;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                formLogin()
                .loginPage("/login")
                .and()
                .authorizeRequests()
                .antMatchers("/spitter/me").hasAuthority("ROLE_SPITTER")
                .anyRequest().permitAll();
        http.csrf().disable();
        http.requiresChannel().antMatchers("spitter/register").requiresSecure();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.userDetailsService(new SpitterUserService(spitterMapperServiceImp));
    }
}
