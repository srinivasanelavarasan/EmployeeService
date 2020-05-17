package com.assignment.jwtfilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

/* This class implements the custom filter by extending org.springframework.web.filter.GenericFilterBean.  
 * Override the doFilter method with ServletRequest, ServletResponse and FilterChain.
 * This is used to authorize the API access for the application.
 */

/**
 * The Class JwtFilter.
 */
public class JwtFilter extends GenericFilterBean {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

	/*
	 * Authorization and Authentication logic can be extended in this class and it
	 * will be invoked before controller
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		logger.info("doFilter method invoked in JwtFilter");
		filterChain.doFilter(servletRequest, servletResponse);
	}

}
