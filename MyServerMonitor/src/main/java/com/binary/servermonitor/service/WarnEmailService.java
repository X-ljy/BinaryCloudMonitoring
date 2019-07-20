package com.binary.servermonitor.service;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.entity.WarnEmail;
import org.json.JSONObject;

public class WarnEmailService {
    public WarnEmail warnEmail(UserInfo userInfo, String json){
        WarnEmail email = new WarnEmail();
        JSONObject jsonObject = new JSONObject(json);
        try {
            email.setUsername(userInfo.getUsername());
            email.setEmail1(jsonObject.getString("email1"));
            email.setEmail2(jsonObject.getString("email2"));
            email.setEmail3(jsonObject.getString("email3"));
            email.setEmail4(jsonObject.getString("email4"));
            email.setEmail5(jsonObject.getString("email5"));
            email.setEmail6(jsonObject.getString("email6"));
        }catch (Exception e){

        }
        return email;
    }
}
