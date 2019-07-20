package com.binary.servermonitor.data_api.host;


import com.binary.servermonitor.data_api.bottle.ServerInfo;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.google.gson.Gson;
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
 * @retrn [{"Id":"i-ng6rj33hdi7","InterfaceSize":1,"VolumeSize":2,"Name":"001","Status":"START","Task":"NONE","ProductStatus":"NORMAL","PayType":"PREPAID","ProductModelId":"122","ProductType":"1核1G_SERIES_STANDARD","Cpu":1,"Memory":1,"Password":"K8.ccut","KeyPair":"null","KeyPairName":"null","CreateTime":"2019-04-03T17:13:18 +0800","DueTime":"2019-09-03T17:13:18 +0800","CloseTime":"2019-09-03T18:13:18 +0800","ShutdownTime":"null","BindStatus":"UNBIND","InterfaceSet":[{"Id":"p-2k6rj33hd013m","InstanceId":"i-ng6rj33hdi7","NetworkId":"n-6c6rj33hd398h","SubnetId":"s-zb6rj33hd4224","MacAddress":"fa:16:3e:93:9a:dc","IpAddress":"10.10.10.5","Status":"ON_LINE","Uuid":"f5a0be95-b9d2-4b0a-bde9-c4da0bdcb352","Type":"DEFAULT","NetworkName":"DEFAULT","Bandwidth":500}],"InternetSet":[{"Id":"eip-nu6rj33hdc9p","IpAddress":"49.82.41.203","Bandwidth":2,"PayType":"PREPAID","DueTime":"2019-09-03T17:13:12 +0800","CloseTime":"2019-09-03T18:13:12 +0800","AllocateTime":"2019-04-03T17:13:12 +0800","ProductStatus":"NORMAL","ProductModelId":"413","ProductType":"ChinaTelecom"}],"InternetSize":1,"VolumeSet":[{"Id":"v-hm6rj33hdi55i","Name":"cec1904032cU7_0sys","Type":"sata-vm","PayType":"PREPAID","Size":40,"Index":0,"DueTime":"2019-09-03T17:13:18 +0800","CloseTime":"null","CreateTime":"2019-04-03T17:13:18 +0800","Uuid":"fde3012d-9816-4ea9-8c01-e49ea1bc01ce","ProductStatus":"NORMAL","ProductModelId":116},{"Id":"v-w86rj33heg63n","Name":"cec1904032cU7_0data1","Type":"sata-vm","PayType":"PREPAID","Size":10,"Index":1,"DueTime":"2019-09-03T17:14:16 +0800","CloseTime":"2019-09-03T18:14:16 +0800","CreateTime":"2019-04-03T17:14:16 +0800","Uuid":"193194cb-4c09-46c6-937e-8cb93dfa8fc3","ProductStatus":"NORMAL","ProductModelId":116}],"Uuid":"112b14ae-a423-43c6-9f8b-e8c2bf4d9129","FirewallId":"f-s86rj33hd717x","ImageId":"t-mc6ri9ggb02n","ImageName":"CentOS","OsName":"CentOS7.2","OsVersion":"7.2","OsBit":"64","InitPassword":"K8.ccut","UserId":"18362782","Locked":false,"IdLong":"i-ng6rj33hdi7-112b14ae-a423-43c6-9f8b-e8c2bf4d9129","HostName":"jsha-nova07","Host":"jsha-nova07","InstanceSeries":"SERIES_STANDARD","SeriesName":"普通型"},{"Id":"i-si6rj33hdi40d","InterfaceSize":1,"VolumeSize":2,"Name":"002","Status":"START","Task":"NONE","ProductStatus":"NORMAL","PayType":"PREPAID","ProductModelId":"122","ProductType":"1核1G_SERIES_STANDARD","Cpu":1,"Memory":1,"Password":"K8.ccut","KeyPair":"null","KeyPairName":"null","CreateTime":"2019-04-03T17:13:18 +0800","DueTime":"2019-09-03T17:13:18 +0800","CloseTime":"2019-09-03T18:13:18 +0800","ShutdownTime":"null","BindStatus":"UNBIND","InterfaceSet":[{"Id":"p-vm6rj33hdz16i","InstanceId":"i-si6rj33hdi40d","NetworkId":"n-6c6rj33hd398h","SubnetId":"s-zb6rj33hd4224","MacAddress":"fa:16:3e:27:a2:e4","IpAddress":"10.10.10.4","Status":"ON_LINE","Uuid":"44a1619f-a62d-47ea-a3d2-28817ccc33f9","Type":"DEFAULT","NetworkName":"DEFAULT","Bandwidth":500}],"InternetSet":[{"Id":"eip-7x6rj34kbg117","IpAddress":"49.82.41.170","Bandwidth":2,"PayType":"PREPAID","DueTime":"2019-09-03T17:13:18 +0800","CloseTime":"2019-09-03T18:13:18 +0800","AllocateTime":"2019-04-04T20:11:51 +0800","ProductStatus":"NORMAL","ProductModelId":"413","ProductType":"ChinaTelecom"}],"InternetSize":1,"VolumeSet":[{"Id":"v-l56rj33heg628","Name":"cec1904032cU7_1data1","Type":"sata-vm","PayType":"PREPAID","Size":10,"Index":1,"DueTime":"2019-09-03T17:14:16 +0800","CloseTime":"2019-09-03T18:14:16 +0800","CreateTime":"2019-04-03T17:14:16 +0800","Uuid":"febd2280-ebad-4a75-994b-61d344733359","ProductStatus":"NORMAL","ProductModelId":116},{"Id":"v-hv6rj33hdi55f","Name":"cec1904032cU7_1sys","Type":"sata-vm","PayType":"PREPAID","Size":40,"Index":0,"DueTime":"2019-09-03T17:13:18 +0800","CloseTime":"null","CreateTime":"2019-04-03T17:13:18 +0800","Uuid":"81cff5bb-dffb-4536-ac97-cb043050e5e2","ProductStatus":"NORMAL","ProductModelId":116}],"Uuid":"0428b296-fcea-4afc-8343-13e443d941c9","FirewallId":"f-s86rj33hd717x","ImageId":"t-mc6ri9ggb02n","ImageName":"CentOS","OsName":"CentOS7.2","OsVersion":"7.2","OsBit":"64","InitPassword":"K8.ccut","UserId":"18362782","Locked":false,"IdLong":"i-si6rj33hdi40d-0428b296-fcea-4afc-8343-13e443d941c9","HostName":"jsha-nova10","Host":"jsha-nova10","InstanceSeries":"SERIES_STANDARD","SeriesName":"普通型"}]
 * 返回类型对象数组里面的每个对象包含数组
 * 数组中每个对象为每一台主机的信息
 * 对象中的InterfaceSet为私有网络信息，InternetSet为公网ip信息，VolumeSet为硬盘信息 均为对象数组
 *
 */
public class HostSnapQueryApi {

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
        //UTC时间
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
        return JsonDate;
    }
}
