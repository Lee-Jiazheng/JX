package com.neusoft.mapper;

import com.neusoft.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderMapper {
    /*
    获取所有订单列表
     */
    @Select("select * from myorder")
    public List<Order> getAllOrder();

    /*
    通过订单ID查询相关信息
     */
    @Select("select * from myorder where orderid= #{orderid}")
    public Order getOrderById(@Param("orderid") int orderid);

    /*
    通过用户查询相关信息
     */
    @Select("select * from myorder where orderBuyer= #{orderbuyer}")
    public List<Order> getOrderByBuyer(@Param("orderBuyer") int orderBuyer);

    /*
    用户购买商品时就会插入一条新的订单项
     */
    @Insert("insert into myorder(orderid,ordergoods,orderbuyer,ordertime," +
            "orderfinished,orderdestination,orderprice,ordercompany)" +
            "values(#{orderid},#{ordergoods},#{orderbuyer},#{ordertime}," +
            "#{orderfinished},#{orderdestination},#{orderprice}," +
            "#{ordercompany})")
    public void addOrder(Order order);

    /*
    只能修改订单状态，原始数据一插入就不能修改
    */
    @Update("update order set orderfinished=#{orderfinished} where " +
            "orderid=#{orderid}")
    public void updateOrder(@Param("isfinished") int isFinished, @Param
            ("orderid") int orderid);

    @Delete("delete from myorder where orderid=#{orderid}")
    public void delOrderById(@Param("orderid") int orderid);


}