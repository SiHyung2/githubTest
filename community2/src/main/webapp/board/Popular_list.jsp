<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="mvc.model.BoardDTO"%>
<%
String sessionId = (String) session.getAttribute("sessionId");
List Popular_boardList = (List) request.getAttribute("Popular_boardlist");
int Popular_total_record = ((Integer) request.getAttribute("Popular_total_record")).intValue();
int Popular_pageNum = ((Integer) request.getAttribute("Popular_pageNum")).intValue();
int Popular_total_page = ((Integer) request.getAttribute("Popular_total_page")).intValue();
%>








<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>Board</title>
<script type="text/javascript">
	function checkForm() {	
		if (${sessionId==null}) {
			alert("로그인 해주세요.");
			return false;
		}

		location.href = "./Popular_BoardWriteForm.do?id=<%=sessionId%>"
	}
</script>

<link rel="stylesheet" href="./resources/css/Board_list.css">
</head>
<body>
	<menu>
		<div class="container">
			<div>
				<h3>MENU</h3>
			</div>
			<ul class="li-con">
				<li style="cursor: pointer;" class="li-item"
					onclick="location.href='#'">menu1</li>
				<li style="cursor: pointer;" class="li-item"
					onclick="location.href='#'">menu2</li>
				<li style="cursor: pointer;" class="li-item"
					onclick="location.href='#'">menu3</li>
				<li style="cursor: pointer;" class="li-item"
					onclick="location.href='#'">menu4</li>
			</ul>
		</div>
	</menu>

	<div class="wrapper">
		<header class="main">
			<header>
				<div>
					<!-- 				컨텍스트에 맞게 주소를 입력해야하므로 myprofile.jsp에 c:url을 사용함 -->
					<a href="homepage_do.do?pageNum=1">MINECRAFT COMMUNITY</a> <img
						type="button" src="resources/image/hamburger_icon.png"
						onclick="location.href='<c:url value="myprofile.jsp"/>'" alt="=">
				</div>
			</header>
		</header>
		<nav class="search">
			<!-- 			<div> -->
			<!-- 				<input type="text" placeholder="검색어 입력"> <img -->
			<!-- 					src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"> -->
			<!-- 			</div> -->
			<table>
				<tr>
					<td align="left">&nbsp;&nbsp; <select name="items" class="txt">
							<option value="subject">제목에서</option>
							<option value="content">본문에서</option>
							<option value="name">글쓴이에서</option>
					</select> <input name="text" type="text" /> <input type="submit"
						id="btnAdd" class="btn btn-primary " value="검색 " />
					</td>
					<td align="right"><a href="#"
						onclick="checkForm(); return false;" class="btn btn-primary">&laquo;글쓰기</a>
					</td>
				</tr>
			</table>
		</nav>
		<section class="border_list">
			<div id="board-list">
				<div class="container">
					<table class="table table-hover">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성일</th>
							<th>조회</th>
							<th>글쓴이</th>
						</tr>
						<%
						for (int j = 0; j < Popular_boardList.size(); j++) {
							BoardDTO notice = (BoardDTO) Popular_boardList.get(j);
						%>
						<tr>
							<td><%=notice.getNum()%></td>
							<td><a
								href="./Popular_BoardViewAction.do?num=<%=notice.getNum()%>&Popular_pageNum=<%=Popular_pageNum%>"><%=notice.getSubject()%></a></td>
							<td><%=notice.getRegist_day()%></td>
							<td><%=notice.getHit()%></td>
							<td><%=notice.getName()%></td>
						</tr>
						<%
						}
						%>
					</table>
				</div>
			</div>



		</section>
		<aside class="real_time">
			<div>
				<header class="real_time_header">
					<div>실시간 인기 게시판</div>
				</header>
				<section class="real_time_section">
					<div>
						1&nbsp;&nbsp;<span><a href="#">슬립백이라는 고길동</a></span>
					</div>
					<div>
						2&nbsp;&nbsp;<span><a href="#">10만원권 초상화 이순신</a></span>
					</div>
					<div>
						3&nbsp;&nbsp;<span><a href="#">이재용 회장 유튜브 하기로</a></span>
					</div>
					<div>
						4&nbsp;&nbsp;<span><a href="#">서버3 버그 패치관련</a></span>
					</div>
					<div>
						5&nbsp;&nbsp;<span><a href="#">서버 운영진은 들어라</a></span>
					</div>
				</section>
			</div>
		</aside>
		<aside class="popular_information">
			<div>
				<header class="popular_information_header">
					<div>인기 게시판</div>
					<div>정보 게시판</div>
				</header>
				<section class="popular_information_section">
					<div>
						<span><a href="#">블루투스 샤워기 개발 성공.jpg</a></span>
					</div>
					<div>
						<span><a href="#">10만원권 초상화 이순신 장군</a></span>
					</div>
					<div>
						<span><a href="#">지구온난화 가속화</a></span>
					</div>
					<div>
						<span><a href="#">친구많은 거지 VS 친구 없는 부자</a></span>
					</div>
					<div>
						<span><a href="#">이재용 회장 유튜브 하기로 결정</a></span>
					</div>
				</section>
			</div>
		</aside>
		<div class="write_and_view_button"></div>
		<footer class="footer_button"></footer>
	</div>


	<!-- 	<table> -->
	<!-- 		<tr> -->
	<!-- 			<td width="100%" align="left">&nbsp;&nbsp; <select name="items" -->
	<!-- 				class="txt"> -->
	<!-- 					<option value="subject">제목에서</option> -->
	<!-- 					<option value="content">본문에서</option> -->
	<!-- 					<option value="name">글쓴이에서</option> -->
	<!-- 			</select> <input name="text" type="text" /> <input type="submit" id="btnAdd" -->
	<!-- 				class="btn btn-primary " value="검색 " /> -->
	<!-- 			</td> -->
	<!-- 			<td width="100%" align="right"><a href="#" -->
	<!-- 				onclick="checkForm(); return false;" class="btn btn-primary">&laquo;글쓰기</a> -->
	<!-- 			</td> -->
	<!-- 		</tr> -->
	<!-- 	</table> -->

</body>
</html>





