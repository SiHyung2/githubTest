<%@page contentType="text/html; charset=utf-8"%>
<nav class="navbar navbar-expand  navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="./welcome.jsp">Home</a>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item" ><a class="nav-link" href="./products.jsp">상품목록</a></li>
				<li class="nav-item" ><a class="nav-link" href="./addProduct.jsp">상품등록</a></li>
				<li class="nav-item"><a class="nav-link" href="./editProduct.jsp?
				edit=<%=java.net.URLEncoder.encode("update", "UTF-8")%>">상품 수정</a></li>
				<li class="nav-item"><a class="nav-link" href="./editProduct.jsp?
				edit=<%=java.net.URLEncoder.encode("delete", "UTF-8")%>">상품 삭제</a></li>
				
<!-- 				edit 매개변수는 꼭 인코딩해야 제대로 전달되는 것을 확인 하였음 -->
<!-- 				디렉티브 태그 다 안 적어서 그런가..? -->
<!-- 				<li class="nav-item"><a class="nav-link" href="./editProduct.jsp? -->
<!-- 				edit=delete">상품 삭제</a></li>  -->
			</ul>
		</div>
	</div>
</nav>