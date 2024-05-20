package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PaymentVO;

public class PaymentDAO {
	// 결제 정보 저장
	public static void setPaymentRegister(PaymentVO pvo) {
		String sql = "INSERT INTO PAYMENTS VALUES(PAYMENTS_ID_SEQ.nextval, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pvo.getAirports_id());
			pstmt.setString(2, pvo.getVihicle_id());
			pstmt.setString(3, pvo.getCustomer_name());
			pstmt.setString(4, pvo.getCustomer_phone());
			pstmt.setString(5, pvo.getCustomer_email());
			pstmt.setInt(6, pvo.getEconomy_count());
			pstmt.setInt(7, pvo.getPrestige_count());
			pstmt.setInt(8, pvo.getTotal_price());
			int value = pstmt.executeUpdate();
			if (value == 1) {
				System.out.println(pvo.getCustomer_name() + " 결제내역 등록 성공");
			} else {
				System.out.println(pvo.getCustomer_name() + " 결제내역 등록 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void getPaymentList(String customer_phone, int airports_id) {
		String sql = "SELECT P.vihicle_id, to_char(p.payment_date,'YYYY-MM-DD') payment_date , p.customer_name, a.airline_name, a.depairport_name, a.arrairport_name, "
				+ "to_char(a.dep_plandtime,'YYYY-MM-DD HH24:MI') dep_plandtime, to_char(a.arr_plandtime,'YYYY-MM-DD HH24:MI') arr_plandtime, p.economy_count, p.prestige_count, p.total_price "
				+ "FROM PAYMENTS P INNER JOIN AIRPORTS A ON P.AIRPORTS_ID = A.AIRPORTS_ID "
				+ "WHERE p.AIRPORTS_ID =? AND p.customer_phone=? ORDER BY P.payment_date DESC";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, airports_id);
			pstmt.setString(2, customer_phone);
			rs = pstmt.executeQuery();
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			System.out.println(" 항공편ID | 결제일 | 고객이름 | 항공사명 | 출발공항 | 도착공항 | 출발시간 | 도착시간 | 일반석 | 비즈니스석 | 총가격 ");
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			while (rs.next()) {
				System.out.println(" " + rs.getString("vihicle_id") + " | " + String.valueOf(rs.getDate("payment_date"))
						+ " | " + rs.getString("customer_name") + " | " + rs.getString("airline_name") + " | "
						+ rs.getString("depairport_name") + " | " + rs.getString("arrAirport_name") + " | "
						+ rs.getString("dep_plandtime") + " | " + rs.getString("arr_plandtime") + " | "
						+ rs.getInt("economy_count") + " | " + rs.getInt("prestige_count") + " | "
						+ rs.getInt("total_price"));
			}
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void setPaymentRegister(String customer_name, String customer_phone) {
		String sql = "SELECT P.vihicle_id, to_char(p.payment_date,'YYYY-MM-DD') payment_date , p.customer_name, a.airline_name, a.depairport_name, a.arrairport_name, "
				+ "to_char(a.dep_plandtime,'YYYY-MM-DD HH24:MI') dep_plandtime, to_char(a.arr_plandtime,'YYYY-MM-DD HH24:MI') arr_plandtime, p.economy_count, p.prestige_count, p.total_price "
				+ "FROM PAYMENTS P INNER JOIN AIRPORTS A ON P.AIRPORTS_ID = A.AIRPORTS_ID "
				+ "WHERE p.customer_name =? AND p.customer_phone=? ORDER BY P.payment_date DESC";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer_name);
			pstmt.setString(2, customer_phone);
			rs = pstmt.executeQuery();
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			System.out.println(" 항공편ID | 결제일 | 고객이름 | 항공사명 | 출발공항 | 도착공항 | 출발시간 | 도착시간 | 일반석 | 비즈니스석 | 총가격 ");
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			while (rs.next()) {
				System.out.println(" " + rs.getString("vihicle_id") + " | " + String.valueOf(rs.getDate("payment_date"))
						+ " | " + rs.getString("customer_name") + " | " + rs.getString("airline_name") + " | "
						+ rs.getString("depairport_name") + " | " + rs.getString("arrAirport_name") + " | "
						+ rs.getString("dep_plandtime") + " | " + rs.getString("arr_plandtime") + " | "
						+ rs.getInt("economy_count") + " | " + rs.getInt("prestige_count") + " | "
						+ rs.getInt("total_price"));
			}
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
