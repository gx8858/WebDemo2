<%@page import="cn.itcast.utils.MyCookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品的列表页面</title>

<style type="text/css">
	.img1{
		width: 160px;
		height: 140px;
	}
	.img2{
		width: 80px;
		height: 70px;
	}

</style>

</head>
<body>

	<img class="img1" src="/day11/img/1.jpg"><a href="/day11/product?id=1">手电筒</a>
	<img class="img1" src="/day11/img/2.jpg"><a href="/day11/product?id=2">电话</a>
	<img class="img1" src="/day11/img/3.jpg"><a href="/day11/product?id=3">电视</a>
	<br/>
	<img class="img1" src="/day11/img/4.jpg"><a href="/day11/product?id=4">冰箱</a>
	<img class="img1" src="/day11/img/5.jpg"><a href="/day11/product?id=5">手表</a>
	<img class="img1" src="/day11/img/6.jpg"><a href="/day11/product?id=6">电脑</a>
	
	<h3>商品的浏览器记录</h3>
	<h4><a href="/day11/removeProduct">清除浏览记录</a></h4>
	
<%
	// 获取到cookie的内容 可以把cookie的内容动态的显示到页面上
	Cookie [] cookies = request.getCookies();
	// 通过指定名称来获取cookie
	Cookie cookie = MyCookieUtil.getCookieByName(cookies, "product");
	// 判断cookie不为空
	if(cookie != null){
		// 获取cookie的值
		String longid = cookie.getValue();		// product=1,2,3
		// 切割
		String [] ids = longid.split(",");
		// 循环遍历
		for(String id : ids){
%>
		<img class="img2" src="/day11/img/<%= id %>.jpg">++++"/day11/img/<%= id %>.jpg"
<%			
			
		}
	}
%>	
	
</body>
</html>






