package com.atguigu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述：
 *
 * @author jytang
 * @since 2021-10-28
 */
@Component
@Slf4j
public class MyLoadBalance implements LoadBalance {


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }

    AtomicInteger atomicInteger = new AtomicInteger(0);

    private int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current + 1;

        } while (!atomicInteger.compareAndSet(current, next));
        log.info("*****第{}次访问***** ", next);
        return next;
    }
}
