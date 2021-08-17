package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.domain.SysUser;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    // 引用类型 @Autowired, @Resource
    // @Autowired
    @Resource
    private UserDao userDao;


    @Override
    public void addUser(SysUser user) {
        userDao.insertUser(user);
    }
}
