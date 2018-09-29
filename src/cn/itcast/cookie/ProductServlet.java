package cn.itcast.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.utils.MyCookieUtil;

/**
 * ��Ʒ�����¼�ĺ�̨
 * @author Administrator
 *
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = -5747737695587699577L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 0.��ȡ������idֵ
		 * 1.�ж��Ƿ��ǵ�һ�η��ʣ�����ȡָ�����Ƶ�cookie���Ϊnull��˵���ǵ�һ�η��ʣ�
		 * 		* ����ǵ�һ�η��ʣ�����Ʒ��id���浽cookie�У���дcookie��
		 * 		* ������ǵ�һ�η���
		 * 			* �Ȼ�ȡcookie�е����ݣ������жϣ��ж�cookie���Ƿ������ǰ�������Ʒ��
		 * 				* ���cookie���Ѿ������˸���Ʒ����ô�Ͳ��ô�����
		 * 				* �������������cookie��׷�Ӹ���Ʒ	product=1	product=1,2
		 * 2.�ض�����Ʒ���б�ҳ��
		 * 3.��Ҫ����Ʒ���б�ҳ���л�ȡcookie�������ݣ���������ʾ��ҳ���ϡ�
		 */
		// �Ȼ�ȡ��Ʒ��id
		String id = request.getParameter("id");
		// ��ȡcookie������
		Cookie [] cookies = request.getCookies();
		// ����ָ�����Ƶ�cookie
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "product");
		// ���cookieΪnull��˵���ǵ�һ�η��ʣ�����Ʒ��id���浽cookie�У���д
		if(cookie == null){
			// �ǵ�һ��
			Cookie c = new Cookie("product",id);
			
			// ������Чʱ��
			c.setMaxAge(60*60*24);
			
			// ������Ч��·��
			c.setPath("/test");
			
			// ��д
			response.addCookie(c);
		}else{
			// ˵��cookie��Ϊ��
			// �Ȼ�ȡcookie�����ݣ��ó������жϣ���cookie�п��ܰ�����ǰ����Ʒ
			String longid = cookie.getValue();		// product=1,2,3		����˵��ǰ�������4	product=4,1,2,3
			// �ж��ַ���ids�Ƿ������ǰ��id
			// ��ids�ַ����и������
			String [] ids = longid.split(",");
			if(!checkId(ids,id)){
				// ˵������������Ʒ
				cookie.setValue(id + "," + longid);
				
				cookie.setMaxAge(60*60*24);
				
				// ������Ч��·��
				cookie.setPath("/test");
				
				// ��дcookie
				response.addCookie(cookie);
			}
		}
		// �ض������ת����ʹ��request��洢���ݣ�������ת����request.getContextPath()��ȡ����·����Ĭ�Ϻ���Ŀ������ͬ
		response.sendRedirect(request.getContextPath() + "/cookie/productList.jsp");
	}
	
	/**
	 * �ж�ids���������Ƿ����id��ֵ
	 * @param ids
	 * @param id
	 * @return
	 */
	private boolean checkId(String[] ids, String id) {
		for (String s : ids) {
			// ��ȡs��idƥ��
			if(s.equals(id)){
				// ����
				return true;
			}
		}
		// ������
		return false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}





