package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserLogin;
import com.binary.servermonitor.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Wei Peng
 */
@RestController
public class RegisterController {

    @Autowired
    LoginRepository loginRepository;

    @PostMapping(value = "/user/register")
    public String register(@RequestParam String email, @RequestParam String password, HttpSession session){
        UserLogin userLogin = new UserLogin();
        List<UserLogin> list = loginRepository.findAll();
        if (email != null && password != null){
            for (int i = 0;i < list.size();i ++){
                UserLogin userLogin1 = list.get(i);
                if (email.equals(userLogin1.getUsername())){
                    return "error";
                }
            }
            userLogin.setUsername(email);
            userLogin.setPassword(password);
            loginRepository.save(userLogin);
            return "index";
        }
        else {
            return "error";
        }
    }
}
