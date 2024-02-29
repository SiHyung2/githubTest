//
//package mvc.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import mvc.model.BoardDAO;
//import mvc.model.BoardDTO;
//
////@WebServlet("/")
//public class test1 extends HttpServlet {
//	// HttpServlet을 상속받아 컨트롤러 클래스를 정의합니다.
//	private static final long serialVersionUID = 1L;
//	static final int LISTCOUNT = 5; // 페이지당 글 목록의 개수를 상수로 정의합니다.
//
//	// GET 요청 처리
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response); // POST 요청 처리 메서드 호출
//	}
//
//	// POST 요청 처리
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		// 클라이언트로부터 전송된 요청 URI, contextPath, 그리고 command를 추출합니다.
//		String RequestURI = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String command = RequestURI.substring(contextPath.length());
//
//		// 응답 타입과 요청 인코딩을 설정합니다.
//		response.setContentType("text/html; charset=utf-8");
//		request.setCharacterEncoding("utf-8");
//
//		// 요청된 command에 따라 다른 동작을 수행합니다.
//		if (command.equals("/BoardListAction.do")) { // 등록된 글 목록 페이지 출력하기
//			requestBoardList(request);
//			RequestDispatcher rd = request.getRequestDispatcher("./board/list.jsp");
//			rd.forward(request, response);
//		} else if (command.equals("/BoardWriteForm.do")) { // 글 등록 페이지 출력하기
//			requestLoginName(request);
//			RequestDispatcher rd = request.getRequestDispatcher("./board/writeForm.jsp");
//			rd.forward(request, response);
//		} else if (command.equals("/BoardWriteAction.do")) { // 새로운 글 등록하기
//			requestBoardWrite(request);
//			RequestDispatcher rd = request.getRequestDispatcher("/BoardListAction.do");
//			rd.forward(request, response);
//		} else if (command.equals("/BoardViewAction.do")) { // 선택된 글 상세 페이지 가져오기
//			requestBoardView(request);
//			RequestDispatcher rd = request.getRequestDispatcher("/BoardView.do");
//			rd.forward(request, response);
//		} else if (command.equals("/BoardView.do")) { // 글 상세 페이지 출력하기
//			RequestDispatcher rd = request.getRequestDispatcher("./board/view.jsp");
//			rd.forward(request, response);
//		} else if (command.equals("/BoardUpdateAction.do")) { // 선택된 글의 조회수 증가하기
//			requestBoardUpdate(request);
//			RequestDispatcher rd = request.getRequestDispatcher("/BoardListAction.do");
//			rd.forward(request, response);
//		} else if (command.equals("/BoardDeleteAction.do")) { // 선택된 글 삭제하기
//			requestBoardDelete(request);
//			RequestDispatcher rd = request.getRequestDispatcher("/BoardListAction.do");
//			rd.forward(request, response);
//		}
//	}
//
//	// 등록된 글 목록 가져오기
//	public void requestBoardList(HttpServletRequest request) {
//		BoardDAO dao = BoardDAO.getInstance();
//		List<BoardDTO> boardlist = new ArrayList<BoardDTO>();
//
//		int pageNum = 1; // 현재 페이지 번호 초기화
//		int limit = LISTCOUNT; // 페이지당 보여줄 글의 개수
//
//		// pageNum 파라미터 값이 있으면 pageNum 설정
//		if (request.getParameter("pageNum") != null)
//			pageNum = Integer.parseInt(request.getParameter("pageNum"));
//
//		String items = request.getParameter("items"); // 검색필드
//		String text = request.getParameter("text"); // 검색어
//
//		// 등록된 글의 총 개수 조회
//		int total_record = dao.getListCount(items, text);
//		// 특정 페이지의 글 목록 가져오기
//		boardlist = dao.getBoardList(pageNum, limit, items, text);
//
//		int total_page;
//
//		// 총 페이지 개수 계산
//		if (total_record % limit == 0) {
//			total_page = total_record / limit;
//			Math.floor(total_page);
//		} else {
//			total_page = total_record / limit;
//			Math.floor(total_page);
//			total_page = total_page + 1;
//		}
//
//		// JSP에 전달할 데이터 설정
//		request.setAttribute("pageNum", pageNum);
//		request.setAttribute("total_page", total_page);
//		request.setAttribute("total_record", total_record);
//		request.setAttribute("boardlist", boardlist);
//	}
//
//	// 인증된 사용자명 가져오기
//	public void requestLoginName(HttpServletRequest request) {
//		String id = request.getParameter("id");
//
//		BoardDAO dao = BoardDAO.getInstance();
//
//		// 사용자 ID에 해당하는 이름 조회
//		String name = dao.getLoginNameById(id);
//
//		request.setAttribute("name", name);
//	}
//
//	// 새로운 글 등록하기
//	public void requestBoardWrite(HttpServletRequest request) {
//		BoardDAO dao = BoardDAO.getInstance();
//
//		BoardDTO board = new BoardDTO();
//		board.setId(request.getParameter("id"));
//		board.setName(request.getParameter("name"));
//		board.setSubject(request.getParameter("subject"));
//		board.setContent(request.getParameter("content"));
//
//		// 콘솔에 출력 (테스트용)
//		System.out.println(request.getParameter("name"));
//		System.out.println(request.getParameter("subject"));
//		System.out.println(request.getParameter("content"));
//
//		// 현재 시간을 yyyy/MM/dd(HH:mm:ss) 형식으로 가져오기
//		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
//		String regist_day = formatter.format(new java.util.Date());
//
//		// 글의 조회수, 작성일자, IP 설정
//		board.setHit(0);
//		board.setRegist_day(regist_day);
//		board.setIp(request.getRemoteAddr());
//
//		dao.insertBoard(board);
//	}
//
//	// 선택된 글 상세 페이지 가져오기
//	public void requestBoardView(HttpServletRequest request) {
//		BoardDAO dao = BoardDAO.getInstance();
//		int num = Integer.parseInt(request.getParameter("num"));
//		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
//
//		// 특정 번호의 글 가져오기
//		BoardDTO board = new BoardDTO();
//		board = dao.getBoardByNum(num, pageNum);
//
//		// JSP에 전달할 데이터 설정
//		request.setAttribute("num", num);
//		request.setAttribute("page", pageNum);
//		request.setAttribute("board", board);
//	}
//
//	// 선택된 글 내용 수정하기
//	public void requestBoardUpdate(HttpServletRequest request) {
//		int num = Integer.parseInt(request.getParameter("num"));
//		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
//
//		BoardDAO dao = BoardDAO.getInstance();
//
//		BoardDTO board = new BoardDTO();
//		board.setNum(num);
//		board.setName(request.getParameter("name"));
//		board.setSubject(request.getParameter("subject"));
//		board.setContent(request.getParameter("content"));
//
//		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
//		String regist_day = formatter.format(new java.util.Date());
//
//		board.setHit(0);
//		board.setRegist_day(regist_day);
//		board.setIp(request.getRemoteAddr());
//
//		dao.updateBoard(board);
//	}
//
//	// 선택된 글 삭제하기
//	public void requestBoardDelete(HttpServletRequest request) {
//		int num = Integer.parseInt(request.getParameter("num"));
//		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
//
//		BoardDAO dao = BoardDAO.getInstance();
//		dao.deleteBoard(num);
//	}
//}
