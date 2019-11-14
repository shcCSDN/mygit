package com.easytop;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.easytop.mapper") //@MapperScan 用户扫描MyBatis的Mapper
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
//没有登陆访问：http://localhost:8888/user/welcome
//	执行到了preHandle方法
//	public java.lang.String com.easytop.controller.LoginController.welcome()
//	已成功拦截并转发跳转  我登录了之后再访问http://localhost:8888/user/welcome 后台获取到session中的用户后也放行了到了退出界面
}
 