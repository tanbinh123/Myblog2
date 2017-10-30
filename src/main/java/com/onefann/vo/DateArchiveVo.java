package com.onefann.vo;

/**
 * Created by one_fann on 2017/10/25.
 */
public class DateArchiveVo {
    private String date;
    private Integer count;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "DateArchiveVo{" +
                "date='" + date + '\'' +
                ", count=" + count +
                '}';
    }
}
