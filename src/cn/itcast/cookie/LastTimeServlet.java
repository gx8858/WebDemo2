package cn.itcast.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.utils.MyCookieUtil;

/**
 * 显示用户上次的访问时间
 */
public class LastTimeServlet extends HttpServlet {
	private static final long serialVersionUID = -6068764497514719951L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.先判断是否是第一次访问？因为：第一次访问和第n次处理的业务是不同的。
		 * 2.如果是第一次访问：先输出一句欢迎，记录当前的时间，保存到cookie中，回写到浏览器端。
		 * 3.如果不是第一次访问，获取cookie中的值（就是你上次的访问的时间），把时间输出到页面上。记录当前的时间，保存到cookie中。回写到浏览器端。
		 */
		
		// 设置字符中文乱码的问题
		response.setContentType("text/html;charset=UTF-8");
		
		// 先判断是否是第一次访问？先获取所有的cookie数组，查找咱们定义的cookie。
		// 如果找到咱们定义的cookie，说明不是第一次访问。如果没找到，那就是说明是第一次访问。
		// 获取cookie的数组
		Cookie [] cookies = request.getCookies();
		// 查找自己定义的cookie，查找指定名称的cookie。	(Cookie c = new Cookie("last","cookie的值"));
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "last");
		// 记录当前的时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 当前的时间的字符串
		String sDate = sdf.format(date);
		// 如果cookie为null，说明是第一次访问
		if(cookie == null){
			// 我是第一次访问
			// 输出一句话
			response.getWriter().print("<h3>亲，这是您的第一次访问！！</h3>");
			// 记录当前的时间
			// 把当前的时间回保存cookie中
			Cookie c = new Cookie("last", sDate);
			
			// 设置有效时间
			c.setMaxAge(60*60);	// 1小时
			c.setPath("/test"); // 有效路径就变成了/test
			// 回写
			response.addCookie(c);
		}else{
			// 获取上次的访问时间（从cookie中获取）
			String lasttime = cookie.getValue();
			// 把上次的时间输出到页面上去
			response.getWriter().print("<h3>亲，您上次的访问时间是" + lasttime + " ！！</h3>");
			// 记录当前的时间
			cookie.setValue(sDate);
			
			// 设置有效时间
			cookie.setMaxAge(60*60);	// 1小时
			cookie.setPath("/test"); // 有效路径就变成了/test
			
			// 回写
			response.addCookie(cookie);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
