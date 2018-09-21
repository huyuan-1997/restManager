package com.rsm.common;

import java.io.Serializable;

public class Result implements Serializable {
	private boolean success;
	private String message;

	public Result(boolean success, String message) {
		super();
		this.setSuccess(success);
		this.setMessage(message);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
