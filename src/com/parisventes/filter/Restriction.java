package com.parisventes.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Restriction implements Filter {

	public Restriction() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(true);
		if (session.getAttribute("isLog") == null) {
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath) + "/home");
		} else {
			chain.doFilter(req, res);
		}

	}

	public void init(FilterConfig config) {

	}

	public void destroy() {

	}

}
