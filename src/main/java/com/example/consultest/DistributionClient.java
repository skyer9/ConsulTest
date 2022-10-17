package com.example.consultest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "myprefix-myApp")
public interface DistributionClient {

    @GetMapping(value = "/data", consumes = "application/json")
    String sendData(@RequestParam(required = false) String query);
}
