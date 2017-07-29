package com.neusoft.service.impl;

import com.neusoft.mapper.IAdminMapper;
import com.neusoft.mapper.ICategoryMapper;
import com.neusoft.mapper.IGoodsMapper;
import com.neusoft.mapper.IGoodsPhotoMapper;
import com.neusoft.model.AdminUser;
import com.neusoft.model.Category;
import com.neusoft.model.Goods;
import com.neusoft.model.Goodsphoto;
import com.neusoft.model.extraModel.Admin_order;
import com.neusoft.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
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
    private IGoodsMapper goodsMapper;
    @Autowired
    private ICategoryMapper categoryMapper;
    @Autowired
    private IGoodsPhotoMapper goodsPhotoMapper;


    @CacheEvict(allEntries=true)
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

    @Override
    public boolean verify_AdminUser(AdminUser adminUser) {
        if(adminMapper.getCorrespondingAdminUser(adminUser)==null){
            return false;
        }
        return true;
    }

    @Override
    public int getGoodsIdByGoodsName(String Goodsname) {
        return goodsMapper.getGoodsIdByGoodsName(Goodsname);
    }

    @Override
    @CacheEvict(allEntries=true)
    public int addCategory(Category category) {
        if(category.getParentflag() == null || category.getParentflag() == false){
            category.setParentflag(false);
            categoryMapper.addCategory(category);
        }else{
            categoryMapper.addCategoryParent(category);
        }
        return 0;
    }

    @Override
    public List<Admin_order> getAllAdminOrders() {
        return adminMapper.getAllAdminOrders();
    }

    @Override
    public List<Admin_order> getAllAdminOrdersIsFinished() {
        return adminMapper.getAllAdminOrdersIsFinished();
    }

    @Override
    public List<Admin_order> getAllAdminOrdersNotFinished() {
        return adminMapper.getAllAdminOrdersNotFinished();
    }

    @Override
    public List<Category> getAllParentCategories() {
        return categoryMapper.getAllParentCategories();
    }

    @Override
    public List<Category> getAllSonCategories() {
        return categoryMapper.getAllSonCategories();
    }

    @Override
    public int delete_category(int categoryid) {
        categoryMapper.delCategoryById(categoryid);
        return 0;
    }
}
