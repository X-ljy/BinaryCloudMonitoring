package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetNowCpuMemUseService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetNowCpuMemUsenfoController {

    @PostMapping(value = "/getNowCpuMemData")
    public ArrayList<Float> getNowCpuMem(String hostip){
        InfoBean cpuUseInfoBean = new InfoBean();
        cpuUseInfoBean.setStartTime(DateTool.getStartTime());
        cpuUseInfoBean.setEndTime(DateTool.getEndTime());
        cpuUseInfoBean.setQueryUrl(SearchUrlList.cpuUseUrl);
        cpuUseInfoBean.setId(hostip);
        cpuUseInfoBean.setSize(50);
        GetNowCpuMemUseService service = new GetNowCpuMemUseService();
        float cpuUse = service.getNowCpuInfo(cpuUseInfoBean);
        InfoBean memInfoBean = new InfoBean();
        memInfoBean.setStartTime(DateTool.getStartTime());
        memInfoBean.setEndTime(DateTool.getEndTime());
        memInfoBean.setQueryUrl(SearchUrlList.memUseInfo);
        memInfoBean.setId(hostip);
        memInfoBean.setSize(50);
        float memUse = service.getNowMemInfo(memInfoBean);
        ArrayList<Float> list = new ArrayList<>();
        list.add(cpuUse);
        list.add(memUse);
        return list;
    }

}
