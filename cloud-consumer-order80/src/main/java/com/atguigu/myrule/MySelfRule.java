package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述：Ribbon官方文档建议
 * 为了防止所有的应用都可以扫描到，所以不能放到主类ComponentScan可以扫到的包下
 *
 * @author jytang
 * @since 2021-10-28
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
