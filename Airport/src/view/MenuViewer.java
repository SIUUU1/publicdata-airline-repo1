package view;

public class MenuViewer {
	public static void mainMenuView() {
		System.out.println("****************************************************************");
		System.out.println("\t\t   Welcome to Trip Airline Ticket");
		System.out.println("****************************************************************");
		System.out.println(" 1. 항공권 예매하기  \t2. 예매내역 확인하기 \t3. 종료");
		System.out.println("****************************************************************");
	}
	public static void depAirportMenuView() {
		System.out.println("****************************************************************");
		System.out.println(" 1. 무안  2. 광주  3. 군산   4. 여수   5. 원주   6. 양양   7. 제주");
		System.out.println(" 8. 김해  9. 사천  10. 울산  11. 인천  12. 김포  13. 포항  14. 대구");
		System.out.println(" 15. 청주");
		System.out.println("****************************************************************");
		System.out.print("출발공항>> ");
	}
	
	public static void arrAirportMenuView() {
		System.out.println("****************************************************************");
		System.out.println(" 1. 무안  2. 광주  3. 군산   4. 여수   5. 원주   6. 양양   7. 제주");
		System.out.println(" 8. 김해  9. 사천  10. 울산  11. 인천  12. 김포  13. 포항  14. 대구");
		System.out.println(" 15. 청주");
		System.out.println("****************************************************************");
		System.out.print("도착공항>> ");
	}
	public static void airlineNameMenuView() {
		System.out.println("****************************************************************");
		System.out.println(" 1. 아시아나항공  2. 에어부산  3. 에어서울    4. 이스타항공   5. 플라이강원");
		System.out.println(" 6. 하이에어     7. 제주항공  8. 진에어     9. 대한항공     10. 티웨이항공");
		System.out.println("****************************************************************");
		System.out.print("항공사>> ");
	}
}
