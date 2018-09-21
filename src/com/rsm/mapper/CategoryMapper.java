package com.rsm.mapper;

import java.util.List;
import java.util.Map;

import com.rsm.bean.Category;
import com.rsm.bean.Cooker;

public interface CategoryMapper {
	/**
	 * 分页查询所有
	 * @return
	 */
	List<Category> findAll();
	/**
	 * 增加一个菜品分类
	 */
	void add(Category category);
	/**
	 * 查询一个菜品分类
	 */
	Category findOne(int id);
	/**
	 * 通过id修改菜品分类
	 * @param category
	 */
	void update(Category category);
	/**
	 * 删除一个分类
	 * @param id
	 */
	void delete(int id);
	/**
	 * 查找所有的分类，并且给一个别名
	 * @return
	 */
	List<Map> findAllCategory();
	/**
	 * 查询所有厨师分类
	 * @return
	 */
	
	List<Map> findAllCook();
	/**
	 * 查找一个厨师
	 * @return
	 */
	Cooker findCookById(int id);
}
