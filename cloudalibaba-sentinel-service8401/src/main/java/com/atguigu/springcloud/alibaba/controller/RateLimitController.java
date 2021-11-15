package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.myhandle.CustomerBlockHandler;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @author jytang
 * @since 2021-11-07 13:30
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handle_byResource")
    public CommonResult byResource() {
        return new CommonResult(200, "测试资源名称限流成功", new Payment(2021L, "2012L"));
    }

    public CommonResult handle_byResource(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 测试资源失败");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "rateLimit/byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "测试url成功", new Payment(2022L, "2022L"));
    }


    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "用户自定义限流成功", new Payment(2023L, "2033L"));
    }
}
