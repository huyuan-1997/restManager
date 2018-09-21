package com.rsm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rsm.bean.User;
import com.rsm.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(Model model,String username,String password,HttpSession session) {
		User user=userService.findUser(username, password);
		if(user!=null) {
			session.setAttribute("USER_SESSION", user);
			return "index";
		}
		model.addAttribute("msg","账号或密码错误");
		return "login";
	}
	
	@RequestMapping("/register")
	public String register(User user) {
		int result=userService.addUser(user);
		System.out.println("user:"+user);
		if(result>0) {
			return "login";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:tologin.do";
	}
	
	
	@RequestMapping("/tologin")
	public String toLogin() {
		return "login";
	}
}
