package com.binary.servermonitor.kafka_to_es.common;

/**
 * @author 夕
 * @date 2019/5/4
 */
public class TopicList {

    public static String ReadIoDataTopic = "ReadIoData";
    public static String ReadIoDataTopicCorn = "0 0/1 * * * ? *";

    public static String ReadIopsDataTopic = "ReadIopsData";
    public static String ReadIopsDataTopicCorn = "0 0/1 * * * ? *";

    public static String WriteIoDataTopic = "WriteIoData";
    public static String WriteIoDataTopicCorn = "0 0/1 * * * ? *";

    public static String WriteIopsDataTopic = "WriteIopsData";
    public static String WriteIopsDataTopicCorn = "0 0/1 * * * ? *";

    public static String PublicIpInFlowDataTopic = "PublicIpInFlowData";
    public static String PublicIpInFlowDataTopicCorn = "0 0/1 * * * ? *";

    public static String PublicIpOutFlowDataTopic = "PublicIpOutFlowData";
    public static String PublicIpOutFlowDataTopicCorn = "0 0/1 * * * ? *";

    //agent
    public static String binaryAgentCpuUseInfo = "binaryAgentCpuUseInfo";
    public static String binaryAgentDiskBaseInfo = "binaryAgentDiskBaseInfo";
    public static String binaryAgentDiskIoInfo = "binaryAgentDiskIoInfo";
    public static String binaryAgentLoadAverage = "binaryAgentLoadAverage";
    public static String binaryAgentMemBaseInfo = "binaryAgentMemBaseInfo";
    public static String binaryAgentNetworkCardInfo = "binaryAgentNetworkCardInfo";
    public static String binaryAgentOnlineUsers = "binaryAgentOnlineUsers";
    public static String binaryAgentProcInfo = "binaryAgentProcInfo";

    //mysqlAgent
    public static String binaryAgentMysqlprocesslist = "binaryAgentMysqlprocesslist";
    public static String binaryAgentMysqlConnectionNumber = "binaryAgentMysqlConnectionNumber";
    public static String binaryAgentMysqlQps = "binaryAgentMysqlQps";
    public static String binaryAgentMysqlTPS = "binaryAgentMysqlTPS";
    public static String binaryAgentMysqlKeyBuffer = "binaryAgentMysqlKeyBuffer";
    public static String binaryAgentMysqlInnodbBuffer = "binaryAgentMysqlInnodbBuffer";
    public static String binaryAgentMysqlQueryCache = "binaryAgentMysqlQueryCache";
    public static String binaryAgentMysqlTableCache = "binaryAgentMysqlTableCache";
    public static String binaryAgentMysqlThreadCache = "binaryAgentMysqlThreadCache";

}
