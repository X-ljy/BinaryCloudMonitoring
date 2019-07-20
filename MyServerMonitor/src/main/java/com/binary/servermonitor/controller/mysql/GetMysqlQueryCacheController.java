package com.binary.servermonitor.controller.mysql;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetMysqlInnodbBufferService;
import com.binary.servermonitor.service.queryseverice.GetMysqlQpsService;
import com.binary.servermonitor.service.queryseverice.GetMysqlQueryCacheService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetMysqlQueryCacheController {

    @PostMapping(value = "/getMysqlQueryCache")
    public ArrayList[] getMysqlQueryCache(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlQueryCache);
        infoBean.setStartTime(DateTool.getOneHourStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlQueryCacheService service = new GetMysqlQueryCacheService();
        return service.getMyqlQueryCache(infoBean);
    }

    @PostMapping(value = "/getDayMysqlQueryCache")
    public ArrayList[] getDayMysqlQueryCache(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlQueryCache);
        infoBean.setStartTime(DateTool.getOneDayStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlQueryCacheService service = new GetMysqlQueryCacheService();
        return service.getMyqlQueryCache(infoBean);
    }

    @PostMapping(value = "/getWeekMysqlQueryCache")
    public ArrayList[] getWeekMysqlQueryCache(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlQueryCache);
        infoBean.setStartTime(DateTool.getOneWeekStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlQueryCacheService service = new GetMysqlQueryCacheService();
        return service.getMyqlQueryCache(infoBean);
    }
}
