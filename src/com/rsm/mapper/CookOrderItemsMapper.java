package com.rsm.mapper;

import java.util.List;

import com.rsm.bean.CookOrderItems;

public interface CookOrderItemsMapper {
	//根据厨师查询六项OrderItem
	public List<CookOrderItems> queryOrderItemsByCookerId(int cookId);
	//根据订单item编号更改状态
	public int updateStatusTo2ByItemId(int id);
	//根据订单item编号改变为出菜
	public int updateStatusTo3ByItemId(int id);
}
