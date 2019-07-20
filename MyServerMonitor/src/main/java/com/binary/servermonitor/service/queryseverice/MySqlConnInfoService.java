package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.data_api.MySql.MysqlApi;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class MySqlConnInfoService {

    public String getConnInfo(String hostip){
        MysqlApi mysqlApi = new MysqlApi();
        String json = mysqlApi.getMySqlConnInfo(hostip);
        JSONObject jsonObject = new JSONObject(json);
        JSONObject jsonObject1 = jsonObject.getJSONObject("date");
        return "";
    }
}
