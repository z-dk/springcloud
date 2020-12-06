package com.zdk.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <b>类 名 称</b> :  ConfigBean<br/>
 * <b>类 描 述</b> :  ==spring applicatonContext.xml<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/5 21:11<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/5 21:11<br/>
 * <b>修改备注</b> :
 */
@Configuration
public class ConfigBean {
    
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public IRule getIRule() {
        return new RoundRobinRule();
    }
    
}
