package com.binary.servermonitor.data_api.cpu;

import com.binary.servermonitor.data_api.bottle.ServerInfo;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Wei Peng
 * @retrn 实例{"Data":[["2019-04-24T03:46:00Z","4.49"]],"Id":"i-si6rj33hdi40d","Unit":"%","Interval":60}
 * Data中的数据由二维数组组成
 * Id为主机Id
 * Unit为单位
 * Interval 时间间隔
 */
public class CpuApi {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private String getURLEncoderString(String str){
        String result = null;
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String encryption(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }
    private String HAMCSha256(String url,String AccessKeySecret){
        String Base64Str;
        try {
            Mac hmacSha256 = Mac.getInstance("HmacSHA256");
            byte[] keyBytes = AccessKeySecret.getBytes("UTF-8");
            hmacSha256.init(new SecretKeySpec(keyBytes, 0, keyBytes.length, "HmacSHA256"));
            byte[] stringToSign = hmacSha256.doFinal(url.getBytes("UTF-8"));
            Base64Str = new String(Base64.encodeBase64(stringToSign));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Base64Str;
    }


    public String url(Requestparameters requestparameters){

        String Jsondate = null;
        //UTC时间
        TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss ZZ");
        df.setTimeZone(tz);
        requestparameters.setDate(df.format(new Date()));
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        requestparameters.setEndTime(df2.format(new Date()));
        Date d = new Date();
        requestparameters.setStartTime(df2.format(new Date(d.getTime()-20 * 1000)));
        System.out.println("StartTime:"+requestparameters.getStartTime());
        System.out.println("EndTime:"+requestparameters.getEndTime());
        String Signature ;
        String url1 = "Action=" + requestparameters.getAction() + "&" +
                "Date=" + getURLEncoderString(requestparameters.getDate()).replaceAll("\\+","%20") + "&" +
                "Version=" + requestparameters.getVersion() + "&" +
                "AccessKeyId=" + requestparameters.getAccessKeyId() + "&" +
                "Region=" + requestparameters.getRegion() + "&" +
                "Id=" + requestparameters.getId() + "&" +
                "StartTime=" + getURLEncoderString(requestparameters.getStartTime()).replaceAll("\\+","%20") + "&" +
                "EndTime=" + getURLEncoderString(requestparameters.getEndTime()).replaceAll("\\+","%20");
        String md5 = encryption(url1);
        String url3  =  requestparameters.getMethod() + "\n" + md5 + "\n" + requestparameters.getContentType() + "\n" + getURLEncoderString(requestparameters.getDate()).replaceAll("\\+","%20") + "\n";
        String Base64Str=HAMCSha256(url3,requestparameters.getAccessKeySecret());
        String url4 = getURLEncoderString(Base64Str);
        String s1 = url4.replaceAll("\\+","%20");
        String s2 = s1.replaceAll("\\*","%2A");
        String s3 = s2.replaceAll("%7E","~");
        Signature = s3;
        String url5 = requestparameters.getHost()+"?"+ url1 + "&Signature=" + Signature;


        Request request = new Request.Builder()
                .get()
                .addHeader("Content-Type","application/json;charset=UTF-8")
                .addHeader("Accept-Encoding","*")
                .addHeader("Date",requestparameters.getDate())
                .url(url5)
                .build();
        Response response = null;
        try{
            response = ServerInfo.okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) { // 判断是否成功
                /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
                 * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
                 * 因为string() 方法会将整个文档加载到内存中。
                 * */
                Jsondate = response.body().string();
            }else {
                return "error"; // 链接失败
            }
        } catch (Exception e) {
            Jsondate = "error";
            logger.error("CpuAPi Request error" + e.getMessage());
        }finally {
            response.close();
        }
        return json(Jsondate,requestparameters.getId());
    }

    private String json(String json,String id) {

        int length1 = 0;
        String taskId = null;
        String unit = null;
        int interval = 0;
        JSONObject jsonObject = new JSONObject(json);
        String[][] data = null;
        try {
            taskId = jsonObject.getString("TaskId");
            unit = jsonObject.getString("Unit");
            interval = jsonObject.getInt("Interval");
            JSONArray array1 = jsonObject.getJSONArray("Data");
            data = new String[array1.length()][];
            length1 =array1.length();
            for (int i = 0; i < array1.length(); i++) {
                JSONArray array2 = array1.getJSONArray(i);
                data[i] = new String[array2.length()];
                data[i][0] = array2.getString(0);
                data[i][1] = String.format("%1.2f",array2.getDouble(1));
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        JSONObject jsonObject1 = new JSONObject();
        JSONArray array = new JSONArray();
        for (int j=0;j<length1;j++) {
            array.put(data[j]);
        }
        jsonObject1.put("Id",id);
        jsonObject1.put("Unit",unit);
        jsonObject1.put("Interval",interval);
        jsonObject1.put("Data",array);

        return jsonObject1.toString();

    }
}
