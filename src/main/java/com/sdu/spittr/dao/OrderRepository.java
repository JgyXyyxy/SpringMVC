package com.sdu.spittr.dao;

import com.sdu.spittr.bean.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by J on 2017/3/14.
 */
@Repository
public interface OrderRepository extends MongoRepository<Order,String> {


    List<Order> findByCustomer(String cus);

    List<Order> findByCustomerAndType(String cus,String t);
}
