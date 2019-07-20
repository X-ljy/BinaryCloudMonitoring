package com.binary.servermonitor.data_api.image;


import com.google.gson.Gson;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
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
 * @author Wei Peng
 * @retrn  {"TotalCount":13,"ImageSet":[{"Id":"t-uu6rialdje42w","Name":"CentOS","Description":"","OsId":"o-8kga7h0o81o","OsName":"Linux6.5 64","Shared":true,"Owner":"null","CreateTime":"2018-11-21T13:55:50 +0800","Use":"INSTANCE","HotUpgrade":true,"Status":"null","TemplateName":"null","TemplateImageType":"null","IsoDisk":false,"Gpu":false},{"Id":"t-l46ri9hb1q33","Name":"CentOS","Description":"","OsId":"o-pa1fhbch5o39u","OsName":"Linux6.9 64","Shared":true,"Owner":"null","CreateTime":"2018-10-17T11:01:26 +0800","Use":"INSTANCE","HotUpgrade":true,"Size":40,"Status":"NORMAL","TemplateName":"vm_linux_centos_6.9_64-V2.0.2-20180824-17","TemplateImageType":"null","IsoDisk":true,"Gpu":false},{"Id":"t-nn6ri9hamk85n","Name":"CentOS","Description":"","OsId":"o-vx1fhbch59729","OsName":"Linux6.9 32","Shared":true,"Owner":"null","CreateTime":"2018-10-17T10:58:20 +0800","Use":"INSTANCE","HotUpgrade":false,"Size":40,"Status":"NORMAL","TemplateName":"vm_linux_centos_6.9_32-V2.0.2-20180827-09","TemplateImageType":"null","IsoDisk":true,"Gpu":false},{"Id":"t-3e6ri9hae5478","Name":"Ubuntu","Description":"","OsId":"o-n9ga7h1533d","OsName":"Linux14.04 64","Shared":true,"Owner":"null","CreateTime":"2018-10-17T10:50:41 +0800","Use":"INSTANCE","HotUpgrade":true,"Size":40,"Status":"NORMAL","TemplateName":"vm_linux_ubuntu_14.04.5_64-V2.0.2-20171211-14","TemplateImageType":"null","IsoDisk":true,"Gpu":false},{"Id":"t-666ri9ha9q655","Name":"Windows","Description":"","OsId":"o-23ga7hpd42x","OsName":"Windows2003R2中文版 32","Shared":true,"Owner":"null","CreateTime":"2018-10-17T10:45:26 +0800","Use":"INSTANCE","HotUpgrade":false,"Size":40,"Status":"NORMAL","TemplateName":"vm_windows_2003_R2_32_Ent-40G-V2.0.2-20171025-15","TemplateImageType":"null","IsoDisk":true,"Gpu":false},{"Id":"t-pd6ri9ha55932","Name":"Windows","Description":"","OsId":"o-sah1r982325","OsName":"Windows2003R2中文版 64","Shared":true,"Owner":"null","CreateTime":"2018-10-17T10:41:41 +0800","Use":"INSTANCE","HotUpgrade":false,"Size":40,"Status":"NORMAL","TemplateName":"vm_windows_2003_R2_64_Ent-V2.0.2-20180720-11","TemplateImageType":"null","IsoDisk":true,"Gpu":false},{"Id":"t-bq6ri9ha2j570","Name":"Windows","Description":"","OsId":"o-mhga7hzh31q","OsName":"Windows2012R2中文版 64","Shared":true,"Owner":"null","CreateTime":"2018-10-17T10:38:19 +0800","Use":"INSTANCE","HotUpgrade":false,"Size":40,"Status":"NORMAL","TemplateName":"vm_windows_2012_R2_64_Sta-V2.0.2-20180119-15","TemplateImageType":"null","IsoDisk":true,"Gpu":false},{"Id":"t-4r6ri9hazu95f","Name":"Windows","Description":"","OsId":"o-izga7htl66l","OsName":"Windows2008R2中文版 64","Shared":true,"Owner":"null","CreateTime":"2018-10-17T10:35:30 +0800","Use":"INSTANCE","HotUpgrade":false,"Size":40,"Status":"NORMAL","TemplateName":"vm_windows_2008_R2_64_Ent-V2.0.2-20171129-13","TemplateImageType":"null","IsoDisk":true,"Gpu":false},{"Id":"t-6i6ri9hav7931","Name":"Windows","Description":"","OsId":"o-y4h2hk59572","OsName":"Windows2008R2英文版 64","Shared":true,"Owner":"null","CreateTime":"2018-10-17T10:31:43 +0800","Use":"INSTANCE","HotUpgrade":false,"Size":40,"Status":"NORMAL","TemplateName":"vm_windows_2008_R2_64_Ent_EN-V2.0.2-20171129-13","TemplateImageType":"null","IsoDisk":true,"Gpu":false},{"Id":"t-l96ri9h9mm27m","Name":"Ubuntu","Description":"","OsId":"o-mch52g26297","OsName":"Linux16.04 64","Shared":true,"Owner":"null","CreateTime":"2018-10-17T09:22:22 +0800","Use":"INSTANCE","HotUpgrade":true,"Size":40,"Status":"NORMAL","TemplateName":"vm_linux_ubuntu_16.04.3_64-V2.0.2-20171211-17","TemplateImageType":"null","IsoDisk":true,"Gpu":false},{"Id":"t-o26ri9h9j81f","Name":"CentOS","Description":"","OsId":"o-4v1fi4vdgg906","OsName":"Linux7.4 64","Shared":true,"Owner":"null","CreateTime":"2018-10-17T09:19:08 +0800","Use":"INSTANCE","HotUpgrade":true,"Size":40,"Status":"NORMAL","TemplateName":"vm_linux_centos_7.4_64-V2.0.2-20180531-13","TemplateImageType":"null","IsoDisk":true,"Gpu":false},{"Id":"t-tk6ri9h9dg91d","Name":"Windows","Description":"","OsId":"o-so1fi4fd8z99n","OsName":"Windows2016中文版 64","Shared":true,"Owner":"null","CreateTime":"2018-10-17T09:13:16 +0800","Use":"INSTANCE","HotUpgrade":false,"Size":60,"Status":"NORMAL","TemplateName":"vm_windows_2016_64-V2.0.2-20180621","TemplateImageType":"null","IsoDisk":true,"Gpu":false},{"Id":"t-mc6ri9ggb02n","Name":"CentOS","Description":"","OsId":"o-amga7h064d","OsName":"Linux7.2 64","Shared":true,"Owner":"null","CreateTime":"2018-10-16T16:47:36 +0800","Use":"INSTANCE","HotUpgrade":true,"Size":40,"Status":"NORMAL","TemplateName":"vm_linux_centos_7.2_64-V2.0.2-20171207-09","TemplateImageType":"null","IsoDisk":true,"Gpu":false}]}
 * TotalCount 镜像的总数
 * ImageSet为对象数组 每一个对象为每一个镜像的详细参数
 */
