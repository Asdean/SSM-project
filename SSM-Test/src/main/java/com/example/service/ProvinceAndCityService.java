package com.example.service;

import com.example.entity.City;
import com.example.entity.Province;

import java.util.List;

public interface ProvinceAndCityService {
    int addCity(City city);

    List<City> queryCities(Integer provinceId);

    List<Province> queryProvinces();
}
