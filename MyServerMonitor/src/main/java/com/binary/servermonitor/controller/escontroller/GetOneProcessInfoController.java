package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.OneProcessInfo;
import com.binary.servermonitor.entity.ProcessInfo;
import com.binary.servermonitor.entity.esbean.ProcessBean;
import com.binary.servermonitor.service.queryseverice.GetOneProcessInfoService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetOneProcessInfoController {

    @PostMapping(value = "/getOneProcessInfo")
    public ArrayList<OneProcessInfo> getProcessInfo(@RequestParam String hostip, @RequestParam String pid){
        ProcessBean processBean = new ProcessBean();
        processBean.setId(hostip);
        processBean.setSize(1000);
        processBean.setPid(pid);
        processBean.setQueryUrl(SearchUrlList.processInfo);
        processBean.setStartTime(DateTool.getOneDayStartTime());
        processBean.setEndTime(DateTool.getNowTime());
        GetOneProcessInfoService service = new GetOneProcessInfoService();
        ArrayList<OneProcessInfo> list = service.getOneProcessInfo(processBean);
        return list;
    }
}
