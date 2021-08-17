package com.example.dao;

import com.example.vo.ProvinceCity;

import java.util.List;

/**
 *
 */
public interface ProvinceDao {

    List<ProvinceCity> selectProvinceCityList(Integer provinceId);
}
