package com.rsm.mapper;

import java.util.Map;

import com.github.pagehelper.Page;
import com.rsm.bean.Category;
import com.rsm.bean.Food;

public interface MenuedetailMapper {

	void add(Food food);

	Page<Food> findAll(Map map);
	Page<Food> findAll();
	Food findOne(int id);

	void update(Food food);

	void delete(int id);

	Category findCategoryById(int id);

}
