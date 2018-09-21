package com.rsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsm.bean.Food;
import com.rsm.bean.Orders;
import com.rsm.bean.OrdersItem;
import com.rsm.mapper.OrdersMapper;
import com.rsm.service.OrdersService;
import com.rsm.util.Page;

@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	private OrdersMapper ordersMapper;

	@Override
	public List<Orders> selectOrdersList() {
		//1.鏌ヨ鎵�鏈夌殑澶ц鍗�
		List<Orders> ordersList=ordersMapper.selectOrdersList();
	
		for(Orders order:ordersList) {
			//2.鏌ヨ姣忎釜澶ц鍗曚笅鐨勬墍鏈夊皬璁㈠崟
			Orders orders=ordersMapper.findOrdersWithItems(order.getOrder_id());
		
			int totalPrice=0;
			List<OrdersItem> ordersItems=orders.getOrdersItems();
			for(OrdersItem item:ordersItems) {
				//3.鏍规嵁灏忚鍗曢鐗╃殑id鏌ヨ椋熺墿锛屽緱鍒伴鐗╀环鏍�
			 Food f=ordersMapper.seletFoodById(item.getFood_id());
			 item.setItem_price(f.getFoodPrice()*item.getAmount());
			 //4.姣忎釜灏忚鍗曠殑椋熺墿鐨勪环鏍肩浉鍔犲氨鏄ぇ璁㈠崟鐨勯噾棰�
			 totalPrice+=item.getItem_price();
			}
			order.setTotalPrice(totalPrice);
			
			 
		}
		 
		
		return ordersList;
	}

	@Override
	public int deleteOrdersById(Integer order_id) {
		
		return ordersMapper.deleteOrdersById(order_id);
	}

	@Override
	public List<Orders> listOrdersPage(Page page) {
		//1.鏌ヨ鎵�鏈夌殑澶ц鍗�
		List<Orders> ordersList=ordersMapper.listOrdersPage(page);
	
		for(Orders order:ordersList) {
			//2.鏌ヨ姣忎釜澶ц鍗曚笅鐨勬墍鏈夊皬璁㈠崟
			Orders orders=ordersMapper.findOrdersWithItems(order.getOrder_id());
		
			int totalPrice=0;
			List<OrdersItem> ordersItems=orders.getOrdersItems();
			for(OrdersItem item:ordersItems) {
				//3.鏍规嵁灏忚鍗曢鐗╃殑id鏌ヨ椋熺墿锛屽緱鍒伴鐗╀环鏍�
			 Food f=ordersMapper.seletFoodById(item.getFood_id());
			 item.setItem_price(f.getFoodPrice()*item.getAmount());
			 //4.姣忎釜灏忚鍗曠殑椋熺墿鐨勪环鏍肩浉鍔犲氨鏄ぇ璁㈠崟鐨勯噾棰�
			 totalPrice+=item.getItem_price();
			}
			order.setTotalPrice(totalPrice);
			
			 
		}
		return ordersList;
	}

	@Override
	public int total() {
		 
		return ordersMapper.total();
	}

	 
	
	
}
