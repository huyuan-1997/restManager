package com.rsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsm.bean.Cooker;
import com.rsm.bean.Paging;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rsm.bean.CookOrderItems;
import com.rsm.mapper.CookerMapper;
import com.rsm.mapper.CookOrderItemsMapper;

@Service
public class CookerService {
	@Autowired
	CookerMapper mapper;
	@Autowired
	CookOrderItemsMapper cookOrderItemsMapper;
	
	public int insertCooker(Cooker cooker) {
		int result = mapper.insertCooker(cooker);
		return result;
	}
	
	public List<Cooker> queryAllCooker(){
		return mapper.queryAllCooker();
	}
	
	public int deleteCookers(String ids){
		return mapper.deleteCookers(ids);
	}
	
	public Cooker queryCookerById(int id) {
		return mapper.queryCookerById(id);
	}
	
	public List<CookOrderItems> CookOrderItems(int cookId){
	 return	cookOrderItemsMapper.queryOrderItemsByCookerId(cookId);
	}
	public int starCookOrderItem(int id) {
		return cookOrderItemsMapper.updateStatusTo2ByItemId(id);
	}
	public int finishCookOrderItem(int id) {
		return cookOrderItemsMapper.updateStatusTo3ByItemId(id);
	}
	
	public List<CookOrderItems> querycookOrderItemsPage(int cookId,Paging paging) {
		if (paging.getPage()<1) {
			paging.setPage(1);
		}if (paging.getPage()>paging.getTotalPages()) {
			paging.setPage(paging.getTotalPages());
		}
		PageHelper.startPage(paging.getPage(),paging.getPageSize());
		List<CookOrderItems> list =  cookOrderItemsMapper.queryOrderItemsByCookerId(cookId);
		PageInfo<CookOrderItems> pageinf = new PageInfo<CookOrderItems>(list);
		paging.setPageResult(list);
		paging.setTotalPages(pageinf.getPages());
		
		return list;
	}
	
	
}
