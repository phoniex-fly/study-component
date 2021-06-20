package com.demo.oauthclient.authorization.config.strategy;


import com.demo.common.util.Constant;
import com.demo.oauthclient.resource.web.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component(Constant.CLIENT_OAUTH)
public class ClientUserStrategy extends UserDetailsServiceStrategy {

    @Autowired
    private Map<String, TargetService> targetServices;

    @Override
    public UserDetails loadUserByUsername(String name, String target) throws UsernameNotFoundException {
        TargetService targetService = this.targetServices.get(target);
        targetService.findUserByName(name);
        return targetService.loadUserByUsername(name);
    }
}
