package org.learnspring.bootspring.controller.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.cors().and().authorizeRequests().antMatchers("/api/actor/**", "/",
        // "/home", "/hello").permitAll().anyRequest().authenticated().and().formLogin()
        // .loginPage("/login").permitAll().and().logout().permitAll();

        // http
        // .authorizeRequests()
        // .antMatchers("/api/actor/**").authenticated()
        // .antMatchers("/").permitAll();

        http.csrf().disable().cors().and().authorizeRequests().anyRequest().authenticated().and().httpBasic(); //csrf().disable()

    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("USER");
    }

   //var user = {
   //    "username": "mami",
   //    "password": "tosun"
   //};

   //var username = "admin";
   //var password = "password";

   //fetch('http://localhost:8080/post', {
   //    method: 'POST',
   //    headers: {
   //        'Authorization': 'Basic ' + btoa(username + ":" + password),
   //        'Accept': 'application/json',
   //        'Content-Type': 'application/json'
   //    },
   //    body: JSON.stringify(user)  //JSON.stringify({ 'username': 'shard123', 'password': 'bravo' }) 
   //});


}
