package com.hari.student;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayAccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
		Calendar cal = Calendar.getInstance();
		if(cal.get(Calendar.DAY_OF_WEEK) == 4){
			response.getWriter().write("We don't  work  on Wednesdays!");
			return false;
		}
		return true;
	}
	
	@Override
	public void  postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,	ModelAndView model)throws Exception{
		System.out.println("PostHandle "+ request.getRequestURI().toString());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,Exception exception)throws Exception{
		System.out.println("AfterCompletion "+ request.getRequestURI().toString());
	}
}
