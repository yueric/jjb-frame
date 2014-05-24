package com.demo.common;

import java.io.Serializable;
/**
 * 登陆信息
 * @author eric
 *
 */
public class LoginInfo implements Serializable {
	//用户名字
	private String name;
	//用户访问当前模块
	private String module;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
}
