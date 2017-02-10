package com.test.filter;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/****
 * 系统拦截器
 *
 */
public class SysFilter implements Filter{
	
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
	@Override
	public void destroy() {
		
	}
	// ② 执行过滤
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
				FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse)response;
		String XRequestedWith = httpRequest.getHeader("X-Requested-With");//XMLHttpRequest==ajax   null==>other
		
		res.setDateHeader("Expires",0); //Expires:过时期限值 
		res.setHeader("Cache-Control", "no-cache"); //Cache-Control来控制页面的缓存与否,public:浏览器和缓存服务器都可以缓存页面信息；
		res.setHeader("Pragma", "no-cache"); //Pragma:设置页面是否缓存，为Pragma则缓存，no-cache则不缓存
		
			// ②-1 保证该过滤器在一次请求中只被调用一次
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
		} else {
			 
			chain.doFilter(request, response);
		}
	}
		
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//filter中注入service
		/*ServletContext context = arg0.getServletContext();  
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);  
		sysUserService = (SysUserService) ctx.getBean("sysUserService");*/
	}
	
	  
  
}
