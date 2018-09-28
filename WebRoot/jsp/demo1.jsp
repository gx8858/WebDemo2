<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>想编写一个java的代码</h3>

<%-- 
	1.<%! java代码  %>	（不常用）作为类的成员变量。
	2.<%= java代码  %>	 输出的语句（结尾后不能写分号）
	3.<%  java代码  %>	 编写变量和语句（局部的变量和语句出现）
--%>	

<%!  
	int a = 10;
%>

<%= "HELLO" %>
<%= a %>

<% 
	int b = 100;	// 局部变量
	if(b == 50){
		
	}else{
		
	}
%>

	
</body>
</html>






