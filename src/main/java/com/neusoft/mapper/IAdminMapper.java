package com.neusoft.mapper;

import com.neusoft.model.AdminUser;
import com.neusoft.model.Goods;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Bruce Lee on 2017/7/18.
 */
public interface IAdminMapper {
    @Insert("insert into admin_user(admin_name, admin_password, phone_num) values(#{adminName}, #{adminPassword}, #{phoneNum})")
    int addAdminUser(AdminUser adminUser);

    @Insert("insert into goods(goods_name, goods_quantity, goods_create_time, goods_price, goods_category, goods_status, goods_update_time) " +
            "values(#{goodsName}, #{goodsQuantity}, #{goodsCreateTime}, #{goodsPrice}, #{goodsCategory}, #{goodsStatus}, #{goodsUpdateTime})")
    int addGood(Goods good);
}
