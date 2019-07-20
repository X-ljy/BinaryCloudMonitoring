package com.binary.servermonitor.data_collection.dao;

import com.binary.servermonitor.data_collection.entity.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.openmbean.CompositeData;
import java.time.temporal.TemporalAccessor;

/**
 * @author 夕
 * @date 2019/5/2
 */

@Repository
public interface UserInfoDao extends JpaRepository<UserBean,Integer> {
    UserBean findByUsername(String username);
}
