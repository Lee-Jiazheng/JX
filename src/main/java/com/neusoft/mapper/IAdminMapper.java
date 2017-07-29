package com.neusoft.mapper;

import com.neusoft.model.AdminUser;
import com.neusoft.model.Goods;
import com.neusoft.model.extraModel.Admin_order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.List;
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

    @Select("select orderid, ordertime, orderfinished, goodcount, orderprice, addressname, nickname,  goodsname from myorder, user, goods, address where user.userid = myorder.orderbuyer and goods.goodsid = myorder.ordergoods and address.addressid = myorder.addressid")
    List<Admin_order> getAllAdminOrders();

    @Select("select orderid, ordertime, orderfinished, goodcount, orderprice, addressname, nickname,  goodsname from myorder, user, goods, address where user.userid = myorder.orderbuyer and goods.goodsid = myorder.ordergoods and address.addressid = myorder.addressid and orderfinished = true")
    List<Admin_order> getAllAdminOrdersIsFinished();

    @Select("select orderid, ordertime, orderfinished, goodcount, orderprice, addressname, nickname,  goodsname from myorder, user, goods, address where user.userid = myorder.orderbuyer and goods.goodsid = myorder.ordergoods and address.addressid = myorder.addressid and orderfinished = false")
    List<Admin_order> getAllAdminOrdersNotFinished();
}
