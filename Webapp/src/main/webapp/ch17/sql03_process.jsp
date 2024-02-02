<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		String name=request.getParameter("name");
	%>
	<sql:setDataSource var="dataSource"
		url="jdbc:oracle:thin:@localhost:1522:xe"
		driver="oracle.jdbc.driver.OracleDriver" user = "c##madang"  password="c##madang"/>
	
	<sql:update dataSource="${dataSource}" var="resultSet">
		UPDATE member SET name=? where id=? and passwd=?
		<sql:param value="<%=name %>"/>
		<sql:param value="<%=id %>"/>
		<sql:param value="<%=passwd %>"/>
	</sql:update>
	
</body>
</html>