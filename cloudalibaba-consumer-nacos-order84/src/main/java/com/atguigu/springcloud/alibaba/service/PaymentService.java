package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.service.impl.PaymentFallBackService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 功能描述：
 *
 * @author jytang
 * @since 2021-11-07 22:20
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallBackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
