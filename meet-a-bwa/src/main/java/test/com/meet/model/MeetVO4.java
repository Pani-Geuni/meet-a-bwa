package test.com.meet.model;

import java.util.Objects;

public class MeetVO4 {
	
	// my list를 불러오기 위한 VO
	private String registered_no;
	private String user_no;
	private String meet_no;
	private String meet_name;
	private String meet_description;
	private String meet_county;
	private String meet_interest_name;
	private String meet_gender;
	private Integer meet_nop;
	private Integer meet_age;
	private Integer like_cnt;
	private Integer user_cnt;
	public String getRegistered_no() {
		return registered_no;
	}
	public void setRegistered_no(String registered_no) {
		this.registered_no = registered_no;
	}
	public String getUser_no() {
		return user_no;
	}
	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	public String getMeet_no() {
		return meet_no;
	}
	public void setMeet_no(String meet_no) {
		this.meet_no = meet_no;
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
	public Integer getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(Integer like_cnt) {
		this.like_cnt = like_cnt;
	}
	public Integer getUser_cnt() {
		return user_cnt;
	}
	public void setUser_cnt(Integer user_cnt) {
		this.user_cnt = user_cnt;
	}
	@Override
	public String toString() {
		return "MeetVO4 [registered_no=" + registered_no + ", user_no=" + user_no + ", meet_no=" + meet_no
				+ ", meet_name=" + meet_name + ", meet_description=" + meet_description + ", meet_county=" + meet_county
				+ ", meet_interest_name=" + meet_interest_name + ", meet_gender=" + meet_gender + ", meet_nop="
				+ meet_nop + ", meet_age=" + meet_age + ", like_cnt=" + like_cnt + ", user_cnt=" + user_cnt + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(like_cnt, meet_age, meet_county, meet_description, meet_gender, meet_interest_name,
				meet_name, meet_no, meet_nop, registered_no, user_cnt, user_no);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetVO4 other = (MeetVO4) obj;
		return Objects.equals(like_cnt, other.like_cnt) && Objects.equals(meet_age, other.meet_age)
				&& Objects.equals(meet_county, other.meet_county)
				&& Objects.equals(meet_description, other.meet_description)
				&& Objects.equals(meet_gender, other.meet_gender)
				&& Objects.equals(meet_interest_name, other.meet_interest_name)
				&& Objects.equals(meet_name, other.meet_name) && Objects.equals(meet_no, other.meet_no)
				&& Objects.equals(meet_nop, other.meet_nop) && Objects.equals(registered_no, other.registered_no)
				&& Objects.equals(user_cnt, other.user_cnt) && Objects.equals(user_no, other.user_no);
	}
	
	
	
}
