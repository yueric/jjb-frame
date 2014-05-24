package com.demo.common;

import com.jfinal.core.Controller;

/**
 * CommonController
 */
public class CommonController extends Controller {
	
	public void index() {
		render("common/index.html");
	}
	/**
	 * 用户登陆
	 */
	public void login(){		
		
	}
	public void rspw() {
		render("common/reset-password.html");
	}
	
	public void frame() {
		render("common/frame.html");
	}
	
	public void chat() {
		render("chat/index.html");
	}
	
	/**
	 * 文件上传测试
	 */
	public void uploadImg(){
		
		
	}
}
