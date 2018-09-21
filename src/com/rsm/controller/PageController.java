package com.rsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 用来进行页面跳转
 * @author 胡园
 *
 */
@Controller
public class PageController {
	@RequestMapping("/index")
	public String show() {
		return "index";
	}

	/**
	 * 功能：展示其他页面
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
