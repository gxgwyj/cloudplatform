package com.xyz.cloudplatform.filter;

import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

/**
 * 类: MDCFilter <br>
 * 描述: Log4jMDC<br>
 * 作者: gaoxugang <br>
 * 时间: 2018年01月12日 17:31
 */
public class MDCFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uuid = UUID.randomUUID().toString();
        MDC.put("MDC_ID", uuid);
        filterChain.doFilter(servletRequest, servletResponse);
        MDC.clear();
    }

    @Override
    public void destroy() {

    }
}
