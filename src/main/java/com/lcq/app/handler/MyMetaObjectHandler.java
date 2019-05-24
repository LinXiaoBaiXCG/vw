package com.lcq.app.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.Instant;
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createDate = this.getFieldValByName("createDate", metaObject);
        if (null == createDate){
            this.setFieldValByName("createDate",Instant.now(),metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object createDate = this.getFieldValByName("updateDate", metaObject);
        if (null == createDate){
            this.setFieldValByName("updateDate",Instant.now(),metaObject);
        }
    }
}
