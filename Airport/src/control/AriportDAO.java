package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AirportVO;

public class AriportDAO {
	// 항공권 정보 저장
	public static void setAirportRegister(List<AirportVO> list) {
		String sql = "INSERT INTO AIRPORTS VALUES(AIRPORTS_ID_SEQ.nextval,?,?,?,?,to_date(?,'YYYY-MM-DD HH24:MI'),to_date(?,'YYYY-MM-DD HH24:MI'),?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);

			for (AirportVO avo : list) {
				pstmt.setString(1, avo.getVihicle_id());
				pstmt.setString(2, avo.getAirline_name());
				pstmt.setString(3, avo.getDepAirport_name());
				pstmt.setString(4, avo.getArrAirport_name());
				pstmt.setString(5, avo.getDep_plandtime());
				pstmt.setString(6, avo.getArr_plandtime());
				pstmt.setInt(7, avo.getEconomy_charge());
				pstmt.setInt(8, avo.getPrestige_charge());
				int value = pstmt.executeUpdate();
				if (value != 1) {
					System.out.println(avo.getVihicle_id() + " 등록 실패");
				}
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

	// 항공권 목록 가져오기
	public static ArrayList<AirportVO> getAirportList(List<AirportVO> list) {
		ArrayList<AirportVO> airportDataList = new ArrayList<>();
		String sql = "SELECT * FROM AIRPORTS where vihicle_id=? and AIRLINE_NAME=? "
				+ "and DEPAIRPORT_NAME=? and ARRAIRPORT_NAME=? and to_char(DEP_PLANDTIME,'YYYYMMDD')=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println(" 항공편ID | 항공편명 | 항공사명 | 출발공항 | 도착공항 | 출발시간 | 도착시간 | 일반석운임 | 비즈니스석운임 ");
			System.out.println("-------------------------------------------------------------------------------------");
			for (int i = 0; i < list.size(); i++) {
				pstmt.setString(1, list.get(i).getVihicle_id());
				pstmt.setString(2, list.get(i).getAirline_name());
				pstmt.setString(3, list.get(i).getDepAirport_name());
				pstmt.setString(4, list.get(i).getArrAirport_name());
				pstmt.setString(5, list.get(i).getDep_plandtime().substring(0, 8));
				rs = pstmt.executeQuery();

				while (rs.next()) {
					AirportVO avo = new AirportVO();
					avo.setAirports_id(rs.getInt("airports_id"));
					avo.setVihicle_id(rs.getString("vihicle_id"));
					avo.setAirline_name(rs.getString("airline_name"));
					avo.setDepAirport_name(rs.getString("depAirport_name"));
					avo.setArrAirport_name(rs.getString("arrAirport_name"));
					avo.setDep_plandtime(String.valueOf(rs.getDate("dep_plandtime")));
					avo.setArr_plandtime(String.valueOf(rs.getDate("arr_plandtime")));
					avo.setEconomy_charge(rs.getInt("economy_charge"));
					avo.setPrestige_charge(rs.getInt("prestige_charge"));
					System.out.println(avo.toString());
					airportDataList.add(avo);
				}
			}
			System.out.println("-------------------------------------------------------------------------------------");
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
		return airportDataList;
	}

}
