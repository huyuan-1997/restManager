package com.rsm.common;

import java.util.List;

/**
 * ��ҳʵ��bean
 * 
 * @author huyuan
 *
 */
public class PageResult {
	private long total;// �ܼ�¼��
	private List rows;// ��ǰҳ���

	public PageResult(long total, List rows) {
		super();
		this.setTotal(total);
		this.setRows(rows);
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
