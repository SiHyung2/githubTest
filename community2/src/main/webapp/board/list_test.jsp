<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="mvc.model.BoardDTO"%>
<%
	String sessionId = (String) session.getAttribute("sessionId");
	List boardList = (List) request.getAttribute("boardlist");
	int total_record = ((Integer) request.getAttribute("total_record")).intValue();
	int pageNum = ((Integer) request.getAttribute("pageNum")).intValue();
	int total_page = ((Integer) request.getAttribute("total_page")).intValue();
%>
<html>
<head>
<script type="text/javascript">
	function checkForm() {	
		if (${sessionId==null}) {
			alert("로그인 해주세요.");
			return false;
		}

		location.href = "./Freedom_BoardWriteForm.do?id=<%=sessionId%>"
	}
</script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- 구글 폰트 link -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css'
	rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css2?family=Anta&display=swap"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gugi&display=swap"
	rel="stylesheet">
<title>MINECRAFT COMMUNITY</title>
<!-- css 모음 -->
<link rel="stylesheet"
	href="../resources/css/homepage/homepage_layout.css">
<link rel="stylesheet" href="../resources/css/homepage/main.css">
<link rel="stylesheet" href="../resources/css/homepage/login.css">
<link rel="stylesheet" href="../resources/css/homepage/carousel.css">
<link rel="stylesheet" href="../resources/css/homepage/search.css">
<link rel="stylesheet" href="../resources/css/homepage/link.css">
<link rel="stylesheet" href="../resources/css/homepage/popular.css">
<link rel="stylesheet" href="../resources/css/homepage/freedom.css">
<link rel="stylesheet" href="../resources/css/homepage/notification.css">
<link rel="stylesheet" href="../resources/css/homepage/information.css">
<link rel="stylesheet" href="../resources/css/homepage/game.css">
<!-- 캐러셀 js모음(나머지 한개는 밑에) -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

