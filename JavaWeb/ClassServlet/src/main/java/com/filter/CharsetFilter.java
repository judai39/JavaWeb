package com.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@WebServlet("*.do")
public class CharsetFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        chain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}