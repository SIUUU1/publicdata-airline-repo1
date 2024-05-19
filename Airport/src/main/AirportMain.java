package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import model.AirportVO;

public class AirportMain {
	public static Scanner sc = new Scanner(System.in);
	public static List<AirportVO> list = null;// 항공사정보리스트

	public static void main(String[] args) {
		boolean flag = false;
		
		System.out.println("****************************************************************");
		System.out.println("\t\t" + "   Welcome to Trip Airline Ticket");
		System.out.println("****************************************************************");

		System.out.println("****************************************************************");
		System.out.println(" 1. 무안  2. 광주  3. 군산   4. 여수   5. 원주   6. 양양   7. 제주");
		System.out.println(" 8. 김해  9. 사천  10. 울산  11. 인천  12. 김포  13. 포항  14. 대구");
		System.out.println(" 15. 청주");
		System.out.println("****************************************************************");

		System.out.print("출발공항ID>>");
		int selectDepAirport = sc.nextInt();
		String depAirportId = null;
		sc.nextLine();
		switch (selectDepAirport) {
		case 1:
			depAirportId = "NAARKJB";
			break;
		case 2:
			depAirportId = "NAARKJJ";
			break;
		case 3:
			depAirportId = "NAARKJK";
			break;
		case 4:
			depAirportId = "NAARKJY";
			break;
		case 5:
			depAirportId = "NAARKNW";
			break;
		case 6:
			depAirportId = "NAARKNY";
			break;
		case 7:
			depAirportId = "NAARKPC";
			break;
		case 8:
			depAirportId = "NAARKPK";
			break;
		case 9:
			depAirportId = "NAARKPS";
			break;
		case 10:
			depAirportId = "NAARKPU";
			break;
		case 11:
			depAirportId = "NAARKSI";
			break;
		case 12:
			depAirportId = "NAARKSS";
			break;
		case 13:
			depAirportId = "NAARKTH";
			break;
		case 14:
			depAirportId = "NAARKTN";
			break;
		case 15:
			depAirportId = "NAARKTU";
			break;
		}

		System.out.println("****************************************************************");
		System.out.println(" 1. 무안  2. 광주  3. 군산   4. 여수   5. 원주   6. 양양   7. 제주");
		System.out.println(" 8. 김해  9. 사천  10. 울산  11. 인천  12. 김포  13. 포항  14. 대구");
		System.out.println(" 15. 청주");
		System.out.println("****************************************************************");

		System.out.print("도착공항ID>>");
		int selectArrAirport = sc.nextInt();
		sc.nextLine();
		String arrAirportId = null;
		switch (selectArrAirport) {
		case 1:
			arrAirportId = "NAARKJB";
			break;
		case 2:
			arrAirportId = "NAARKJJ";
			break;
		case 3:
			arrAirportId = "NAARKJK";
			break;
		case 4:
			arrAirportId = "NAARKJY";
			break;
		case 5:
			arrAirportId = "NAARKNW";
			break;
		case 6:
			arrAirportId = "NAARKNY";
			break;
		case 7:
			arrAirportId = "NAARKPC";
			break;
		case 8:
			arrAirportId = "NAARKPK";
			break;
		case 9:
			arrAirportId = "NAARKPS";
			break;
		case 10:
			arrAirportId = "NAARKPU";
			break;
		case 11:
			arrAirportId = "NAARKSI";
			break;
		case 12:
			arrAirportId = "NAARKSS";
			break;
		case 13:
			arrAirportId = "NAARKTH";
			break;
		case 14:
			arrAirportId = "NAARKTN";
			break;
		case 15:
			arrAirportId = "NAARKTU";
			break;
		}

		System.out.print("출발일(yyyymmdd)>>");
		String depPlandTime = sc.nextLine();

		System.out.println("****************************************************************");
		System.out.println(" 1. 아시아나항공  2. 에어부산  3. 에어서울    4. 이스타항공   5. 플라이강원");
		System.out.println(" 6. 하이에어     7. 제주항공  8. 진에어     9. 대한항공     10. 티웨이항공");
		System.out.println("****************************************************************");

		System.out.print("항공사ID>>");
		int selectAirline = sc.nextInt();
		sc.nextLine();
		String airlineId = null;

		switch (selectAirline) {
		case 1:
			airlineId = "AAR";
			break;
		case 2:
			airlineId = "ABL";
			break;
		case 3:
			airlineId = "ASV";
			break;
		case 4:
			airlineId = "ESR";
			break;
		case 5:
			airlineId = "FGW";
			break;
		case 6:
			airlineId = "HGG";
			break;
		case 7:
			airlineId = "JJA";
			break;
		case 8:
			airlineId = "JNA";
			break;
		case 9:
			airlineId = "KAL";
			break;
		case 10:
			airlineId = "TWB";
			break;
		}
		// 항공권 검색
		list = selectAirport(depAirportId, arrAirportId, depPlandTime, airlineId);
		if (!list.isEmpty()) {
			list.forEach(e -> System.out.println(e));
			flag = true;
		} else {
			System.out.println("찾으시는 정보가 없습니다.");
		}
		//항공권 데이터 입력 비우고 넣기
		
		if(flag) {
			// 골라서 인원수
			// 티켓 가격 계산
			System.out.print("예약하실 항공편을 선택하세요. ");
			System.out.print("인원수>>");
			int count = sc.nextInt();
			sc.nextLine();
			System.out.print("총금액 : ");
			System.out.print("이름 : ");
			System.out.print("전화번호 : ");
			
		}
		//지불내역 데이터 넣기
		
	}//end of main

