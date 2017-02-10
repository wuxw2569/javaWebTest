package com.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * <p class="detail">
 * 功能：特殊字符过滤器
 * </p>
 * @ClassName: CharacterFilter 
 * @version V1.0  
 * @date 2014年9月25日 
 */
public class CharacterFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		/**
		 * 表单文本域中的js特殊代码转码，防止js注入
		 */
		TsRequest wrapRequest=new TsRequest(request,request.getParameterMap());
		chain.doFilter(wrapRequest, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
