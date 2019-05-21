package com.lcq.app.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: app
 * @description: 用户
 * @author: LCQ
 * @create: 2019-05-20 22:53
 **/
@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private String id;
    private String user;
    private String password;
}
