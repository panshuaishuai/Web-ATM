package com.qingshixun.atm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class SecurityFilter implements Filter {

	public SecurityFilter() {

	}

	/**
	 * @see 销毁 方法
	 */
	public void destroy() {

	}

	/**
	 * @see 请求转发时执行的方法
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		String requestURI = httpServletRequest.getRequestURI();
		if (requestURI.contains("login.jsp") || requestURI.contains("style.css") || requestURI.contains("LoginServlet")
				|| requestURI.contains("images") || session.getAttribute("accountIndex") != null) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see 初始化方法
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
