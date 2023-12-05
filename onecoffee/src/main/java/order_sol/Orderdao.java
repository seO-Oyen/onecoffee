package order_sol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBCon;

public class Orderdao {

	/*
	 * SELECT * FROM menu WHERE CASE WHEN category = '커피' THEN category WHEN
	 * drink_Type = lower('') THEN drink_Type WHEN name LIKE '' THEN name ELSE NULL
	 * END IS NOT NULL ORDER BY no;
	 * 
	 * SELECT * FROM menu WHERE CASE WHEN category = ? THEN category WHEN drink_Type
	 * = lower(?) THEN drink_Type WHEN name LIKE ? THEN name ELSE NULL END IS NOT
	 * NULL ORDER BY no;
	 **/

	// 메뉴 선택 메서드
	public List<Menu> getMenuList(Menu sch) {
		List<Menu> menuList = new ArrayList<Menu>();
		String sql = "SELECT * FROM menu \r\n";
		if (!(sch.getCategory().isEmpty() && sch.getDrink_Type().isEmpty() && sch.getName().isEmpty())) {
			sql += "WHERE CASE WHEN category = ? THEN category\r\n" + "WHEN drink_Type = lower(?) THEN drink_Type \r\n"
					+ "WHEN name LIKE ? THEN name ELSE NULL END IS NOT NULL ORDER BY no ";
		}

		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 처리코드1
			if (!(sch.getCategory().isEmpty() && sch.getDrink_Type().isEmpty() && sch.getName().isEmpty())) {
				pstmt.setString(1, sch.getCategory());
				pstmt.setString(2, sch.getDrink_Type());
				if (!sch.getName().isEmpty()) {
					pstmt.setString(3, "%" + sch.getName() + "%");
				} else {
					pstmt.setString(3, sch.getName());
				}
			}

			try (ResultSet rs = pstmt.executeQuery();) {
				// 처리코드2
				while (rs.next()) {
					menuList.add(new Menu(rs.getInt("no"), rs.getString("category"), rs.getString("name"),
							rs.getString("drink_Type"), rs.getInt("price"), rs.getString("detail")));
				}
				System.out.println("건수:" + menuList.size());
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		}

		return menuList;
	}

	/*
	 * + "SELECT no, kind, type, name, price, cnt FROM BEVERAGE " + "WHERE " +
	 * "CASE WHEN kind = ? THEN kind " + "WHEN type = UPPER(?) " +
	 * "THEN type WHEN name LIKE ? " + "THEN name " +
	 * "ELSE NULL END IS NOT NULL ORDER BY no";
	 */

	// 장바구니 추가 메서드

