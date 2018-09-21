package com.rsm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rsm.bean.Category;
import com.rsm.bean.Cooker;
import com.rsm.common.PageResult;
import com.rsm.common.Result;
import com.rsm.mapper.CategoryMapper;
import com.rsm.service.ICategoryService;
@Service
@Transactional
public class CategoryService implements ICategoryService {
	@Autowired
	private CategoryMapper categoryMapper;
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		Page<Category> page = (Page<Category>) categoryMapper.findAll();
		return new PageResult(page.getTotal(),page.getResult());
	}
	@Override
	public void add(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.add(category);
	}
	@Override
	public Category findOne(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.findOne(id);
	}
	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.update(category);
	}
	@Override
	public void delete(int[] ids) {
		// TODO Auto-generated method stub
		for(int id:ids){
			categoryMapper.delete(id);
		}	

	}
	@Override
	public List<Map> findAll() {
		// TODO Auto-generated method stub
		return categoryMapper.findAllCategory();
	}
	@Override
	public List<Map> findAllCook() {
		// TODO Auto-generated method stub
		return categoryMapper.findAllCook();
	}
	@Override
	public Cooker findCook(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.findCookById(id);
	}

}
