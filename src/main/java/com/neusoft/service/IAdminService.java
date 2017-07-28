package com.neusoft.service;

import com.neusoft.model.AdminUser;
import com.neusoft.model.Category;
import com.neusoft.model.Goods;
import com.neusoft.model.Goodsphoto;

import java.util.List;
import java.util.Map;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
public interface IAdminService {
    public static final String cacheName = "adminCache";

    public int add_good(Goods goods);
    public Map<Category, List<Category>> getAllCategoriesWithLevel();

    public Goodsphoto getGoodPhotoByGoodId(int goodId);
    public boolean verify_AdminUser(AdminUser adminUser);
    public int getGoodsIdByGoodsName(String Goodsname);
}
