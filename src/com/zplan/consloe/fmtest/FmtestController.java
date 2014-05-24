package com.zplan.consloe.fmtest;

import com.jfinal.core.Controller;

/**
 * FmtestController
 * 
 */
public class FmtestController extends Controller {
	public void index() {
		setAttr("fmtestPage", Fmtest.getQuery(getParaToInt(0, 1)));
		render("list.html");
	}
	
	public void add() {
		render("add.html");
	}
	
	public void save() {
		getModel(Fmtest.class).save();
		redirect("/fmtest");
	}
	
	public void edit() {
		setAttr("fmtest", Fmtest.dao.findById(getParaToInt()));
	}
	
	public void update() {
		getModel(Fmtest.class).update();
		redirect("/fmtest");
	}
	
	public void delete() {
		Fmtest.dao.deleteById(getParaToInt());
		redirect("/fmtest");
	}
}