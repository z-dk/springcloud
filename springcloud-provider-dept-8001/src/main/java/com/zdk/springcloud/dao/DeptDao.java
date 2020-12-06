package com.zdk.springcloud.dao;

import com.zdk.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>类 名 称</b> :  DeptDao<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/5 17:44<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/5 17:44<br/>
 * <b>修改备注</b> :
 */
@Mapper
@Repository
public interface DeptDao {
    
    public boolean addDept(Dept dept);
    
    public Dept queryById(Long id);
    
    public List<Dept> queryAll();
    
    
}
