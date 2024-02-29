//package mvc.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import mvc.model.BoardDAO;
//import mvc.model.BoardDTO;
//import mvc.model.Freedom_BoardDAO;
//import mvc.model.Information_BoardDAO;
//import mvc.model.Popular_BoardDAO;
//
////@WebServlet("/")
//public class BoardController_backup extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	static final int LISTCOUNT = 5;
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String RequestURI = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String command = RequestURI.substring(contextPath.length());
//
//		response.setContentType("text/html; charset=utf-8");
//		request.setCharacterEncoding("utf-8");
//
//		if (command.equals("/BoardListAction.do")) {// 등록된 글 목록 페이지 출력하기
//			requestBoardList(request);
//			RequestDispatcher rd = request.getRequestDispatcher("./board/list.jsp");
//			rd.forward(request, response);
//		} else if (command.equals("/BoardWriteForm.do")) { // 글 등록 페이지 출력하기
//			requestLoginName(request);
//			RequestDispatcher rd = request.getRequestDispatcher("./board/writeForm.jsp");
//			rd.forward(request, response);
//		} else if (command.equals("/BoardWriteAction.do")) {// 새로운 글 등록하기
//			requestBoardWrite(request);
//			RequestDispatcher rd = request.getRequestDispatcher("/BoardListAction.do");
//			rd.forward(request, response);
//		} else if (command.equals("/BoardViewAction.do")) {// 선택된 글 상세 페이지 가져오기
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
//		} else if (command.equals("/BoardDeleteAction_homepage.do")) { // 홈페이지
//			requestBoardList(request);
//			RequestDispatcher rd = request.getRequestDispatcher("./homepage.jsp");
//			rd.forward(request, response);
//		}
//
////		만들기 빡세네,,,
////		else if (command.equals("/BoardListAction_insert.do")) {// 페이지에 삽입하는 등록된 글 목록 페이지 출력하기
////			requestBoardList(request);
////			RequestDispatcher rd = request.getRequestDispatcher("./board/list.jsp");
////			rd.forward(request, response);
////		}		
//	}
//
//	// 등록된 글 목록 가져오기
//	public void requestBoardList(HttpServletRequest request) {
//
////		Popular_BoardDAO dao = Popular_BoardDAO.getInstance();
////		게시판 타입에 따라 다른 dao를 선택하는 메소드로
//		BoardDAO dao = null;
//		dao = selectBoard(request);
//
//		List<BoardDTO> boardlist = new ArrayList<BoardDTO>();
//
//		int pageNum = 1;
//		int limit = LISTCOUNT;
//
//		if (request.getParameter("pageNum") != null)
//			pageNum = Integer.parseInt(request.getParameter("pageNum"));
//
//		String items = request.getParameter("items");
//		String text = request.getParameter("text");
//
//		int total_record = dao.getListCount(items, text);
//		boardlist = dao.getBoardList(pageNum, limit, items, text);
//
//		int total_page;
//
//		if (total_record % limit == 0) {
//			total_page = total_record / limit;
//			Math.floor(total_page);
//		} else {
//			total_page = total_record / limit;
//			Math.floor(total_page);
//			total_page = total_page + 1;
//		}
//
//		request.setAttribute("pageNum", pageNum);
//		request.setAttribute("total_page", total_page);
//		request.setAttribute("total_record", total_record);
//		request.setAttribute("boardlist", boardlist);
//	}
//
//	// 인증된 사용자명 가져오기
//	public void requestLoginName(HttpServletRequest request) {
//
//		String id = request.getParameter("id");
//
//		BoardDAO dao = null;
//		dao = selectBoard(request);
//
//		String name = dao.getLoginNameById(id);
//
//		request.setAttribute("name", name);
//	}
//
//	// 새로운 글 등록하기
//	public void requestBoardWrite(HttpServletRequest request) {
//
//		BoardDAO dao = null;
//		dao = selectBoard(request);
//
//		BoardDTO board = new BoardDTO();
//		board.setId(request.getParameter("id"));
//		board.setName(request.getParameter("name"));
//		board.setSubject(request.getParameter("subject"));
//		board.setContent(request.getParameter("content"));
//
//		System.out.println(request.getParameter("name"));
//		System.out.println(request.getParameter("subject"));
//		System.out.println(request.getParameter("content"));
//		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
//		String regist_day = formatter.format(new java.util.Date());
//
//		board.setHit(0);
//		board.setRegist_day(regist_day);
//		board.setIp(request.getRemoteAddr());
//
//		dao.insertBoard(board);
//	}
//
//	// 선택된 글 상세 페이지 가져오기
//	public void requestBoardView(HttpServletRequest request) {
//
//		BoardDAO dao = null;
//		dao = selectBoard(request);
//		int num = Integer.parseInt(request.getParameter("num"));
//		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
//
//		BoardDTO board = new BoardDTO();
//		board = dao.getBoardByNum(num, pageNum);
//
//		request.setAttribute("num", num);
//		request.setAttribute("page", pageNum);
//		request.setAttribute("board", board);
//	}
//
//	// 선택된 글 내용 수정하기
//	public void requestBoardUpdate(HttpServletRequest request) {
//
//		int num = Integer.parseInt(request.getParameter("num"));
//		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
//
//		BoardDAO dao = null;
//		dao = selectBoard(request);
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
//
//		int num = Integer.parseInt(request.getParameter("num"));
//		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
//
//		BoardDAO dao = null;
//		dao = selectBoard(request);
//
//		dao.deleteBoard(num);
//	}
//
//	// 게시판에 따라 dao 타입 결정
//	public BoardDAO selectBoard(HttpServletRequest request) {
//		BoardDAO dao = null;
////		Popular_BoardDAO dao = Popular_BoardDAO.getInstance();
//
////		String board_type = request.getParameter("board_type");
////		if (board_type.equals("popular")) {
////			dao = Popular_BoardDAO.getInstance();
////		} else if (board_type.equals("freedom")) {
////			dao = Freedom_BoardDAO.getInstance();
////		} else if (board_type.equals("information")) {
////			dao = Information_BoardDAO.getInstance();
////		}
////		return dao;
//
//		//try-catch문을 이용해서 게시판 타입 세션값을 가져오는데 없으면 매개변수로 가져온 게시판 타입 변수를 게시판 타입 세션값에 넣는다.
//		try {
//			HttpSession session = request.getSession(true);
//			String board_type_session = (String)session.getAttribute("board_type_session");
//			
//			
//			
//			if (board_type_session.equals("popular")) {
//				dao = Popular_BoardDAO.getInstance();
//				return dao;
//		    } else if (board_type_session.equals("freedom")) {
//		    	dao = Freedom_BoardDAO.getInstance();
//		    	return dao;
//		    } else if (board_type_session.equals("information")) {
//		    	dao = Information_BoardDAO.getInstance();
//		    	return dao;
//		    }
//		}catch(NullPointerException e){
//			// 세션에 board_type_session이 없는 경우
//			HttpSession session = request.getSession(true);
//			String board_type = request.getParameter("board_type");
//			session.setAttribute("board_type_session", board_type);
//			 if (board_type.equals("popular")) {
//		            dao = Popular_BoardDAO.getInstance();
//		        } else if (board_type.equals("freedom")) {
//		            dao = Freedom_BoardDAO.getInstance();
//		        } else if (board_type.equals("information")) {
//		            dao = Information_BoardDAO.getInstance();
//		        }
//			 return dao;
//		}
//		return dao;
//
//		// 조건문에 안 걸리면 null dao 반환
//
//	}
//
//}
