package cn.itcast.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo2 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 先获取session中的值（msg）
		// 访问/test/session1的时候如果禁用了cookie,当跳转到session2的时候显示不出getAttribute的值
		// 这时候就要把session1输出的getId的值已参数方式拼接到路径后，例：（http://localhost:8080/test/session2?JSESSIONID=6D68AE333445545A8842BC68DBD6E020） 即可得到getAttribute的值 
		
		HttpSession session = request.getSession();
		String msg = (String) session.getAttribute("msg");
		System.out.println(msg);
		response.getWriter().write("success");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
