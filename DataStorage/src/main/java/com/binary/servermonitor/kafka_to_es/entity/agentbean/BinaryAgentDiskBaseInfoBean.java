package com.binary.servermonitor.kafka_to_es.entity.agentbean;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/6/30
 */
@Repository
public class BinaryAgentDiskBaseInfoBean {
    /**
     * {"date": "2019-06-29 16:40:05", "data": {"tmpfs": {"diskUsed": "0", "diskUseRate": "0%", "diskAvail": "93M", "diskSize": "93M", "fileSystem": "tmpfs", "mounted": "/run/user/0"}, "overlay": {"diskUsed": "11G", "diskUseRate": "30%", "diskAvail": "27G", "diskSize": "40G", "fileSystem": "overlay", "mounted": "/var/lib/docker/overlay2/e3b5d146199fdd9fe82ff320b9642170c7dd28a84781eaea3732abcd9cd07412/merged"}, "/dev/vdb1": {"diskUsed": "37M", "diskUseRate": "1%", "diskAvail": "9.2G", "diskSize": "9.8G", "fileSystem": "/dev/vdb1", "mounted": "/vdb1"}, "devtmpfs": {"diskUsed": "0", "diskUseRate": "0%", "diskAvail": "451M", "diskSize": "451M", "fileSystem": "devtmpfs", "mounted": "/dev"}, "/dev/vda1": {"diskUsed": "11G", "diskUseRate": "30%", "diskAvail": "27G", "diskSize": "40G", "fileSystem": "/dev/vda1", "mounted": "/"}, "shm": {"diskUsed": "0", "diskUseRate": "0%", "diskAvail": "64M", "diskSize": "64M", "fileSystem": "shm", "mounted": "/var/lib/docker/containers/bfaac199e2e9bc6451d43e70080bc5b3d4a7898fadf0afda31030f7fc0d0a92b/mounts/shm"}}, "hostIp": "49.82.41.203"}
     *         Filesystem：代表该文件系统时哪个分区，所以列出的是设备名称。
     *         Size：空间总大小
     *         Used：已经使用的空间大小。
     *         Available：剩余的空间大小。
     *         Use%：磁盘使用率。如果使用率在90%以上时，就需要注意了，避免磁盘容量不足出现系统问题，尤其是对于文件内容增加较快的情况(如/home、/var/spool/mail等)。
     *         Mounted on：磁盘挂载的目录，即该磁盘挂载到了哪个目录下面
     */
    private String hostIp;
    private String date;
    private String fileSystem;
    private String size;
    private String used;
    private String available;
    private String useRate;
    private String mounted;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"fileSystem\":\"" + fileSystem  + "\"," +
                "\"size\":\"" + size  + "\"," +
                "\"used\":\"" + used  + "\"," +
                "\"available\":\"" + available  + "\"," +
                "\"useRate\":\"" + useRate  + "\"," +
                "\"mounted\":\"" + mounted  + "\""  +
                "}";
    }
    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(String fileSystem) {
        this.fileSystem = fileSystem;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getUseRate() {
        return useRate;
    }

    public void setUseRate(String useRate) {
        this.useRate = useRate;
    }

    public String getMounted() {
        return mounted;
    }

    public void setMounted(String mounted) {
        this.mounted = mounted;
    }
}