</head>
<body>

	<!-- 중간 태그 section,  양옆 태그 aside -->
	<div class="wrapper">
		<jsp:include page="../main.jsp" />
		<aside id="login">


			<%
			String msg = request.getParameter("msg");
			
			String loginId = (String) session.getAttribute("sessionId");
			if (loginId != null) {
				out.println(" <h2>" + loginId + "님 </h2>");
			%>
			<a class="nav-link" href="<c:url value="./logoutMember.jsp"/>">로그아웃 </a>
			<%	
			}
			else {
			%>
			
			
			<div>
				<div>마인 커뮤 로그인</div>
				<div>
					<%
					String error = request.getParameter("error");
					if (error != null) {
						out.println("<script>alert('아이디와 비밀번호를 확인해 주세요');</script>");
					}
					%>
					<!-- 					form문을 쓰면 2줄이 되기때문에 인라인 시트로 수정해준다 -->
					<form action="./processLoginMember.jsp" method="post"
						style="display: flex; padding-bottom: -50px">

						<div id="login_input" style="width: 70px; margin-right: 95px;">
							<div>
								<input type="text" placeholder="ID" name='id' required autofocus>
							</div>
							<div>
								<input type="password" placeholder="Password" name='password'
									required>
							</div>
						</div>
						<button id="login_btn" type="submit" style="width: 60px;">login</button>
					</form>
				</div>
				<div>
					<div>
						<a href="./addMember.jsp">회원가입</a>
					</div>
					<div>
						<a href="find.jsp"> 아이디 비밀번호 찾기</a>
					</div>
				</div>

			</div>
			
			
			<% } %>
		</aside>
		<section id="carousel">
			<!-- Swiper 캐러셀-->
			<div class="swiper mySwiper">
				<div class="swiper-wrapper">
					<!-- 게시판 사진만 각 슬라이드에 넣고 사진을 누르면 해당 게시판으로 이동하도록 만들기 -->
					<div class="swiper-slide">
						<!-- 해당 ID의 게시물로 이동 -->
						<img style="cursor: pointer;"
							src="../resources/image/img_post1.jpg" alt="이미지 없음"
							onclick="location.href='post.html'">
					</div>
					<div class="swiper-slide">
						<img style="cursor: pointer;" src="../resources/image/pizza.jpg"
							alt="이미지 없음" onclick="location.href='post.html'">
					</div>
					<div class="swiper-slide">
						<img style="cursor: pointer;" src="../resources/image/images.jpg"
							alt="이미지 없음" onclick="location.href='post.html'">
					</div>
					<div class="swiper-slide">
						<img style="cursor: pointer;"
							src="../resources/image/img_post2.jpg" alt="이미지 없음"
							onclick="location.href='post.html'">
					</div>
					<div class="swiper-slide">
						<!-- 해당 ID의 게시물로 이동 -->
						<img style="cursor: pointer;" src="../resources/image/images.jpg"
							alt="이미지 없음" onclick="location.href='post.html'">
					</div>
					<div class="swiper-slide">
						<img style="cursor: pointer;" src="../resources/image/pizza.jpg"
							alt="이미지 없음" onclick="location.href='post.html'">
					</div>
					<div class="swiper-slide">Slide 7</div>
					<div class="swiper-slide">Slide 8</div>
					<div class="swiper-slide">Slide 9</div>
				</div>
				<div class="swiper-pagination"></div>
			</div>

			<!-- 이위치에 있는 js가 캐러셀을 조정 -->
			<script>
				var swiper = new Swiper(".mySwiper", {
					slidesPerView : 4,
					grid : {
						rows : 1,
					},
					spaceBetween : 30,
					pagination : {
						el : ".swiper-pagination",
						clickable : true,
					},
				});
			</script>
		</section>
		<aside id="search">
			<div class="input-group">
				<img style="cursor: pointer;" src="../resources/image/search.png"
					onclick="location.href='serach.html'"></img> <input type="search"
					class="form-control rounded" placeholder="검색하기" aria-label="Search"
					aria-describedby="search-addon" />

			</div>
		</aside>
		<aside id="link">
			<div>
				<header> QUICK LINK </header>

				<div>
					<span id="square">&nbsp;</span> <span id="server"> <!-- 일단 아무 디코 서버를 적었다 -->
						<a href="https://discord.com/invite/uzhqXw5NyK">서버1 ></a>
					</span>
				</div>
				<div>
					<span id="square">&nbsp;</span> <span id="server"> <a
						href="https://discord.com/invite/uzhqXw5NyK">서버2 ></a>
					</span>
				</div>
				<div>
					<span id="square">&nbsp;</span> <span id="server"> <a
						href="https://discord.com/invite/uzhqXw5NyK">서버3 ></a>
					</span>
				</div>
				<div>
					<span id="square">&nbsp;</span> <span id="server"> <a
						href="https://discord.com/invite/uzhqXw5NyK">서버4 ></a>
					</span>
				</div>


			</div>
		</aside>
		<section id="popular">
			<header>
				<!-- href="Noticeboard?menu=popular" 으로 적을 예정인데
              의미는 게시판의 메뉴에 인기 게시판을 누른상태로 게시판으로
              이동하기 위함이다 -->
				<div>
					<a  href="<c:url value="../Popular_BoardListAction.do?pageNum=1"/>">인기 게시판</a>
				</div>
				<div>
					<a  href="<c:url value="../Freedom_BoardListAction.do?pageNum=1"/>">자유 게시판</a>
				</div>
				<div>
					<a href="<c:url value="../Information_BoardListAction.do?pageNum=1"/>">정보 게시판</a>
				</div>
			</header>
			<section>
				<aside>
					<div class="image_post">
						<!-- 해당 게시판으로 들어가도록 수정필요 -->
						<img style="cursor: pointer;"
							src="../resources/image/img_post1.jpg"
							onclick="location.href='Noticeboard.html'" alt="사진 없음">
						<div>
							<a href="Noticeboard.html">요즘 걸그룹과 옛날 걸그룹의 차이점.jpg </a>
						</div>
					</div>
				</aside>
				<div class="post_list">
				

	
								<%
									for (int j = 0; j < boardList.size(); j++) {
										BoardDTO notice = (BoardDTO) boardList.get(j);
								%>
								<tr>
									<td><%=notice.getNum()%></td>
									<td><a href="../Freedom_BoardViewAction.do?num=<%=notice.getNum()%>&pageNum=<%=pageNum%>"><%=notice.getSubject()%></a></td>
									<td><%=notice.getRegist_day()%></td>
									<td><%=notice.getHit()%></td>
									<td><%=notice.getName()%></td>
								</tr>
								<%
									}
								%>



				</div>
			</section>
		</section>
		<aside id="notification">
			<header>
				<!-- ?를 통하여 게시판 화면의 메뉴에서 공지사항을 한채로 게시판 화면으로
                 넘겨주는 것을 추가해야함 -->
				<div>
					<a href="notification.jsp">공지사항</a>
				</div>
			</header>
			<section>
				<div>공지1공지1공지1공지1공지1</div>
				<div>공지2공지2공지2공지2공지2</div>
				<div>공지3공지3공지3공지3공지3공지3</div>
				<div>공지4공지4공지4</div>
				<div>공지5공지5공지5공지5공지5공지5공지5공지5공지5공지5공지5</div>
				<div>공지1공지1공지1공지1공지1</div>
				<div>공지2공지2공지2공지2공지2</div>
			</section>
		</aside>
		<aside id="infomation">
			<div>
				<div id="circle"></div>
				<a id="info_btn" href="#">네더 차원 정보 </a>
			</div>
			<div>
				<div id="circle"></div>
				<a id="info_btn" href="#">엔더 차원 정보 </a>
			</div>
			<div>
				<div id="circle"></div>
				<a id="info_btn" href="#">오버 월드 tip </a>
			</div>

		</aside>
		<section id="freedom">
			<header>
				<div>
					<a href="#">자유 게시판</a>
				</div>
			</header>
			<section class="d-flex">
				<div class="post_list">
					<div>슬립백이라는 고길동</div>
					<div>일본 한구에 전쟁 선포시 시뮬레이션</div>
					<div>마크 유저 연령대 분포.png</div>
					<div>마크에서 피아노를 구현해보았다</div>
					<div>러시아 한국에 선전포고해...</div>
					<div>한화 97년만에 첫 우승</div>
				</div>
				<div class="post_list">
					<div>1분 스피드런</div>
					<div>자바 웹 개발 워크북 성장하는 개발자를 만든느 실무형 로드랩 서블랫에서 스프링 부트까지</div>
					<div>한국에서 배우는 k-유교문화 예의범절에서 제사상 차리는 법까지</div>
					<div>마크에서 담배를 구현해보았다</div>
					<div>러시아 한국에 선전포고해...</div>
					<div>한화 97년만에 첫 우승할뻔했</div>
				</div>
			</section>
		</section>
		<aside id="game">
			<header>
				<div>
					<a href="Noticeboard.html">게임 게시판</a>
				</div>
			</header>
			<section>
				<div class="post_list">
					<div>마크에서 컴퓨터를 구현해보았다</div>
					<div>바이옴별 각 몬스터 및 광물 확률분포</div>
					<div>플러그인 개발을 위한 이클립스 연동법</div>
					<div>유용한 모드 모음집</div>
					<div>게임에 존재하는 유일한 이스터애그</div>
					<div>마크에서 피아노를 구현해보았다</div>
					<div>바이옴별 각 몬스터 및 광물 확률분포</div>
				</div>
			</section>
		</aside>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<p class="w-100 text-center">©️ 시형 주식회사</p>
