package cn.itcast.session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ���ﳵ�ĺ�̨
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = -4944571720622706932L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 0.Map<String,Integer> cart ���������Ʒ�����ƺ�������
		 * 1.���ղ��������յ�idֵ����idֵת������Ӧ����Ʒ��
		 * 2.�ж��Ƿ��ǵ�һ�ι��򣨴�session�л�ȡ�����������null���϶��ǵ�һ�ι���
		 * 		* �����һ�ι��򣬴���һ�����ﳵ���Ѹ���Ʒ���������뵽���У��ٰѳ����뵽session�С�
		 * 		* ������ǵ�һ�ι���
		 * 			* ���жϳ����Ƿ��������Ʒ����Ϊ�����������Ʒ�ˣ�����+1
		 * 			* �������������Ʒ��ֱ�ӰѸ���Ʒ���복�С�
		 * 3.ת�������ض��򵽼���������߽���ҳ��
		 * 4.ȥ�����ҳ�棨����Ʒ�����ƺ�������ʾ��ҳ���ϣ�
		 */
		// �Ȼ�ȡ����Ĳ���
		String id = request.getParameter("id");
		// ��idת������Ӧ����Ʒ����
		String [] names = new String []{"�ֵ�Ͳ","����","����","ϴ�»�","�绰","����"};
		// ת����int����
		int index = Integer.parseInt(id);
		// ��ǰ����Ʒ����
		String productName = names[index - 1];
		// �Ȼ�ȡsession
		HttpSession session = request.getSession();
		// ��session����ȡ��
		Map<String, Integer> cart = (Map<String, Integer>)session.getAttribute("cart");
		// ���cart��null
		if(cart == null){
			// ��һ��
			// �ѹ������Ʒ���뵽����
			cart = new HashMap<String, Integer>();
			// ����Ʒ���복��
			cart.put(productName, 1);
			// �ѳ�����session��
			session.setAttribute("cart", cart);
		}else{
			// �Ȼ�ȡ���е����ݣ��͵�ǰ�������Ʒ�����ж�
			if(cart.containsKey(productName)){
				// �Ȼ�ȡ��Ʒ������
				Integer count = cart.get(productName);
				// ����+1  
				count++;
				// �ڰ���Ʒ���복��
				cart.put(productName, count);
				// ���뵽session��
				session.setAttribute("cart", cart);
			}else{
				// ֱ�Ӵ��뵽����
				cart.put(productName, 1);
				// ���뵽session��
				session.setAttribute("cart", cart);
			}
		}
		
		// �ض��򵽼����������ȥ�����ҳ��
		response.sendRedirect(request.getContextPath()+"/session/gopay.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
