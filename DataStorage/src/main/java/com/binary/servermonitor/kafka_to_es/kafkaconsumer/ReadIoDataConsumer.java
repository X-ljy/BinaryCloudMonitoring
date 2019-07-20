package com.binary.servermonitor.kafka_to_es.kafkaconsumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.kafka_to_es.common.IndexList;
import com.binary.servermonitor.kafka_to_es.entity.ReadIoDataBean;
import com.binary.servermonitor.kafka_to_es.util.DateFormat;
import com.binary.servermonitor.kafka_to_es.util.EsUtils;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @author 夕
 * @date 2019/5/15
 */
@Service
public class ReadIoDataConsumer extends Thread {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String topic;
    private String zookeeperConnect;
    private String groupId;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getZookeeperConnect() {
        return zookeeperConnect;
    }

    public void setZookeeperConnect(String zookeeperConnect) {
        this.zookeeperConnect = zookeeperConnect;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }



    /**
     * {"Data":[{"Data":[["2019-05-10T05:45:00Z","0.00"]],"Tag":"vda"},
     *        {"Data":[["2019-05-10T05:45:00Z","0.00"]],"Tag":"vdb"}],
     * 	"Id":"i-si6rj33hdi40d",
     * 	"Unit":"Bytes/s",
     * 	"Interval":60}
     *curl -POST 10.10.44.127:9200/readiodata/readiodata/_mapping?pretty -d '{
     *    "readiodata": {
     *        "properties": {
     *               "id": {
     *                       "type": "keyword",
     *                       "store": "true"
     *                },
     *               "data":{
     *                     "properties":{
     *                          "tag1" :  {
     *                                 "properties": {
     *                                           "date1": {
     *                                                         "type": "date",
     *                                                          "format":"yyyy-MM-dd HH:mm:ss"
     *                                                         },
     *                                           "data1": {"type":"double"}
     *                                   }
     *                            },
     *                         "tag2" : {
     *                                "properties": {
     *                                           "date2": {
     *                                                         "type": "date",
     *                                                          "format":"yyyy-MM-dd HH:mm:ss"
     *                                                         },
     *                                          "data2": {"type":"double"}
     *                                   }
     *                           }
     *                      }
     *               },
     *               "unit": {
     *                     "type": "text"
     *               }
     *        }
     *    }
     * }'
     */

    @Autowired
    ReadIoDataBean readIoDataBean;

    @Override
    public void run() {
        ConsumerConnector consumer = createConsumer();
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, 1); // 一次从主题中获取一个数据
        Map<String, List<KafkaStream<byte[], byte[]>>>  messageStreams = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = messageStreams.get(topic).get(0);// 获取每次接收到的这个数据
        ConsumerIterator<byte[], byte[]> iterator =  stream.iterator();
        while(iterator.hasNext()){

            String message = new String(iterator.next().message());


            JSONObject jsonObject = JSON.parseObject(message);

            readIoDataBean.setId(jsonObject.getString("Id"));
            readIoDataBean.setUnit(jsonObject.getString("Unit"));

            JSONArray jsonArray = jsonObject.getJSONArray("Data");

            JSONObject jsonObject1 = jsonArray.getJSONObject(0);
            readIoDataBean.setTag1(jsonObject1.getString("Tag"));
            JSONArray jsonArray1 = jsonObject1.getJSONArray("Data");
            JSONArray jsonArray11 = jsonArray1.getJSONArray(0);
            readIoDataBean.setData1((Double) jsonArray11.getDouble(1));
            String date1 = jsonArray11.getString(0);
            String dd1 = DateFormat.DateFormatToString(date1);
            readIoDataBean.setDate1(dd1);

            JSONObject jsonObject2 = jsonArray.getJSONObject(0);
            readIoDataBean.setTag2(jsonObject1.getString("Tag"));
            JSONArray jsonArray2 = jsonObject2.getJSONArray("Data");
            JSONArray jsonArray22 = jsonArray2.getJSONArray(0);
            readIoDataBean.setData2((Double) jsonArray22.getDouble(1));
            String date2 = jsonArray22.getString(0);
            String dd2 = DateFormat.DateFormatToString(date2);
            readIoDataBean.setDate2(dd2);

            System.out.println(readIoDataBean.toJsonString());

            try {
                EsUtils.sendDataToIndex(IndexList.readIoDataIndex,readIoDataBean.toJsonString());
            } catch (IOException e) {
                logger.error("ReadIoDataConsumer" + e.getMessage());

            }

        }
    }

    private ConsumerConnector createConsumer() {
        Properties properties = new Properties();
        properties.put("zookeeper.connect", zookeeperConnect);//声明zk
        properties.put("group.id", groupId);// 必须要使用别的组名称， 如果生产者和消费者都在同一组，则不能访问同一组内的topic数据
        return Consumer.createJavaConsumerConnector(new ConsumerConfig(properties));
    }


}
