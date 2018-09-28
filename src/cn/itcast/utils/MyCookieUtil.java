package cn.itcast.utils;

import javax.servlet.http.Cookie;

/**
 * ����cookie
 * @author Administrator
 *
 */
public class MyCookieUtil {
	
	/**
	 * ͨ��cookie����������ȡָ����cookie������ҵ�����cookie������Ҳ���������null
	 * @param cookies
	 * @param cookieName
	 * @return
	 */
	public static Cookie getCookieByName(Cookie [] cookies,String cookieName){
		// ���cookies����Ϊ�գ�����null
		if(cookies == null){
			return null;
		}else{
			// �����Ϊ�գ�ѭ���������õ�ÿһ��cookie����cookieNameȥ�жϣ����ƥ��ɹ��ˣ����ء�
			for (Cookie cookie : cookies) {
				// �õ�ÿһ��cookie����cookieNameȥ�жϣ����ƥ��ɹ��ˣ����ء�
				// ��ȡcookie������
				if(cookie.getName().equals(cookieName)){
					// ƥ��ɹ���
					return cookie;
				}
			}
			return null;
		}
	}

}