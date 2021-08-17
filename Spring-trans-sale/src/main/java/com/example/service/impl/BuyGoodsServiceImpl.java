package com.example.service.impl;

import com.example.dao.GoodsDao;
import com.example.dao.SaleDao;
import com.example.entity.Goods;
import com.example.entity.Sale;
import com.example.exception.NotEnoughException;
import com.example.service.BuyGoodsService;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("====buy()开始====");

        // 添加购买记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        // 查询购买商品
        Goods goods = goodsDao.selectById(goodsId);
        if (goods == null) {
            throw new NullPointerException(goodsId + "商品不存在");
        } else if (goods.getAmount() < nums) {
            throw new NotEnoughException(goodsId + "商品库存不足");
        }

        // 更新商品
        Goods good = new Goods();
        good.setId(goodsId);
        good.setAmount(nums);
        goodsDao.updateGoodS(good);

        System.out.println("====buy()完成====");
    }
}
