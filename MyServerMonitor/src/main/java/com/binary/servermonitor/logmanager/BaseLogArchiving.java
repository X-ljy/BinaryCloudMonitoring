package com.binary.servermonitor.logmanager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.HostIp;
import com.binary.servermonitor.entity.esbean.LogFileBean;
import com.binary.servermonitor.repository.HostIpRepository;
import com.binary.servermonitor.util.DateTool;
import com.binary.servermonitor.util.EsUtils;
import com.binary.servermonitor.util.RepositoryUtil;
import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author 夕
 * @date 2019/5/22
 */

@Component
public class BaseLogArchiving implements Job {


    private static LogFileBean logFileBean = new LogFileBean();


    public static String JsonTOCsv(String json){
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    public static com.alibaba.fastjson.JSONArray AnalysisJson(String res){

        com.alibaba.fastjson.JSONArray resJsonArray = new com.alibaba.fastjson.JSONArray();

        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        com.alibaba.fastjson.JSONArray jsonArray = jsonObject1.getJSONArray("hits");
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject jsonObject2 = (JSONObject) iterator.next();
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            resJsonArray.add(jsonObject3);
        }

        return resJsonArray;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String res = null;
        com.alibaba.fastjson.JSONArray jsonArray = null;
        String Temp = null;
        String FileName = null;
        //获取host列表
        String[] hostID =  HostList.getHostList();

        for (String str : hostID){
            try {

                HostIp hostIp = RepositoryUtil.getHostIp(str);

                //CPU 数据
                logFileBean.setQueryUrl(SearchUrlList.cpuUseUrl);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toCpuJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/CpuUseLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));


                //基础磁盘数据
                logFileBean.setQueryUrl(SearchUrlList.diskBaseInfo);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toDiskInfoJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/DiskBaseLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //磁盘IO数据
                logFileBean.setQueryUrl(SearchUrlList.diskIoInfo);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toDiskIoInfoJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/DiskIoLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));


                //系统平均负载数据
                logFileBean.setQueryUrl(SearchUrlList.averageLoad);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toAverageJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/LoadAverageLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //内存数据
                logFileBean.setQueryUrl(SearchUrlList.memUseInfo);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toMemeryJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/MemeryLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //公网IP流入数据
                logFileBean.setQueryUrl(SearchUrlList.publicipinflowDataUrl);
                logFileBean.setId(str);
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toPublicInflowJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/PublicIpInflowLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //公网IP流出数据
                logFileBean.setQueryUrl(SearchUrlList.publicipoutflowDataUrl);
                logFileBean.setId(str);
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toPublicOutflowJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/PublicIpOutflowLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));


                //磁盘读取IO数据
                logFileBean.setQueryUrl(SearchUrlList.readioDataUrl);
                logFileBean.setId(str);
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toReadIoJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/ReadIoLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //磁盘读取IOPS数据
                logFileBean.setQueryUrl(SearchUrlList.readiopsDataUrl);
                logFileBean.setId(str);
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toReadIopsJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/ReadIopsLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));


                //磁盘写入IO数据
                logFileBean.setQueryUrl(SearchUrlList.writeioDataUrl);
                logFileBean.setId(str);
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toWriteIoJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/WriteIoLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //磁盘写入IOPS数据
                logFileBean.setQueryUrl(SearchUrlList.writeiopsDataUrl);
                logFileBean.setId(str);
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toWriteIopsJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/WriteIopsLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));


                //主机网卡流量信息
                logFileBean.setQueryUrl(SearchUrlList.netCardInfo);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toNetworkCardJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/NetWorkCardLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //在线用户信息
                logFileBean.setQueryUrl(SearchUrlList.binaryagentonlineusersindex);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toOnlineUserJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/OnlineUserLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //进程信息
                logFileBean.setQueryUrl(SearchUrlList.processInfo);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(25000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toProcJsonString());
                System.out.println("proc : "  +  res);
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/ProcLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //mysql连接数
                logFileBean.setQueryUrl(SearchUrlList.mysqlConnectionNumber);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toMysqlConnectionNumbeJsonString());
                System.out.println("mysqlConnectionNumber : "  +  res);
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/MysqlConnectionNumberLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //mysql Innodb Buffer 命中率
                logFileBean.setQueryUrl(SearchUrlList.mysqLinnodbBuffer);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toMysqlInnodbBufferJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/MysqlInnodbBufferLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));


                //mysql key Buffer 命中率
                logFileBean.setQueryUrl(SearchUrlList.mysqlKeyBuffer);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toMysqlKeyBufferJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/MysqlKeyBufferLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //mysql连接详细数据
                logFileBean.setQueryUrl(SearchUrlList.mysqlProcessList);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toMysqlProcessListJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/MysqlProcessListLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //mysql QPS
                logFileBean.setQueryUrl(SearchUrlList.mysqlqQps);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toMysqlQPSJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/MysqlQPSLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //mysql Query Cache 命中率
                logFileBean.setQueryUrl(SearchUrlList.mysqlQueryCache);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toMysqlQueryCacheJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/MysqlQueryCacheLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //mysql table Cache 命中率
                logFileBean.setQueryUrl(SearchUrlList.mysqlTableCache);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toMysqlTableCacheJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/MysqlTableCacheLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));


                //mysql thread Cache 命中率
                logFileBean.setQueryUrl(SearchUrlList.mysqlThreadCache);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toMysqlThreadCacheJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/MysqlThreadCacheLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));

                //mysql TPS 命中率
                logFileBean.setQueryUrl(SearchUrlList.mysqlTps);
                logFileBean.setId(hostIp.getHostip());
                logFileBean.setStartTime(DateTool.getLogStartTime());
                logFileBean.setEndTime(DateTool.getLogEndTime());
                logFileBean.setSize(1000);
                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toMysqlTPSJsonString());
                jsonArray = AnalysisJson(res);
                Temp = DateTool.getLogEndTime().replaceAll(":","-");
                FileName = Temp.replaceAll(" ","_");
                FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+hostIp.getHostip()+"/MysqlTPSLogData/"+FileName+".csv"), JsonTOCsv(jsonArray.toString()));


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
