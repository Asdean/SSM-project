package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.domain.SysUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository("mysqlDao")
public class MySqlUserDao implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("====执行了数据库的insert操作===");
    }
}
