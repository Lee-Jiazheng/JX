package com.neusoft.service.impl;

import com.neusoft.mapper.IAdminMapper;
import com.neusoft.model.Goods;
import com.neusoft.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
@Service("adminService")
@Transactional
public class AdminService implements IAdminService{

    @Autowired
    private IAdminMapper adminMapper;


    public int add_good(Goods good) {
        adminMapper.addGood(good);
        return 0;
    }
}
