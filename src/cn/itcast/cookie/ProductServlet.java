package cn.itcast.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.utils.MyCookieUtil;

/**
 * 商品浏览记录的后台
 * @author Administrator
 *
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = -5747737695587699577L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 0.获取传过来id值
		 * 1.判断是否是第一次访问？（获取指定名称的cookie如果为null，说明是第一次访问）
		 * 		* 如果是第一次访问，把商品的id保存到cookie中，回写cookie。
		 * 		* 如果不是第一次访问
		 * 			* 先获取cookie中的内容，进行判断（判断cookie中是否包含当前点击的商品）
		 * 				* 如果cookie中已经包含了该商品，那么就不用处理了
		 * 				* 如果不包含，在cookie中追加该商品	product=1	product=1,2
		 * 2.重定向商品的列表页面
		 * 3.需要在商品的列表页面中获取cookie的中内容，把内容显示到页面上。
		 */
		// 先获取商品的id
		String id = request.getParameter("id");
		// 获取cookie的数组
		Cookie [] cookies = request.getCookies();
		// 查找指定名称的cookie
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "product");
		// 如果cookie为null，说明是第一次访问，把商品的id保存到cookie中，回写
		if(cookie == null){
			// 是第一次
			Cookie c = new Cookie("product",id);
			
			// 设置有效时间
			c.setMaxAge(60*60*24);
			
			// 设置有效的路径
			c.setPath("/day11");
			
			// 回写
			response.addCookie(c);
		}else{
			// 说明cookie不为空
			// 先获取cookie的内容（拿出来做判断），cookie有可能包含当前的商品
			String longid = cookie.getValue();		// product=1,2,3		假如说当前点击的是4	product=4,1,2,3
			// 判断字符串ids是否包含当前的id
			// 把ids字符串切割成数组
			String [] ids = longid.split(",");
			if(!checkId(ids,id)){
				// 说明不包含该商品
				cookie.setValue(id+","+longid);
				
				cookie.setMaxAge(60*60*24);
				
				// 设置有效的路径
				cookie.setPath("/day11");
				
				// 回写cookie
				response.addCookie(cookie);
			}
		}
		// 重定向或者转发（使用request域存储内容，必须是转发）request.getContextPath()获取虚拟路径，默认和项目名称相同
		response.sendRedirect(request.getContextPath()+"/cookie/productList.jsp");
	}
	
	/**
	 * 判断ids的数组中是否包含id的值
	 * @param ids
	 * @param id
	 * @return
	 */
	private boolean checkId(String[] ids, String id) {
		for (String s : ids) {
			// 获取s和id匹配
			if(s.equals(id)){
				// 包含
				return true;
			}
		}
		// 不包含
		return false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}





