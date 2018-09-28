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
		 * ������رգ���ΪԿ��û�ˣ��Ͳ����ҵ��������ڲ���session�С�
		 */
		// ��ȡsession��ֵ
		HttpSession session = request.getSession();
		// ��������ֵ
		session.setAttribute("msg", "С��");
		// ��ȡsession��Կ��
		System.out.println(session.getId());
		
		String path = "/day11/session2";
		// ��д·��
		// String path2 = response.encodeRedirectURL(path);
		// �ض���session2��̨
		response.sendRedirect(path);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
