package com.zdk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <b>类 名 称</b> :  EurekaServer_7001<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/5 21:50<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/5 21:50<br/>
 * <b>修改备注</b> :
 */
@SpringBootApplication
@EnableEurekaServer // 服务端的启动类，可以接收
public class EurekaServer_7001 {
    
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7001.class, args);
    }
    
}
