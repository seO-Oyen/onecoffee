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
		
		String sql = "select * from board";
		
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			try (ResultSet rs = pstmt.executeQuery();) {
				// 처리코드2
				while (rs.next()) {
					boards.add(new Board(
							rs.getInt("no"),
							rs.getString("title"),
							rs.getString("text"),
							rs.getDate("firstDate"),
							rs.getBoolean("isEnd"),
							rs.getBoolean("isNotice")
					));
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
	public void createBoard() {
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
				+ ");";
		
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 처리코드1
			/*pstmt.setString(1, sch.getKind());
			pstmt.setString(2, sch.getType());
			pstmt.setString(3, "%"+sch.getName()+"%");*/

			try (ResultSet rs = pstmt.executeQuery();) {
				// 처리코드2
				/*while (rs.next()) {
					bevList.add(new Beverage(
							rs.getInt("no"),
							rs.getString("kind"),
							rs.getString("type"),
							rs.getString("name"),
							rs.getInt("price")
							));
				}
				System.out.println("건수:" + bevList.size());*/
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		}
	}
	
}
