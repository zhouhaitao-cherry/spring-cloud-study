package com.zhouht.softdev.ribbonconsumer.controller;

import com.zhouht.softdev.ribbonconsumer.service.HellService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) 2023 Limited, a Tencent company. All rights reserved.
 *
 * @author p_htaozhou@tencent.com
 * @create 2023/12/25 11:32
 */

@RestController
public class Controller {

    @Resource
    private HellService hellService;

    @GetMapping("hello")
    public String hello() {
        return hellService.hello();
    }
}
