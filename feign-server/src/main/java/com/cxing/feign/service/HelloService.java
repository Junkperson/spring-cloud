package com.cxing.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "user-server")
public interface HelloService {

    @RequestMapping(value = "/user/selectUser",method = RequestMethod.GET)
    String selectUser(@RequestParam(value = "name") String name);

}
