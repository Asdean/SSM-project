package com.example.service.impl;

import com.example.service.SomeService;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        System.out.println("业务方法doSome(), 创建商品的订单");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("doOther()");
        return "abc";
    }

    @Override
    public String doFirst(String name) {
        System.out.println("执行doFirst()方法");
        return "doFirst";
    }

    @Override
    public void doSecond() {
        System.out.println("执行doSecond()方法" + 10/0);
    }

    @Override
    public void doThird() {
        System.out.println("执行doThird()方法" + 10/0);
    }
}
