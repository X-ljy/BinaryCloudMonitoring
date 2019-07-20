package com.binary.servermonitor.controller.mysql;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetMysqlInnodbBufferService;
import com.binary.servermonitor.service.queryseverice.GetMysqlTableCacheService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetMysqlTableCacheController {

    @PostMapping(value = "/getMysqlTableCache")
    public ArrayList[] getMysqlTableCache(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlTableCache);
        infoBean.setStartTime(DateTool.getOneHourStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlTableCacheService service = new GetMysqlTableCacheService();
        return service.getMyqlTableCache(infoBean);
    }

    @PostMapping(value = "/getDayMysqlTableCache")
    public ArrayList[] getDayMysqlTableCache(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlTableCache);
        infoBean.setStartTime(DateTool.getOneDayStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlTableCacheService service = new GetMysqlTableCacheService();
        return service.getMyqlTableCache(infoBean);
    }

    @PostMapping(value = "/getWeekMysqlTableCache")
    public ArrayList[] getWeekMysqlTableCache(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlTableCache);
        infoBean.setStartTime(DateTool.getOneWeekStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlTableCacheService service = new GetMysqlTableCacheService();
        return service.getMyqlTableCache(infoBean);
    }
}
