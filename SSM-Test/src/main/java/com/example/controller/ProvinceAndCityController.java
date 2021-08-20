package com.example.controller;

import com.example.entity.City;
import com.example.entity.Province;
import com.example.service.ProvinceAndCityService;
import com.example.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProvinceAndCityController {
    @Autowired
    private ProvinceAndCityService service;

    //查询所有的省份
    @RequestMapping("/queryProvince.do")
    @ResponseBody
    public CommonResult queryProvinces(){
        List<Province> list = service.queryProvinces();
        CommonResult cr = new CommonResult();
        if(list !=null && list.size()>0){
            cr.setCode(0);
            cr.setMsg("查询成功");
            cr.setData(list);
        } else {
            cr.setCode(1);
            cr.setMsg("查询无结果");
            cr.setData("");
        }
        return cr;
    }

    //添加城市
    @RequestMapping("/city/addCity.do")
    @ResponseBody
    public CommonResult addCity(City city) {
        int rows = service.addCity(city);
        CommonResult cr = new CommonResult();
        if(rows > 0) {
            cr.setCode(0);
            cr.setMsg("添加城市"+city.getName()+"成功");
            cr.setData(city);
        } else {
            cr.setCode(1);
            cr.setMsg("添加城市失败");
            cr.setData("");
        }
        return cr;
    }


    //查询城市
    @RequestMapping("/city/queryCity.do")
    @ResponseBody
    public CommonResult queryCity(Integer pid) {
        List<City> cityList = service.queryCities(pid);
        CommonResult cr  = new CommonResult();
        if(cityList != null && cityList.size() > 0 ) {
            cr.setCode(0);
            cr.setMsg("查询出"+cityList.size()+"个城市");
            cr.setData(cityList);
        } else {
            cr.setCode(1);
            cr.setMsg("查询无结果");
            cr.setData("");
        }
        return cr;
    }
}
