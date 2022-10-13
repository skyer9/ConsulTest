package com.example.consultest;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RequiredArgsConstructor
public class ConsulTestApplication {

    // private final DiscoveryClient discoveryClient;
    //
    //
    // @RequestMapping("/serviceUrl")
    // public String serviceUrl() {
    //     List<ServiceInstance> list = discoveryClient.getInstances("myprefix-myApp");
    //     if (list != null && list.size() > 0) {
    //         return list.get(0).getUri().toString();
    //     }
    //     return null;
    // }

    private final DistributionClient distributionClient;

    @RequestMapping("/use-feign")
    public String sendData() {
        distributionClient.sendData("Hello World");
        return "sent";
    }

    @RequestMapping("/data")
    public String test() {
        return "Hello Test";
    }

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsulTestApplication.class, args);
    }

}

