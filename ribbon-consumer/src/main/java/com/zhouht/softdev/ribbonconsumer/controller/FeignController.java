package com.zhouht.softdev.ribbonconsumer.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) 2023 Limited, a Tencent company. All rights reserved.
 *
 * @author p_htaozhou@tencent.com
 * @create 2023/12/26 10:50
 */

@RestController
@RequestMapping("feign")
public class FeignController {

    @Resource
    private DemoFeignClient demoFeignClient;

    @GetMapping("hello")
    public String hello(){
        return demoFeignClient.hello();
    }
}
