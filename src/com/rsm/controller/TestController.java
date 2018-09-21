package com.rsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TestController {

	@RequestMapping("/index")
	public String show(){
		return "index";
	}
	@RequestMapping("/menue")
	public String menue(){
		return "menue";
	}
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	@RequestMapping("/cook")
	public String cook(){
		return "cook";
	}
	@RequestMapping("/menuedetail")
	public String menuedetail(){
		return "menuedetail";
	}
	@RequestMapping("/waiter")
	public String waiter(){
		return "waiter";
	}
	@RequestMapping("/orders")
	public String orders(){
		return "orders";
	}
	
	
}
