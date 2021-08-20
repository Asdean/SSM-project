package com.example.dao;

import com.example.entity.City;

import java.util.List;

public interface CityDao {
    int insertCity(City city);

    List<City> selectCities(Integer provinceId);
}
