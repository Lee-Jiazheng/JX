package com.neusoft.service.impl;

import com.neusoft.mapper.IAdminMapper;
import com.neusoft.mapper.ICategoryMapper;
import com.neusoft.mapper.IGoodsMapper;
import com.neusoft.mapper.IGoodsPhotoMapper;
import com.neusoft.model.Category;
import com.neusoft.model.Goods;
import com.neusoft.model.Goodsphoto;
import com.neusoft.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames={IAdminService.cacheName})
public class AdminService implements IAdminService{

    @Autowired
    private IAdminMapper adminMapper;
    @Autowired
    private ICategoryMapper categoryMapper;
    @Autowired
    private IGoodsPhotoMapper goodsPhotoMapper;


    public int add_good(Goods good) {
        adminMapper.addGood(good);
        return 0;
    }

    @Override
    @Cacheable(key="#root.methodName")
    public Map<Category, List<Category>> getAllCategoriesWithLevel() {
        Map<Category, List<Category>> result_map = new HashMap<>();
        List<Category> categories = categoryMapper.getAllCategories();


        for(Category category : categories){
            if(category.getParentflag() == true){
                List<Category> tempCategory = categoryMapper.getCategoriesByParentId(category.getCategoryid());
                result_map.put(category, tempCategory);
            }
        }
        return result_map;
    }

    @Override
    public Goodsphoto getGoodPhotoByGoodId(int goodId) {
        List<Goodsphoto> goodsphotoList = goodsPhotoMapper.getAllPhoto(goodId);
        if(goodsphotoList.size() != 0){
            return goodsPhotoMapper.getAllPhoto(goodId).get(0);
        }else{
            return null;
        }
    }
}
