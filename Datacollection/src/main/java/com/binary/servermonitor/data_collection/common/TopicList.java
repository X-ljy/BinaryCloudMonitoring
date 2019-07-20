package com.binary.servermonitor.data_collection.common;



/**
 * @author 夕
 * @date 2019/5/4
 */
public class TopicList {

    public  static String CpuDataTopic = "CpuData";

    public static String ReadIoDataTopic = "ReadIoData";

    public static String ReadIopsDataTopic = "ReadIopsData";

    public static String WriteIoDataTopic = "WriteIoData";

    public static String WriteIopsDataTopic = "WriteIopsData";

    public static String PublicIpInFlowDataTopic = "PublicIpInFlowData";

    public static String PublicIpOutFlowDataTopic = "PublicIpOutFlowData";

    //bottle
    public static String MemoryDataTopic = "MemoryData";

    public static String RunTimeAndAverageDataTopic = "RunTimeAndAverageData";

    public static String lineUsersDataTopic = "lineUsersData";

    public static String DiskInfoDataTopic = "DiskInfoData";

    public static String ProcessInfoDataTopic = "ProcessInfoData";

    //agent
    public static String    binaryAgentCpuUseInfo = "binaryAgentCpuUseInfo";
    public static String    binaryAgentDiskBaseInfo = "binaryAgentDiskBaseInfo";
    public static String    binaryAgentDiskIoInfo = "binaryAgentDiskIoInfo";
    public static String    binaryAgentLoadAverage = "binaryAgentLoadAverage";
    public static String    binaryAgentMemBaseInfo = "binaryAgentMemBaseInfo";
    public static String    binaryAgentNetworkCardInfo = "binaryAgentNetworkCardInfo";
    public static String    binaryAgentOnlineUsers = "binaryAgentOnlineUsers";
    public static String    binaryAgentProcInfo = "binaryAgentProcInfo";

    //mysqlAgent
    public static String    binaryAgentMysqlprocesslist = "binaryAgentMysqlprocesslist";
    public static String    binaryAgentMysqlConnectionNumber = "binaryAgentMysqlConnectionNumber";
    public static String    binaryAgentMysqlQps = "binaryAgentMysqlQps";
    public static String    binaryAgentMysqlTPS = "binaryAgentMysqlTPS";
    public static String    binaryAgentMysqlKeyBuffer = "binaryAgentMysqlKeyBuffer";
    public static String    binaryAgentMysqlInnodbBuffer = "binaryAgentMysqlInnodbBuffer";
    public static String    binaryAgentMysqlQueryCache = "binaryAgentMysqlQueryCache";
    public static String    binaryAgentMysqlTableCache = "binaryAgentMysqlTableCache";
    public static String    binaryAgentMysqlThreadCache = "binaryAgentMysqlThreadCache";


}
