package com.sdu.spittr.controller;

import com.sdu.spittr.bean.Order;
import com.sdu.spittr.dao.OrderRepository;
import com.sdu.spittr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by J on 2017/3/15.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MongoOperations operations;

    @RequestMapping("/{cusName}")
    public
    @ResponseBody
    List<Order> showOrder(@PathVariable(value = "cusName") String cus) {
//        List<Order> orders = orderService.findOrderByCustomer(cus);
        List<Order> orders1 = orderRepository.findByCustomer(cus);
        return orders1;
    }

//    @RequestMapping("/{id}")
//    public @ResponseBody Order showOrder2(@PathVariable(value ="id") String id){
//        Order order = orderRepository.findOne(id);
//        return  order;
//    }


}



