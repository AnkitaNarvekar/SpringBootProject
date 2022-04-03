package com.ankita.SportShoesProject;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ankita.SportShoesProject.service.CustomUserDetailsService;


 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    
    
    
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
	
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http.authorizeRequests() //
	 * .antMatchers("/loginuser").hasAnyAuthority("USER","ADMIN")
	 * .antMatchers("/").hasAnyAuthority("USER","ADMIN")
	 * .antMatchers("/admin/*").hasAuthority("ADMIN") //.authenticated()
	 * //.anyRequest().permitAll() //.and() //.formLogin()
	 * .usernameParameter("email") //.defaultSuccessUrl("/userdashboard")
	 * .permitAll() .and() //.logout().logoutSuccessUrl("/").permitAll();
	 * 
	 * .anyRequest() .authenticated() .and() .formLogin() .permitAll() .and()
	 * .csrf() .disable(); }
	 */
	 
    
	/*
	 * @Override public void configure(HttpSecurity http) throws Exception { http
	 * .csrf().disable() .authorizeRequests()
	 * .antMatchers("/loginuser").hasAnyRole("USER")
	 * .antMatchers("/admin").hasAnyRole("ADMIN")
	 * .and().formLogin().loginPage("/login") //.successHandler(successHandler)
	 * .permitAll() .and().logout(); }
	 */
    
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	            .antMatchers("/user").authenticated()
	            .antMatchers("/admin").authenticated()
	            .anyRequest().permitAll()
	            .and()
	            .formLogin()
	                .usernameParameter("email")
	                .defaultSuccessUrl("/user")
	                .permitAll()
	            .and()
	            .logout().logoutSuccessUrl("/").permitAll();
	    }
     
}