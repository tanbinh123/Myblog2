package com.onefann.enums;

/**
 * Created by one_fann on 2017/10/29.
 */
public enum ResultEnum {

    SUCCESS(0, "SUCCESS"),
    ERROR(1,"ERROR"),
    BLOG_SAVE_SUCCESS(10,"博客保存成功") ;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

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


}
