package com.binary.servermonitor.data_collection.services;

import com.binary.servermonitor.data_collection.dao.UserInfoDao;
import com.binary.servermonitor.data_collection.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author 夕
 * @date 2019/5/2
 */

@Service
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;


    public UserBean getUserInfo(String username){
        return  userInfoDao.findByUsername(username);
    }
}
