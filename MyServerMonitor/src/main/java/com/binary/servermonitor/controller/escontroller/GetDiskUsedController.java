package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetDiskUseService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetDiskUsedController {

    @PostMapping(value = "/getDiskUsed")
    public ArrayList<Float> getDiskUsed(@RequestParam String hostip){
        ArrayList<Float> list = new ArrayList<>();
        InfoBean infoBean = new InfoBean();
        infoBean.setStartTime(DateTool.getOneHourStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        infoBean.setQueryUrl(SearchUrlList.diskBaseInfo);
        infoBean.setId(hostip);
        infoBean.setSize(50);
        GetDiskUseService service = new GetDiskUseService();
        list = service.getDiskUsed(infoBean);
        return list;
    }
}
