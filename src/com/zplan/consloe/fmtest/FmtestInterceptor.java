package com.zplan.consloe.fmtest;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * FmtestInterceptor
 */
public class FmtestInterceptor implements Interceptor {
	
	public void intercept(ActionInvocation ai) {
		ai.getController().setAttr("_MODULE", "fmtest");
		ai.invoke();
	}
}
