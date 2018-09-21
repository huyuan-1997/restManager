package com.rsm.bean;

public class OrdersItem {
	private Integer id;
	private Integer food_id;
	private String status;
	private Integer order_id;
	private String food_name;
	private Integer amount;
	private Integer item_price;
	
	
	
	
	public Integer getItem_price() {
		return item_price;
	}
	public void setItem_price(Integer item_price) {
		this.item_price = item_price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFood_id() {
		return food_id;
	}
	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	@Override
	public String toString() {
		return "OrdersItem [id=" + id + ", food_id=" + food_id + ", status=" + status + ", order_id=" + order_id + "]";
	}
	
}
