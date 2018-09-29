package cn.itcast.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 浏览器关闭，因为钥匙没了，就不能找到服务器内部的session中。
		 */
		// 获取session的值
		HttpSession session = request.getSession();
		// 存入属性值
		session.setAttribute("msg", "小凤");
		// 获取session的钥匙
		System.out.println(session.getId());
		
		String path = "/test/session2";
		// 重写路径
		// String path2 = response.encodeRedirectURL(path);
		// 重定向到session2后台
		response.sendRedirect(path);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
