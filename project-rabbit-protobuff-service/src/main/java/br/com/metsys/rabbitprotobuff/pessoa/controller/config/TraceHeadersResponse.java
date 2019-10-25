package br.com.metsys.rabbitprotobuff.pessoa.controller.config;

import org.slf4j.MDC;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/filter-response-header/*")
public class TraceHeadersResponse extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("X-B3-TraceIdInjection",
                MDC.get("X-B3-TraceId"));

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // ...
    }
}

