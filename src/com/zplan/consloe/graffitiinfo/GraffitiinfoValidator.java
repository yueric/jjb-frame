package com.zplan.consloe.graffitiinfo;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * GraffitiinfoValidator.
 */
public class GraffitiinfoValidator extends Validator {
	
	protected void validate(Controller controller) {
		//目前生成请按需添加，谢谢！！！
		validateInteger("graffitiinfo.id", Integer.MIN_VALUE, Integer.MAX_VALUE, "idMsg", "请输入数字！");
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Graffitiinfo.class);		
		String actionKey = getActionKey();
		if (actionKey.equals("/graffitiinfo/save"))
			controller.render("add.html");
		else if (actionKey.equals("/graffitiinfo/update"))
			controller.render("edit.html");
	}
}
