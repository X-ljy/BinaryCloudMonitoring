package com.binary.servermonitor.controller;
import com.binary.servermonitor.entity.UserLogin;
import com.binary.servermonitor.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class LoginController {

    @Autowired
    LoginRepository loginRepository;

    @PostMapping(value = "/user/login")
    public String userlogin(@RequestParam String email, @RequestParam String password,
                            HttpSession session){
        UserLogin userLogin = loginRepository.findByUsername(email);
        System.out.println(email);
        System.out.println(password);
        if (userLogin == null){
            return "error";
        }
        if (password.equals(userLogin.getPassword())){
            session.setAttribute("username",email);
            return "index";
        }
        else {
            return "error";
        }
    }


}
