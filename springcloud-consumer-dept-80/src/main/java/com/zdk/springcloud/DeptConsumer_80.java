package com.zdk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>类 名 称</b> :  DeptConsumer_80<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/5 21:21<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/5 21:21<br/>
 * <b>修改备注</b> :
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer_80 {
    
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
    
}
