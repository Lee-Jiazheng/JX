package com.neusoft.service;

import com.neusoft.model.Shopcart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IShopCartService {
    public List<Integer> getShopCartFromCookie(HttpServletRequest request);

    public void addShopCartToCookie(HttpServletRequest request, HttpServletResponse response, int goodId);

    public List<Integer> getShopcartById(int shopcartBuyer);

    public void addShopcart(Shopcart shopcart);

    public void delShopcartById(int shopcartBuyer);

}
