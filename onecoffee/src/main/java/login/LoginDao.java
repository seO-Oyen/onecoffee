package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBCon;

public class LoginDao {
	public boolean userAccess(String id, String pwd) { // 회원 로그인
		String sql = "SELECT * FROM MEMBER\r\n"
				+ "WHERE id = ? AND pwd = ?";
		
		try(
				Connection con = DBCon.con();
				PreparedStatement pstmt = con.prepareStatement(sql);
			){
			// 처리코드1
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			try(
					ResultSet rs = pstmt.executeQuery();
				){
				// 처리코드2
				return rs.next(); 
			}
			
		}catch(SQLException e) {
			System.out.println("DB 에러 : " + e.getMessage());
		}catch(Exception e) {
			System.out.println("일반 에러 : " + e.getMessage());
		}
		
		
		return false;
	}
	
	public boolean isAdmin(String id, String pwd) { // 관리자 로그인
		return id.equals("admin") && pwd.equals("0000");
	}
	
}
