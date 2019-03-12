package com.example.spring02.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
// HandlerInterceptorAdapter 추상클래스 상속
// preHandle(), postHandle() 오버라이딩
public class AdminInterceptor 
	extends HandlerInterceptorAdapter {
	//전처리
	@Override
	public boolean preHandle(HttpServletRequest request
			, HttpServletResponse response, Object handler) 
					throws Exception {
		//세션 객체 생성
		HttpSession session=request.getSession();
		//세션변수 admin_userid가 없으면
		if(session.getAttribute("admin_userid")==null) {
			//로그인 페이지로 이동
			response.sendRedirect(request.getContextPath()
					+"/admin/login.do?message=nologin");
			//메인 액션으로 이동하지 않음
			return false;
		}else {
			//세션 변수가 있으면 메인 액션으로 이동
			return true;
		}
	}
	//후처리
	@Override
	public void postHandle(HttpServletRequest request
			, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}


