package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionUtilr {

	private static SessionUtilr sessionUtilr = null;

	public static SessionUtilr getInstance() {
		if (sessionUtilr == null) {
			sessionUtilr = new SessionUtilr();
		}
		return sessionUtilr;
	}

	public void putValue(HttpServletRequest req, String key, Object value) {
		req.getSession().setAttribute(key, value);
	}

	public Object getValue(HttpServletRequest req, String key) {
		return req.getSession().getAttribute(key);
	}

	public void removeValue(HttpServletRequest req, String key) {	
		req.getSession().removeAttribute(key);
	}
}