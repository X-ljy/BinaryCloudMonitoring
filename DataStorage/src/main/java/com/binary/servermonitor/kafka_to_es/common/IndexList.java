package com.binary.servermonitor.kafka_to_es.common;

/**
 * @author 夕
 * @date 2019/5/14
 */
public class IndexList {

    public static String readIoDataIndex = "/readiodata/readiodata";
    public static String readIopsDataIndex = "/readiopsdata/readiopsdata";
    public static String writeIoDataIndex = "/writeiodata/writeiodata";
    public static String writeIopsDataIndex = "writeiopsdata/writeiopsdata";
    public static String publicipInflowDataIndex = "/publicipinflowdata/publicipinflowdata";
    public static String publicipOutflowDataIndex = "/publicipoutflowdata/publicipoutflowdata";

    //agent
    public static String binaryagentcpuuseinfoindex = "/binaryagentcpuuseinfoindex/binaryagentcpuuseinfoindex";
    public static String binaryagentdiskbaseinfoindex = "/binaryagentdiskbaseinfoindex/binaryagentdiskbaseinfoindex";
    public static String binaryagentdiskioinfoindex = "/binaryagentdiskioinfoindex/binaryagentdiskioinfoindex";
    public static String binaryagentloadaverageindex = "/binaryagentloadaverageindex/binaryagentloadaverageindex";
    public static String binaryagentmembaseinfoindex = "/binaryagentmembaseinfoindex/binaryagentmembaseinfoindex";
    public static String binaryagentnetworkcardinfoindex = "/binaryagentnetworkcardinfoindex/binaryagentnetworkcardinfoindex";
    public static String binaryagentonlineusersindex = "/binaryagentonlineusersindex/binaryagentonlineusersindex";
    public static String binaryagentprocinfoindex = "/binaryagentprocinfoindex/binaryagentprocinfoindex";

    //mysqlagentIndex
    public static String binaryagentmysqlconnectionnumberindex = "/binaryagentmysqlconnectionnumberindex/binaryagentmysqlconnectionnumberindex";
    public static String binaryagentmysqlinnodbbufferindex = "/binaryagentmysqlinnodbbufferindex/binaryagentmysqlinnodbbufferindex";
    public static String binaryagentmysqlkeybufferindex = "/binaryagentmysqlkeybufferindex/binaryagentmysqlkeybufferindex";
    public static String binaryagentmysqlprocesslistindex = "/binaryagentmysqlprocesslistindex/binaryagentmysqlprocesslistindex";
    public static String binaryagentmysqlqpsindex = "/binaryagentmysqlqpsindex/binaryagentmysqlqpsindex";
    public static String binaryagentmysqlquerycacheindex = "/binaryagentmysqlquerycacheindex/binaryagentmysqlquerycacheindex";
    public static String binaryagentmysqltablecacheindex = "/binaryagentmysqltablecacheindex/binaryagentmysqltablecacheindex";
    public static String binaryagentmysqlthreadcacheindex = "/binaryagentmysqlthreadcacheindex/binaryagentmysqlthreadcacheindex";
    public static String binaryagentmysqltpsindex = "/binaryagentmysqltpsindex/binaryagentmysqltpsindex";

    //jvmIndex
    public static String classLoadingInfoIndex = "/classloadinginfo/classloadinginfo";
    public static String compilationInfoIndex = "/compilationinfo/compilationinfo";
    public static String jvmMemoryInfoIndex = "/jvmmemoryinfo/jvmmemoryinfo";
    public static String operatingSystemInfoIndex = "/operatingsysteminfo/operatingsysteminfo";
    public static String jvmRuntimeInfoIndex = "/jvmruntimeinfoindex/jvmruntimeinfoindex";
    public static String threadInfoIndex = "/threadinfoindex/threadinfoindex";


}



