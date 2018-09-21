package com.rsm.bean;

public class Cooker {
	private int id;
	private String cook_name;
	public Cooker() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cooker(int id, String cook_name) {
		super();
		this.id = id;
		this.cook_name = cook_name;
	}
	@Override
	public String toString() {
		return "Cooker [id=" + id + ", cook_name=" + cook_name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCook_name() {
		return cook_name;
	}
	public void setCook_name(String cook_name) {
		this.cook_name = cook_name;
	}
	
}
