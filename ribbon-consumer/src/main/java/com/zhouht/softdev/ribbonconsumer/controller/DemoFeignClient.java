package com.zhouht.softdev.ribbonconsumer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Copyright (C) 2023 Limited, a Tencent company. All rights reserved.
 *
 * @author p_htaozhou@tencent.com
 * @create 2023/12/26 10:51
 */

@FeignClient(name = "SPRING-CLOUD-STUDY-DEMO", fallback = DemoFallback.class)
public interface DemoFeignClient {

    @GetMapping("/demo/hello")
    String hello();
}
