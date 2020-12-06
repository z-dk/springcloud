package com.zdk.springcloud.service;

import com.zdk.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * <b>类 名 称</b> :  DeptClientService<br/>
 * <b>类 描 述</b> :  通过feign的调用方式，同时实现服务降级处理<br/>
 * <b>创 建 人</b> :  zdk<br/>
 * <b>创建时间</b> :  2020 12 06 19:23<br/>
 * <b>修 改 人</b> :  zdk<br/>
 * <b>修改时间</b> :  2020 12 06 19:23<br/>
 * <b>修改备注</b> :  
 */
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    
    @GetMapping("dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id);
    
    @GetMapping("dept/list")
    public List<Dept> queryAll();
    
    @PostMapping("dept/add")
    public Boolean addDept(Dept dept);
    
}