</body>
</html>
















<!-- <body> -->
<!-- 	<div class="jumbotron"> -->
<!-- 		<div class="container"> -->
<!-- 			<h1 class="display-3">게시판</h1> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<div class="container"> -->
<%-- 		<form action="<c:url value="../Freedom_BoardListAction.do"/>" method="post"> --%>
<!-- 			<div> -->
<!-- 				<div class="text-right"> -->
<%-- 					<span class="badge badge-success">전체 <%=total_record%>건	</span> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div style="padding-top: 50px"> -->
<!-- 				<table class="table table-hover"> -->
<!-- 					<tr> -->
<!-- 						<th>번호</th> -->
<!-- 						<th>제목</th> -->
<!-- 						<th>작성일</th> -->
<!-- 						<th>조회</th> -->
<!-- 						<th>글쓴이</th> -->
<!-- 					</tr> -->
<%-- 					<% --%>
// 						for (int j = 0; j < boardList.size(); j++) {
// 							BoardDTO notice = (BoardDTO) boardList.get(j);
<%-- 					%> --%>
<!-- 					<tr> -->
<%-- 						<td><%=notice.getNum()%></td> --%>
<%-- 						<td><a href="./Freedom_BoardViewAction.do?num=<%=notice.getNum()%>&pageNum=<%=pageNum%>"><%=notice.getSubject()%></a></td> --%>
<%-- 						<td><%=notice.getRegist_day()%></td> --%>
<%-- 						<td><%=notice.getHit()%></td> --%>
<%-- 						<td><%=notice.getName()%></td> --%>
<!-- 					</tr> -->
<%-- 					<% --%>
// 						}
<%-- 					%> --%>
<!-- 				</table> -->
<!-- 			</div> -->
<!-- 			<div align="center"> -->
<%-- 				<c:set var="pageNum" value="<%=pageNum%>" /> --%>
<%-- 				<c:forEach var="i" begin="1" end="<%=total_page%>"> --%>
<%-- 					<a href="<c:url value="./Freedom_BoardListAction.do?pageNum=${i}" /> "> --%>
<%-- 						<c:choose> --%>
<%-- 							<c:when test="${pageNum==i}"> --%>
<%-- 								<font color='4C5317'><b> [${i}]</b></font> --%>
<%-- 							</c:when> --%>
<%-- 							<c:otherwise> --%>
<%-- 								<font color='4C5317'> [${i}]</font> --%>

<%-- 							</c:otherwise> --%>
<%-- 						</c:choose> --%>
<!-- 					</a> -->
<%-- 				</c:forEach> --%>
<!-- 			</div> -->
<!-- 			<div align="left"> -->
<!-- 				<table> -->
<!-- 					<tr> -->
<!-- 						<td width="100%" align="left">&nbsp;&nbsp;  -->
<!-- 						<select name="items" class="txt"> -->
<!-- 								<option value="subject">제목에서</option> -->
<!-- 								<option value="content">본문에서</option> -->
<!-- 								<option value="name">글쓴이에서</option> -->
<!-- 						</select> <input name="text" type="text" /> <input type="submit" id="btnAdd" class="btn btn-primary " value="검색 " /> -->
<!-- 						</td> -->
<!-- 						<td width="100%" align="right"> -->
<!-- 							<a href="#" onclick="checkForm(); return false;" class="btn btn-primary">&laquo;글쓰기</a> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</table> -->
<!-- 			</div> -->
<!-- 		</form> -->
<!-- 		<hr> -->
<!-- 	</div> -->
<!-- </body> -->
<!-- </html> -->





