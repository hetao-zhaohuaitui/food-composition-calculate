package com.food.composition.calculate.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆检查
 * 
 * @author H.R.ZHAO
 *
 * @version LoginHandlerInterceptor.java, v 0.1 2020年03月06日 11:47:49 H.R.ZHAO
 *          Exp $
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
	// 目标方法执行之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object user = request.getSession().getAttribute("loginUser");
		if (user == null) {
			// 未登陆，返回登陆页面
			request.setAttribute("msg", "没有权限请先登陆");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		} else {
			// 已登陆，放行请求
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
