package com.binary.servermonitor.controller;

import com.binary.servermonitor.clusterinfo.EsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 夕
 * @date 2019/5/18
 */

@RestController
public class EsInfoController {

    @Autowired
    EsInfo esInfo;

    @PostMapping("/getEsInfo")
    public String getEsInfo(){
        return esInfo.getEsInfo();
    }

}
