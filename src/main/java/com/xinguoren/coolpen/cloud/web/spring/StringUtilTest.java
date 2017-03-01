package com.xinguoren.coolpen.cloud.web.spring;

import org.springframework.util.StringUtils;

/**
 * Created by Lenovo on 2017/2/21.
 */
public class StringUtilTest {
    public static void main(String[] args) {
        String abc = "";
        System.out.println(StringUtils.isEmpty(abc));
        System.out.println("=========================测试字符串函数======================");
        String  str1 = "abcc  1234  $$$$   __________  +++++ ______ +++++";
        System.out.println(StringUtils.trimAllWhitespace(str1));

    }
}
