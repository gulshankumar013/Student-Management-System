<%@ page import =  "java.util.ArrayList" %>
<%@ include file = "index.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
<jsp:include page="index.jsp"></jsp:include>
</style>
</head>
<body>

<form action="">
name:<input type="text" name = "name">
name:<input type="password" name = "password">
submit:<input type = "submit" value= "submit">
</form>

<%
String name=request.getParameter("name");
String password = request.getParameter("password");
if(name!=null  && password!= null){
%>
}
<h1>Name:<%=name %></h1>
<h1>Password:<%=password%>  </h1>
<% 
}
%>
  <%-- 
   <h1>jsp</h1>
   <% int a=10; %>
   <h2> <%=a %> </h2>
   <%
   ArrayList ab = new ArrayList();
   ab.add(10);
   ab.add(20);
   ab.add(30);
   %>
   <h2> <%=ab %></h2>
   --%> 
   
</body>
</html>