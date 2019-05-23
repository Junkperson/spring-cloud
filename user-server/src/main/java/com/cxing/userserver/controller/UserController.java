package com.cxing.userserver.controller;


import com.cxing.userserver.service.UserService;
import com.cxing.userserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/selectUser")
    public User selectUser(String name){
        User user = new User();
        user.setId(Integer.parseInt(this.port));
        user.setName(name);
        System.out.printf("我是id为: %d ,name为：%s \n ", user.getId(), user.getName());
        return user;

    }


    @RequestMapping("/queryUser")
    public User queryUser(Integer id){
        User user = new User();
        user.setId(id);
        user = userService.queryUser(user);
        System.out.printf("我是id为: %d ,name为：%s . ", user.getId(), user.getName());
        return user;

    }

    @RequestMapping("/selectOrder")
    public String selectOrder(String name){
        System.out.println("userserver查询orderserver");
        return restTemplate.getForObject("http://ORDER-SERVER/order/selectOrder?name="+name,String.class);

    }



}
