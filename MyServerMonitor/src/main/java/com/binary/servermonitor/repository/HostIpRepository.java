package com.binary.servermonitor.repository;

import com.binary.servermonitor.entity.HostIp;
import com.binary.servermonitor.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wei Peng
 */
@Repository
public interface HostIpRepository extends JpaRepository<HostIp,Integer> {
    public HostIp findByHostid(String hostid);

}
