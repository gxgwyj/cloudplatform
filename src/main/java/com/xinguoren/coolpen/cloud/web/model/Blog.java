package com.xinguoren.coolpen.cloud.web.model;

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
}
