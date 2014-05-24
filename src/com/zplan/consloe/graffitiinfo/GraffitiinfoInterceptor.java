package com.zplan.consloe.graffitiinfo;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * GraffitiinfoInterceptor
 */
public class GraffitiinfoInterceptor implements Interceptor {
	
	public void intercept(ActionInvocation ai) {
		ai.getController().setAttr("_MODULE", "graffitiinfo");
		ai.invoke();
	}
}
