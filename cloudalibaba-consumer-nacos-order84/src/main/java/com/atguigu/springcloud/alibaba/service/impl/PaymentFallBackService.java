package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * 功能描述：
 *
 * @author jytang
 * @since 2021-11-07 22:23
 */
@Component
public class PaymentFallBackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(5555, "PaymentFallBackService-paymentSQL-兜底");
    }
}
