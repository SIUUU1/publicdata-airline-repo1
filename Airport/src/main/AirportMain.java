package main;

import java.util.List;
import java.util.Scanner;
import control.AirportRegisterManager;
import control.PaymentRegisterManager;
import model.AirportVO;
import model.PaymentVO;
import view.AIRLINE_CHOICE;
import view.AIRPORT_CHOICE;
import view.MAINMENU_CHOICE;
import view.MenuViewer;

public class AirportMain {
	public static Scanner sc = new Scanner(System.in);
	public static List<AirportVO> airportList = null;// 항공사정보리스트
	public static List<AirportVO> airportDataList = null;// 항공사정보리스트

	public static void main(String[] args) {
		boolean exitFlag = false; // 메인메뉴 무한루프
		while (!exitFlag) {
			// 메인메뉴
			MenuViewer.mainMenuView();
			String menuSelect = sc.nextLine().replaceAll("[^1-3]", "0");
			if (menuSelect.length() == 0) { // menuSelect가 null일때 대비
				System.out.println("다시 입력하세요.");
			} else {
				int menuSelectNum = Integer.parseInt(menuSelect);
				if (menuSelectNum < 1 || menuSelectNum > 3) {
					System.out.println("1부터 3까지의 숫자를 입력해주세요");
				} else {
					switch (menuSelectNum) {
					case MAINMENU_CHOICE.RESERVATION:
						// 예매하기
						reservation();
						break;
					case MAINMENU_CHOICE.PAYMENTTOTALLIST:
						// 결제내역확인하기
						paymentTotalList();
						break;
					case MAINMENU_CHOICE.QUIT:
						System.out.println("종료합니다.");
						exitFlag = true;
						break;
					}
				}
			}
		} // end of while
	}// end of main

