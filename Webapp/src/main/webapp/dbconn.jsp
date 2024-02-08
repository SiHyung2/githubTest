<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.sql.*"%>
<%
	Connection conn = null;
	try {
		String url = "jdbc:oracle:thin:@localhost:1522:xe";
		String user = "c##webmarket";
		String password="c##webmarket";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection (url, user, password);
	} catch (SQLException ex) {
		out.println(".<br>");
		out.println("SQLException:"+ ex.getMessage());
	}
%>


<!--  Connection conn = null; -->
<!--         String url = "jdbc:oracle:thin:@localhost:1521:xe"; -->
<!--         String id = "hr"; -->
<!--         String pw = "java1234"; -->
 
<!--         try { -->
<!--             Class.forName("oracle.jdbc.driver.OracleDriver"); -->
 
<!--             conn = DriverManager.getConnection(url, id, pw); -->
 