package com.example.service.impl;

import com.example.dao.CityDao;
import com.example.dao.ProvinceDao;
import com.example.entity.City;
import com.example.entity.Province;
import com.example.service.ProvinceAndCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceAndCityServiceImpl implements ProvinceAndCityService {
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private CityDao cityDao;

    @Override
    public int addCity(City city) {
        int rows = cityDao.insertCity(city);
        return rows;
    }

    @Override
    public List<City> queryCities(Integer provinceId) {
        List<City> list = cityDao.selectCities(provinceId);
        return list;
    }

    @Override
    public List<Province> queryProvinces() {
        List<Province> list = provinceDao.selectProvinces();
        return list;
    }
}
