package com.binary.servermonitor.kafka_to_es.entity.jvmbean;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 夕
 * @date 2019/5/29
 */
@Repository
public class RuntimeInfoBean {

    private String host;
    private String date;
    private String jvmVersion;
    private long jvmRunTime;
    private List<String> jvmArguments;
    private String classPath;
    private String bootClassPath;
    private String libraryPath;

    public String toJsonString(){
        return "{" +
                "\"host\":\"" + host  + "\","  +
                "\"date\":\"" + date  + "\","  +
                "\"jvmVersion\":\"" + jvmVersion + "\","  +
                "\"jvmRunTime\":\"" + jvmRunTime + "\","  +
                "\"jvmArguments\":\"" + String.join(",", jvmArguments) + "\","  +
                "\"classPath\":\"" + classPath + "\","  +
                "\"bootClassPath\":\"" + bootClassPath + "\","  +
                "\"libraryPath\":\"" +  libraryPath + "\""  +
                '}';
    }

//    public static void main(String[] args) {
//        System.out.println("+++++++++++++++++++++++++++++++++");
//        System.out.println("List转字符串");
//        List<String> list1 = new ArrayList<String>();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        String ss = String.join(",", list1);
//        System.out.println(StringUtils.join(list1,""));
//        System.out.println(ss);
//        System.out.println("+++++++++++++++++++++++++++++++++");
//        System.out.println("字符串转List");
//        List<String> listString = Arrays.asList(ss.split(","));
//        for (String string : listString) {
//            System.out.println(string);
//        }
//        System.out.println("+++++++++++++++++++++++++++++++++");
//    }
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJvmVersion() {
        return jvmVersion;
    }

    public void setJvmVersion(String jvmVersion) {
        this.jvmVersion = jvmVersion;
    }

    public long getJvmRunTime() {
        return jvmRunTime;
    }

    public void setJvmRunTime(long jvmRunTime) {
        this.jvmRunTime = jvmRunTime;
    }

    public List<String> getJvmArguments() {
        return jvmArguments;
    }

    public void setJvmArguments(List<String> jvmArguments) {
        this.jvmArguments = jvmArguments;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getBootClassPath() {
        return bootClassPath;
    }

    public void setBootClassPath(String bootClassPath) {
        this.bootClassPath = bootClassPath;
    }

    public String getLibraryPath() {
        return libraryPath;
    }

    public void setLibraryPath(String libraryPath) {
        this.libraryPath = libraryPath;
    }
}
