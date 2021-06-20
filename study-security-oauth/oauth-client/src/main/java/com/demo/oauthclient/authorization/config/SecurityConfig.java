package com.demo.oauthclient.authorization.config;

import com.demo.oauthclient.authorization.handler.FailureHandler;
import com.demo.oauthclient.authorization.handler.TargetResourceDispatchHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private FailureHandler failureHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * 安全拦截机制
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/user**").hasRole("USER")
                .antMatchers("/login**", "/authentication/require", "/authentication/form", "/oauthGrant", "/oauthLogin", "/oauthClient/callBack").permitAll()
//                .antMatchers("/oauthClient/comeToOauth").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin().successHandler(new TargetResourceDispatchHandler())
                .failureHandler(failureHandler);
//                .loginPage("/authentication/require")
////                .loginProcessingUrl("/authentication/form");


    }

    /**
     * 基于内存的认证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("shixiaoyan")
                .password(passwordEncoder().encode("666395"))
                .roles("USER");
    }


}
