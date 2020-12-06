package com.zdk.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zdk.springcloud.pojo.Dept;
import com.zdk.springcloud.service.DeptService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>类 名 称</b> :  DeptController<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/5 17:55<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/5 17:55<br/>
 * <b>修改备注</b> :
 */
@RestController
public class DeptController {
    
    private final DeptService deptService;
    
    private final DiscoveryClient client;
    
    public DeptController(DeptService deptService, DiscoveryClient client) {
        this.deptService = deptService;
        this.client = client;
    }
    
    @PostMapping("dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }
    
    @GetMapping("dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        
        if (dept == null) {
            throw new RuntimeException("id不存在");
        }
        
        return dept;
    }
    
    @GetMapping("dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }
    
    public Dept hystrixGet(Long id) {
        return new Dept().setDeptno(id).setDname("此id暂无数据");
    }
    
    
    /**
     * 方法描述: 注册进来的微服务，获取一些消息
     * @param 
     * @return org.springframework.cloud.client.discovery.DiscoveryClient
     * @author zdk
     * <br/><b>创建时间:</b>2020/12/6 8:24
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/12/6 8:24
     * @since  1.0.0
     */
    @GetMapping("dept/discovery")
    public DiscoveryClient discovery() {
        List<String> services = client.getServices();
        System.out.println("discovery=>services:"+services);
    
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()
            );
        }
        return this.client;
    }
    
}
