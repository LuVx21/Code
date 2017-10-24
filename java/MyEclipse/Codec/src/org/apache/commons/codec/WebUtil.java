package org.apache.commons.codec;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

//��װ���������Bean�У����ֶκ�bean��������ȫһ�£�
public class WebUtil {

	/*
	����username=abc   password=123
	JavaBean:private String username;private String password;  setUsername(String s);setPassword(String s);
	
	//key:���ֶ�����username��password   value��String[]{abc}  String[]{123}
	Map<String,String[]> map = request.getParameterMap();
	
	//����map,�ж�keyֵ��username�룿����ǣ�����setUsername("abc");
	
	 */
	public static <T> T fillBean(HttpServletRequest request,
			Class<T> class1) {
		try {
			T bean = class1.newInstance();
			//��������������ƣ����ö�Ӧ��setter������������������ֵ�����磺������ֶ���Ϊusername�������bean.setUsername("abc");
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException("��װJavaBeanʱ��������������Ժ���������������Ƿ�һ��");
		}
	}

}
