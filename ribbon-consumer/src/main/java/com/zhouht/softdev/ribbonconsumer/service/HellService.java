package com.zhouht.softdev.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Copyright (C) 2023 Limited, a Tencent company. All rights reserved.
 *
 * @author p_htaozhou@tencent.com
 * @create 2023/12/25 11:33
 */

@Service
public class HellService {

    @Resource
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallBack",ignoreExceptions = TimeoutException.class)
    public String hello() {
        return restTemplate.getForEntity("http://SPRING-CLOUD-STUDY-DEMO/demo/hello", String.class)
                .getBody();
    }

    public String helloFallBack(){
        return "error";
    }
}
