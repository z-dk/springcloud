package com.zdk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>类 名 称</b> :  DeptConsumerFeign<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/6 16:22<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/6 16:22<br/>
 * <b>修改备注</b> :
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.zdk.springcloud"})
public class DeptConsumerFeign {
    
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign.class, args);
    }
    
}
