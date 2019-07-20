package com.binary.servermonitor.data_api.MySql;

import okhttp3.*;

import java.io.IOException;

/**
 * @author Wei Peng
 */
public class MysqlApi {
    public String getMySqlLiveInfo(String hostIp){
        String url = "http://"+ hostIp +":6666/getMysqlIsAlive";
        String json = "";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Response response = null;
        try{
            response = client.newCall(request).execute();
            json = response.body().string();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return json;
    }

    public String getMySqlProInfo(String hostIp){
        String url = "http://"+ hostIp +":6666/getMysqlprocesslist";
        String json = "";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Response response = null;
        try{
            response = client.newCall(request).execute();
            json = response.body().string();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return json;
    }

    public String getMySqlConnInfo(String hostIp){
        String url = "http://" + hostIp + ":6666/getMysqlConnectionNumber";
        String json = "";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Response response = null;
        try{
            response = client.newCall(request).execute();
            json = response.body().string();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return json;
    }
    public String getMySqlUpTimeInfo(String hostIp){
        String url = "http://" + hostIp + ":6666/getMysqlUptime";
        String json = "";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Response response = null;
        try{
            response = client.newCall(request).execute();
            json = response.body().string();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return json;
    }
}
