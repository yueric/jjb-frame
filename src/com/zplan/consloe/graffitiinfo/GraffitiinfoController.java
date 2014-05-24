package com.zplan.consloe.graffitiinfo;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * GraffitiinfoController
 * 
 */
@Before(GraffitiinfoInterceptor.class)
public class GraffitiinfoController extends Controller {
	public void index() {
		setAttr("graffitiinfoPage", Graffitiinfo.getQuery(getParaToInt(0, 1)));
		render("list.html");
	}
	
	public void add() {
		render("add.html");
	}
	
	public void save() {
		getModel(Graffitiinfo.class).save();
		redirect("/graffitiinfo");
	}
	
	public void edit() {
		setAttr("graffitiinfo", Graffitiinfo.dao.findById(getParaToInt()));
	}
	
	public void update() {
		getModel(Graffitiinfo.class).update();
		redirect("/graffitiinfo");
	}
	
	public void delete() {
		Graffitiinfo.dao.deleteById(getParaToInt());
		redirect("/graffitiinfo");
	}
}