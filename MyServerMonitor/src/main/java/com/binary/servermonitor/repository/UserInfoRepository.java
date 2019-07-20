package com.binary.servermonitor.repository;

import com.binary.servermonitor.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wei Peng
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    public UserInfo findByUsername(String username);

}
