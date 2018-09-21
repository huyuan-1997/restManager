package com.rsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rsm.bean.Category;
import com.rsm.bean.Food;
import com.rsm.common.PageResult;
import com.rsm.common.Result;
import com.rsm.service.IMenuedetailService;

@Controller
@RequestMapping("/menuedetail")
public class MenuedetailController {
	@Autowired
	private IMenuedetailService menuedetailService;
	/**
	 * 分页
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public PageResult findPage(int page,int rows,String foodName) throws Exception{
		 foodName=new String(foodName.getBytes("iso8859-1"),"utf-8");
		return menuedetailService.findPage(page,rows,foodName);
	}
	/**
	 * 添加
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Result add(@RequestBody Food food){
		try{
			menuedetailService.add(food);
			return new Result(true,"增加成功");
		}catch(Exception e){
			e.printStackTrace();
			return new Result(false,"增加失败");
		}
	}
	/**
	 * 查询一个
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public Food findOne(int id){
		return menuedetailService.findOne(id);
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Result update(@RequestBody Food food){
		try{
			menuedetailService.update(food);
			return new Result(true,"修改成功");
		}catch(Exception e){
			e.printStackTrace();
			return new Result(false,"修改失败");
		}
	}
	/**
	 * 删除分类
	 */
	@RequestMapping("/delete")
	public Result delete(int[] ids){
		try {
			menuedetailService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	/**
	 * 查询一个
	 */
	@RequestMapping("/findcategoryName")
	@ResponseBody
	public Category findcategoryName(int categoryId){
		return menuedetailService.findcategoryName(categoryId);
	}
	
}
