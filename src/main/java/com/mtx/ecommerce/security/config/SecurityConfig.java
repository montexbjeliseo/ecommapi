package com.mtx.ecommerce.security.config;

import com.mtx.ecommerce.exception.auth.handler.CustomAccessDeniedHandler;
import com.mtx.ecommerce.exception.auth.handler.CustomAuthenticationEntryPoint;
import com.mtx.ecommerce.security.filter.JwtRequestFilter;
import com.mtx.ecommerce.security.service.impl.UserDetailsServiceImpl;
import com.mtx.ecommerce.util.Constants.Endpoints;
import static com.mtx.ecommerce.util.Constants.Roles.ADMIN;
import static com.mtx.ecommerce.util.Constants.Roles.SELLER;
import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(Endpoints.REGISTER_PATH)
                .permitAll()
                .antMatchers(Endpoints.LOGIN_PATH)
                .permitAll()
                .antMatchers(HttpMethod.POST, Endpoints.BRAND).hasAnyAuthority(ADMIN, SELLER)
                .antMatchers(HttpMethod.POST, Endpoints.CATEGORY).hasAnyAuthority(ADMIN, SELLER)
                .antMatchers(HttpMethod.POST, Endpoints.PRODUCT).hasAnyAuthority(ADMIN, SELLER)
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint());
    }

    @Bean
    public BCryptPasswordEncoder bcrypt() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }
    
    @Bean
    @Value("${sendgrid.api.key}")
    public SendGrid sendGridClient(String sendGridAPIKey){
        return new SendGrid(sendGridAPIKey);
    }
    @Bean
    @Value("${sendgrid.email}")
    public String sendGridEmail(String email){
        return email;
    }
}
