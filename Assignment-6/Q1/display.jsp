<%@ page import="java.sql.*" %>

<html>
<head>
<title>Student List</title>
</head>
<body>

<h2>Registered Students</h2>

<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Course</th>
</tr>

<%
try{

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/student_db","root","password");

Statement st = con.createStatement();

ResultSet rs = st.executeQuery("select * from student");

while(rs.next()){
%>

<tr>
<td><%= rs.getInt("id") %></td>
<td><%= rs.getString("name") %></td>
<td><%= rs.getString("email") %></td>
<td><%= rs.getString("course") %></td>
</tr>

<%
}
con.close();
}
catch(Exception e){
out.println(e);
}
%>

</table>

</body>
</html>