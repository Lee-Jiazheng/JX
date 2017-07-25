package com.neusoft.service;

import com.neusoft.model.Order;

import java.util.List;

public interface IOrderService {

    public List<Order> getAllOrder();

    /*
     通过订单ID查询相关信息
    */
    public Order getOrderById(int orderId);

    /*
    通过用户查询相关信息
     */
    public List<Order> getOrderByBuyer(int orderBuyer);

    /*
    用户购买商品时就会插入一条新的订单项
     */
    public void addOrder(Order order);

    public void addOrder(int goodId, int userId);

    /*
    只能修改订单状态，原始数据一插入就不能修改
    */
    public void updateOrder(int isFinished, int orderId);

    public void delOrderById(int orderId);
}
