package com.neusoft.mapper;

import com.neusoft.model.AdminUser;
import com.neusoft.model.Goods;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Bruce Lee on 2017/7/18.
 */
public interface IAdminMapper {
    @Insert("insert into adminuser(adminname, adminpassword, phonenum) values(#{adminName}, #{adminPassword}, #{phoneNum})")
    int addAdminUser(AdminUser adminUser);

    @Insert("insert into goods(goodsName, goodsQuantity, goodscreatetime, goodsprice, goodscategory, goodsstatus, goodsupdatetime) " +
            "values(#{goodsName}, #{goodsQuantity}, #{goodsCreateTime}, #{goodsPrice}, #{goodsCategory}, #{goodsStatus}, #{goodsUpdateTime})")
    int addGood(Goods good);
}
