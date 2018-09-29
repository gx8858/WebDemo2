<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4>商品的信息</h4>

<%
	// 获取车
	Map<String,Integer> cart = (Map<String,Integer>)request.getSession().getAttribute("cart");
	// 购物车不为空
	if(cart != null){
		// 获取车的商品名称和数量
		Set<String> names = cart.keySet();
		// 循环set集合，商品的名称
		for(String name : names){
			
%>
		<h3>亲，您购买了<%= name %>，数量是<%= cart.get(name) %></h3>
<%			
			
		}
	}else{
		
%>
		<h3>亲，您还没有<a href="/test/session/cartlist.jsp">败家</a>，请您快去败家</h3>
<%		
		
	}
	
%>

</body>
</html>