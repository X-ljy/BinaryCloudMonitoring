package com.binary.servermonitor.kafka_to_es.kafkaconsumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.kafka_to_es.common.IndexList;
import com.binary.servermonitor.kafka_to_es.entity.PublicipInflowDataBean;
import com.binary.servermonitor.kafka_to_es.entity.PublicipOutflowDataBean;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author 夕
 * @date 2019/5/15
 */
@Service
public class PublicipOutflowDataConsumer extends Thread{

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
     * {"size":1,"data":[{"data":[["2019-05-10T05:39:00Z","8.48"]],"Ip":"49.82.41.170"}],"Id":["i-si6rj33hdi40d"],"Unit":"Kbps","Interval":60}
     *
     *curl -POST 10.10.44.127:9200/publicipoutflowdata/publicipoutflowdata/_mapping?pretty -d '{
     *   "publicipoutflowdata": {
     *     "properties": {
     *       "id": {
     *         "type": "keyword",
     *         "store": "true"
     *       },
     *       "date": {
     *         "type": "date",
     *         "format":"yyyy-MM-dd HH:mm:ss"
     *       },
     *       "data": {
     *         "type": "double"
     *       },
     *       "unit": {
     *         "type": "text"
     *       }
     *     }
     *   }
     * }'
     */

    @Autowired
    PublicipOutflowDataBean publicipOutflowDataBean;

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
            publicipOutflowDataBean.setUnit(jsonObject.getString("Unit"));
            publicipOutflowDataBean.setId(jsonObject.getJSONArray("Id").getString(0));

            JSONArray jsonArray = jsonObject.getJSONArray("data").getJSONObject(0)
                    .getJSONArray("data")
                    .getJSONArray(0);
            publicipOutflowDataBean.setData(jsonArray.getDouble(1));
            String dd = DateFormat.DateFormatToString(jsonArray.getString(0));
            publicipOutflowDataBean.setDate(dd);

            try {
                EsUtils.sendDataToIndex(IndexList.publicipOutflowDataIndex,publicipOutflowDataBean.toJsonString());
            } catch (IOException e) {
                logger.error("PublicipOutflowDataConsumer" + e.getMessage());
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
