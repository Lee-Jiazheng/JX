package com.neusoft.service;

import com.neusoft.model.Category;
import com.neusoft.model.Goods;

import java.util.List;
import java.util.Map;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
public interface IAdminService {
    public int add_good(Goods goods);
    public Map<Category, List<Category>> getAllCategoriesWithLevel();
}
