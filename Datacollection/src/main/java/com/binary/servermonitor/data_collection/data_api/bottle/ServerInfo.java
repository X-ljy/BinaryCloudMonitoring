package com.binary.servermonitor.data_collection.data_api.bottle;

import okhttp3.*;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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

    public static String getMysqlprocesslist(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getMysqlprocesslist").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getMysqlprocesslist Request error :" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getMysqlConnectionNumber(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getMysqlConnectionNumber").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getMysqlConnectionNumber Request error :" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getMysqlQps(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getMysqlQps").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getMysqlQps Request error :" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getMysqlTPS(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getMysqlTPS").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getMysqlTPS Request error :" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getMysqlKeyBuffer(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getMysqlKeyBuffer").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getMysqlKeyBuffer Request error :" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getMysqlInnodbBuffer(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getMysqlInnodbBuffer").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getMysqlInnodbBuffer Request error :" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }


    public static String getMysqlQueryCache(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getMysqlQueryCache").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getMysqlQueryCache Request error :" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getMysqlTableCache(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getMysqlTableCache").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getMysqlTableCache Request error :" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }


    public static String getMysqlThreadCache(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getMysqlThreadCache").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getMysqlThreadCache Request error :" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getBinaryAgentProcInfo(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getAllProcInfo").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getBinaryAgentProcInfo Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }


    public static String getBinaryAgentOnlineUsers(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getOnlineUsers").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getBinaryAgentOnlineUsers Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getBinaryAgentNetworkCardInfo(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getNetWorkCardInfo").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getBinaryAgentNetworkCardInfo Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getBinaryAgentMemBaseInfo(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getMemBaseInfo").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getBinaryAgentMemBaseInfo Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getBinaryAgentLoadAverage(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getLoadAverage").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getBinaryAgentLoadAverage Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getBinaryAgentDiskIoInfo(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getDiskIoInfo").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getBinaryAgentDiskIoInfo Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }
    public static String getBinaryAgentDiskBaseInfo(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getDiskBaseInfo").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getBinaryAgentDiskBaseInfo Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }

    public static String getBinaryAgentCpuUseInfo(String host, String port)  {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url("http://"+host+":"+port+"/getCpuUseInfo").post(body).build(); // 创建一个请求
        Response response = null; // 返回实体
        String res = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。*/
                res = response.body().string();
            }else {
                return "error"; // 请求失败
            }
        } catch (Exception e) {
            res = "error";
            logger.error("getBinaryAgentCpuUseInfo Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return  res;
    }
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