public class Inquire {
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
                "Region=" + requestparameters.getRegion() ;
        String md5 = encryption(url1);
        String url3  =  requestparameters.getMethod() + "\n" + md5 + "\n" + requestparameters.getContentType() + "\n" + getURLEncoderString(requestparameters.getDate()).replaceAll("\\+","%20") + "\n";
        String Base64Str=HAMCSha256(url3,requestparameters.getAccessKeySecret());
        String url4 = getURLEncoderString(Base64Str);
        String s1 = url4.replaceAll("\\+","%20");
        String s2 = s1.replaceAll("\\*","%2A");
        String s3 = s2.replaceAll("%7E","~");
        Signature = s3;
        String url5 = requestparameters.getHost()+"?"+ url1 + "&Signature=" + Signature;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .addHeader("Content-Type","application/json;charset=UTF-8")
                .addHeader("Accept-Encoding","*")
                .addHeader("Date",requestparameters.getDate())
                .url(url5)
                .build();
        Response response = null;
        try{
            response = client.newCall(request).execute();
            JsonDate = response.body().string();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return json(JsonDate,requestparameters.getId());
    }
    private String json(String json,String id) {
        System.out.println(json);
        String TaskId;
        String Action;
        Integer TotalCount = null;
        Image[] ImageSet = new Image[0];
        String rejson;
        System.out.println(json);
        JSONObject jsonObject = new JSONObject(json);
        try {

            TaskId = jsonObject.getString("TaskId");
            Action = jsonObject.getString("Action");
            TotalCount = jsonObject.getInt("TotalCount");
            ImageSet = new Image[TotalCount];
            JSONArray array = jsonObject.getJSONArray("ImageSet");
            for (int i = 0;i < TotalCount;i ++){
                Image image = new Image();
                JSONObject jsonObject1 = array.getJSONObject(i);
                image.setId(jsonObject1.getString("Id"));
                image.setName(jsonObject1.getString("Name"));
                image.setDescription(jsonObject1.getString("Description"));
                image.setOsId(jsonObject1.getString("OsId"));
                image.setOsName(jsonObject1.getString("OsName"));
                image.setShared(jsonObject1.getBoolean("Shared"));
                image.setOwner(String.valueOf(jsonObject1.get("Owner")));
                image.setCreateTime(jsonObject1.getString("CreateTime"));
                image.setUse(jsonObject1.getString("Use"));
                image.setHotUpgrade(jsonObject1.getBoolean("HotUpgrade"));
                try {
                    image.setSize(jsonObject1.getInt("Size"));
                }catch (Exception e){
                    image.setSize(0);
                }
                image.setStatus(String.valueOf(jsonObject1.get("Status")));
                try {
                    image.setInstanceNum(jsonObject1.getInt("InstanceNum"));
                }catch (Exception e){
                    image.setInstanceNum(0);
                }
                image.setTemplateName(String.valueOf(jsonObject1.get("TemplateName")));
                image.setTemplateImageType(String.valueOf(jsonObject1.get("TemplateImageType")));
                image.setIsoDisk(jsonObject1.getBoolean("IsoDisk"));
                try {
                    image.setGpu(jsonObject1.getBoolean("Gpu"));
                }catch (Exception e){
                    image.setGpu(false);
                }
                ImageSet[i] = image;
            }
            Gson gson = new Gson();
            return "{"+gson.toJson("Code")+":"+gson.toJson("success")+","+gson.toJson("TotalCount")+":"+gson.toJson(TotalCount)+","+gson.toJson("ImageSet")+":"+gson.toJson(ImageSet)+"}";
        }catch (Exception e){
            e.printStackTrace();
            String code;
            String errorMessage;
            code = jsonObject.getString("Code");
            errorMessage = jsonObject.getString("ErrorMessage");
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("Code","error");
            jsonObject2.put("ErrorMessage",errorMessage);
            return jsonObject2.toString();
        }
    }
}

