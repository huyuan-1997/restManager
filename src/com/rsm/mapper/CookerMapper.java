package com.rsm.mapper;

import java.util.List;

import com.rsm.bean.Cooker;

public interface CookerMapper {
	//插入cooker
	public int insertCooker(Cooker cooker);
	//查询所有厨师
	public List<Cooker> queryAllCooker();
	//批量删除厨师
	public int deleteCookers(String ids);
	//根据ID查询厨师
	public Cooker queryCookerById(int id);
}
