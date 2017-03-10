package com.xinguoren.coolpen.cloud.web.controller;

import com.xinguoren.coolpen.cloud.web.model.Blog;
import com.xinguoren.coolpen.cloud.web.service.SearchService;
import com.xinguoren.coolpen.cloud.web.spring.ThreadLocalTest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 搜索引擎123
 * Created by Administrator on 2016/12/12.
 */
@Controller
public class SearchController {
    @Autowired
    SearchService searchService;

    public SearchController(){
        System.out.println("测试单例模式");
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public Object test(@RequestBody Blog blog) {
        return blog;
    }

    @RequestMapping(value = "/lock")
    @ResponseBody
    public Long lock() {
        ThreadLocalTest2.TEST_THREAD_NAME_LOCAL.set("abc");
        return searchService.getLock();
    }

    @RequestMapping(value = "/incr")
    @ResponseBody
    public String incr() {
        return  searchService.getCanAccess()?"访问成功":"5秒钟只能访问3次";
    }


}
