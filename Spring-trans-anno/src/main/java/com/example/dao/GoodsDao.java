package com.example.dao;

import com.example.entity.Goods;


public interface GoodsDao {
    Goods selectById(Integer id);

    // 更新商品信息
    // goods有属性id和amount
    // id为此次购买商品id, amount为此次购买数量
    int updateGoodS(Goods goods);
}
