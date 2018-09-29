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
		
		// �Ȼ�ȡsession�е�ֵ��msg��
		// ����/test/session1��ʱ�����������cookie,����ת��session2��ʱ����ʾ����getAttribute��ֵ
		// ��ʱ���Ҫ��session1�����getId��ֵ�Ѳ�����ʽƴ�ӵ�·����������http://localhost:8080/test/session2?JSESSIONID=6D68AE333445545A8842BC68DBD6E020�� ���ɵõ�getAttribute��ֵ 
		
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
