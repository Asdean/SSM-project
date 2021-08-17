package com.example.services.impl;

import com.example.services.SomeService;

public class SomeServiceImpl implements SomeService {
    /**
     * spring默认使用的无参数构造方法，创建对象。
     * 如果定义了有参数构造方法， 应该在定义无参数构造方法
     */
    public SomeServiceImpl() {
        System.out.println("SomeServiceImpl的无参数构造方法");
    }

    @Override
    public void doSome() {
        System.out.println("执行了doSome方法！");
    }
}
