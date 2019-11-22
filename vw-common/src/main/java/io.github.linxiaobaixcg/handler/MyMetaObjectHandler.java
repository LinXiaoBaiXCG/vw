package io.github.linxiaobaixcg.handler;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author lcq
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Timestamp(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("updateTime", new Timestamp(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("uuid", IdUtil.simpleUUID(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Timestamp(System.currentTimeMillis()), metaObject);
    }
}
