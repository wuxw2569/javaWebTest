package com.test.test;
import java.lang.reflect.Proxy;

import com.test.aop.ProxyUtil;
import com.test.service.IndexService;
import com.test.service.impl.IndexServiceImpl;
/**
 * <p class="detail">
 * 功能：代理测试
 * </p>
 * @ClassName: ProxyTest 
 * @version V1.0  
 * @date 2017-2-8 
 * @author wuxw
 * Copyright 2015 tsou.com, Inc. All rights reserved
 */
public class ProxyTest {
	public static void main(String[] args) {
		Object proxyedObject = new IndexServiceImpl();
		
		ProxyUtil proxyUtils = new ProxyUtil(proxyedObject);
		
		// xml配置方式:  生成代理对象，对被代理对象的这些接口进行代理：UserServiceImpl.class.getInterfaces()
		IndexService proxyObject = (IndexService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), 
				IndexServiceImpl.class.getInterfaces(), proxyUtils); 
		
		/* ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
		 IndexService proxyObject = ctx.getBean("indexService", IndexService.class);*/
		
		proxyObject.doLogin("wuxw","123456");
		
	}
}
