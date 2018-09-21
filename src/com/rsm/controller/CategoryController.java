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
 * 管理菜品分类
 * @author DELL
 *
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	/**
	 * 分页
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
	 * 添加
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Result add(@RequestBody Category category){
		try{
			categoryService.add(category);
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
	public Category findOne(int id){
		return categoryService.findOne(id);
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Result update(@RequestBody Category category){
		try{
			categoryService.update(category);
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
			categoryService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}

	}
	/**
	 * 查询所有的分类
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Map> findAll(){
		return categoryService.findAll();
	}
	/**
	 * 查找所有的Cook
	 */
	@RequestMapping("/findAllCook")
	@ResponseBody
	public List<Map> findAllCook(){
		return categoryService.findAllCook();
	}
	/**
	 * 查找所有的Cook
	 */
	@RequestMapping("/findCook")
	@ResponseBody
	public Cooker findCook(int cookId){
		return categoryService.findCook(cookId);
	}
	
	
}
