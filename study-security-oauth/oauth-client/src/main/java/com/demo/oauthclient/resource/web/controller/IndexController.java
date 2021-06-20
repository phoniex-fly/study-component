package com.demo.oauthclient.resource.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("index")
    public String index(){
        return "首页欢迎您";
    }
}
