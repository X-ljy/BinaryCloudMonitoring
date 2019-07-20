package com.binary.servermonitor.data_collection.kafkaproducer;

import com.binary.servermonitor.data_collection.common.KafkaInfo;
import com.binary.servermonitor.data_collection.common.TopicList;
import com.binary.servermonitor.data_collection.data_api.cpu.CpuApi;
import com.binary.servermonitor.data_collection.data_api.disk.ReadIopsApi;
import com.binary.servermonitor.data_collection.data_api.parameters.Requestparameters;
import com.binary.servermonitor.data_collection.entity.UserBean;
import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONArray;

import java.util.Properties;

/**
 * @author 夕
 * @date 2019/5/4
 */
public class ReadIopsData {

    static Producer<String, String> producer = new KafkaProducer<>(KafkaInfo.getProperties());


    public static String getReadIopsData(UserInfoBean userInfoBean){
        Requestparameters requestparameters = new Requestparameters();
        ReadIopsApi readIopsApi = new ReadIopsApi();
        requestparameters.setAccessKeyId(userInfoBean.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfoBean.getAccess_key_secret());
        requestparameters.setAction("InstanceIopsReadMonitor");
        requestparameters.setRegion(userInfoBean.getRegion());

        JSONArray serverIdArray = new JSONArray(userInfoBean.getHostID());
        for (int i =0 ;i < serverIdArray.length(); i++){
            requestparameters.setId(serverIdArray.getString(i));
            String res =  readIopsApi.url(requestparameters);
            if (res == "error"){
                continue;
            }else {
                producer.send(new ProducerRecord<>(TopicList.ReadIopsDataTopic,serverIdArray.getString(i),res));
            }
        }
        return "success";

    }

}
