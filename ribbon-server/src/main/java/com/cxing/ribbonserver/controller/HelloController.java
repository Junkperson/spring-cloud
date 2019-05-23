package com.cxing.ribbonserver.controller;

import com.cxing.ribbonserver.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        System.out.println("hi");
        return helloService.selectUser( name ).toString();
    }
    @RequestMapping(value = "/hi2")
    public String hi2(@RequestParam String name) {
        System.out.println("hi2");
        return helloService.selectUser2( name ).toString();
    }
}
