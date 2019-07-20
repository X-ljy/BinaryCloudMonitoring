package com.binary.servermonitor.rulemonitor;


import com.binary.servermonitor.rulemonitor.service.FiveMinuteMonitorService;
import com.binary.servermonitor.rulemonitor.service.OneMinuteMonitorService;
import com.binary.servermonitor.rulemonitor.service.SixtyMinuteMonitorService;
import com.binary.servermonitor.rulemonitor.service.TwentyMinuteMonitorService;
import com.binary.servermonitor.util.MySchedulerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Wei Peng
 */


@Component
@Order(value = 2)
public class MonitorJob implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        MySchedulerFactory.addJob("OneMonitorRuleJob","MonitorRuleGroup",
                "OneMonitorRuleTrigger","MonitorRuleTriggerGroup",
                OneMinuteMonitorService.class,"0 0/1 * * * ? *");
        MySchedulerFactory.addJob("FiveMonitorRuleJob","MonitorRuleGroup",
                "FiveMonitorRuleTrigger","MonitorRuleTriggerGroup",
                FiveMinuteMonitorService.class,"0 0/5 * * * ? *");
        MySchedulerFactory.addJob("TwMonitorRuleJob","MonitorRuleGroup",
                "TwMonitorRuleTrigger","MonitorRuleTriggerGroup",
                TwentyMinuteMonitorService.class,"0 0/20 * * * ? *");
        MySchedulerFactory.addJob("OneHourMonitorRuleJob","MonitorRuleGroup",
                "OneHourMonitorRuleTrigger","MonitorRuleTriggerGroup",
                SixtyMinuteMonitorService.class,"0 0/59 * * * ? *");
    }

}