package com.demo.oauthclient.resource.web.service;


import com.demo.oauthclient.resource.web.entity.ClientUser;

import java.util.List;

public interface TargetService<T> {
    //查找用户
    T findUserByName(String agentCode);

    //查找权限
    List<String> findAuths();

    //查找密码
    String findPassword();

    //封装认证用户
    default ClientUser loadUserByUsername(String agentCode) {
        T user = findUserByName(agentCode);
        if (null != user) {
            return new ClientUser(findPassword(), findAuths(), "");
        }
        return null;
    }

    ;

}
