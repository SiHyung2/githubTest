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
		INSERT INTO member(id, name, passwd) VALUES (?,?, ?)
		<sql:param value="<%=id %>"/>
		<sql:param value="<%=name %>"/>
		<sql:param value="<%=passwd %>"/>
	</sql:update>
	<c:import var="url" url="sql01.jsp"/>
		${url}
</body>
</html>