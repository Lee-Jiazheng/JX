package com.neusoft.mapper;

import com.neusoft.model.AdminUser;
import com.neusoft.model.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Bruce Lee on 2017/7/18.
 */
public interface IAdminMapper {
    @Insert("insert into adminuser(adminname, adminpassword, phonenum) values(#{adminName}, #{adminPassword}, #{phoneNum})")
    int addAdminUser(AdminUser adminUser);

    @Insert("insert into goods(goodsName, goodsQuantity, goodscreatetime, goodsprice, goodscategory, goodsstatus, goodsupdatetime) " +
            "values(#{goodsName}, #{goodsQuantity}, #{goodsCreateTime}, #{goodsPrice}, #{goodsCategory}, #{goodsStatus}, #{goodsUpdateTime})")
    int addGood(Goods good);

    @Select("select * from adminuser where adminname = #{adminName} and adminpassword = #{adminPassword}")
    AdminUser getCorrespondingAdminUser(AdminUser adminUser);
}
