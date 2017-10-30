package com.onefann.vo;

/**
 * Created by one_fann on 2017/10/25.
 */
public class BlogTypeArchiveVo {
    private String blogTypeName;
    private Integer count;

    public String getBlogTypeName() {
        return blogTypeName;
    }

    public void setBlogTypeName(String blogTypeName) {
        this.blogTypeName = blogTypeName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BlogTypeArchiveVo{" +
                "blogTypeName='" + blogTypeName + '\'' +
                ", count=" + count +
                '}';
    }
}
