package com.test.aop;

import java.lang.reflect.Method;

import java.lang.reflect.InvocationHandler;
/**
 * <p class="detail">
 * 功能：指定代理类
 * </p>
 * @ClassName: ProxyUtil 
 * @version V1.0  
 * @date 2017-2-8 
 */
public class ProxyUtil implements InvocationHandler   {
	private Object target;	// 被代理的对象
	public ProxyUtil(Object target) {
		// TODO Auto-generated constructor stub
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println("do aop代理 before....");
		Object result =  method.invoke(target, args);
		System.out.println("do aop代理 after....");
		return result;
		
	}

	public final Object getTarget() {
		return target;
	}

	public final void setTarget(Object target) {
		this.target = target;
	}
	
	
}
