package com.rsm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsm.bean.Food;
import com.rsm.bean.OrdersItem;
import com.rsm.mapper.OrdersItemMapper;
import com.rsm.service.OrdersItemService;
import com.rsm.util.Page;

@Service
public class OrdersItemServiceImpl implements OrdersItemService{
	@Autowired
	private OrdersItemMapper ordersItemMapper;
	@Override
	public List<OrdersItem>selectOrderItemListById(Integer order_id) {
		//1.鏍规嵁澶ц鍗曠殑id鏌ヨ鎵�鏈夌殑灏忚鍗�
		List<OrdersItem> ordersItems=ordersItemMapper.selectOrderItemListById(order_id);
		
		for(OrdersItem oItem:ordersItems) {
			//2.鏍规嵁姣忎竴涓皬璁㈠崟鐨勯鐗﹊d鏌ヨ鍒板畠鐨� 椋熺墿
			Food f=ordersItemMapper.seletFoodById(oItem.getFood_id());
			//3.寰楀埌椋熺墿鐨勫悕绉�
			oItem.setFood_name(f.getFoodName());
			//寰楀埌灏忚鍗曠殑浠锋牸
			oItem.setItem_price(f.getFoodPrice()*oItem.getAmount());
		 
		}
		 
		
		
		return ordersItems;
	}
	@Override
	public List<OrdersItem> listOrdersItemPage(Integer order_id, Page page) {
		 
		Map map=new HashMap();
		map.put("order_id",order_id);
		map.put("start", page.getStart());
		map.put("count", page.getCount());
		
		//1.鏍规嵁澶ц鍗曠殑id鏌ヨ鎵�鏈夌殑灏忚鍗�
		List<OrdersItem> ordersItems=ordersItemMapper.listOrdersItemPage(map);

		for(OrdersItem oItem:ordersItems) {
			//2.鏍规嵁姣忎竴涓皬璁㈠崟鐨勯鐗﹊d鏌ヨ鍒板畠鐨� 椋熺墿
			Food f=ordersItemMapper.seletFoodById(oItem.getFood_id());
			//3.寰楀埌椋熺墿鐨勫悕绉�
			oItem.setFood_name(f.getFoodName());
			//寰楀埌灏忚鍗曠殑浠锋牸
			oItem.setItem_price(f.getFoodPrice()*oItem.getAmount());
		 
		}
		 
		return ordersItems;
	}
	@Override
	public int total(Integer order_id) {
		
		return ordersItemMapper.total(order_id);
	}
	 
	
	
	
}
