package com.rsm.mapper;

import java.util.List;
import java.util.Map;

import com.rsm.bean.Category;
import com.rsm.bean.Cooker;

public interface CategoryMapper {
	/**
	 * ��ҳ��ѯ����
	 * @return
	 */
	List<Category> findAll();
	/**
	 * ����һ����Ʒ����
	 */
	void add(Category category);
	/**
	 * ��ѯһ����Ʒ����
	 */
	Category findOne(int id);
	/**
	 * ͨ��id�޸Ĳ�Ʒ����
	 * @param category
	 */
	void update(Category category);
	/**
	 * ɾ��һ������
	 * @param id
	 */
	void delete(int id);
	/**
	 * �������еķ��࣬���Ҹ�һ������
	 * @return
	 */
	List<Map> findAllCategory();
	/**
	 * ��ѯ���г�ʦ����
	 * @return
	 */
	
	List<Map> findAllCook();
	/**
	 * ����һ����ʦ
	 * @return
	 */
	Cooker findCookById(int id);
}
