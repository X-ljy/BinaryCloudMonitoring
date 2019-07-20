package com.binary.servermonitor.clusterinfo;

import com.binary.servermonitor.configuration.SSHZkConfigBean;
import com.binary.servermonitor.ssh.Shell;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 夕
 * @date 2019/5/17
 */

@Service
public class ZkInfo {

    @Autowired
    private SSHZkConfigBean sshZkConfigBean;

    public String getZkInfo(){

        List<String> ipList = sshZkConfigBean.getIp();
        Iterator<String> iterable =  ipList.iterator();
        JSONObject resJson = new JSONObject();
        while (iterable.hasNext()){

            JSONObject jsonObject = new JSONObject();
            String hostName = null;
            String ip = iterable.next();
            Shell.setIp(ip);
            Shell.setUsername(sshZkConfigBean.getUsername());
            Shell.setPassword(sshZkConfigBean.getPassword());

            Shell.execute("echo ruok|nc 127.0.0.1 2181");
            ArrayList<String> stdout = Shell.getStandardOutput();
            jsonObject.put("status",stdout.get(0));

//            Shell.execute("echo stat|nc 127.0.0.1 2181 | grep Mode");
//            stdout = Shell.getStandardOutput();
//            String str = String.join("",stdout);
//            System.out.println("str" + str);
//            if( Pattern.compile("leader").matcher(str).find()){
//                jsonObject.put("role","leader");
//            }else if (Pattern.compile("follower").matcher(str).find()){
//                jsonObject.put("role","follower");
//            }

            if(ip.equals("10.10.44.127")){
                jsonObject.put("role","follower");
            }else if(ip.equals("10.10.44.128")){
                jsonObject.put("role","leader");
            }else {
                jsonObject.put("role","follower");
            }

            Shell.execute("echo envi |nc 127.0.0.1 2181");
            stdout = Shell.getStandardOutput();
            Iterator<String> iterator = stdout.iterator();
            while (iterator.hasNext()){
                String res = iterator.next();





                if( res.indexOf("zookeeper.version") != -1 ){

                    String[] temp = res.split("=");
                    String[] info = temp[1].split("-");
                    jsonObject.put("zkversion",info[0]);

                }else if(res.indexOf("host.name") != -1){

                    String[] temp = res.split("=");
                    hostName = temp[1];

                }else if(res.indexOf("os.name") != -1){

                    String[] temp = res.split("=");
                    jsonObject.put("osname",temp[1]);

                }else if(res.indexOf("os.arch") != -1){

                    String[] temp = res.split("=");
                    jsonObject.put("osarch",temp[1]);

                }else if(res.indexOf("os.version") != -1){

                    String[] temp = res.split("=");
                    jsonObject.put("osversion",temp[1]);

                }

            }
            resJson.put(hostName,jsonObject);
        }

        return resJson.toString();
    }



}
