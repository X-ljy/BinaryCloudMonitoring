package com.binary.servermonitor.data_api.bottle;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author 夕
 * @date 2019/5/7
 */
public class ServerInfo {

    private static  org.slf4j.Logger logger = LoggerFactory.getLogger(ServerInfo.class);

    // OkHttpClient对象
    public static OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                                .retryOnConnectionFailure(true)
                                                .connectTimeout(30, TimeUnit.SECONDS).build();

    public static String getCpuInfo(String host, String port) {
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getCpuInfo").build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 链接失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getCpuInfo Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return res;
    }


    public static String getSystemInfo(String host, String port) {
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getSystemInfo").build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 链接失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getSystemInfo Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getMemInfo(String host, String port)  {
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getMemInfo").build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 链接失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getMemInfo Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }


    public static String getRunTimeAndAverage(String host, String port)  {
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getRunTimeAndAverage").build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 链接失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getRunTimeAndAverage Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }


    public static String getOnlineUsers(String host, String port)  {
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getOnlineUsers").build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();

            }else {
                return "error"; // 链接失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getOnlineUsers Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getDiskInfo(String host, String port) {
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getDiskInfo").build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 链接失败
            }
        } catch (IOException e) {
            res = "error";
            logger.error("getDiskInfo Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getProcessInfo(String host, String port) {
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getProcessInfo").build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                 res = response.body().string();

            }else {
                return "error"; // 链接失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getProcessInfo Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }


}
