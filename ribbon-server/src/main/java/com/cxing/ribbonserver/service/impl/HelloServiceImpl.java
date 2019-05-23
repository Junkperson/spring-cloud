package com.cxing.ribbonserver.service.impl;

import com.cxing.ribbonserver.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Object selectUser(String name) {
        return restTemplate.getForObject("http://USER-SERVER/user/selectUser?name="+name,String.class);
    }


    @HystrixCommand(fallbackMethod = "hiError")
    @Override
    public Object selectUser2(String name) {
        return restTemplate.getForObject("http://USER-SERVER/user/selectUser?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
