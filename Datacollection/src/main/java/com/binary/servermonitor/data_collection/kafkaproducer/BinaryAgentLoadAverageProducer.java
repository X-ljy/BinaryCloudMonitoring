package com.binary.servermonitor.data_collection.kafkaproducer;

import com.binary.servermonitor.data_collection.common.IpMap;
import com.binary.servermonitor.data_collection.common.KafkaInfo;
import com.binary.servermonitor.data_collection.common.TopicList;
import com.binary.servermonitor.data_collection.data_api.bottle.ServerInfo;
import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONArray;

/**
 * @author 夕
 * @date 2019/6/29
 */
public class BinaryAgentLoadAverageProducer {
    static Producer<String, String> producer = new KafkaProducer<>(KafkaInfo.getProperties());

    public static String runBinaryAgentLoadAverageProducer(UserInfoBean userInfoBean){

        JSONArray serverIdArray = new JSONArray(userInfoBean.getHostID());
        for (int i =0 ;i < serverIdArray.length(); i++){
            String res = ServerInfo.getBinaryAgentLoadAverage(IpMap.ipList.get(serverIdArray.getString(i)),"6666");
            if (res.equals("error")){
                continue;
            }else {
                producer.send(new ProducerRecord<>(TopicList.binaryAgentLoadAverage,serverIdArray.getString(i),res));
            }
        }
        return "success";
    }
}
