//package login.vo;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import db.DBCon;
//
//
//public class ModifyMemInfo {
//	public int updateMember(Create) {
//		int uptCnt = 0;
//		String sql = "UPDATE MEMBER01\r\n"
//				+ "SET mno = ?, name = ?, id = ?, pwd = ?, auth = ?, point = ?\r\n"
//				+ "WHERE deptno = ?";
//		try (Connection con = DBCon.con();
//	            PreparedStatement pstmt = con.prepareStatement(sql);)
//			{
//	            con.setAutoCommit(false);
//	         // 내가 처리할 처리코드 1
//	            pstmt.setInt(1,upt.getMno());
//	            pstmt.setString(2,upt.getName());
//	            pstmt.setString(3,upt.getId());
//	            pstmt.setString(4,upt.getPwd());
//	            pstmt.setString(5,upt.getAuth());
//	            pstmt.setInt(6,upt.getPoint());
//	            
//	            uptCnt = pstmt.executeUpdate();
//	            if(uptCnt==0) {
//	            	System.out.println("수정 실패");
//	            	con.rollback();
//	            }else {
//	            	con.commit();
//	            	System.out.println("CUD 성공");
//	            }
//	           
//	         } catch (SQLException e) {
//	            System.out.println("DB에러 : " + e.getMessage());
//	            //con.rollback;
//	         } catch (Exception e) {
//	            System.out.println("일반에러 : " + e.getMessage());
//	         }
//		return uptCnt;
//	}
//}
