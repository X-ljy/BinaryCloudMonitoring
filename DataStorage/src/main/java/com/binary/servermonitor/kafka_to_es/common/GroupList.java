package com.binary.servermonitor.kafka_to_es.common;

/**
 * @author 夕
 * @date 2019/5/14
 */
public class GroupList {

    public static String zookeeperConnect = "10.10.44.127:2181,10.10.44.128:2181,10.10.44.129:2181";


    public static String groupCpu = "groupCpu";
    public static String groupBaseDisk = "groupBaseDisk";
    public static String groupIoDisk = "groupIoDisk";
    public static String groupMem = "groupMem";
    public static String groupOnlineUsers = "groupOnlineUsers";
    public static String groupProcess = "groupProcess";
    public static String groupNetworkCard = "groupNetworkCard";
    public static String groupPublicInflow = "groupPublicInflow";
    public static String groupPublicOutflow = "groupPublicOutflow";
    public static String groupReadIo = "groupReadIo";
    public static String groupReadIops = "groupReadIops";
    public static String groupLoadAverage = "groupLoadAverage";
    public static String groupWriteIo = "groupWriteIo";
    public static String groupWriteIops = "groupWriteIops";

    //mysql
    public static String groupBinaryAgentMysqlConnectionNumber = "groupBinaryAgentMysqlConnectionNumber";
    public static String groupBinaryAgentMysqlInnodbBuffer = "groupBinaryAgentMysqlInnodbBuffer";
    public static String groupBinaryAgentMysqlKeyBuffer = "groupBinaryAgentMysqlKeyBuffer";
    public static String groupBinaryAgentMysqlprocesslist = "groupBinaryAgentMysqlprocesslist";
    public static String groupBinaryAgentMysqlQps = "groupBinaryAgentMysqlQps";
    public static String groupBinaryAgentMysqlQueryCache = "groupBinaryAgentMysqlQueryCache";
    public static String groupBinaryAgentMysqlTableCache = "groupBinaryAgentMysqlTableCache";
    public static String groupBinaryAgentMysqlThreadCache = "groupBinaryAgentMysqlThreadCache";
    public static String groupBinaryAgentMysqlTPS = "groupBinaryAgentMysqlTPS";



}
