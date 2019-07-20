package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.PrivateNetwork;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.PrivateNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Wei Peng
 * 私有网络页面数据
 */
@RestController
public class PrivateNetworkController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/prinet/query")
    public ArrayList<PrivateNetwork> priNetQuery(HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        PrivateNetworkService service = new PrivateNetworkService();
        ArrayList<PrivateNetwork> list = service.priNetService(userInfo);
        return list;
    }
}
