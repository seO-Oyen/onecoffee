package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBCon;
import login.vo.CreateAccount;

public class CreateMemDao {
// terms 관련 db에 number로 저장? 
		public int CreateAccount(CreateAccount ins) {
		int insCnt = 0; // db 몇 행에 업데이트인지 저장하기위함
		String sql = "INSERT INTO MEMBER VALUES (mem_seq.nextval, ?, ?, ?, ?, ?, ?, 0)";
		try (Connection con = DBCon.con();
	            PreparedStatement pstmt = con.prepareStatement(sql);) {
	            con.setAutoCommit(false);
	         // 내가 처리할 처리코드 1				
	            pstmt.setString(1, ins.getName());
	            pstmt.setString(2, ins.getId());
	            pstmt.setString(3, ins.getPwd());
	            pstmt.setString(4, ins.getPhoneNumber());
	            pstmt.setString(5, ins.getAddress());
	            pstmt.setString(6, ins.getPwdAnswer());
	            
	            insCnt = pstmt.executeUpdate(); // db 업데이트한 행에 따라 그 행 숫자를 반환
	            if(insCnt==0) { // 실패하면 0 반환
	            	System.out.println("등록 실패");
	            	con.rollback();
	            }else {
	            	con.commit();
	            	System.out.println("등록 성공");
	            }
	         } catch (SQLException e) {
	            System.out.println("DB에러 : " + e.getMessage());
	            //con.rollback;
	         } catch (Exception e) {
	            System.out.println("일반에러 : " + e.getMessage());
	         }
		return insCnt;
	}
		public boolean idExist(String id) { // 아이디 중복 확인
			String sql = "SELECT * FROM MEMBER\r\n"
					+ "WHERE id = ?";
			
			try(
					Connection con = DBCon.con();
					PreparedStatement pstmt = con.prepareStatement(sql);
				){
				// 처리코드1
				pstmt.setString(1, id);
				try(
						ResultSet rs = pstmt.executeQuery();
					){
					// 처리코드2
					return rs.next(); // result 값으로 가져올 정보가 있으면 true 반환이고 없으면 false 반환 (id 값 유무에 따라 바뀜)
				}
				
			}catch(SQLException e) {
				System.out.println("DB 에러 : " + e.getMessage());
			}catch(Exception e) {
				System.out.println("일반 에러 : " + e.getMessage());
			}
			return false;
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
//	        CreateMemDao dao = new CreateMemDao();
//
//	        // CreateAccount 메서드의 리턴 타입을 int로 변경했기 때문에 수정
//	        int result = dao.CreateAccount(new CreateAccount("java테스트", "console", "test1", "02", "서울", "서울"));
//
//	        System.out.println("Result: " + result);
	}
}
