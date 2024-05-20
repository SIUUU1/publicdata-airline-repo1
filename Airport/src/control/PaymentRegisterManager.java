package control;

import java.util.List;
import java.util.Scanner;

import model.AirportVO;
import model.PaymentVO;

public class PaymentRegisterManager {
	static Scanner sc = new Scanner(System.in);

	// 결제 정보 저장
	public static PaymentVO paymentRegister(List<AirportVO> airportDataList) {
		int numId = -1;
		int prestige_count = 0;
		int airports_id = -1;
		PaymentVO pvo = null;

		System.out.print("예약하실 항공편을 선택하세요. ");
		airports_id = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < airportDataList.size(); i++) {
			if (airportDataList.get(i).getAirports_id() == airports_id) {
				numId = i;
				break;
			}
		}
		if (numId == -1) {
			System.out.println("예매하실 항공편ID가 정확하지 않습니다.");
		} else {
			if (airportDataList.get(numId).getPrestige_charge() != 0) {
				System.out.print("예매하실 비즈니스석 인원수>> ");
				prestige_count = sc.nextInt();
				sc.nextLine();
			}
			System.out.print("예매하실 일반석 인원수>> ");
			int economy_count = sc.nextInt();
			sc.nextLine();
			System.out.print("이름>> ");
			String customer_name = sc.nextLine();
			System.out.print("전화번호>> ");
			String customer_phone = sc.nextLine();
			System.out.print("이메일>> ");
			String customer_email = sc.nextLine();
			int total_price = economy_count * airportDataList.get(numId).getEconomy_charge()
					+ prestige_count * airportDataList.get(numId).getPrestige_charge();
			System.out.println("총결제금액 : " + total_price);

			pvo = new PaymentVO(airportDataList.get(numId).getAirports_id(), airportDataList.get(numId).getVihicle_id(),
					customer_name, customer_phone, customer_email, economy_count, prestige_count, total_price);
		}

		PaymentDAO.setPaymentRegister(pvo);
		return pvo;
	}

	// 현재 결제내역 출력하기
	public static void paymentSelect(String customer_phone, int airports_id) {
		PaymentDAO.getPaymentList(customer_phone, airports_id);
	}

	// 결제내역 가져오기
	public static void paymentTotalList() {
		System.out.print("이름>> ");
		String customer_name = sc.nextLine();
		System.out.print("전화번호>> ");
		String customer_phone = sc.nextLine();
		PaymentDAO.setPaymentRegister(customer_name, customer_phone);
	}

}
