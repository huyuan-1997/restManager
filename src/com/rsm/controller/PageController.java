package com.rsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * ��������ҳ����ת
 * @author ��԰
 *
 */
@Controller
public class PageController {
	@RequestMapping("/index")
	public String show() {
		return "index";
	}

	/**
	 * ���ܣ�չʾ����ҳ��
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
