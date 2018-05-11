package com.ericknunes.ericknunes.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    /**The Login view map*/
    public static final String LOGIN_VIEW_NAME = "user/login";

    @RequestMapping("/login")
    public String Login()
    {
        return LOGIN_VIEW_NAME;
    }
}