	public int insertCart(int cnt, int no) {
		int insCnt = 0;
		String sql = "INSERT INTO cart (category, drink_type, name, price, cnt, no)\r\n"
				+ "SELECT category, drink_type, name, price, ? , no\r\n" + "FROM menu\r\n" + "WHERE no = ?";
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			// 처리코드1
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, no);
			insCnt = pstmt.executeUpdate();
			if (insCnt == 0) {
				System.out.println("등록 실패");
				con.rollback();
			} else {
				con.commit(); // Commit the transaction
				System.out.println("등록 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		}

		return insCnt;
	}

	// 장바구니 출력 메서드
	public List<Cart> getCartList() {
		List<Cart> cartList = new ArrayList<Cart>();
		String sql = "SELECT * FROM cart";

		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 처리코드1

			try (ResultSet rs = pstmt.executeQuery();) {
				// 처리코드2
				while (rs.next()) {
					cartList.add(new Cart(rs.getString("category"), rs.getString("drink_Type"), rs.getString("name"),
							rs.getInt("price"), rs.getInt("cnt"), rs.getInt("no")));
				}
				System.out.println("건수:" + cartList.size());
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		}

		return cartList;
	}

	// 장바구니 삭제 기능 메서드

	public int deleteCart(int no) {
		int delCnt = 0;
		String sql = "DELETE FROM cart where NO = ?";
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			// 처리코드1
			pstmt.setInt(1, no);
			delCnt = pstmt.executeUpdate();
			if (delCnt == 0) {
				System.out.println("삭제 실패");
				con.rollback();
			} else {
				con.commit(); // Commit the transaction
				System.out.println("삭제 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		}
		return delCnt;
	}

	// 장바구니 수량 증가 메서드
	// UPDATE carttest SET cnt= cnt+1 WHERE NO=?;
	public int plusCnt(int no) {
		int uptCnt = 0;
		String sql = "UPDATE carttest SET cnt= cnt+1 WHERE NO=?";
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			// 처리코드1
			pstmt.setInt(1, no);
			uptCnt = pstmt.executeUpdate();
			if (uptCnt == 0) {
				System.out.println("CUD 실패");
				System.out.println();
				con.rollback();
			} else {
				con.commit(); // Commit the transaction
				System.out.println("CUD 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		}

		return uptCnt;
	}

	// 회원 포인트 불러오기
	// SELECT point FROM MEMBER WHERE ID = ?
	public int getPoint(String id) {
		int point = 0;
		String sql = "SELECT point FROM MEMBER WHERE ID = ?";
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, id);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					point = rs.getInt("point");
					System.out.println("포인트 조회 성공: " + point);
				} else {
					System.out.println("해당 아이디에 대한 데이터가 없습니다.");
				}
			}

		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		}

		return point;
	}

	// 포인트 사용 메서드
	// UPDATE MEMBER SET point = point-? WHERE id=?
	public int uptPoint(int point, String id) {
		int uptPoint = 0;
		String sql = "UPDATE MEMBER SET point = point-? WHERE id=?";
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			// 처리코드1
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
			uptPoint = pstmt.executeUpdate();
			if (uptPoint == 0) {
				System.out.println("CUD 실패");
				System.out.println();
				con.rollback();
			} else {
				con.commit(); // Commit the transaction
				System.out.println("CUD 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		}

		return uptPoint;
	}

	// 포인트 추가 메서드
	// UPDATE MEMBER SET point = point-? WHERE id=?
	public int plusPoint(int point, String id) {
		int plustPoint = 0;
		String sql = "UPDATE MEMBER SET point = point+? WHERE id=?";
		try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			// 처리코드1
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
			plustPoint = pstmt.executeUpdate();
			if (plustPoint == 0) {
				System.out.println("CUD 실패");
				System.out.println();
				con.rollback();
			} else {
				con.commit(); // Commit the transaction
				System.out.println("CUD 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		}

		return plustPoint;
	}
	
	// 장바구니 전체 삭제 메서드 

		public int deleteCart() {
			int delCnt = 0;
			String sql = "DELETE FROM cart ";
			try (Connection con = DBCon.con(); PreparedStatement pstmt = con.prepareStatement(sql);) {
				con.setAutoCommit(false);
				// 처리코드1
				
				delCnt = pstmt.executeUpdate();
				if (delCnt == 0) {
					System.out.println("삭제 실패");
					con.rollback();
				} else {
					con.commit(); // Commit the transaction
					System.out.println("삭제 성공");
				}
			} catch (SQLException e) {
				System.out.println("DB 에러:" + e.getMessage());
			} catch (Exception e) {
				System.out.println("일반 에러:" + e.getMessage());
			}
			return delCnt;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Orderdao dao = new Orderdao();

//		for(Menu m01 : dao.getMenuList(new Menu("","ice",""))) {
//				System.out.print(m01.getCategory() + "\t");
//				System.out.print(m01.getName() + "\t");
//				System.out.print(m01.getDrink_Type() + "\t");
//				System.out.print(m01.getPrice() + "\n");
//		}

		// 장바구니에 음료를 추가합니다.
//		Carttest c01 = new Carttest();
//	
//		int insCnt = dao.insertCarttest( new Carttest(1,"커피","ICE","아메리카노",3000,1));
//		System.out.println(insCnt);
//			

//		int insCnt = dao.insertCart(2,1);
//		System.out.println(insCnt);

//		dao.plusCnt(2);

//		for (Beverage b01 : dao.getBevList(new Beverage(" ", "ice", " "))) {
//			System.out.print(b01.getNo() + "\t");
//			System.out.print(b01.getKind() + "\t");
//			System.out.print(b01.getType() + "\t");
//			System.out.print(b01.getName() + "\t");
//			System.out.print(b01.getPrice() + "\t");
//			System.out.print(b01.getCnt() + "\n");
//		}
//		List<Cart> cartList = dao.getCartList();
//		for(Cart c01 : cartList) {
//			System.out.print(c01.getCategory()+"\t");
//			System.out.print(c01.getDrink_type()+"\t");
//			System.out.print(c01.getName()+"\t");
//			System.out.print(c01.getPrice()+"\t");
//			System.out.print(c01.getCnt()+"\n");
//		}
//		

		int point = dao.getPoint("dlathf0202");
		System.out.println(point);
		
		int plusPoint = dao.plusPoint(2000,"dlathf0202");
		

	}

}
