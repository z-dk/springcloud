package com.zdk.springcloud.controller;

import com.zdk.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <b>类 名 称</b> :  DeptConsumerController<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/5 21:07<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/5 21:07<br/>
 * <b>修改备注</b> :
 */
@RestController
public class DeptConsumerController {
    
    // 消费者不应该有service
    // RestFul风格请求 RestTemplate==注册到spring
    @Autowired
    private RestTemplate restTemplate;
    // Ribbon通过服务名访问
    //private static final String REST_URL_PREFIX = "http://localhost:8001/";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT/";
    
    @RequestMapping("consumer/dept/add")
    public Boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX+"dept/add",dept,Boolean.class);
    }
    
    @RequestMapping("consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX+"dept/get/"+id,Dept.class);
    }
    
    @RequestMapping("consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX+"dept/list",List.class);
    }
    
}
