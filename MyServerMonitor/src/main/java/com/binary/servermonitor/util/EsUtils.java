package com.binary.servermonitor.util;


import com.binary.servermonitor.common.SearchUrlList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * @author 夕
 * @date 2019/5/11
 */


public class EsUtils {

    private static Logger logger = LoggerFactory.getLogger(EsUtils.class);
    public static String CLUSTER_NAME = "MyServerMonitorES";//Elasticsearch集群名称
    public static String HOST_IP = "10.10.44.127";//Elasticsearch集群master节点

    public static String getClusterName() {
        return CLUSTER_NAME;
    }

    public static void setClusterName(String clusterName) {
        CLUSTER_NAME = clusterName;
    }

    public static String getHostIp() {
        return HOST_IP;
    }

    public static void setHostIp(String hostIp) {
        HOST_IP = hostIp;
    }

    /**
     * 创建RestClient
     * @return restClient
     */
//    public static RestClient getRestClient(){
//        RestClient restClient = RestClient.builder(
//                new HttpHost(HOST_IP, 9200, "http")
//        ).build();
//        return restClient;
//    }
    static RestClient restClient = RestClient.builder(
            new HttpHost(HOST_IP, 9200, "http")
    ).build();

    public static String getEsVersion() throws IOException {
//        RestClient restClient = getRestClient();
        Response response = null;
        try {
            //同步发送请求
            response = restClient.performRequest("GET", "/");
            int statusCode = response.getStatusLine().getStatusCode();//响应状态行，可以从中获取状态码
            if(statusCode == 200){
                String responseBody = EntityUtils.toString(response.getEntity());//响应体包含在org.apache.http.HttpEntity对象中
                return responseBody;
            }else {
                return "error";
            }
        } catch (Exception e){
            logger.error("getEsVersion Request error" + e.getMessage() );
        }
        return "error";
    }


    public static String getEsHealth() throws IOException {
//        RestClient restClient = getRestClient();
        Response response = null;
        try {
            //同步发送请求
            response = restClient.performRequest("GET", "/_cat/health?v");
            int statusCode = response.getStatusLine().getStatusCode();//响应状态行，可以从中获取状态码
            if(statusCode == 200){
                String responseBody = EntityUtils.toString(response.getEntity());//响应体包含在org.apache.http.HttpEntity对象中
                return responseBody;
            }else {
                return "error";
            }
        } catch (Exception e){
            logger.error("getEsHealth Request error" + e.getMessage() );
        }
        return "error";
    }

    public static String getEsIndexList() throws IOException {
//        RestClient restClient = getRestClient();
        Response response = null;
        try {
            //同步发送请求
            response = restClient.performRequest("GET", "/_cat/indices?v");
            int statusCode = response.getStatusLine().getStatusCode();//响应状态行，可以从中获取状态码
            if(statusCode == 200){
                String responseBody = EntityUtils.toString(response.getEntity());//响应体包含在org.apache.http.HttpEntity对象中
                return responseBody;
            }else {
                return "error";
            }
        } catch (Exception e){
            logger.error("getEsNodeList Request error" + e.getMessage() );
        }
        return "error";
    }



    public static String sendDataToIndex(String url , String jsonString ) throws IOException {
//        RestClient restClient = getRestClient();
        Response response = null;
        try{
            Map<String, String> params = Collections.emptyMap();
            HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
            response = restClient.performRequest("POST", url, params, entity);
            int statusCode = response.getStatusLine().getStatusCode();//响应状态行，可以从中获取状态码
            if(statusCode == 200){
                String responseBody = EntityUtils.toString(response.getEntity());//响应体包含在org.apache.http.HttpEntity对象中
                return "success";
            }else {
                return "error";
            }
        }catch (Exception e){
            logger.error("sendDataToIndex Request error" + e.getMessage() );
        }
        return "error";
    }

    public static String queryDataFromES(String url , String jsonString) throws IOException {

        Response response = null;
        try {
            Map<String, String> params = Collections.emptyMap();
            HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
            response = restClient.performRequest("POST", url, params, entity);
            int statusCode = response.getStatusLine().getStatusCode();//响应状态行，可以从中获取状态码
            if (statusCode == 200 || statusCode == 201) {
                String responseBody = EntityUtils.toString(response.getEntity());//响应体包含在org.apache.http.HttpEntity对象中
                return responseBody;
            } else {
                return "error";
            }
        } catch (Exception e) {
            logger.error("sendDataToIndex Request error"  + e.getMessage());
        }
        return "error";
    }

}