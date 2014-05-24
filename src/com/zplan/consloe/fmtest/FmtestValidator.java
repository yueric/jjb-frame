package com.zplan.consloe.fmtest;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * FmtestValidator.
 */
public class FmtestValidator extends Validator {
	
	protected void validate(Controller controller) {
		//目前生成请按需添加，谢谢！！！
		validateInteger("fmtest.id", Integer.MIN_VALUE, Integer.MAX_VALUE, "idMsg", "请输入数字！");
		validateInteger("fmtest.age", Integer.MIN_VALUE, Integer.MAX_VALUE, "ageMsg", "请输入数字！");
		validateDate("fmtest.birthday", "2000-12-31", "2099-12-31", "birthdayMsg", "请输入日期！");
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Fmtest.class);		
		String actionKey = getActionKey();
		if (actionKey.equals("/fmtest/save"))
			controller.render("add.html");
		else if (actionKey.equals("/fmtest/update"))
			controller.render("edit.html");
	}
}
