package com.cxing.orderserver.controller;

import com.cxing.orderserver.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/selectOrder")
    public Order selectOrer(String name){
        Order order =new Order();
        order.setId(1);
        order.setName(name);
        order.setPrice(1.0);
        return  order;
    }


    @RequestMapping("/selectUser")
    public String selectUser(String name){
        System.out.println("orderserver查询userserver");
        return this.restTemplate.getForObject("http://USER-SERVER/user/selectUser?name="+name,String.class);
    }


}
