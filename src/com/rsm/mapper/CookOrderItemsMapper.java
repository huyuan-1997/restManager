package com.rsm.mapper;

import java.util.List;

import com.rsm.bean.CookOrderItems;

public interface CookOrderItemsMapper {
	//���ݳ�ʦ��ѯ����OrderItem
	public List<CookOrderItems> queryOrderItemsByCookerId(int cookId);
	//���ݶ���item��Ÿ���״̬
	public int updateStatusTo2ByItemId(int id);
	//���ݶ���item��Ÿı�Ϊ����
	public int updateStatusTo3ByItemId(int id);
}
