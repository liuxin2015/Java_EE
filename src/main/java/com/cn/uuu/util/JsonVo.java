/**
 * @author liuxin
 *
 */
package com.cn.uuu.util;

/**
 * 请求的返回值
 * @author ck
 * @param <T>
 */
public class JsonVo<T> {
	
	/**
	 *  请求是否成功
	 */
	private boolean success;
	
	/**
	 * 请求返回的消息
	 */
	private String message;
	
	/**
	 * 返回的结构
	 */
	private T results;
	
	public boolean isSuccess(){
		return success;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public T getResults(){
		return results;
	}

	public void setResults(T results){
		this.results = results;
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}

}