package com.binary.servermonitor.logmanager;

import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 夕
 * @date 2019/5/23
 */
@Component
public class HostList {

    @Autowired
    private UserInfoRepository userInfoRepository;

    private static UserInfoRepository hostListuserInfoRepository;

    @PostConstruct
    public void init(){
        hostListuserInfoRepository = userInfoRepository;
    }

    public static String[] getHostList(){
        Set<String> hostID = new HashSet<>();
        //查找有多少主机
        ArrayList<UserInfo> allUser = (ArrayList<UserInfo>) hostListuserInfoRepository.findAll();
        for(int i = 0;i<allUser.size();i++){
            String temp = allUser.get(i).getRegion();
            JSONObject jsonObject = JSONObject.parseObject(temp);
            Set<String> ketset =  jsonObject.keySet();
            for(String str : ketset){
                com.alibaba.fastjson.JSONArray jsonArray =  JSONObject.parseArray(jsonObject.getString(str));
                for (int j = 0;j<jsonArray.size();j++){
                    hostID.add(jsonArray.getString(j));
                }
            }
        }
        return hostID.toArray(new String[hostID.size()]);
    }

}
