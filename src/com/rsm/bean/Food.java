package com.rsm.bean;

import java.io.Serializable;

public class Food implements Serializable{
	private int foodId;
	private String foodName;
	private int foodPrice;
	private String foodUrl;
	private int categoryId;
	private Category categorys;
	private int foodSort;
	public Food() {
		// TODO Auto-generated constructor stub
	}
	public Food(int foodId, String foodName, int foodPrice, String foodUrl, int categoryId, int foodSort) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodUrl = foodUrl;
		this.categoryId = categoryId;
		this.foodSort = foodSort;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodUrl() {
		return foodUrl;
	}
	public void setFoodUrl(String foodUrl) {
		this.foodUrl = foodUrl;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getFoodSort() {
		return foodSort;
	}
	public void setFoodSort(int foodSort) {
		this.foodSort = foodSort;
	}
	public Category getCategorys() {
		return categorys;
	}
	public void setCategorys(Category categorys) {
		this.categorys = categorys;
	}
}
