package com.binary.servermonitor.logmanager;

import com.binary.servermonitor.util.MySchedulerFactory;
import org.json.CDL;
import org.json.JSONArray;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 夕
 * @date 2019/5/22
 */

@Component
@Order(value = 2)
public class LogJob implements ApplicationRunner {

    public static String JsonTOCsv(String json){
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        MySchedulerFactory.addJob("BaseInfoLogJob","BaseInfoLogGroup",
                            "BaseInfoLogTrigger","BaseInfoLogTriggerGroup",
                            BaseLogArchiving.class,"0 0 1 * * ? * ");
    }
}
