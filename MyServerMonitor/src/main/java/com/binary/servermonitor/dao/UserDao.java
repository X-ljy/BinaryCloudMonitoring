package com.binary.servermonitor.dao;

import com.binary.servermonitor.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 夕
 * @date 2019/4/28
 */
public interface UserDao extends JpaRepository<UserLogin,String> {

}
