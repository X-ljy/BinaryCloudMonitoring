package com.binary.servermonitor.data_collection.kafkaproducer;

import com.binary.servermonitor.data_collection.common.KafkaInfo;
import com.binary.servermonitor.data_collection.common.TopicList;
import com.binary.servermonitor.data_collection.data_api.cpu.CpuApi;
import com.binary.servermonitor.data_collection.data_api.disk.WriteIopsApi;
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
public class WriteIopsData {
    static Producer<String, String> producer = new KafkaProducer<>(KafkaInfo.getProperties());

    public static String getWriteIopsData(UserInfoBean userInfoBean){
        Requestparameters requestparameters = new Requestparameters();
        WriteIopsApi writeIopsApi = new WriteIopsApi();
        requestparameters.setAccessKeyId(userInfoBean.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfoBean.getAccess_key_secret());
        requestparameters.setAction("InstanceIopsWriteMonitor");
        requestparameters.setRegion(userInfoBean.getRegion());

        JSONArray serverIdArray = new JSONArray(userInfoBean.getHostID());
        for (int i =0 ;i < serverIdArray.length(); i++){
            requestparameters.setId(serverIdArray.getString(i));
            String res =  writeIopsApi.url(requestparameters);
            if (res == "error"){
                continue;
            }else {
                producer.send(new ProducerRecord<>(TopicList.WriteIopsDataTopic,serverIdArray.getString(i),res));
            }
        }
        return "success";
    }
}
