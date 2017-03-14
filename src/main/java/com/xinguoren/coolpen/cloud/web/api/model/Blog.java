package com.xinguoren.coolpen.cloud.web.api.model;


import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/9.
 */
public class Blog implements Serializable {
    private String title;
    private String author;
    private String content;

    public Blog(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Blog() {
    }

    @Override
    public String toString() {
        return "Blog [title=" + title + ", author=" + author + ", content="
                + content + "]";
    }


    public String getTitle() {
        return title;
    }

    public Blog(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}