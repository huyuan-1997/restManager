package com.rsm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rsm.bean.Category;
import com.rsm.bean.Cooker;
import com.rsm.common.PageResult;
import com.rsm.common.Result;
import com.rsm.service.ICategoryService;
/**
 * �����Ʒ����
 * @author DELL
 *
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	/**
	 * ��ҳ
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public PageResult findPage(int page,int rows){
		return categoryService.findPage(page,rows);
	}
	/**
	 * ���
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Result add(@RequestBody Category category){
		try{
			categoryService.add(category);
			return new Result(true,"���ӳɹ�");
		}catch(Exception e){
			e.printStackTrace();
			return new Result(false,"����ʧ��");
		}
	}
	/**
	 * ��ѯһ��
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public Category findOne(int id){
		return categoryService.findOne(id);
	}
	/**
	 * �޸�
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Result update(@RequestBody Category category){
		try{
			categoryService.update(category);
			return new Result(true,"�޸ĳɹ�");
		}catch(Exception e){
			e.printStackTrace();
			return new Result(false,"�޸�ʧ��");
		}
	}
	/**
	 * ɾ������
	 */
	@RequestMapping("/delete")
	public Result delete(int[] ids){
		try {
			categoryService.delete(ids);
			return new Result(true, "ɾ���ɹ�"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "ɾ��ʧ��");
		}

	}
	/**
	 * ��ѯ���еķ���
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Map> findAll(){
		return categoryService.findAll();
	}
	/**
	 * �������е�Cook
	 */
	@RequestMapping("/findAllCook")
	@ResponseBody
	public List<Map> findAllCook(){
		return categoryService.findAllCook();
	}
	/**
	 * �������е�Cook
	 */
	@RequestMapping("/findCook")
	@ResponseBody
	public Cooker findCook(int cookId){
		return categoryService.findCook(cookId);
	}
	
	
}
