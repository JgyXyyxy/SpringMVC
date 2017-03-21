package com.sdu.spittr.controller;


import com.mongodb.BasicDBList;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import com.sdu.spittr.bean.Order;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by J on 2017/1/6.
 * MongoTemplate mongo
 */

@Controller
@RequestMapping({"/","homepage"})
public class HomeController {

    private static int coutttt = 0;
    @Autowired
    MongoOperations mongo;

    @RequestMapping(method = GET)
    public
//    @ResponseBody List<Order>
    String home(){

        long count = mongo.getCollection("test3").count();
        coutttt++;
        System.out.println("countt: "+coutttt);
        System.out.println("count: "+count);
//        多个条件组合查询时：
//        例如：onumber="002" and cname="zcy"
//        mongoTemplate.find (new Query(Criteria.where("onumber").is("002").and("cname").is("zcy")),entityClass)
//        例如：onumber="002" or cname="zcy"
//        mongoTemplate.findOne(newQuery(newCriteria().orOperator(Criteria.where("onumber").is("002"),Criteria.where("cname").is("zcy"))),entityClass);
//        Order order = new Order();
//        order.setId("1");
//        order.setCustomer("J");
//        order.setType("2");
////        mongo.save(order,"test3");
//        order.setId("2");
//        mongo.insert(order,"test3");
//        String orderId = "1";
//        Order order1 = mongo.findById(orderId,Order.class);
//        System.out.println("client: "+order1.getCustomer());


        return "home";
//        return all;
    }


}