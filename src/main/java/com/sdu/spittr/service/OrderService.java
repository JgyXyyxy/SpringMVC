package com.sdu.spittr.service;

import com.sdu.spittr.bean.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by J on 2017/3/15.
 */
public interface OrderService {

    List<Order> findAllOrders();

    List<Order> findOrderByCustomer(String cus);

    List<Order> findOrderByCustomerAndType(String cus,String t);
}
