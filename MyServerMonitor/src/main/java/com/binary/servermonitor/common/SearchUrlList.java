package com.binary.servermonitor.common;

/**
 * @author 夕
 * @date 2019/5/19
 */
public class SearchUrlList {

    public static String processDataUrl = "/processdata/processinfodata/_search";

    public static String averageLoad = "/binaryagentloadaverageindex/binaryagentloadaverageindex/_search";

    public static String cpuDataUrl     = "/cpudata/cpudata/_search";

    public static String cpuUseUrl = "/binaryagentcpuuseinfoindex/binaryagentcpuuseinfoindex/_search";

    public static String processInfo = "/binaryagentprocinfoindex/binaryagentprocinfoindex/_search";

    public static String memUseInfo = "/binaryagentmembaseinfoindex/binaryagentmembaseinfoindex/_search";

    public static String netCardInfo = "/binaryagentnetworkcardinfoindex/binaryagentnetworkcardinfoindex/_search";

    public static String diskIoInfo = "binaryagentdiskioinfoindex/binaryagentdiskioinfoindex/_search";
    public static String diskBaseInfo = "/binaryagentdiskbaseinfoindex/binaryagentdiskbaseinfoindex/_search";

    public static String diskinfoDataUrl = "/diskinfodata/diskinfodata/_search";

    public static String memoryDataUrl = "/memorydata/memorydata/_search";

    public static String publicipinflowDataUrl = "/publicipinflowdata/publicipinflowdata/_search";

    public static String publicipoutflowDataUrl = "/publicipoutflowdata/publicipoutflowdata/_search";

    public static String readioDataUrl = "/readiodata/readiodata/_search";

    public static String readiopsDataUrl = "/readiopsdata/readiopsdata/_search";

    public static String runtimeAndAverageDataUrl = "/runtimeandaveragedata/runtimeandaveragedata/_search";

    public static String writeioDataUrl = "/writeiodata/writeiodata/_search";

    public static String writeiopsDataUrl = "/writeiopsdata/writeiopsdata/_search";

    public static String binaryagentonlineusersindex = "/binaryagentonlineusersindex/binaryagentonlineusersindex/_search";

    public static String mysqlProcessList = "/binaryagentmysqlprocesslistindex/binaryagentmysqlprocesslistindex/_search";
    public static String mysqlConnectionNumber = "/binaryagentmysqlconnectionnumberindex/binaryagentmysqlconnectionnumberindex/_search";
    public static String mysqLinnodbBuffer = "/binaryagentmysqlinnodbbufferindex/binaryagentmysqlinnodbbufferindex/_search";
    public static String mysqlKeyBuffer = "/binaryagentmysqlkeybufferindex/binaryagentmysqlkeybufferindex/_search";
    public static String mysqlqQps = "/binaryagentmysqlqpsindex/binaryagentmysqlqpsindex/_search";
    public static String mysqlQueryCache = "/binaryagentmysqlquerycacheindex/binaryagentmysqlquerycacheindex/_search";
    public static String mysqlTableCache = "/binaryagentmysqltablecacheindex/binaryagentmysqltablecacheindex/_search";
    public static String mysqlThreadCache = "/binaryagentmysqlthreadcacheindex/binaryagentmysqlthreadcacheindex/_search";
    public static String mysqlTps = "/binaryagentmysqltpsindex/binaryagentmysqltpsindex/_search";

    //jvm
    public static String classLoadingInfoIndex = "/classloadinginfo/classloadinginfo/_search";
    public static String compilationInfoIndex = "/compilationinfo/compilationinfo/_search";
    public static String jvmMemoryInfoIndex = "/jvmmemoryinfo/jvmmemoryinfo/_search";
    public static String operatingSystemInfoIndex = "/operatingsysteminfo/operatingsysteminfo/_search";
    public static String jvmRuntimeInfoIndex = "/jvmruntimeinfoindex/jvmruntimeinfoindex/_search";
    public static String threadInfoIndex = "/threadinfoindex/threadinfoindex/_search";

}
