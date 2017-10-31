package com.onefann.enums;

/**
 * Created by one_fann on 2017/10/29.
 */
public enum ResultEnum {

    SUCCESS(0, "SUCCESS"),
    ERROR(1,"ERROR"),
    BLOG_SAVE_SUCCESS(10,"博客保存成功") ,
    BLOG_DELTE_ERROR(11,"博客删除失败"),
    BLOG_DELETE_SUCCESS(12,"博客删除成功"),
    BLOG_PARAMS_ERROR(12,"博客参数错误"),
    DATE_FORMAT_ERROR(30,"日期格式化错误");

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
