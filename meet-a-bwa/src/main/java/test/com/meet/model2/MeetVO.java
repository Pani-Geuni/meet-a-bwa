package test.com.meet.model2;

import java.util.Date;
import java.util.Objects;

public class MeetVO {
	private String meet_no;
	private String meet_image;
	private String meet_name;
	private String meet_description;
	private String meet_city;
	private String meet_county;
	private String meet_interest_name;
	private String meet_gender;
	private Integer meet_nop;
	private Integer meet_age;
	private Date meet_date;
	private String user_no;
	
	
	public MeetVO() {}
	
	public MeetVO(String meet_no, String meet_image, String meet_name, String meet_description, String meet_city,
			String meet_county, String meet_interest_name, String meet_gender, Integer meet_nop, Integer meet_age,
			Date meet_date, String user_no) {
		super();
		this.meet_no = meet_no;
		this.meet_image = meet_image;
		this.meet_name = meet_name;
		this.meet_description = meet_description;
		this.meet_city = meet_city;
		this.meet_county = meet_county;
		this.meet_interest_name = meet_interest_name;
		this.meet_gender = meet_gender;
		this.meet_nop = meet_nop;
		this.meet_age = meet_age;
		this.meet_date = meet_date;
		this.user_no = user_no;
	}

	public String getMeet_no() {
		return meet_no;
	}

	public void setMeet_no(String meet_no) {
		this.meet_no = meet_no;
	}

	public String getMeet_image() {
		return meet_image;
	}

	public void setMeet_image(String meet_image) {
		this.meet_image = meet_image;
	}

	public String getMeet_name() {
		return meet_name;
	}

	public void setMeet_name(String meet_name) {
		this.meet_name = meet_name;
	}

	public String getMeet_description() {
		return meet_description;
	}

	public void setMeet_description(String meet_description) {
		this.meet_description = meet_description;
	}

	public String getMeet_city() {
		return meet_city;
	}

	public void setMeet_city(String meet_city) {
		this.meet_city = meet_city;
	}

	public String getMeet_county() {
		return meet_county;
	}

	public void setMeet_county(String meet_county) {
		this.meet_county = meet_county;
	}

	public String getMeet_interest_name() {
		return meet_interest_name;
	}

	public void setMeet_interest_name(String meet_interest_name) {
		this.meet_interest_name = meet_interest_name;
	}

	public String getMeet_gender() {
		return meet_gender;
	}

	public void setMeet_gender(String meet_gender) {
		this.meet_gender = meet_gender;
	}

	public Integer getMeet_nop() {
		return meet_nop;
	}

	public void setMeet_nop(Integer meet_nop) {
		this.meet_nop = meet_nop;
	}

	public Integer getMeet_age() {
		return meet_age;
	}

	public void setMeet_age(Integer meet_age) {
		this.meet_age = meet_age;
	}

	public Date getMeet_date() {
		return meet_date;
	}

	public void setMeet_date(Date meet_date) {
		this.meet_date = meet_date;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	@Override
	public String toString() {
		return "MeetVO [meet_no=" + meet_no + ", meet_image=" + meet_image + ", meet_name=" + meet_name
				+ ", meet_description=" + meet_description + ", meet_city=" + meet_city + ", meet_county=" + meet_county
				+ ", meet_interest_name=" + meet_interest_name + ", meet_gender=" + meet_gender + ", meet_nop="
				+ meet_nop + ", meet_age=" + meet_age + ", meet_date=" + meet_date + ", user_no=" + user_no + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(meet_age, meet_city, meet_county, meet_date, meet_description, meet_gender, meet_image,
				meet_interest_name, meet_name, meet_no, meet_nop, user_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetVO other = (MeetVO) obj;
		return Objects.equals(meet_age, other.meet_age) && Objects.equals(meet_city, other.meet_city)
				&& Objects.equals(meet_county, other.meet_county) && Objects.equals(meet_date, other.meet_date)
				&& Objects.equals(meet_description, other.meet_description)
				&& Objects.equals(meet_gender, other.meet_gender) && Objects.equals(meet_image, other.meet_image)
				&& Objects.equals(meet_interest_name, other.meet_interest_name)
				&& Objects.equals(meet_name, other.meet_name) && Objects.equals(meet_no, other.meet_no)
				&& Objects.equals(meet_nop, other.meet_nop) && Objects.equals(user_no, other.user_no);
	}
	
	
	
	
}
