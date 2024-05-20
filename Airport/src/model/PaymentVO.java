package model;

import java.util.Objects;

public class PaymentVO {
	private int payments_id; // 결제ID
	private int airports_id; // 항공권ID
	private String vihicle_id; // 항공편ID
	private String payment_date; // 결제일
	private String customer_name; // 고객 이름
	private String customer_phone; // 고객 전화번호
	private String customer_email; // 고객 이메일
	private int economy_count; // 일반석
	private int prestige_count; // 비즈니스석
	private int total_price; // 총가격

	public PaymentVO() {
		super();
	}

	public PaymentVO(int airports_id, String vihicle_id, String customer_name, String customer_phone,
			String customer_email, int economy_count, int prestige_count, int total_price) {
		super();
		this.airports_id = airports_id;
		this.vihicle_id = vihicle_id;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.customer_email = customer_email;
		this.economy_count = economy_count;
		this.prestige_count = prestige_count;
		this.total_price = total_price;
	}

	public PaymentVO(int payments_id, int airports_id, String vihicle_id, String payment_date, String customer_name,
			String customer_phone, String customer_email, int economy_count, int prestige_count, int total_price) {
		super();
		this.payments_id = payments_id;
		this.airports_id = airports_id;
		this.vihicle_id = vihicle_id;
		this.payment_date = payment_date;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.customer_email = customer_email;
		this.economy_count = economy_count;
		this.prestige_count = prestige_count;
		this.total_price = total_price;
	}

	public int getPayments_id() {
		return payments_id;
	}

	public void setPayments_id(int payments_id) {
		this.payments_id = payments_id;
	}

	public int getAirports_id() {
		return airports_id;
	}

	public void setAirports_id(int airports_id) {
		this.airports_id = airports_id;
	}

	public String getVihicle_id() {
		return vihicle_id;
	}

	public void setVihicle_id(String vihicle_id) {
		this.vihicle_id = vihicle_id;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public int getEconomy_count() {
		return economy_count;
	}

	public void setEconomy_count(int economy_count) {
		this.economy_count = economy_count;
	}

	public int getPrestige_count() {
		return prestige_count;
	}

	public void setPrestige_count(int prestige_count) {
		this.prestige_count = prestige_count;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(airports_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentVO other = (PaymentVO) obj;
		return airports_id == other.airports_id;
	}

	@Override
	public String toString() {
		return "PaymentVO [payments_id=" + payments_id + ", airports_id=" + airports_id + ", vihicle_id=" + vihicle_id
				+ ", payment_date=" + payment_date + ", customer_name=" + customer_name + ", customer_phone="
				+ customer_phone + ", customer_email=" + customer_email + ", economy_count=" + economy_count
				+ ", prestige_count=" + prestige_count + ", total_price=" + total_price + "]";
	}

}
