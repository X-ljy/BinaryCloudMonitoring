package com.binary.servermonitor.service;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.entity.WarnRule;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Wei Peng
 */
public class WarnRuleCreatService {
    public WarnRule warnRuleCreat(UserInfo userInfo, String json){
        System.out.println(json);
        JSONObject jsonObject = new JSONObject(json);
        Integer strategyNum;
        JSONObject jsonObject1 = new JSONObject();
        WarnRule rule = new WarnRule();
        try {
            strategyNum = Integer.valueOf(jsonObject.getString("strategyNum"));
            System.out.println(strategyNum);
            JSONArray array = new JSONArray();
            for (int i = 0; i < strategyNum; i ++){
                JSONObject jsonObject2 = new JSONObject();
                jsonObject2.put("option",jsonObject.getString("option" + i));
                jsonObject2.put("typeName",jsonObject.getString("typeName" + i));
                jsonObject2.put("typeMethod",jsonObject.getString("typeMethod" + i));
                jsonObject2.put("typeValue",jsonObject.getString("typeValue" + i));
                array.put(jsonObject2);
            }
            jsonObject1.put("strategySet",array);
            rule.setStrategy(jsonObject1.toString());
            rule.setTerm(jsonObject.getString("trem"));
            rule.setCycle(jsonObject.getString("cycle"));
            rule.setAlarmTimes(jsonObject.getString("alarmtimes"));
            rule.setLevel(jsonObject.getString("level"));
            rule.setNoticeType(jsonObject.getString("noticeType"));
            rule.setHitCounts(jsonObject.getString("hitcounts"));
            rule.setRuleName(jsonObject.getString("name"));
            rule.setUsername(userInfo.getUsername());
            rule.setHostId(jsonObject.getString("hostId"));
        }catch (Exception e){

        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rule.setCreatTime(df.format(new Date()));
        return rule;
    }
}
