package com.binary.servermonitor.rulemonitor.monitorservice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.*;
import com.binary.servermonitor.service.queryseverice.*;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class GetUtilService {
    public ArrayList[] getCpuUtil(String hostip, Integer size, String startTime, String endTime){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.cpuUseUrl);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetCpuUseUtilService service = new GetCpuUseUtilService();
        return service.getCpuUseService(infoBean);
    }

    public ArrayList[] getMemUtil(String hostIp, Integer size, String startTime, String endTime){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostIp);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.memUseInfo);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetMemUseUtilInfoService service = new GetMemUseUtilInfoService();
        return service.getMemUseUtilService(infoBean);
    }

    public ArrayList[] getDiskUtil(String hostIp, Integer size, String startTime, String endTime){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostIp);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.memUseInfo);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetDiskUseUtilService service = new  GetDiskUseUtilService();
        return service.getDiskUsed(infoBean);
    }

    public ArrayList[] getReadIoUtil(String hostId, Integer size, String startTime, String endTime){
        ReadIoDataBean infoBean = new ReadIoDataBean();
        infoBean.setId(hostId);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.readioDataUrl);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetDiskIoService service = new GetDiskIoService();
        return service.getReadIoUsed(infoBean);
    }

    public ArrayList[] getWriteIoUtil(String hostId, Integer size, String startTime, String endTime){
        WriteIoDataBean infoBean = new WriteIoDataBean();
        infoBean.setId(hostId);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.writeioDataUrl);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetDiskIoService service = new GetDiskIoService();
        return service.getWriteIoUsed(infoBean);
    }

    public ArrayList[] getReadIopsUtil(String hostId, Integer size, String startTime, String endTime){
        ReadIopsDataBean infoBean = new ReadIopsDataBean();
        infoBean.setId(hostId);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.readiopsDataUrl);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetDiskIoService service = new GetDiskIoService();
        return service.getReadIopsUsed(infoBean);
    }

    public ArrayList[] getWriteIopsUtil(String hostId, Integer size, String startTime, String endTime){
        WriteIopsDataBean infoBean = new WriteIopsDataBean();
        infoBean.setId(hostId);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.writeiopsDataUrl);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetDiskIoService service = new GetDiskIoService();
        return service.getWriteIopsUsed(infoBean);
    }

    public ArrayList[] getIpInflowUtil(String hostId, Integer size, String startTime, String endTime){
        PublicIpInflowDataBean infoBean = new PublicIpInflowDataBean();
        infoBean.setId(hostId);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.publicipinflowDataUrl);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetIpflowService service = new GetIpflowService();
        return service.getIpInFlow(infoBean);
    }

    public ArrayList[] getIpOutflowUtil(String hostId, Integer size, String startTime, String endTime){
        PublicIpOutflowDataBean infoBean = new PublicIpOutflowDataBean();
        infoBean.setId(hostId);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.publicipoutflowDataUrl);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetIpflowService service = new GetIpflowService();
        return service.getIpOutFlow(infoBean);
    }

    public ArrayList[] getAverageLoadUtil(String hostIp, Integer size, String startTime, String endTime){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostIp);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.averageLoad);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetAverageLoadService service = new GetAverageLoadService();
        return service.getAverageLoad(infoBean);
    }
    public ArrayList[] getMysqlQpsUtil(String hostIp, Integer size, String startTime, String endTime){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostIp);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.mysqlqQps);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetMysqlQpsService service = new GetMysqlQpsService();
        return service.getMyqlQps(infoBean);
    }

    public ArrayList[] getMysqlTpsUtil(String hostIp, Integer size, String startTime, String endTime){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostIp);
        infoBean.setSize(size);
        infoBean.setQueryUrl(SearchUrlList.mysqlTps);
        infoBean.setStartTime(startTime);
        infoBean.setEndTime(endTime);
        GetMysqlTpsService service = new GetMysqlTpsService();
        return service.getMyqlTps(infoBean);
    }

}
