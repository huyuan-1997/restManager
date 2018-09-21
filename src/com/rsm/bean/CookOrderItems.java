package com.rsm.bean;

public class CookOrderItems {
	private int id;
	private int food_id;
	private int status;
	private int order_id;
	private int amount;
	private String food_name;
	public CookOrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CookOrderItems(int id, int food_id, int status, int order_id, int amount, String food_name) {
		super();
		this.id = id;
		this.food_id = food_id;
		this.status = status;
		this.order_id = order_id;
		this.amount = amount;
		this.food_name = food_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	@Override
	public String toString() {
		return "OrderItems [id=" + id + ", food_id=" + food_id + ", status=" + status + ", order_id=" + order_id
				+ ", amount=" + amount + ", food_name=" + food_name + "]";
	}
	
}
