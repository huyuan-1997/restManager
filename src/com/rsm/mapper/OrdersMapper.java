package com.rsm.mapper;

import java.util.List;

import com.rsm.bean.Food;
import com.rsm.bean.Orders;
import com.rsm.util.Page;


public interface OrdersMapper {
	//鏌ヨ鎵�鏈夌殑澶ц鍗�
	public List<Orders> selectOrdersList();
	//鏍规嵁澶ц鍗曟煡璇㈡墍鏈夌殑灏忚鍗�
	public Orders findOrdersWithItems(Integer order_id);
	//鏍规嵁灏忚鍗曠殑椋熺墿id鏌ラ鐗�
	public Food seletFoodById(Integer id);
	//鍒犻櫎璁㈠崟
	public int deleteOrdersById(Integer order_id);
	
	/*******鍒嗛〉寮�濮�********************/
	public List<Orders> listOrdersPage(Page page);
	public int total();
}
