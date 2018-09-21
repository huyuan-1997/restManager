package com.rsm.service;

import java.util.List;

import com.rsm.bean.OrdersItem;
import com.rsm.util.Page;

public interface OrdersItemService {
	//鏍规嵁澶ц鍗曠殑id鏌ヨ鍒板畠鐨勬墍鏈夊皬璁㈠崟
	public List<OrdersItem> selectOrderItemListById(Integer order_id);
	
	/*******鍒嗛〉寮�濮�********************/
	public List<OrdersItem> listOrdersItemPage(Integer order_id,Page page);
	public int total(Integer order_id);
	
	
}
