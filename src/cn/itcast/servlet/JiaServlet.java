package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理求和的操作
 * @author Administrator
 *
 */
public class JiaServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.获取请求参数
		 * 2.求和
		 * 3.使用转发或者重定向到成功页面
		 */
		// 获取请求参数
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		int num11 = Integer.parseInt(num1);
		int num22 = Integer.parseInt(num2);
		int result = num11 + num22;
		
		// 找到成功的页面
		// 使用重定向或者转发
		request.setAttribute("result", result);
		// 只能使用转发了（/jsp/he.jsp）
		request.getRequestDispatcher("/jsp/he.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
