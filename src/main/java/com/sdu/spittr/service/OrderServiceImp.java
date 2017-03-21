package com.sdu.spittr.service;

import com.sdu.spittr.bean.Order;
import com.sdu.spittr.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by J on 2017/3/15.
 */
@Service("orderService")
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findOrderByCustomer(String cus) {
        return orderRepository.findByCustomer(cus);
    }

    @Override
    public List<Order> findOrderByCustomerAndType(String cus, String t) {
        return orderRepository.findByCustomerAndType(cus,t);
    }
}
