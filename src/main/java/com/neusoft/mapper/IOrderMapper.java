package com.neusoft.mapper;

import com.neusoft.model.Order;
import org.apache.ibatis.annotations.*;

public interface IOrderMapper {
    /*
    通过订单ID查询相关信息
     */
    @Select("select * from order where orderId= #{orderId}")
    public Order getOrderById(@Param("orderId") int orderId);

    /*
    通过用户查询相关信息
     */
    @Select("select * from order where orderBuyer= #{orderBuyer}")
    public Order getOrderByBuyer(@Param("orderBuyer") int orderBuyer);

    /*
    用户购买商品时就会插入一条新的订单项
     */
    @Insert("insert into order(orderId,orderGoods,orderBuyer,orderTime," +
            "orderFinished,orderDestination,orderPrice,orderCompany)" +
            "values(#{orderId},#{orderGoods},#{orderBuyer},#{orderTime}," +
            "#{orderFinished},#{orderDestination},#{orderPrice}," +
            "#{orderCompany})")
    public void addOrder(Order order);

    /*
    只能修改订单状态，原始数据一插入就不能修改
    */
    @Update("update order set orderFinished=#{orderFinished} where " +
            "orderId=#{orderId}")
    public void updateOrder(@Param("isFinished") Boolean isFinished, @Param
            ("orderId") int orderId);

    @Delete("delete from order where orderId=#{orderId}")
    public void delOrderById(@Param("orderId") int orderId);


}