	// 예매하기
	public static void reservation() {
		boolean findFlag = false;
		int selectDepAirport = 0;// 출발공항
		int selectArrAirport = 0;// 도착공항
		String depPlandTime = null; // 출발일
		int selectAirline = 0;// 항공사

		// 출발공항
		MenuViewer.depAirportMenuView();
		selectDepAirport = sc.nextInt();
		String depAirportId = null;
		sc.nextLine();
		switch (selectDepAirport) {
		case AIRPORT_CHOICE.NAARKJB:
			depAirportId = "NAARKJB";
			break;
		case AIRPORT_CHOICE.NAARKJJ:
			depAirportId = "NAARKJJ";
			break;
		case AIRPORT_CHOICE.NAARKJK:
			depAirportId = "NAARKJK";
			break;
		case AIRPORT_CHOICE.NAARKJY:
			depAirportId = "NAARKJY";
			break;
		case AIRPORT_CHOICE.NAARKNW:
			depAirportId = "NAARKNW";
			break;
		case AIRPORT_CHOICE.NAARKNY:
			depAirportId = "NAARKNY";
			break;
		case AIRPORT_CHOICE.NAARKPC:
			depAirportId = "NAARKPC";
			break;
		case AIRPORT_CHOICE.NAARKPK:
			depAirportId = "NAARKPK";
			break;
		case AIRPORT_CHOICE.NAARKPS:
			depAirportId = "NAARKPS";
			break;
		case AIRPORT_CHOICE.NAARKPU:
			depAirportId = "NAARKPU";
			break;
		case AIRPORT_CHOICE.NAARKSI:
			depAirportId = "NAARKSI";
			break;
		case AIRPORT_CHOICE.NAARKSS:
			depAirportId = "NAARKSS";
			break;
		case AIRPORT_CHOICE.NAARKTH:
			depAirportId = "NAARKTH";
			break;
		case AIRPORT_CHOICE.NAARKTN:
			depAirportId = "NAARKTN";
			break;
		case AIRPORT_CHOICE.NAARKTU:
			depAirportId = "NAARKTU";
			break;
		}

		// 도착공항
		MenuViewer.arrAirportMenuView();
		selectArrAirport = sc.nextInt();
		sc.nextLine();
		String arrAirportId = null;
		switch (selectArrAirport) {
		case AIRPORT_CHOICE.NAARKJB:
			arrAirportId = "NAARKJB";
			break;
		case AIRPORT_CHOICE.NAARKJJ:
			arrAirportId = "NAARKJJ";
			break;
		case AIRPORT_CHOICE.NAARKJK:
			arrAirportId = "NAARKJK";
			break;
		case AIRPORT_CHOICE.NAARKJY:
			arrAirportId = "NAARKJY";
			break;
		case AIRPORT_CHOICE.NAARKNW:
			arrAirportId = "NAARKNW";
			break;
		case AIRPORT_CHOICE.NAARKNY:
			arrAirportId = "NAARKNY";
			break;
		case AIRPORT_CHOICE.NAARKPC:
			arrAirportId = "NAARKPC";
			break;
		case AIRPORT_CHOICE.NAARKPK:
			arrAirportId = "NAARKPK";
			break;
		case AIRPORT_CHOICE.NAARKPS:
			arrAirportId = "NAARKPS";
			break;
		case AIRPORT_CHOICE.NAARKPU:
			arrAirportId = "NAARKPU";
			break;
		case AIRPORT_CHOICE.NAARKSI:
			arrAirportId = "NAARKSI";
			break;
		case AIRPORT_CHOICE.NAARKSS:
			arrAirportId = "NAARKSS";
			break;
		case AIRPORT_CHOICE.NAARKTH:
			arrAirportId = "NAARKTH";
			break;
		case AIRPORT_CHOICE.NAARKTN:
			arrAirportId = "NAARKTN";
			break;
		case AIRPORT_CHOICE.NAARKTU:
			arrAirportId = "NAARKTU";
			break;
		}

		// 출발일
		System.out.print("출발일(yyyymmdd)>> ");
		depPlandTime = sc.nextLine();

		// 항공사
		MenuViewer.airlineNameMenuView();
		selectAirline = sc.nextInt();
		sc.nextLine();
		String airlineId = null;
		switch (selectAirline) {
		case AIRLINE_CHOICE.AAR:
			airlineId = "AAR";
			break;
		case AIRLINE_CHOICE.ABL:
			airlineId = "ABL";
			break;
		case AIRLINE_CHOICE.ASV:
			airlineId = "ASV";
			break;
		case AIRLINE_CHOICE.ESR:
			airlineId = "ESR";
			break;
		case AIRLINE_CHOICE.FGW:
			airlineId = "FGW";
			break;
		case AIRLINE_CHOICE.HGG:
			airlineId = "HGG";
			break;
		case AIRLINE_CHOICE.JJA:
			airlineId = "JJA";
			break;
		case AIRLINE_CHOICE.JNA:
			airlineId = "JNA";
			break;
		case AIRLINE_CHOICE.KAL:
			airlineId = "KAL";
			break;
		case AIRLINE_CHOICE.TWB:
			airlineId = "TWB";
			break;
		}

		// 항공권 검색
		airportList = AirportRegisterManager.selectAirport(depAirportId, arrAirportId, depPlandTime, airlineId);
		if (!airportList.isEmpty()) {
			// 항공권 등록
			AirportRegisterManager.airportRegister(airportList);
			// 항공권리스트 출력
			AirportRegisterManager.airportList(airportList);
			findFlag = true;
		} else {
			System.out.println("찾으시는 정보가 없습니다.");
		}

		// 항공권 예매하기
		if (findFlag) {
			// 지불내역 데이터 넣기
			PaymentVO pvo = PaymentRegisterManager.paymentRegister(airportDataList);
			if (pvo != null) {
				// 결제내역 출력
				PaymentRegisterManager.paymentSelect(pvo.getCustomer_phone(), pvo.getAirports_id());
			}
		}
	}

	// 결제내역확인하기
	public static void paymentTotalList() {
		PaymentRegisterManager.paymentTotalList();
	}
}
