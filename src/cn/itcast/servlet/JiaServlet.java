package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ������͵Ĳ���
 * @author Administrator
 *
 */
public class JiaServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.��ȡ�������
		 * 2.���
		 * 3.ʹ��ת�������ض��򵽳ɹ�ҳ��
		 */
		// ��ȡ�������
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		int num11 = Integer.parseInt(num1);
		int num22 = Integer.parseInt(num2);
		int result = num11 + num22;
		
		// �ҵ��ɹ���ҳ��
		// ʹ���ض������ת��
		request.setAttribute("result", result);
		// ֻ��ʹ��ת���ˣ�/jsp/he.jsp��
		request.getRequestDispatcher("/jsp/he.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
