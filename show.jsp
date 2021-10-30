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
<%@page import="java.sql.*,database.*" %>
<table class="center">
<tr><td>
<ul>
  <li><a  href="add.html">AddContact</a></li>
  <li><a href="show.jsp">Show My Contact</a></li>
  <li><a href="index.html">Logout</a></li>
 </ul>
</td></tr>
</table>
<table border="2" class="center">
<tr><th colspan="5">My Contact</th></tr>
<tr ><th>Name</th><th>Address</th><th>Phone Number</th><th>Email</th></tr>

<%
try{
	Connection cn=UserConnect.getCn();
	HttpSession ses=request.getSession(false);
	String cid=(String)ses.getAttribute("uid");
	PreparedStatement ps=cn.prepareStatement("select * from contact where cid=?");
	ps.setString(1, cid);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>

</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>


</body>
</html>