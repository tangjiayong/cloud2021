package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 功能描述：
 *
 * @author jytang
 * @since 2021-10-28
 */
public interface LoadBalance {

    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
