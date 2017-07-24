package com.neusoft.service.impl;

import com.neusoft.mapper.IAdminMapper;
import com.neusoft.mapper.ICategoryMapper;
import com.neusoft.model.Category;
import com.neusoft.model.Goods;
import com.neusoft.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
@Service("adminService")
@Transactional
public class AdminService implements IAdminService{

    @Autowired
    private IAdminMapper adminMapper;
    @Autowired
    private ICategoryMapper categoryMapper;


    public int add_good(Goods good) {
        adminMapper.addGood(good);
        return 0;
    }

    @Override
    //@Cacheable
    public Map<Category, List<Category>> getAllCategoriesWithLevel() {
        Map<Category, List<Category>> result_map = new HashMap<>();
        List<Category> categories = categoryMapper.getAllCategories();


        for(Category category : categories){
            if(category.getParentFlag() == true){
                List<Category> tempCategory = categoryMapper.getCategoriesByParentId(category.getCategoryId());
                result_map.put(category, tempCategory);
            }
        }
        return result_map;
    }
}
