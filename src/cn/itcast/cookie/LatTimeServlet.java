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
 * ��ʾ�û��ϴεķ���ʱ��
 * @author Administrator
 *
 */
public class LatTimeServlet extends HttpServlet {
	private static final long serialVersionUID = -6068764497514719951L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.���ж��Ƿ��ǵ�һ�η��ʣ���Ϊ����һ�η��ʺ͵�n�δ����ҵ���ǲ�ͬ�ġ�
		 * 2.����ǵ�һ�η��ʣ������һ�件ӭ����¼��ǰ��ʱ�䣬���浽cookie�У���д��������ˡ�
		 * 3.������ǵ�һ�η��ʣ���ȡcookie�е�ֵ���������ϴεķ��ʵ�ʱ�䣩����ʱ�������ҳ���ϡ���¼��ǰ��ʱ�䣬���浽cookie�С���д��������ˡ�
		 */
		
		// �����ַ��������������
		response.setContentType("text/html;charset=UTF-8");
		
		// ���ж��Ƿ��ǵ�һ�η��ʣ��Ȼ�ȡ���е�cookie���飬�������Ƕ����cookie��
		// ����ҵ����Ƕ����cookie��˵�����ǵ�һ�η��ʡ����û�ҵ����Ǿ���˵���ǵ�һ�η��ʡ�
		// ��ȡcookie������
		Cookie [] cookies = request.getCookies();
		// �����Լ������cookie������ָ�����Ƶ�cookie��	(Cookie c = new Cookie("last","cookie��ֵ"));
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "last");
		// ��¼��ǰ��ʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ��ǰ��ʱ����ַ���
		String sDate = sdf.format(date);
		// ���cookieΪnull��˵���ǵ�һ�η���
		if(cookie == null){
			// ���ǵ�һ�η���
			// ���һ�仰
			response.getWriter().print("<h3>�ף���ү��Ǯ����Ŷ����</h3>");
			// ��¼��ǰ��ʱ��
			// �ѵ�ǰ��ʱ��ر���cookie��
			Cookie c = new Cookie("last", sDate);
			
			// ������Чʱ��
			c.setMaxAge(60*60);	// 1Сʱ
			c.setPath("/day11"); // ��Ч·���ͱ����/day11
			// ��д
			response.addCookie(c);
		}else{
			// ��ȡ�ϴεķ���ʱ�䣨��cookie�л�ȡ��
			String lasttime = cookie.getValue();
			// ���ϴε�ʱ�������ҳ����ȥ
			response.getWriter().print("<h3>�ף����ϴεķ���ʱ����"+lasttime+"���´ο����Ŷ����</h3>");
			// ��¼��ǰ��ʱ��
			cookie.setValue(sDate);
			
			// ������Чʱ��
			cookie.setMaxAge(60*60);	// 1Сʱ
			cookie.setPath("/day11"); // ��Ч·���ͱ����/day11
			
			// ��д
			response.addCookie(cookie);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
