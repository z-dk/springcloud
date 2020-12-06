package com.zdk.springcloud.controller;

import com.zdk.springcloud.pojo.Dept;
import com.zdk.springcloud.service.DeptClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>类 名 称</b> :  DeptConsumerController<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/6 16:31<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/6 16:31<br/>
 * <b>修改备注</b> :
 */
@RestController
public class DeptConsumerController {
    
    private final DeptClientService deptClientService;
    
    public DeptConsumerController(DeptClientService deptClientService) {
        this.deptClientService = deptClientService;
    }
    
    @RequestMapping("consumer/dept/add")
    public Boolean add(Dept dept) {
        return deptClientService.addDept(dept);
    }
    
    @RequestMapping("consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.queryById(id);
    }
    
    @RequestMapping("consumer/dept/list")
    public List<Dept> list() {
        return deptClientService.queryAll();
    }
    
    
}
