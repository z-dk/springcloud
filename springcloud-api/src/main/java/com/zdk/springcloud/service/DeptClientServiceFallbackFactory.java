package com.zdk.springcloud.service;

import com.zdk.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>类 名 称</b> :  DeptClientServiceFallbackFactory<br/>
 * <b>类 描 述</b> :  Hystrix服务降级处理<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/6 19:16<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/6 19:16<br/>
 * <b>修改备注</b> :
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            
            @Override
            public Dept queryById(Long id) {
                return new Dept("由于服务降级，该服务器已被关闭").setDeptno(id);
            }
    
            @Override
            public List<Dept> queryAll() {
                return new ArrayList<>();
            }
    
            @Override
            public Boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
