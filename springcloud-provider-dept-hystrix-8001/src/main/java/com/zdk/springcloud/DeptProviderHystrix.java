package com.zdk.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * <b>类 名 称</b> :  DeptProviderHystrix<br/>
 * <b>类 描 述</b> :  Hystrix的服务熔断处理<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/6 17:18<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/6 17:18<br/>
 * <b>修改备注</b> :
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableCircuitBreaker   // 开启对熔断的支持
public class DeptProviderHystrix {
    
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix.class, args);
    }
    
    /**
     * 方法描述: 增加一个servlet，监控流，监控的请求需要配置熔断方法
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean
     * @author zdk
     * <br/><b>创建时间:</b>2020/12/6 20:52
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/12/6 20:52
     * @since  1.0.0
     */
    @Bean
    public ServletRegistrationBean getHystrixMetricsStreamServlet() {
        ServletRegistrationBean<HystrixMetricsStreamServlet> hystrixBean = new ServletRegistrationBean<>(new HystrixMetricsStreamServlet());
        hystrixBean.addUrlMappings("/actuator/hystrix.stream");
        return hystrixBean;
    }
    
}
