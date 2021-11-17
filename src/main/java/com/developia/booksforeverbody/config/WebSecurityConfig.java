package com.developia.booksforeverbody.config;

import com.developia.booksforeverbody.dao.entity.Role;
import com.developia.booksforeverbody.service.MyUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder passwordEncoder;

    private final MyUserDetailService myUserDetailService;


    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder
                .userDetailsService(myUserDetailService)
                .passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity security) throws Exception{
        security.authorizeRequests()
                .antMatchers("/books/*").permitAll()
                .antMatchers("/carts/*").hasAuthority(Role.USER.name())
                .anyRequest().authenticated().
                and().formLogin()
                .loginPage("/users/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
                .logoutSuccessUrl("/books")
                .and().exceptionHandling().accessDeniedPage("/users/access-denied");
    }
}
