package com.xinguoren.coolpen.cloud.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/12/12.
 */
@Controller
public class SearchController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}
