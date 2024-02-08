<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:set> 기본 사용 방법--%>
<c:set var="username1" value="김연아" />
<c:set var="username2">박지성</c:set>
${username1}<br>
${username2}<br>
${pageScope.username1}<br>
${pageScope.username2}<br>
<p></p>
 
<%--보관소 지정(ServletRequest)--%>
<c:set var="username3" scope="request">마일리 사이러스</c:set>
${pageScope.username3}<br>
${requestScope.username3}<br>
<p></p>
 
<%--기존 값 덮어씀--%>
<% pageContext.setAttribute("username4", "마고 로비"); %>
기존 username4 : ${username4}<br>
<c:set var="username4" value="레오나르도 디카프리오" />
변경 username4 : ${username4}<br>