	// 항공권 검색함수
	public static List<AirportVO> selectAirport(String depAirportId, String arrAirportId, String depPlandTime,
			String airlineId) {
		List<AirportVO> list = new ArrayList<>();
		// 1.요청 url 생성
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /* URL */
		try {
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
					+ "=ZZK6F84oQsGUcoz%2BiNgdSgTrLL5bKPHr2ppbYMYXSKVSRBzjVqPzEyWEzKoOqVLUdNpry0wyNejJ1AnztcO2HQ%3D%3D");
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
			urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
					+ URLEncoder.encode("xml", "UTF-8")); /* 데이터 타입(xml, json) */
			urlBuilder.append("&" + URLEncoder.encode("depAirportId", "UTF-8") + "="
					+ URLEncoder.encode(depAirportId, "UTF-8")); /* 출발공항ID */
			urlBuilder.append("&" + URLEncoder.encode("arrAirportId", "UTF-8") + "="
					+ URLEncoder.encode(arrAirportId, "UTF-8")); /* 도착공항ID */
			urlBuilder.append("&" + URLEncoder.encode("depPlandTime", "UTF-8") + "="
					+ URLEncoder.encode(depPlandTime, "UTF-8")); /* 출발일(YYYYMMDD) */
			urlBuilder.append("&" + URLEncoder.encode("airlineId", "UTF-8") + "="
					+ URLEncoder.encode(airlineId, "UTF-8")); /* 항공사ID */
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 2.connection 객체 생성
		URL url = null;
		HttpURLConnection conn = null;
		try {
			url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			// System.out.println("Response code: " + conn.getResponseCode());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 3.요청전송 및 응답 처리
		BufferedReader br = null;
		try {
			int statusCode = conn.getResponseCode();
			// System.out.println(statusCode);
			if (statusCode >= 200 && statusCode <= 300) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			Document doc = parseXML(conn.getInputStream());
			NodeList descNodes = doc.getElementsByTagName("item");
			for (int i = 0; i < descNodes.getLength(); i++) {
				Node item = descNodes.item(i);
				AirportVO data = new AirportVO();
				for (Node node = item.getFirstChild(); node != null; node = node.getNextSibling()) {
					switch (node.getNodeName()) {
					case "vihicleId":
						data.setVihicle_id(node.getTextContent());
						break;
					case "airlineNm":
						data.setAirline_name(node.getTextContent());
						break;
					case "depAirportNm":
						data.setDepAirport_name(node.getTextContent());
						break;
					case "arrAirportNm":
						data.setArrAirport_name(node.getTextContent());
						break;
					case "depPlandTime":
						data.setDep_plandtime(node.getTextContent());
						break;
					case "arrPlandTime":
						data.setArr_plandtime(node.getTextContent());
						break;
					case "economyCharge":
						data.setEconomy_charge(Integer.parseInt(node.getTextContent()));
						break;
					case "prestigeCharge":
						data.setPrestige_charge(Integer.parseInt(node.getTextContent()));
						break;
					}
				}
				list.add(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 4.자원반환
		conn.disconnect();
		return list;
	}

	public static Document parseXML(InputStream inputStream) {
		DocumentBuilderFactory objdcBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder objdcBuilder = null;
		Document doc = null;
		try {
			objdcBuilder = objdcBuilderFactory.newDocumentBuilder();
			doc = objdcBuilder.parse(inputStream);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
}
