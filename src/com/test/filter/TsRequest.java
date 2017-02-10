package com.test.filter;

import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * <p class="detail">
 * 功能：封装的请求处理特殊字符
		 表单文本域中的js特殊代码转码，防止js注入
 * </p>
 * @ClassName: TsRequest 
 * @version V1.0  
 * @date 2014年9月25日 
 */
public class TsRequest extends HttpServletRequestWrapper {
	private Map params;

	public TsRequest(HttpServletRequest request, Map newParams) {
		super(request);
		this.params = newParams;
	}

	public Map getParameterMap() {
		return params;
	}

	public Enumeration getParameterNames() {
		Vector l = new Vector(params.keySet());
		return l.elements();
	}

	public String[] getParameterValues(String name) {
		Object v = params.get(name);
		if (v == null) {
			return null;
		} else if (v instanceof String[]) {
			String[] value = (String[]) v;
			for (int i = 0; i < value.length; i++) {
				value[i] = value[i].replaceAll("<script>", "&lt;script&gt;");
				value[i] = value[i].replaceAll("</script>", "&lt;/script&gt;");
			}
			return (String[]) value;
		} else if (v instanceof String) {
			String value = (String) v;
			value = value.replaceAll("<script>", "&lt;script&gt;");
			value = value.replaceAll("</script>", "&lt;/script&gt;");
			return new String[] { (String) value };
		} else {
			return new String[] { v.toString() };
		}
	}

	public String getParameter(String name) {
		Object v = params.get(name);
		if (v == null) {
			return null;
		} else if (v instanceof String[]) {
			String[] strArr = (String[]) v;
			if (strArr.length > 0) {
				String value = strArr[0];
				value = value.replaceAll("<script>", "&lt;script&gt;");
				value = value.replaceAll("</script>", "&lt;/script&gt;");
				return value;
			} else {
				return null;
			}
		} else if (v instanceof String) {
			String value = (String) v;
			value = value.replaceAll("<script>", "&lt;script&gt;");
			value = value.replaceAll("</script>", "&lt;/script&gt;");
			return (String) value;
		} else {
			return v.toString();
		}
	}
}
