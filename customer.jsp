<%@ page import="com.DbConnection" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table
{
//border-collapse:collapse;
width:100%;
}
tr,td
{
padding:8px;
text-align:left;
border-bottom: 1px solid #ddd;
border: 2px solid balck;
}
th
{
background-color: #f2f2f2;
}

</style>
</head>
<body>
<% Connection con=DbConnection.connect();
//int acc=Integer.parseInt(request.getParameter("Mobile_NO"));
PreparedStatement st;
st=con.prepareStatement("select * from  customer");
//st.setInt(1,acc);
ResultSet rs=st.executeQuery();


%>
<table border="3">
<thead>
  <tr>
    <td>cid</td>
    <td>Name</td>
    <td>Email</td>	
	<td>password</td>
    <td>Phone number</td>   
    <td>Address</td>
    <td>Message</td>
    <td>image</td>
    <td>status</td>
    <td>Delete</td>
    <td>Approve</td>
    <td>DisApprove</td>
  </tr>
  </thead>
  <% while(rs.next()){ %>
  <tr>
    <td><%=rs.getInt(1)%></td>
    <td><%=rs.getString(2)%></td>
    <td><%=rs.getString(3)%></td>
    <td><%=rs.getString(4)%></td>
	<td><%=rs.getString(5)%></td>
	<td><%=rs.getString(6)%></td>
	<td><%=rs.getString(7)%></td>
	<td><%=rs.getString(8)%></td>
    <%
    	byte[] imageData = rs.getBytes("Rcp");
    	String img = Base64.getEncoder().encodeToString(imageData);
    %>
    <td>
    	<a href="data:image/jpeg;base64,<%=img%>" download>
	    	<img alt="Recepit" src="data:image/jpeg;base64,<%=img%>" style="height: 50px;width: 50px;" />
    	</a>
    </td>
    <td><%=rs.getString(9)%></td>
   	 
   	<td><a href="delete.jsp?Id=<%=rs.getInt(1)%>">delete</a></td> 
   	<td><a href="approve.jsp?Id=<%=rs.getInt(1)%>">Approve</a></td> 
   	<td><a href="Disapprove.jsp?Id=<%=rs.getInt(1)%>">DisApprove</a></td> 
   	
  </tr>
  <% }%>
</table>
<div>
  <a href="operation.html" class="btn rounded-pill py-2 px-4 ms-3 d-none d-lg-block">Back</a>
              
                </div>
</body>
</html>