package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import model.PaymentVO;
import oracle.jdbc.OracleTypes;

public class PaymentDAO {
	// 결제 정보 저장
	public static void setPaymentRegister(PaymentVO pvo) {
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DBUtil.makeConnection();
			cstmt = con.prepareCall("{CALL PAY_INSERT_PROC(?,?,?,?,?,?,?,?,?)}");
			cstmt.setInt(1, pvo.getAirports_id());
			cstmt.setString(2, pvo.getVihicle_id());
			cstmt.setString(3, pvo.getCustomer_name());
			cstmt.setString(4, pvo.getCustomer_phone());
			cstmt.setString(5, pvo.getCustomer_email());
			cstmt.setInt(6, pvo.getEconomy_count());
			cstmt.setInt(7, pvo.getPrestige_count());
			cstmt.setInt(8, pvo.getTotal_price());
			cstmt.registerOutParameter(9, Types.INTEGER);
			cstmt.executeUpdate();
			int value = cstmt.getInt(9);
			if (value == 0) {
				System.out.println(pvo.getCustomer_name() + " 결제내역 등록 성공");
			} else {
				System.out.println(pvo.getCustomer_name() + " 결제내역 등록 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResources(con, cstmt);
		}
	}

	public static void getPaymentList(String customer_phone, int airports_id) {
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.makeConnection();
			cstmt = con.prepareCall("{CALL PAYMENTS_PRINT_PROC1(?,?,?)}");
			cstmt.setInt(1, airports_id);
			cstmt.setString(2, customer_phone);
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			cstmt.executeQuery();
			rs = (ResultSet) cstmt.getObject(3);
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					" 운항기ID |    결제일    | 고객이름 | 출발공항 | 도착공항 |      출발시간      |      도착시간      | 일반석 | 비즈니스석 |  항공사명  | 총가격 ");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------");
			while (rs.next()) {
				System.out.printf(" %-6s | %s | %-5s |  %-3s  |  %-3s  | %s | %s | %-3d |  %-5d  | %-6s | %d \n",
						rs.getString("vihicle_id"), String.valueOf(rs.getDate("payment_date")),
						rs.getString("customer_name"), rs.getString("depairport_name"), rs.getString("arrAirport_name"),
						rs.getString("dep_plandtime"), rs.getString("arr_plandtime"), rs.getInt("economy_count"),
						rs.getInt("prestige_count"), rs.getString("airline_name"), rs.getInt("total_price"));
			}
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResources(con, cstmt, rs);
		}
	}

	public static void getPaymentList(String customer_name, String customer_phone) {
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.makeConnection();
			cstmt = con.prepareCall("{CALL PAYMENTS_PRINT_PROC2(?,?,?)}");
			cstmt.setString(1, customer_name);
			cstmt.setString(2, customer_phone);
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			cstmt.executeQuery();
			rs = (ResultSet) cstmt.getObject(3);
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					" 운항기ID |    결제일    | 고객이름 | 출발공항 | 도착공항 |      출발시간      |      도착시간      | 일반석 | 비즈니스석 |  항공사명  | 총가격 ");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------");
			while (rs.next()) {
				System.out.printf(" %-6s | %s | %-5s |  %-3s  |  %-3s  | %s | %s | %-3d |  %-5d  | %-6s | %d \n",
						rs.getString("vihicle_id"), String.valueOf(rs.getDate("payment_date")),
						rs.getString("customer_name"), rs.getString("depairport_name"), rs.getString("arrAirport_name"),
						rs.getString("dep_plandtime"), rs.getString("arr_plandtime"), rs.getInt("economy_count"),
						rs.getInt("prestige_count"), rs.getString("airline_name"), rs.getInt("total_price"));
			}
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResources(con, cstmt, rs);
		}
	}

}
