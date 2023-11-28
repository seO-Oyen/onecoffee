package test;

import java.util.List;

import dao.BoardDAO;
import vo.Board;

public class TestClass {

	public static void main(String[] args) {
		
		BoardDAO boardDao = new BoardDAO();
		
		List<Board> boards = boardDao.getBoards();
		
		for (Board board : boards) {
			System.out.println("=================");
			System.out.println("게시글 번호 : " + board.getNo());
			System.out.println("제목 : " + board.getTitle());
			System.out.println("내용 : " + board.getText());
			System.out.println("등록일 : " + board.getFirstDate());
			System.out.println("처리여부 : " + board.isEnd());
			System.out.println("공지여부 : " + board.isNotice());
			System.out.println("=================");
		}

	}

}
