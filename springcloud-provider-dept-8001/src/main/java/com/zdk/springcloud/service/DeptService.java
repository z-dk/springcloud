package com.zdk.springcloud.service;

import com.zdk.springcloud.pojo.Dept;

import java.util.List;

/**
 * <b>类 名 称</b> :  DeptService<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/5 17:53<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/5 17:53<br/>
 * <b>修改备注</b> :
 */
public interface DeptService {
    
    public boolean addDept(Dept dept);
    
    public Dept queryById(Long id);
    
    public List<Dept> queryAll();
    
}
