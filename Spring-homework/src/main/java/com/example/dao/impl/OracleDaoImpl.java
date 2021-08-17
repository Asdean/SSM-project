package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.domain.SysUser;

/**
 *
 */
public class OracleDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("oracle的insert");
    }
}
