package com.jshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jshop.model.Customer;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String cpath = request.getContextPath();
		String requestAction = request.getRequestURI().replace(cpath, "");
		HttpSession session = request.getSession();
		
		Customer user = (Customer) session.getAttribute("user");
		if(user == null) {
			session.setAttribute("requestAction", requestAction);
			response.sendRedirect(cpath + "/account/login.php");
			return false;
		}
		else {
			if(user.getAdmin() == false) {
				session.setAttribute("requestAction", requestAction);
				response.sendRedirect(cpath + "/account/login.php");
				return false;
			}
		}
		return true;
	}
}
