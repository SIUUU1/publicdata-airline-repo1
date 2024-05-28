package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.AirportVO;
import oracle.jdbc.OracleTypes;

public class AriportDAO {
	// 항공권 정보 저장
	public static void setAirportRegister(List<AirportVO> list) {
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DBUtil.makeConnection();
			cstmt = con.prepareCall("{CALL AIRPORTS_INSERT_PROC(?,?,?,?,?,?,?,?,?)}");

			for (AirportVO avo : list) {
				cstmt.setString(1, avo.getVihicle_id());
				cstmt.setString(2, avo.getAirline_name());
				cstmt.setString(3, avo.getDepAirport_name());
				cstmt.setString(4, avo.getArrAirport_name());
				cstmt.setString(5, avo.getDep_plandtime());
				cstmt.setString(6, avo.getArr_plandtime());
				cstmt.setInt(7, avo.getEconomy_charge());
				cstmt.setInt(8, avo.getPrestige_charge());
				cstmt.registerOutParameter(9, Types.INTEGER);
				cstmt.executeUpdate();
				int value = cstmt.getInt(9);
				if (value == 0) {
					System.out.println("항공편 등록 성공");
				}
				if (value == 1) {
					System.out.println("항공편 정보가 중복되어 등록하지 않았습니다.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResources(con, cstmt);
		}
	}

	// 항공권 목록 가져오기
	public static ArrayList<AirportVO> getAirportList(List<AirportVO> list) {
		ArrayList<AirportVO> airportDataList = new ArrayList<>();
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.makeConnection();
			cstmt = con.prepareCall("CALL AIRPORTS_PRINT_PROC(?,?,?,?,?,?)");

			System.out.println(
					"--------------------------------------------------------------------------------------------------------------");
			System.out.println(
					" 항공편ID | 운항기ID | 출발공항 | 도착공항 |      출발시간      |      도착시간      |  항공사명   | 일반석운임 | 비즈니스석운임 ");
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < list.size(); i++) {
				cstmt.setString(1, list.get(i).getVihicle_id());
				cstmt.setString(2, list.get(i).getAirline_name());
				cstmt.setString(3, list.get(i).getDepAirport_name());
				cstmt.setString(4, list.get(i).getArrAirport_name());
				cstmt.setString(5, list.get(i).getDep_plandtime().substring(0, 8));
				cstmt.registerOutParameter(6, OracleTypes.CURSOR);
				cstmt.executeQuery();
				rs = (ResultSet) cstmt.getObject(6);
				while (rs.next()) {
					AirportVO avo = new AirportVO();
					avo.setAirports_id(rs.getInt("airports_id"));
					avo.setVihicle_id(rs.getString("vihicle_id"));
					avo.setAirline_name(rs.getString("airline_name"));
					avo.setDepAirport_name(rs.getString("depAirport_name"));
					avo.setArrAirport_name(rs.getString("arrAirport_name"));
					avo.setDep_plandtime(rs.getString("dep_plandtime"));
					avo.setArr_plandtime(rs.getString("arr_plandtime"));
					avo.setEconomy_charge(rs.getInt("economy_charge"));
					avo.setPrestige_charge(rs.getInt("prestige_charge"));
					airportDataList.add(avo);

					System.out.printf("  %-4d  | %-6s |  %-3s  |  %-3s  | %s | %s | %-6s | %-7d | %-7d \n",
							rs.getInt("airports_id"), rs.getString("vihicle_id"), rs.getString("depAirport_name"),
							rs.getString("arrAirport_name"), rs.getString("dep_plandtime").substring(0, 16),
							rs.getString("arr_plandtime").substring(0, 16), rs.getString("airline_name"),
							rs.getInt("economy_charge"), rs.getInt("prestige_charge"));
				}
			}
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResources(con, cstmt, rs);
		}
		return airportDataList;
	}

}
