package com.example;

import com.example.dao.ProvinceDao;
import com.example.utils.MyBatisUtil;
import com.example.vo.ProvinceCity;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest2 {
    @Test
    public void testSelectProvinceCityList(){
        SqlSession session = MyBatisUtil.getSqlSession();
        ProvinceDao dao = session.getMapper(ProvinceDao.class);
        List<ProvinceCity> list = dao.selectProvinceCityList(1);
        session.close();
        list.forEach(p -> System.out.println(p));
    }
}
