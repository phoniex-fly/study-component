package com.demo.oauthclient.resource.web.controller;

import com.demo.oauthclient.resource.web.entity.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
//    @PreAuthorize("hasRole('ROLE_USER')")
    public UserInfo me(){
        UserInfo info = new UserInfo();
        info.setName("张三");
        info.setEmail("qq");
        return info;
    }
}
