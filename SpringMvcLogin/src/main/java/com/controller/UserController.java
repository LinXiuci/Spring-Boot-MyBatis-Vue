package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {


    /*
    * 跳转到首页页面
    * */
    @RequestMapping("index")
    public String toIndex(){
        System.out.println("index");
        return "index";
    }

    /*
     * 跳转到登录页面
     *
     * */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String toLogin(){
        return "WEB-INF/jsp/login";
    }

    /*
     * 设置登录页面
     * @rerurn login
     * */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session){

        //获取login页面的账号与密码
        String username=user.getUsername();
        String password=user.getPassword();

        //判断账号与密码是否正确
        if(username==null||"".equals(username.trim()) || password==null||"".equals(password.trim())){
            model.addAttribute("msg","账号或密码不能为空！");
            return "WEB-INF/jsp/login";
        }
        //如果账号与密码都正确则跳转到首页页面
        if (username.equals("admin")&&password.equals("1234")){
            session.setAttribute("USERNAME",user);
            return "/index";
        }

        model.addAttribute("msg","账号或密码错误，请重新输入账号或密码！");
        return "WEB-INF/jsp/login";
    }

    /*
    * 成功页面
    * */
    @RequestMapping("success")
    public String success(HttpSession session){
        User user=(User) session.getAttribute("USERNAME");
        System.out.println(user);
        if (user!=null){
            System.out.println(user);
            return "WEB-INF/jsp/success";
        }
        return "WEB-INF/jsp/login";
    }

    /*
    * 退出页面
    * */
    @RequestMapping("logout")
    public String logout(HttpSession session){
        User user=(User) session.getAttribute("USERNAME");
        if (user!=null){
            session.invalidate();
            return "index";
        }
        return "WEB-INF/jsp/login";
    }


}
