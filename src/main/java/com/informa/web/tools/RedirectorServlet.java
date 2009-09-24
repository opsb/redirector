package com.informa.web.tools;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectorServlet implements Servlet {

	public void destroy() {
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return "redirector";
	}

	public void init(ServletConfig config) throws ServletException {
	}

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		((HttpServletResponse)response).sendRedirect(urlWithContextRemoved((HttpServletRequest)request));
	}

	private String urlWithContextRemoved(HttpServletRequest request) {

		String queryString = request.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		
		String urlWithoutContext = "http://ic.informatm.com" + request.getPathInfo() + queryString;
		
		return urlWithoutContext;
	}

	

}
