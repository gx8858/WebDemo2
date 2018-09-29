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
 * 购物车的后台
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = -4944571720622706932L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 0.Map<String,Integer> cart 车里面放商品的名称和数量。
		 * 1.接收参数，接收的id值。把id值转换成相应的商品。
		 * 2.判断是否是第一次购买（从session中获取车，如果车是null，肯定是第一次购买）
		 * 		* 如果是一次购买，创建一个购物车，把该商品和数量存入到车中，再把车存入到session中。
		 * 		* 如果不是第一次购买
		 * 			* 先判断车中是否包含该商品，因为如果包含该商品了，数量+1
		 * 			* 如果不包含该商品，直接把该商品存入车中。
		 * 3.转发或者重定向到继续购物或者结算页面
		 * 4.去结算的页面（把商品的名称和数量显示到页面上）
		 */
		// 先获取请求的参数
		String id = request.getParameter("id");
		// 想id转换成响应的商品名称
		String [] names = new String []{"手电筒","电视","冰箱","洗衣机","电话","电脑"};
		// 转换成int类想
		int index = Integer.parseInt(id);
		// 当前的商品名称
		String productName = names[index - 1];
		// 先获取session
		HttpSession session = request.getSession();
		// 从session来获取车
		Map<String, Integer> cart = (Map<String, Integer>)session.getAttribute("cart");
		// 如果cart是null
		if(cart == null){
			// 第一次
			// 把购买的商品存入到车中
			cart = new HashMap<String, Integer>();
			// 把商品放入车中
			cart.put(productName, 1);
			// 把车放入session中
			session.setAttribute("cart", cart);
		}else{
			// 先获取车中的内容，和当前购买的商品进行判断
			if(cart.containsKey(productName)){
				// 先获取商品的数量
				Integer count = cart.get(productName);
				// 数量+1  
				count++;
				// 在把商品存入车中
				cart.put(productName, count);
				// 存入到session中
				session.setAttribute("cart", cart);
			}else{
				// 直接存入到车中
				cart.put(productName, 1);
				// 存入到session中
				session.setAttribute("cart", cart);
			}
		}
		
		// 重定向到继续购物或者去结算的页面
		response.sendRedirect(request.getContextPath()+"/session/gopay.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
