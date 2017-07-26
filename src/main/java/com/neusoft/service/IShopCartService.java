package com.neusoft.service;

import com.neusoft.model.Shopcart;

import java.util.List;

public interface IShopCartService {
    public List<Integer> getShopcartById(int shopcartBuyer);

    public void addShopcart(Shopcart shopcart);

    public void delShopcartById(int shopcartBuyer);

}
