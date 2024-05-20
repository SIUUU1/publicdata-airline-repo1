package control;

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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import main.AirportMain;
import model.AirportVO;

public class AirportRegisterManager {
	// 항공권 정보 저장
	public static void airportRegister(List<AirportVO> list) {
		AriportDAO.setAirportRegister(list);
	}

	// 항공권 목록 가져오기
	public static void airportList(List<AirportVO> list) {
		AirportMain.airportDataList = AriportDAO.getAirportList(list);
	}

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
