package com.example;

import com.example.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        BuyGoodsService service = (BuyGoodsService) ctx.getBean("buyGoodsService");

        // com.sun.proxy.$Proxy14, 使用事务, 创建代理对象
        // System.out.println(service.getClass().getName());
        // service.buy(1001, 10);
        // service.buy(1005, 10);
        // service.buy(1001, 200);
        service.buy(1002, 20);
    }
}
