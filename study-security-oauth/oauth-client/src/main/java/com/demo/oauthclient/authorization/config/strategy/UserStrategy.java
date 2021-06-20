package com.demo.oauthclient.authorization.config.strategy;

import com.demo.common.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component(Constant.CLIENT_USER)
public class UserStrategy extends UserDetailsServiceStrategy {

    @Value("${oauth.roles}")
    public String roles;

    @Autowired
    private HttpServletRequest request;

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String name, String target) throws UsernameNotFoundException {
        User user = null;
        return user;
    }
}
