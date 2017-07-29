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
    @Select("select * from myorder where orderbuyer= #{orderbuyer}")
    public List<Order> getOrderByBuyer(@Param("orderbuyer") int orderbuyer);

    /*
    用户购买商品时就会插入一条新的订单项
     */
    @Insert("insert into myorder(orderid,ordergoods,orderbuyer,ordertime," +
            "orderfinished,orderdestination,orderprice,ordercompany, addressid)" +
            "values(#{orderid},#{ordergoods},#{orderbuyer},#{ordertime}," +
            "#{orderfinished},#{orderdestination},#{orderprice}," +
            "#{ordercompany}, #{addressid})")
    public void addOrder(Order order);

    /*
    只能修改订单状态，原始数据一插入就不能修改
    */
    @Update("update myorder set orderfinished=#{orderfinished} where " +
            "orderid=#{orderid}")
    public void updateOrder(@Param("orderfinished") boolean orderfinished, @Param
            ("orderid") int orderid);

    @Delete("delete from myorder where orderid=#{orderid}")
    public void delOrderById(@Param("orderid") int orderid);

    @Update("update myorder set iscommented=true where orderid=#{orderid}")
    public void evaluateOrder(int orderid);


}