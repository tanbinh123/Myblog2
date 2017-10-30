package com.onefann.vo;


import com.onefann.domain.BlogType;
import com.onefann.domain.Comment;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by one_fann on 2017/10/27.
 */
public class BlogVo {

    private Long id;

    private String title;

    private String summary;

    private String content;

    private String htmlContent; // 将 md 转为 html

    private List<Comment> comments;

    private Date createTime;

    private Integer readSize = 0; // 访问量、阅读量

    private Integer commentSize = 0;  // 评论量

    private BlogType blogType;

    private String tags;  // 标签

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    public Integer getReadSize() {
        return readSize;
    }

    public void setReadSize(Integer readSize) {
        this.readSize = readSize;
    }

    public Integer getCommentSize() {
        return commentSize;
    }

    public void setCommentSize(Integer commentSize) {
        this.commentSize = commentSize;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
