package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mvc.database.DBConnection;

public abstract class BoardDAO {

//	public static BoardDAO instance;
	
	public BoardDAO() {
		
	}

//	public static abstract BoardDAO getInstance() ;
	
	//board 테이블의 레코드 개수
	public abstract int getListCount(String items, String text) ;
	
	//board 테이블의 레코드 가져오기
	public abstract ArrayList<BoardDTO> getBoardList(int page, int limit, String items, String text) ;
	//member 테이블에서 인증된 id의 사용자명 가져오기
	public abstract String getLoginNameById(String id) ;

	//board 테이블에 새로운 글 삽입히가
	public abstract void insertBoard(BoardDTO board) ;
	//선택된 글의 조회수 증가하기
	public abstract void updateHit(int num) ;
	//선택된 글 상세 내용 가져오기
	public abstract BoardDTO getBoardByNum(int num, int page) ;
	//선택된 글 내용 수정하기
	public abstract void updateBoard(BoardDTO board) ;
	//선택된 글 삭제하기
	public abstract void deleteBoard(int num) ;
}


