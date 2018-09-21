package com.rsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rsm.bean.OrdersItem;
import com.rsm.service.OrdersItemService;
import com.rsm.util.Page;

@Controller
public class OrdersItemController {
	@Autowired
	private OrdersItemService ordersItemService;
	
	@RequestMapping("/selectOrderItemListById")
	public String selectOrderItemListById(Integer order_id,Page page,Model model) {
		
		/*List<OrdersItem> orderItemLists=ordersItemService.selectOrderItemListById(order_id);*/
		List<OrdersItem> orderItemLists=ordersItemService.listOrdersItemPage(order_id, page);
		int total=ordersItemService.total(order_id);
		page.caculateLast(total);
		model.addAttribute("oilist", orderItemLists);
		
		
		return "ordersItem";
	}
	
}
