package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.service.impl.IndexServiceImpl;

@Controller  
@Scope(value="prototype")
@RequestMapping(value="/web/index")
public class IndexController {
	
	@Autowired
	IndexServiceImpl indexService;
	
	
	/**
	 * <p class="detail">
	 * 功能：登录
	 * </p>
	 * @author wuxw
	 * @param request
	 * @param response
	 * @param user
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 * @throws
	 */
	@RequestMapping(value="/doLogin",produces="application/json;charset=UTF-8")
   	@ResponseBody
    public String doLogin(HttpServletRequest request,HttpServletResponse response,   
            String userName, String userPwd) throws Exception {  
		String userInfo = indexService.doLogin( userName, userPwd);
		
        return userInfo;  
    }  
	
	/**
	 * <p class="detail">
	 * 功能：index
	 * </p>
	 * @author wuxw
	 * @return 
	 * @throws
	 */
	@RequestMapping(value="/index",produces="application/json;charset=UTF-8")
    public String index() { 
    	
        return "/index";  
    }
}
