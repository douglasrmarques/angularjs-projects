package com.infobase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Security configuration for the application
 */
@Configuration
public class ConfigAppBase extends WebSecurityConfigurerAdapter {

    /**
     * The below configuration permits the unauthenticated users to access the login page.
     * All others requests the user must be authenticated
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests().antMatchers("/", "/audit/**", "/ad/**", "/pages/product/**", "/pages/home/**", "/login**", "/webjars/**").permitAll().anyRequest()
            .authenticated().and().exceptionHandling()
            .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/")).and().logout()
            .logoutSuccessUrl("/").permitAll().and().csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

}
