package com.sia.main.web.model;

public class Response {
	private String status;
	private String message;
	private Object data;
	
	public Response(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public Response() {
		this.status = "ok";
		this.message = "";
		this.data = null;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}