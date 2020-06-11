package com.laptrinhjavaweb.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
	String targetUrl = determineTargetUrl(authentication);
	if(response.isCommitted()) {
		return ;
	}
	redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	
	/*
	 * this function for filter url by role
	 */
	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		
		return url;
	}
}
