package com.rsm.service;

import java.util.List;

import com.rsm.bean.Orders;
import com.rsm.util.Page;

public interface OrdersService {
	//鏌ヨ鎵�鏈夌殑澶ц鍗�
	public List<Orders> selectOrdersList();
	//鍒犻櫎璁㈠崟
	public int deleteOrdersById(Integer order_id);
	
	/*******鍒嗛〉寮�濮�********************/
	public List<Orders> listOrdersPage(Page page);
	public int total();
	
}
