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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by Bruce Lee on 2017/7/23.
 */
@Service("shopCartService")
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
    public List<Integer> getShopCartFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        List<Integer> goodIds = new ArrayList<>();
        for(Cookie cookie : cookies){
            try{
                goodIds.add(Integer.parseInt(cookie.getValue()));
            }catch (Exception ex){
                System.out.println("cookie异常");
            }
        }
        return goodIds;
    }

    @Override
    public void addShopCartToCookie(HttpServletRequest request, HttpServletResponse response, int goodId) {

        String key = UUID.randomUUID().toString().replace("-", "");
        String value = String.valueOf(goodId);
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(24*60*60);
        response.addCookie(cookie);
    }

    @Override
    public List<Integer> getShopcartById(int shopcartBuyer) {
        List<Shopcart> shopcartList = shopcartMapper.getShopcartById(shopcartBuyer);
        List<Integer> goodsList = new ArrayList<>();
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
