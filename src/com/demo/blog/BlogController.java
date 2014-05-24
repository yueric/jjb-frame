package com.demo.blog;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * BlogController
 * 注意：在实际项目中业务与sql需要写在Model中，此demo仅为示意,故将sql写在了Controller中
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {
	public void index() {
		setAttr("blogPage", Blog.getQuery(getParaToInt(0, 1)));
		render("blog.html");
	}
	
	public void add() {
		render("add.html");
	}
	
	public void save() {
		getModel(Blog.class).save();
		redirect("/blog");
	}
	
	public void edit() {
		setAttr("blog", Blog.dao.findById(getParaToInt()));
	}
	
	public void update() {
		getModel(Blog.class).update();
		redirect("/blog");
	}
	
	public void delete() {
		Blog.dao.deleteById(getParaToInt());
		redirect("/blog");
	}
}


