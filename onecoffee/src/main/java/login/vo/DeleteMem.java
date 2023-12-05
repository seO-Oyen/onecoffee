package login.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBCon;

public class DeleteMem {
	public int deleteMember(int mno) {
		int delCnt = 0;
		String sql = "DELETE FROM MEMBER01 WHERE mno = ?";
		try (Connection con = DBCon.con();
	            PreparedStatement pstmt = con.prepareStatement(sql);)
			{
	            con.setAutoCommit(false);
	         // 내가 처리할 처리코드 1
	            pstmt.setInt(1,mno);
	            delCnt = pstmt.executeUpdate();
	            
	            if(delCnt==0) {
	            	System.out.println("삭제 실패");
	            	con.rollback();
	            }else {
	            	con.commit();
	            	System.out.println("삭제 성공");
	            }
	           
	         } catch (SQLException e) {
	            System.out.println("DB에러 : " + e.getMessage());
	            //con.rollback;
	         } catch (Exception e) {
	            System.out.println("일반에러 : " + e.getMessage());
	         }
		return delCnt;
	}
}
