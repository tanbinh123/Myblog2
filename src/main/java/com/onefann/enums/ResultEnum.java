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
    BLOG_PARAMS_ERROR(13,"参数错误"),
    BLOGTYPE_DELETE_SUCCESS(14,"博客类别删除成功"),
    BLOGTYPE_DELETE_ERROR(15,"博客类别删除失败"),
    BlOGTYPE_SAVE_SUCCESS(16,"博客类别保存成功"),
    BlOGTYPE_SAVE_ERROR(17,"博客保存失败"),
    USER_SAVE_ERROR(20, "用户保存失败"),
    USER_SAVE_SUCCESS(21, "用户保存成功"),
    COMMENT_SAVE_SUCCESS(30,"评论保存成功"),
    COMMENT_SAVE_ERROR(31,"评论保存失败"),
    COMMENT_DELETE_SUCCESS(32, "评论删除成功"),
    COMMENT_DELETE_ERROR(33, "评论删除失败"),
    ;


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
