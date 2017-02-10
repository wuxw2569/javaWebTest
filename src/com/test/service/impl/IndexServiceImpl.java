package com.test.service.impl;

import com.test.service.IndexService;

public class IndexServiceImpl implements IndexService {
	
	/**
	 * <p class="detail">
	 * 功能：这登录
	 * </p>
	 * @author wuxw
	 * @param userName
	 * @param userPwd
	 * @return 
	 * @throws
	 */
	public String doLogin(String userName,String userPwd){
		System.out.println("service : 这里service开始执行登录....");
		System.out.println("service : 登录名: "+ userName+",登录密码: "+userPwd);
		return "登录成功";
	}
	
	/**
	 * <p class="detail">
	 * 功能：查询用户列表
	 * </p>
	 * @author wuxw
	 * @param keywords
	 * @return 
	 * @throws
	 */
	public String queryForUserList(String keywords){
		System.out.println("这里service开始执行查询用户列表....");
		return "查询成功";
	}

}
