package com.cn.uuu.pojo;

import com.cn.uuu.reflect.ReflectInterface;

public class Message implements ReflectInterface{
	private Integer id;
	private String message;
	private String time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void sPrint(){
		System.out.println("SPring");
	}

	public void say() {
		System.out.println("Hello Message");
	}
}
