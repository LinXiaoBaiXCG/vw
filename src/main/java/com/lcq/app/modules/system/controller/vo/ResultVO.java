package com.lcq.app.modules.system.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: app
 * @description: 结果返回
 * @author: LCQ
 * @create: 2019-05-22 22:08
 **/
@Data
public class ResultVO implements Serializable {
    private static final long serialVersionUID = -358419585618707814L;
    //错误码
    private int code;
    //提示信息
    private String msg;
    //返回内容
    private Object data;

    public ResultVO() {
    }

    public ResultVO(String msg) {
        this.msg = msg;
    }

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
