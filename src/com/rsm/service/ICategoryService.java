package com.rsm.service;

import java.util.List;
import java.util.Map;

import com.rsm.bean.Category;
import com.rsm.bean.Cooker;
import com.rsm.common.PageResult;
import com.rsm.common.Result;

public interface ICategoryService {
	PageResult findPage(int page, int rows);
	void add(Category category);
	Category findOne(int id);
	void update(Category category);
	void delete(int[] ids);
	List<Map> findAll();
	List<Map> findAllCook();
	Cooker findCook(int id);
}
