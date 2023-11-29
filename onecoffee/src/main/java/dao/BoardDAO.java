package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBCon;
import vo.Board;

public class BoardDAO {

	// 게시판 조회
	public List<Board> getBoards() {
		List<Board> boards = new ArrayList<Board>();

		String sql = "select * from board order by no desc";

		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			try (ResultSet rs = pstmt.executeQuery();) {
				// 처리코드2
				while (rs.next()) {
					boards.add(new Board(rs.getInt("no"), rs.getString("title"), rs.getString("text"),
							rs.getDate("firstDate"), rs.getBoolean("isEnd"), rs.getBoolean("isNotice")));
				}
				System.out.println("건수:" + boards.size());
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		}

		return boards;
	}

	// 게시판 글 생성
	public void createBoard(String title, String text, int userNum) {
		String sql = "INSERT INTO board\r\n" 
				+ "(\r\n" 
				+ "	NO,\r\n" 
				+ "	title,\r\n" 
				+ "	text,\r\n" 
				+ "	writer,\r\n"
				+ "	firstdate\r\n" 
				+ ")\r\n" 
				+ "VALUES\r\n" 
				+ "(\r\n" 
				+ "	board_seq.NEXTVAL,\r\n" 
				+ "	?,\r\n" // 제목
				+ "	?,\r\n" // 본문내용
				+ "	?,\r\n" // 유저 번호
				+ "	sysdate\r\n" // 날짜
				+ ")";

		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			// 내가 처리할 처리코드 1
			pstmt.setString(1, title);
			pstmt.setString(2, text);
			pstmt.setInt(3, userNum);

			int insCnt = pstmt.executeUpdate(); // db 업데이트한 행에 따라 그 행 숫자를 반환
			if (insCnt == 0) { // 실패하면 0 반환
				System.out.println("등록 실패");
				con.rollback();
			} else {
				con.commit();
				System.out.println("등록 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB에러 : " + e.getMessage());
			// con.rollback;
		} catch (Exception e) {
			System.out.println("일반에러 : " + e.getMessage());
		}
	}
	
	// 처리 완료
	public Board updateIsEnd(int boardNum) {
		Board board = new Board();
		
		return board;
	}
	
	// 게시판 수정
	
	// 게시판 삭제

}
