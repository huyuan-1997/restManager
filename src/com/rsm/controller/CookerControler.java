package com.rsm.controller;

import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.rsm.bean.Cooker;
import com.rsm.bean.Paging;
import com.rsm.bean.CookOrderItems;
import com.rsm.service.impl.CookerService;

@Controller
public class CookerControler {
	@Autowired
	CookerService cookerService;
	@RequestMapping(value="/insertCooker.do")
	public ModelAndView insertCooker(Cooker cooker){
		ModelAndView mv = new ModelAndView();
		cookerService.insertCooker(cooker);
		System.out.println(cooker);
		mv.setViewName("redirect:/cook.do");
		return mv;
	}
	
	@RequestMapping("/cook.do")
	public ModelAndView cookerPage() {
		ModelAndView mv = new ModelAndView();
		List<Cooker> cookers = cookerService.queryAllCooker();
		mv.addObject("cookers", cookers);
		mv.setViewName("cook");
		return mv;
	}
	@RequestMapping("deleteCookers.do")
	public ModelAndView deleteCookers(String ids) {
		ModelAndView mv = new ModelAndView();
		System.out.println(ids);
		if (ids!=null) {
			cookerService.deleteCookers(ids);
		}
		mv.setViewName("redirect:cook.do");
		return mv;
	}
	
	
	@RequestMapping("cookOrderItems.do")
	public ModelAndView CookOrderItem(int id,Paging paging) {
		List<CookOrderItems> orderItems = cookerService.querycookOrderItemsPage(id, paging);
		ModelAndView mv = new ModelAndView();
		mv.addObject("cookOrderItems", orderItems);
		int cookid=id;
		mv.addObject("cookid", cookid);
		mv.addObject("paging", paging);
		mv.setViewName("cookOrdersItem");
		
		/*Pageing pageing = new Pageing();
		pageing.setPage(1);
		pageing.setPageSize(5);
		List<CookOrderItems> orderItem=cookerService.querycookOrderItemsPage(1, pageing);
		for(CookOrderItems cook:orderItem) {
			System.out.println(cook);
		}
		System.out.println(pageing);*/
		
		return mv;
		
	}
	
	@RequestMapping("startCookOrderItem.do")
	public ModelAndView startCookOrderItem(int cookid,int itemId,Paging paging) {
		ModelAndView mv = new ModelAndView();
		cookerService.starCookOrderItem(itemId);
		List<CookOrderItems> orderItems = cookerService.querycookOrderItemsPage(cookid, paging);
		mv.addObject("cookid", cookid);
		mv.addObject("cookOrderItems", orderItems);
		mv.addObject("paging", paging);
		mv.setViewName("cookOrdersItem");
		return mv;
	}
	@RequestMapping("finishCookOrderItem.do")
	public ModelAndView finishCookOrderItem(int cookid,int itemIdFin,Paging paging) {
		ModelAndView mv = new ModelAndView();
		cookerService.finishCookOrderItem(itemIdFin);
		List<CookOrderItems> orderItems = cookerService.querycookOrderItemsPage(cookid, paging);
		if (orderItems.size()<1) {
			paging.setPage(paging.getPage()-1);
			orderItems = cookerService.querycookOrderItemsPage(cookid, paging);
		}
		mv.addObject("cookid", cookid);
		mv.addObject("cookOrderItems", orderItems);
		mv.addObject("paging", paging);
		mv.setViewName("cookOrdersItem");
		return mv;
	}
	
	
}
