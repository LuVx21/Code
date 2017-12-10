package org.hsweb.commons.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

//封装请求参数到Bean中（表单字段和bean的属性完全一致）
public class WebUtil {

	/*
	表单：username=abc   password=123
	JavaBean:private String username;private String password;  setUsername(String s);setPassword(String s);
	
	//key:表单字段名：username和password   value：String[]{abc}  String[]{123}
	Map<String,String[]> map = request.getParameterMap();
	
	//遍历map,判断key值是username码？如果是，调用setUsername("abc");
	
	 */
	public static <T> T fillBean(HttpServletRequest request,
			Class<T> class1) {
		try {
			T bean = class1.newInstance();
			//按照请求参数名称，调用对应的setter方法，填充请求参数的值。比如：如果表单字段名为username，会调用bean.setUsername("abc");
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException("封装JavaBean时出错，请检查类的属性和请求参数的名称是否一致");
		}
	}

}
