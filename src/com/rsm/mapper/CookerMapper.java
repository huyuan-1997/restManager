package com.rsm.mapper;

import java.util.List;

import com.rsm.bean.Cooker;

public interface CookerMapper {
	//����cooker
	public int insertCooker(Cooker cooker);
	//��ѯ���г�ʦ
	public List<Cooker> queryAllCooker();
	//����ɾ����ʦ
	public int deleteCookers(String ids);
	//����ID��ѯ��ʦ
	public Cooker queryCookerById(int id);
}
