package com.zdk.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <b>类 名 称</b> :  Dept<br/>
 * <b>类 描 述</b> :  dept实体类，orm MySQL--dept<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/5 17:07<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/5 17:07<br/>
 * <b>修改备注</b> :
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)  // 链式写法
public class Dept implements Serializable {
    
    private static final long serialVersionUID = -7927612033069922176L;
    
    private Long deptno;
    private String dname;
    
    // 这个数据存在哪个数据库的字段--微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;
    
    public Dept(String dname) {
        this.dname = dname;
    }
}
