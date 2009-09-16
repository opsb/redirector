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

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return "redirector";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		((HttpServletResponse)response).sendRedirect(urlWithContextRemoved((HttpServletRequest)request));
	}

	private String urlWithContextRemoved(HttpServletRequest request) {

		String scheme = request.getScheme();
		String serverName = request.getServerName();
		String port = "" + request.getServerPort();
		String queryString = request.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		
		String urlWithoutContext = scheme + "://" + serverName + ":" + port +request.getPathInfo() + queryString;
		
		return urlWithoutContext;
	}

	

}
