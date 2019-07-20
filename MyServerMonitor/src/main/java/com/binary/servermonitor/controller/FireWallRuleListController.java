package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.FireWallRule;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.FireWallRuleQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class FireWallRuleListController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/firewall/rule/query")
    public ArrayList<FireWallRule> fireWallRuleList(HttpSession session, @RequestParam String id){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        FireWallRuleQueryService service = new FireWallRuleQueryService();
        ArrayList<FireWallRule> list = service.fireWallRuleQuery(userInfo,id);
        return list;
    }
}
