package model;

import java.util.Objects;

public class PaymentVO {
	private int no;
	private String customer_name; // 고객 이름
	private String customer_phone; // 고객 전화번호
	private String customer_email; // 고객 이메일
	private int customer_age; // 고객 나이
	private String vihicle_id; // 항공편ID
	private int economy_count; // 일반석
	private int prestige_count; // 비즈니스석
	private int total_price; // 총가격

	public PaymentVO() {
		super();
	}

	public PaymentVO(int no, String customer_name, String customer_phone, String customer_email, int customer_age,
			String vihicle_id, int economy_count, int prestige_count, int total_price) {
		super();
		this.no = no;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.customer_email = customer_email;
		this.customer_age = customer_age;
		this.vihicle_id = vihicle_id;
		this.economy_count = economy_count;
		this.prestige_count = prestige_count;
		this.total_price = total_price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public int getCustomer_age() {
		return customer_age;
	}

	public void setCustomer_age(int customer_age) {
		this.customer_age = customer_age;
	}

	public String getVihicle_id() {
		return vihicle_id;
	}

	public void setVihicle_id(String vihicle_id) {
		this.vihicle_id = vihicle_id;
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
		return Objects.hash(no);
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
		return no == other.no;
	}

	@Override
	public String toString() {
		return "Payment [no=" + no + ", customer_name=" + customer_name + ", customer_phone=" + customer_phone
				+ ", customer_email=" + customer_email + ", customer_age=" + customer_age + ", vihicle_id=" + vihicle_id
				+ ", economy_count=" + economy_count + ", prestige_count=" + prestige_count + ", total_price="
				+ total_price + "]";
	}
}
