package com.xinguoren.coolpen.cloud.web.service.api.impl;


import com.xinguoren.coolpen.cloud.web.model.Blog;
import com.xinguoren.coolpen.cloud.web.service.api.BlogService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */
public class BlogServiceImpl implements BlogService {
    public List<Blog> getAllBlogs() {
        System.out.println("服务被调用了.........");
        ArrayList<Blog> list = new ArrayList<Blog>();
        for (int i = 0; i < 10; i++) {
            Blog blog = new Blog("文章"+i,"作者"+i,"内容"+i);
            list.add(blog);
        }
        return list;
    }
}
