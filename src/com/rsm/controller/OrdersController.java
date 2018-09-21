package com.rsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rsm.bean.Orders;
import com.rsm.service.OrdersService;
import com.rsm.util.Page;

@Controller
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("/selectOrdersList")
	public String selectOrdersList(Model model,Page page) {
	/*	List<Orders> ordersList=ordersService.selectOrdersList();*/
		List<Orders> ordersList=ordersService.listOrdersPage(page);
		int total=ordersService.total();
		page.caculateLast(total);
		model.addAttribute("olist", ordersList);
		return "orders";
	}
	
	@RequestMapping("/deleteOrders")
	public String deletOrdersById(Integer order_id) {
		int result=ordersService.deleteOrdersById(order_id);
		if(result>0) {
			return "redirect:selectOrdersList.do";
		}else {
			return "error";
		}
		
		
	}
}
