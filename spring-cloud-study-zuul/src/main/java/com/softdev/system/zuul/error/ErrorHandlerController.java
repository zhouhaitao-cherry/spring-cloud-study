package com.softdev.system.zuul.error;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) 2023 Limited, a Tencent company. All rights reserved.
 * 自定义全局Error页面
 * @author p_htaozhou@tencent.com
 * @create 2023/12/27 16:02
 */

@RestController
public class ErrorHandlerController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public Object error(){
        RequestContext currentContext = RequestContext.getCurrentContext();
        ZuulException throwable = (ZuulException) currentContext.getThrowable();
        return throwable.nStatusCode + "--" + throwable.getMessage();
    }
}
