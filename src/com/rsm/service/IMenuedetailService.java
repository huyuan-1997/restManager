package com.rsm.service;

import com.rsm.bean.Category;
import com.rsm.bean.Food;
import com.rsm.common.PageResult;

public interface IMenuedetailService {

	PageResult findPage(int page, int rows, String foodName);

	void add(Food food);

	Food findOne(int id);

	void update(Food food);

	void delete(int[] ids);

	Category findcategoryName(int categoryId);

}
