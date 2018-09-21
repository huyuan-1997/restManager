package com.rsm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rsm.bean.Category;
import com.rsm.bean.Food;
import com.rsm.common.PageResult;
import com.rsm.mapper.MenuedetailMapper;
import com.rsm.service.IMenuedetailService;

@Service
@Transactional
public class MenuedetailServiceImpl implements IMenuedetailService {
	@Autowired
	private MenuedetailMapper menuedetailMapper;

	@Override
	public PageResult findPage(int pageNum, int pageSize,String foodName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Map map = new HashMap();
		map.put("foodName", foodName);
		Page<Food> page = (Page<Food>) menuedetailMapper.findAll(map);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void add(Food food) {
		// TODO Auto-generated method stub
		menuedetailMapper.add(food);
	}

	@Override
	public Food findOne(int id) {
		// TODO Auto-generated method stub
		return menuedetailMapper.findOne(id);
	}

	@Override
	public void update(Food food) {
		// TODO Auto-generated method stub
		menuedetailMapper.update(food);
	}

	@Override
	public void delete(int[] ids) {
		// TODO Auto-generated method stub
		for(int id:ids){
			menuedetailMapper.delete(id);
		}	
	}
	@Override
	public Category findcategoryName(int id) {
		// TODO Auto-generated method stub
		return menuedetailMapper.findCategoryById(id);
	}

}
