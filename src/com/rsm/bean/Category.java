package com.rsm.bean;

import java.io.Serializable;

public class Category implements Serializable {
	private int id;
	private String categoryName;
	private int cookId;
	private Cooker cooker;
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(int id, String categoryName, int cookId) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.cookId = cookId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getCookId() {
		return cookId;
	}
	public void setCookId(int cookId) {
		this.cookId = cookId;
	}
	public Cooker getCooker() {
		return cooker;
	}
	public void setCooker(Cooker cooker) {
		this.cooker = cooker;
	}
	
}
