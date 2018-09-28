package cn.itcast.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.utils.MyCookieUtil;

/**
 * ��������¼
 * @author Administrator
 *
 */
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 6334928395422816670L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����setMaxAge(0);
		// �Ȼ�ȡcookie
		Cookie [] cookies = request.getCookies();
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "product");
		if(cookie != null){
			
			// ������Ч·��
			cookie.setPath("/day11");
			
			// ������Чʱ����0
			cookie.setMaxAge(0);
			// ��д
			response.addCookie(cookie);
		}
		// �ض���
		response.sendRedirect(request.getContextPath()+"/cookie/productList.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}



