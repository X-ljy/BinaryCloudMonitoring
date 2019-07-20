package com.binary.servermonitor.data_api.host;

import com.binary.servermonitor.data_api.bottle.ServerInfo;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.google.gson.Gson;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 传入参数Requestparameters对象以及密码
 * @author Wei Peng
 * @retrn 返回提示消息 如果修改操作失败返回原因或错误码 {"i-si6rj33hdi40d":"云主机：i-si6rj33hdi40d修改密码成功"}
 */
public class ChangePassword {


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


    public String url(Requestparameters requestparameters, String password){

        String JsonDate = null;
        TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss ZZ");
        df.setTimeZone(tz);
        requestparameters.setDate(df.format(new Date()));
        String Signature ;
        String url1 = "Action=" + requestparameters.getAction() + "&" +
                "Date=" + getURLEncoderString(requestparameters.getDate()).replaceAll("\\+","%20") + "&" +
                "Version=" + requestparameters.getVersion() + "&" +
                "AccessKeyId=" + requestparameters.getAccessKeyId() + "&" +
                "Region=" + requestparameters.getRegion() + "&" +
                "Password=" + password + "&" +
                "Id=" + requestparameters.getId() ;
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
            JsonDate = response.body().string();
            response.close();
        } catch (IOException e) {
            response.close();
            e.printStackTrace();
        }
        response.close();
        return json(JsonDate,requestparameters.getId());
    }

    private String json(String json,String id) {
        System.out.println(json);
        String TaskId;
        String Action;
        Integer TotalCount;
        Integer ErrorCode;
        String errorCode;
        String ErrorMessage;
        String ErrorMsg;
        String Code;
        String rejson = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            TaskId = jsonObject.getString("TaskId");
            Action = jsonObject.getString("Action");
            TotalCount = jsonObject.getInt("TotalCount");
            ErrorCode = jsonObject.getInt("ErrorCode");
            ErrorMessage = jsonObject.getString("ErrorMessage");
            Code = jsonObject.getString("Code");
            if (1100 == ErrorCode){
                System.out.println("密码长度必须在3-24之间");
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put(id,"密码长度必须在3-24之间");
                rejson = jsonObject1.toString();
            }
            else if (3200 == ErrorCode){
                Gson gson = new Gson();
                System.out.println("云主机：" + id + "不存在");
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put(id,"云主机：" + id + "不存在");
                rejson = jsonObject1.toString();
            }

        } catch (Exception e){
            try {
                JSONObject jsonObject = new JSONObject(json);
                TaskId = jsonObject.getString("TaskId");
                Action = jsonObject.getString("Action");
                TotalCount = jsonObject.getInt("TotalCount");
                System.out.println("云主机：" + id + "修改密码成功");
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put(id,"云主机：" + id + "修改密码成功");
                rejson = jsonObject1.toString();

            }catch (Exception e1){
                Gson gson = new Gson();
                JSONObject jsonObject = new JSONObject(json);
                errorCode = jsonObject.getString("ErrorCode");
                ErrorMsg = jsonObject.getString("ErrorMsg");
                System.out.println(ErrorMsg);
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("ErrorCode",errorCode);
                jsonObject1.put("ErrorMsg",ErrorMsg);
                rejson = jsonObject1.toString();
                
            }

        }
        return rejson;

    }


}
