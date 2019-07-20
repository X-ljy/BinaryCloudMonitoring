package com.binary.servermonitor.controller;

import com.binary.servermonitor.clusterinfo.ZkInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 夕
 * @date 2019/5/18
 */

@RestController
public class ZkInfoController {

    @Autowired
    ZkInfo zkInfo;

    @PostMapping("/getZkInfo")
    public String getZkInfo(){
        return "{\"zoo3\":{\"role\":\"follower\",\"osarch\":\"amd64\",\"zkversion\":\"3.4.11\",\"osversion\":\"3.10.0-862.2.3.el7.x86_64\",\"osname\":\"Linux\",\"status\":\"imok\"}," +
                "\"zoo2\":{\"role\":\"leader\",\"osarch\":\"amd64\",\"zkversion\":\"3.4.11\",\"osversion\":\"3.10.0-957.5.1.el7.x86_64\",\"osname\":\"Linux\",\"status\":\"imok\"}," +
                "\"zoo1\":{\"role\":\"follower\",\"osarch\":\"amd64\",\"zkversion\":\"3.4.11\",\"osversion\":\"3.10.0-693.el7.x86_64\",\"osname\":\"Linux\",\"status\":\"imok\"}}";
//        return zkInfo.getZkInfo();
    }

}
