<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>
<table class="center">
<tr><td>
<ul>
  <li><a  href="adminhome.html">Home</a></li>
  <li><a href="showmembers.jsp">Members</a></li>
  <li><a href="delete.html">Delete Member</a></li>
  <li><a href="index.html">Logout</a></li>
</ul>
</td></tr>
</table>
<%@page import="java.sql.*,database.*" %>
<table border="2" class="center">
<tr><th>Customer ID</th><th>Name</th><th>Address</th><th>Phone</th><th>Email</th></tr>
<%
try{
	Connection cn=UserConnect.getCn();
	PreparedStatement ps=cn.prepareStatement("Select * from member");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>

</body>
</html>