package com.demo.oauthclient.authorization.config.strategy;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public abstract class UserDetailsServiceStrategy {

    public abstract UserDetails loadUserByUsername(String name, String target) throws UsernameNotFoundException;
}
