package com.binary.servermonitor.data_api.api;

import okhttp3.*;

import java.io.IOException;

/**
 * @author Wei Peng
 */
public class CpuApi {
    public String getCpuInfo(String ip){

        String json = "";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        String url = "http://"+ ip +":6666/getCpuBaseInfo";
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
        System.out.println("json:"+json);
        return json;
    }
}
