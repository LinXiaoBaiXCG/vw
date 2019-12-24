package io.github.linxiaobaixcg.entity;

import lombok.Getter;

@Getter
public enum StatusCode {
    OK(20000, "成功"),
    ERROR(20001, "失败"),
    LOGINERROR(20002, "用户名或密码错误"),
    ACCESSERROR(20003, "权限不足"),
    REMOTEERROR(20004, "远程调用失败"),
    REPERROR(20005, "重复操作");

    private Integer code;
    private String message;

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}