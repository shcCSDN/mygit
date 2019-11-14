package com.easytop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easytop.pojo.User;
import com.easytop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;
 
    //跳转首页（登录页）
    @RequestMapping("/toIndex")
    public String show(){
        return "index";
    }
 
    //登录操作
    @ResponseBody
    @RequestMapping("/loginUser")
    public String login(User user, HttpServletRequest request){
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        User u1 =userService.login(userName,passWord);
        if (u1==null){
            return "用户名或密码错误";
        }else{
            request.getSession().setAttribute("session_user",user);//登录成功后将用户放入session中，用于在拦截器里面检查是否有这个session,如果有就代表已经登陆了
            return "登录成功";
        }
    }
 
    //跳转注册页
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
 
    //注册操作
    @RequestMapping("/register")
    public String register(User user){
        int su = userService.register(user);
        if(su==0){
            System.out.println("请注册...");
        }else {
        	return "index";
        }
        return "welcome";
    }
 
    //测试未登陆拦截页面
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    /**
     * 修改密码
     * @param users
     * @return
     */
    @RequestMapping("/editUser")
    public String editUser(String passWord,String userName){
    	this.userService.updateUser(passWord,userName);
    	return "update"; 
    }
    
    //退出登录
    @RequestMapping("/outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_user");//退出的时候同时要把登陆的session删除掉，然后从新重定向到首页
        response.sendRedirect("/user/toIndex");
    }
}