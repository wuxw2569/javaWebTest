package com.test.service;

import org.springframework.stereotype.Service;

@Service
public interface IndexService {
	public String queryForUserList(String keywords);
	public String doLogin(String userName,String userPwd);
}
