package com.neusoft.service.impl;

import com.neusoft.mapper.IGoodsMapper;
import com.neusoft.mapper.IOrderMapper;
import com.neusoft.model.Order;
import com.neusoft.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/*
已实现的方法：获取所有订单，通过流水单号查询订单，通过买家查询订单，

增加订单，更新订单（修改状态），删除订单
 */
@Service("orderService")
@Transactional
public class OrderService implements IOrderService {
    @Autowired
    private IOrderMapper orderMapper;
    @Autowired
    private IGoodsMapper goodsMapper;

    public List<Order> getAllOrder() {
        return orderMapper.getAllOrder();
    }

    public Order getOrderById(int orderId) {
        return orderMapper.getOrderById(orderId);
    }

    public List<Order> getOrderByBuyer(int orderBuyer) {
        return orderMapper.getOrderByBuyer(orderBuyer);
    }

    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public void addOrder(int goodId, int userId) {
        Order order = new Order();
        order.setOrderbuyer(userId);
        order.setOrdergoods(goodId);
        order.setOrdertime(new Date());
        order.setOrderdestination("长春");
        orderMapper.addOrder(order);
    }

    public void updateOrder(int isFinished, int orderId) {
        orderMapper.updateOrder(isFinished, orderId);
    }

    public void delOrderById(int orderId) {
        orderMapper.delOrderById(orderId);
    }
}
