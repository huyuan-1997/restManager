package com.rsm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.rsm.bean.User;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// 获取请求的URL
		String url = request.getRequestURI();
		// URL:除了登录请求外，其他的URL都进行拦截控制
		if (url.indexOf("/login.do") >= 0||url.indexOf("/register.do") >= 0/*||url.indexOf("/logout.do") >= 0||url.indexOf("/toregister.do") >= 0||url.indexOf("/register.do") >= 0*/) {
			return true;
		}

		
		// 获取Session
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER_SESSION");
		// 判断Session中是否有用户数据，如果有，则返回true,继续向下执行
		if (user != null) {
			return true;
		}
		// 不符合条件的给出提示信息，并转发到登录页面
		request.setAttribute("msg", "您还没有登录，请先登录！");
		request.getRequestDispatcher("admin/login.jsp")
		                                        .forward(request, response);
		return false;
	}


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
			throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex)
			throws Exception {
		
	}

	 

}
