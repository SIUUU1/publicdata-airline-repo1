package model;
import java.util.Objects;

public class AirportVO {
	private String vihicle_id; // 항공편명
	private String airline_name; // 항공사명
	private String depAirport_name; // 출발공항
	private String arrAirport_name; // 도착공항
	private String dep_plandtime; // 출발시간
	private String arr_plandtime; // 도착시간
	private int economy_charge; // 일반석운임
	private int prestige_charge; // 비즈니스석운임

	public AirportVO() {
		super();
	}

	public AirportVO(String vihicle_id, String airline_name, String depAirport_name, String arrAirport_name,
			String dep_plandtime, String arr_plandtime, int economy_charge, int prestige_charge) {
		super();
		this.vihicle_id = vihicle_id;
		this.airline_name = airline_name;
		this.depAirport_name = depAirport_name;
		this.arrAirport_name = arrAirport_name;
		this.dep_plandtime = dep_plandtime;
		this.arr_plandtime = arr_plandtime;
		this.economy_charge = economy_charge;
		this.prestige_charge = prestige_charge;
	}

	public String getVihicle_id() {
		return vihicle_id;
	}

	public void setVihicle_id(String vihicle_id) {
		this.vihicle_id = vihicle_id;
	}

	public String getAirline_name() {
		return airline_name;
	}

	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}

	public String getDepAirport_name() {
		return depAirport_name;
	}

	public void setDepAirport_name(String depAirport_name) {
		this.depAirport_name = depAirport_name;
	}

	public String getArrAirport_name() {
		return arrAirport_name;
	}

	public void setArrAirport_name(String arrAirport_name) {
		this.arrAirport_name = arrAirport_name;
	}

	public String getDep_plandtime() {
		return dep_plandtime;
	}

	public void setDep_plandtime(String dep_plandtime) {
		this.dep_plandtime = dep_plandtime;
	}

	public String getArr_plandtime() {
		return arr_plandtime;
	}

	public void setArr_plandtime(String arr_plandtime) {
		this.arr_plandtime = arr_plandtime;
	}

	public int getEconomy_charge() {
		return economy_charge;
	}

	public void setEconomy_charge(int economy_charge) {
		this.economy_charge = economy_charge;
	}

	public int getPrestige_charge() {
		return prestige_charge;
	}

	public void setPrestige_charge(int prestige_charge) {
		this.prestige_charge = prestige_charge;
	}

	@Override
	public int hashCode() {
		return Objects.hash(vihicle_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirportVO other = (AirportVO) obj;
		return Objects.equals(vihicle_id, other.vihicle_id);
	}

	@Override
	public String toString() {
		return "AirportData [항공편명=" + vihicle_id + ", 항공사명=" + airline_name + ", 출발공항="
				+ depAirport_name + ", 도착공항=" + arrAirport_name + ", 출발시간=" + dep_plandtime
				+ ", 도착시간=" + arr_plandtime + ", 일반석운임=" + economy_charge + ", 비즈니스석운임="
				+ prestige_charge + "]";
	}


}
