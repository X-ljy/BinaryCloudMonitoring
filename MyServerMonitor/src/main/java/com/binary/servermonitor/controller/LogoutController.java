package com.binary.servermonitor.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class LogoutController {

    @PostMapping(value = "/logout")
    public String logout(HttpSession session){
        String username = String.valueOf(session.getAttribute("username"));
        session.removeAttribute("username");
        return "用户：" + username + "退出登陆";
    }
}
