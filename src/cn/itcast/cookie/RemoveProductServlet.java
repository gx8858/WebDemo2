package cn.itcast.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.utils.MyCookieUtil;

/**
 * 清除浏览记录
 * @author Administrator
 *
 */
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 6334928395422816670L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置setMaxAge(0);
		// 先获取cookie
		Cookie [] cookies = request.getCookies();
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "product");
		if(cookie != null){
			
			// 设置有效路径
			cookie.setPath("/test");
			
			// 设置有效时间是0
			cookie.setMaxAge(0);
			// 回写
			response.addCookie(cookie);
		}
		// 重定向
		response.sendRedirect(request.getContextPath()+"/cookie/productList.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}



