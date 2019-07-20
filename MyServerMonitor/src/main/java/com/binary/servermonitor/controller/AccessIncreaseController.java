package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.AccessIncrease;
import com.binary.servermonitor.service.AddJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Wei Peng
 */
@RestController
public class AccessIncreaseController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/increase")
    public String increase(HttpSession session, @RequestParam String access_key_id, @RequestParam String access_key_secret, @RequestParam String[] region){
        System.out.println(access_key_id);
        System.out.println(access_key_secret);
        System.out.println(Arrays.deepToString(region));
        AccessIncrease accessIncrease = new AccessIncrease();
        String jsonregion = accessIncrease.getInformation(access_key_id,access_key_secret,region);
        System.out.println(jsonregion);
        if ("error".equals(jsonregion)){
            return "error";
        }
        else {
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername((String) session.getAttribute("username"));
            userInfo.setAccess_key_id(access_key_id);
            userInfo.setAccess_key_secret(access_key_secret);
            userInfo.setRegion(jsonregion);
            userInfo.setCompuretroom(Arrays.deepToString(region));
            userInfoRepository.save(userInfo);

//            AddJobService addJobService = new AddJobService();
//            String result = addJobService.addJob(userInfo.getUsername());
//            System.out.println(result);
            return "success";
        }

    }
}
