package com.demo.oauthserver.resource.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"authorizationRequest"})
public class AuthController {

    @RequestMapping("login")
    public String toLogin(){
        return "login";
    }
}
