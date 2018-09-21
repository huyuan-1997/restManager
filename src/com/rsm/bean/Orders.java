package com.rsm.bean;

import java.util.List;

public class Orders {
	private Integer order_id;
	private String create_time;
	private String finish_time;
	private int totalPrice;
	private List<OrdersItem> ordersItems;
	
	
	
	public List<OrdersItem> getOrdersItems() {
		return ordersItems;
	}
	public void setOrdersItems(List<OrdersItem> ordersItems) {
		this.ordersItems = ordersItems;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getFinish_time() {
		return finish_time;
	}
	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", create_time=" + create_time + ", finish_time=" + finish_time
				+ ", totalPrice=" + totalPrice + ", ordersItems=" + ordersItems + "]";
	}
	
	
}
