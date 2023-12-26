package com.zhouht.softdev.ribbonconsumer.controller;

import org.springframework.stereotype.Component;

/**
 * Copyright (C) 2023 Limited, a Tencent company. All rights reserved.
 *
 * @author p_htaozhou@tencent.com
 * @create 2023/12/26 14:46
 */

@Component
public class DemoFallback implements DemoFeignClient{

    @Override
    public String hello() {
        return "fallbcak";
    }
}
