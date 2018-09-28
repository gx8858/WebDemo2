package cn.itcast.utils;

import javax.servlet.http.Cookie;

/**
 * 操作cookie
 * @author Administrator
 *
 */
public class MyCookieUtil {
	
	/**
	 * 通过cookie的名称来获取指定的cookie，如果找到返回cookie，如果找不到，返回null
	 * @param cookies
	 * @param cookieName
	 * @return
	 */
	public static Cookie getCookieByName(Cookie [] cookies,String cookieName){
		// 如果cookies数组为空，返回null
		if(cookies == null){
			return null;
		}else{
			// 如果不为空，循环遍历，拿到每一个cookie，和cookieName去判断，如果匹配成功了，返回。
			for (Cookie cookie : cookies) {
				// 拿到每一个cookie，和cookieName去判断，如果匹配成功了，返回。
				// 获取cookie的名称
				if(cookie.getName().equals(cookieName)){
					// 匹配成功了
					return cookie;
				}
			}
			return null;
		}
	}

}