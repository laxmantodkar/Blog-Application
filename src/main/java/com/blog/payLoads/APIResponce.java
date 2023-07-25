package com.blog.payLoads;



public class APIResponce {

	private String msg;
	private boolean status;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public APIResponce(String msg, boolean status) {
		super();
		this.msg = msg;
		this.status = status;
	}
	
}
