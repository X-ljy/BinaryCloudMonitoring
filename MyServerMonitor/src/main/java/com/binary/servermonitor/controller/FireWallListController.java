package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.FireWallList;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.FireWallQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class FireWallListController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/firewall/list")
    public ArrayList<FireWallList> fireWallList(HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        FireWallQueryService service = new FireWallQueryService();
        ArrayList<FireWallList> list = service.fireWallQuery(userInfo);
        return list;
    }
}
