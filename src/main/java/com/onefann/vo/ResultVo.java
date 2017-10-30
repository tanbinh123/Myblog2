package com.onefann.vo;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by one_fann on 2017/10/25.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResultVo<T> {

    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
