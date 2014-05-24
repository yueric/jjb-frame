package com.demo.blog;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * BlogInterceptor
 */
public class BlogInterceptor implements Interceptor {
	
	public void intercept(ActionInvocation ai) {
		

		ai.getController().setAttr("_MODULE", "blog");
		ai.invoke();
	}
}
