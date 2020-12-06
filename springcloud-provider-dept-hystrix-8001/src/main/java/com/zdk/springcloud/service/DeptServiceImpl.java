package com.zdk.springcloud.service;

import com.zdk.springcloud.dao.DeptDao;
import com.zdk.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b>类 名 称</b> :  DeptServiceImpl<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/5 17:54<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/5 17:54<br/>
 * <b>修改备注</b> :
 */
@Service
public class DeptServiceImpl implements DeptService {
    
    @Autowired
    private DeptDao deptDao;
    
    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }
    
    @Override
    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }
    
    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
