package com.example.service.impl;

import com.example.dao.GoodsDao;
import com.example.dao.SaleDao;
import com.example.entity.Goods;
import com.example.entity.Sale;
import com.example.exception.NotEnoughException;
import com.example.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    /*
    第一种设置方式
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            timeout = 20,
            rollbackFor = {NotEnoughException.class, NullPointerException.class})
    */

    /*
    第二种设置方式
     @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            timeout = 20
     )

     解释 rollbackFor 的使用；
     1）框架首先检查方法抛出的异常是不是在 rollbackFor 的数组中， 如果在一定回滚。
     2）如果方法抛出的异常不在 rollbackFor 数组，
        继续检查抛出的异常是不是 RuntimeException.
        如果是RuntimeException，一定回滚。
     */

    //第三种方式：使用默认值 REQUIRED ，发生运行时异常回滚。
    @Transactional
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
