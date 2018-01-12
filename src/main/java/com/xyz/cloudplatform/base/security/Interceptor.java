package com.xyz.cloudplatform.base.security;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/10/24.
 */
public class Interceptor implements HandlerInterceptor{
    private static final Logger logger = Logger.getLogger(Interceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info(httpServletRequest.getSession().getId());
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie:cookies){
            logger.info(MessageFormat.format("cookie[key={0},value={1}]", cookie.getName(), cookie.getValue()));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
