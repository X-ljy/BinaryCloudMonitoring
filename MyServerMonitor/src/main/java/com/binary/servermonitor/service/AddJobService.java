package com.binary.servermonitor.service;

import okhttp3.*;

import java.io.IOException;

/**
 * @author Wei Peng
 */
public class AddJobService {
    public String addJob(String username){
        String url = "http://localhost:8080/user/login";
        String json = "";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON,json);
        RequestBody formbody = new FormBody.Builder()
                .add("username",username)
                .build();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .post(formbody)
                .url(url)
                .build();
        Response response = null;
        String test = null;
        try{
            response = client.newCall(request).execute();
            test = response.body().string();
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return test;
    }
}
