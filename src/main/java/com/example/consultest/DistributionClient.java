package com.example.consultest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "myprefix-myApp")
public interface DistributionClient {

    @RequestMapping(method = RequestMethod.POST, value = "/data", consumes = "application/json")
    String sendData(String data);
}
