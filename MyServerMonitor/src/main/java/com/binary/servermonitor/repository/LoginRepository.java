package com.binary.servermonitor.repository;

import com.binary.servermonitor.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wei Peng
 * findByUsername 通过用户邮箱查询密码
 * fatch data by username
 */
@Repository
public interface LoginRepository extends JpaRepository<UserLogin, Integer> {
    public UserLogin findByUsername(String username);
}
