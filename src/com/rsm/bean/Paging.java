package com.rsm.bean;

import java.util.List;

public class Paging {
	int page=1;
	int pageSize=10;
	int totalPages=10000;
	List pageResult;
	public Paging() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paging(int page, int pageSize, int totalPages, List pageResult) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.pageResult = pageResult;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List getPageResult() {
		return pageResult;
	}
	public void setPageResult(List pageResult) {
		this.pageResult = pageResult;
	}
	@Override
	public String toString() {
		return "Page [page=" + page + ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", pageResult="
				+ pageResult + "]";
	}
	
	
}
