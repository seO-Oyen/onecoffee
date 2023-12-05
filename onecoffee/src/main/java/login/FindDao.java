package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBCon;

public class FindDao {
	public String getID(String name, String phoneNumber) { // 회원 로그인
		String id = "";
		String sql = "SELECT id FROM MEMBER\r\n"
				+ "WHERE name = ? AND PHONENUM = ?";
		
		try(
				Connection con = DBCon.con();
				PreparedStatement pstmt = con.prepareStatement(sql);
			){
			// 처리코드1
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNumber);
			try(
					ResultSet rs = pstmt.executeQuery();
				){
				// 처리코드2
				if(rs.next()) {
					id = rs.getString("id");
				}
			}
			
		}catch(SQLException e) {
			System.out.println("DB 에러 : " + e.getMessage());
		}catch(Exception e) {
			System.out.println("일반 에러 : " + e.getMessage());
		}
		
		
		return id;
	}

	public String getPWD(String id, String pwdAnswer) { // 회원 로그인
		String pwd = "";
		String sql = "SELECT pwd FROM MEMBER\r\n"
				+ "WHERE id = ? AND pwdAnswer = ?";
		
		try(
				Connection con = DBCon.con();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			// 처리코드1
			pstmt.setString(1, id);
			pstmt.setString(2, pwdAnswer);
			try(
					ResultSet rs = pstmt.executeQuery();
					){
				// 처리코드2
				if(rs.next()) {
					pwd = rs.getString("pwd");
				}
			}
			
		}catch(SQLException e) {
			System.out.println("DB 에러 : " + e.getMessage());
		}catch(Exception e) {
			System.out.println("일반 에러 : " + e.getMessage());
		}
		
		
		return pwd;
	}
}
