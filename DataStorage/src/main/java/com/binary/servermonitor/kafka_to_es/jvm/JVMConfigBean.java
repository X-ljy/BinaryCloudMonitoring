package com.binary.servermonitor.kafka_to_es.jvm;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 夕
 * @date 2019/5/28
 */
@Component
@PropertySource(value = "application-jvm.properties")
@ConfigurationProperties(prefix = "jvm")
public class JVMConfigBean {

    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
