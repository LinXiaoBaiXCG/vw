package io.github.linxiaobaixcg.entity;

import lombok.Data;

/**
 * @program: vw
 * @description: 返回实体
 * @author: LCQ
 * @create: 2019-12-23 20:54
 **/
@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Result(){

    }

    public Result(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Result(StatusCode statusCode){
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }

    public Result(StatusCode statusCode,T data){
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.data = data;
    }

    public Result(Integer code, String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
