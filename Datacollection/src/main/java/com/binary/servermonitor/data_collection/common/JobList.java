package com.binary.servermonitor.data_collection.common;

import com.binary.servermonitor.data_collection.job.*;
import com.binary.servermonitor.data_collection.job.mysql.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 夕
 * @date 2019/5/8
 */
public class JobList {


    public static ArrayList<Class> joblist = new ArrayList<Class>(){{
        add(ReadIoDataJob.class);
        add(ReadIopsDataJob.class);
        add(WriteIoDataJob.class);
        add(WriteIopsDataJob.class);
        add(PublicIpInFlowDataJob.class);
        add(PublicIpOutFlowDataJob.class);
        add(BinaryAgentCpuUseInfoProducerJob.class);
        add(BinaryAgentDiskBaseInfoProducerJob.class);
        add(BinaryAgentDiskIoInfoProducerJob.class);
        add(BinaryAgentLoadAverageProducerJob.class);
        add(BinaryAgentMemBaseInfoProducerJob.class);
        add(BinaryAgentNetworkCardInfoProducerJob.class);
        add(BinaryAgentOnlineUsersProducerJob.class);
        add(BinaryAgentProcInfoProducerJob.class);

        add(BinaryAgentMysqlConnectionNumberJob.class);
        add(BinaryAgentMysqlInnodbBufferJob.class);
        add(BinaryAgentMysqlKeyBufferJob.class);
        add(BinaryAgentMysqlprocesslistJob.class);
        add(BinaryAgentMysqlQpsjob.class);
        add(BinaryAgentMysqlQueryCacheJob.class);
        add(BinaryAgentMysqlTableCacheJob.class);
        add(BinaryAgentMysqlThreadCacheJob.class);
        add(BinaryAgentMysqlTPSJob.class);

    }};



}
