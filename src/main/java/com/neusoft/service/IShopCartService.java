package com.neusoft.service;

import com.neusoft.model.Shopcart;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IShopCartService {
    public List<Integer> getShopCartFromCookie(HttpServletRequest request);

    public List<Integer> getShopcartById(int shopcartBuyer);

    public void addShopcart(Shopcart shopcart);

    public void delShopcartById(int shopcartBuyer);

}
