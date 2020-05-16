package org.wjf.springcloud.vo;

import java.io.Serializable;

public class ResultTemplate<T> implements Serializable {

	private static final long serialVersionUID = -6836290967683816744L;

	private Integer code;

	private String msg;

	private T data;

	private String sym;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}

	public ResultTemplate() {
	}

	private ResultTemplate(Integer code, String msg, T data, String sym) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.sym = sym;
	}

	public static <T> ResultTemplate<T> getSuccessResult(){
		return new ResultTemplate<>(200,"请求成功！",null,"ok");
	}

	public static <T> ResultTemplate<T> getSuccessResult(T t){
		return new ResultTemplate<>(200,"请求成功！",t,"ok");
	}

	public static <T> ResultTemplate<T> getFailResult(){
		return new ResultTemplate<>(400,"请求失败！",null,"fail");
	}

	public static <T> ResultTemplate<T> getFailResult(T t){
		return new ResultTemplate<>(400,"请求失败！",t,"fail");
	}
}
