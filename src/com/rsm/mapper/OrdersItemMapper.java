package com.rsm.mapper;

import java.util.List;
import java.util.Map;

import com.rsm.bean.Food;
import com.rsm.bean.OrdersItem;

public interface OrdersItemMapper {
	//鏍规嵁澶ц鍗曠殑id鏌ヨ鍒板畠鐨勬墍鏈夊皬璁㈠崟
	public List<OrdersItem> selectOrderItemListById(Integer order_id);
	
	//鏍规嵁灏忚鍗曠殑椋熺墿id鏌ヨ鍒版墍鏈夐鐗�
	public Food seletFoodById(Integer id);
	
	/*******鍒嗛〉寮�濮�********************/
	public List<OrdersItem> listOrdersItemPage(Map map);
	public int total(Integer order_id);
	
	
}
