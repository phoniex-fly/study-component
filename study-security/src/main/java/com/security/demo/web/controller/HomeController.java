package com.security.demo.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/demo")
    public String demo() {
        return "demo spring boot";
    }
}
