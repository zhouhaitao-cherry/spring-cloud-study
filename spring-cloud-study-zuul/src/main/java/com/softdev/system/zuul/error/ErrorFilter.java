package com.softdev.system.zuul.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Copyright (C) 2023 Limited, a Tencent company. All rights reserved.
 *
 * @author p_htaozhou@tencent.com
 * @create 2023/12/27 15:50
 */

@Component
public class ErrorFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public Object run() throws ZuulException {
        //获取 Request上下文
        RequestContext context = RequestContext.getCurrentContext();
        //获取异常
        ZuulException exception = (ZuulException) context.getThrowable();
        //记录日志进入系统异常拦截
        LOGGER.error("进入系统异常拦截”", exception);
        //获取 response对象
        HttpServletResponse response = context.getResponse();
        //response对象 设置格式
        response.setContentType("application/json; charset=utf8");
        //response对象 设置状态
        response.setStatus(exception.nStatusCode);
        //输出
        PrintWriter writer = null;

        try {
            writer = response.getWriter();
            writer.print("{code:" + exception.nStatusCode + ",message:\"" + exception.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return null;
    }
}
