package com.neusoft.service.impl;

import com.neusoft.mapper.ICommentsMapper;
import com.neusoft.mapper.IGoodsMapper;
import com.neusoft.mapper.IShopcartMapper;
import com.neusoft.mapper.IUserMapper;
import com.neusoft.model.Shopcart;
import com.neusoft.service.IShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Bruce Lee on 2017/7/23.
 */
@Service("ShopCartService")
@Transactional
public class ShopCartService implements IShopCartService {

    @Autowired
    private ICommentsMapper commentsMapper;
    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private IGoodsMapper goodsMapper;
    @Autowired
    private IShopcartMapper shopcartMapper;

    @Override
    public List<Integer> getShopcartById(int shopcartBuyer) {
        List<Shopcart> shopcartList = shopcartMapper.getShopcartById(shopcartBuyer);
        List<Integer> goodsList = null;
        for (Shopcart shopcart : shopcartList) {
            goodsList.add(shopcart.getShopcartgoods());
        }
        return goodsList;
    }

    @Override
    public void addShopcart(Shopcart shopcart) {
        shopcartMapper.addShopcart(shopcart);
    }

    @Override
    public void delShopcartById(int shopcartBuyer) {
        shopcartMapper.delShopcartById(shopcartBuyer);
    }
}
