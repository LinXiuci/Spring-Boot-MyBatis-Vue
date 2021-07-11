package com.interceptor;

import com.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        // 放行首页页面
        String index=request.getRequestURI();
        if (index.contains("index")){
            return true;
        }

         // 放行登录页面
        String url=request.getRequestURI();
        if (url.contains("login")){
            return true;
        }

        //获取 Session
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("USERNAME");
        if (user!=null){
            return true;
        }

        //不符合条件的给出提示信息，并转发到登录页面
        request.setAttribute("msg","你还没有登录，请登录!");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
