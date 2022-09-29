package test.com.meet.model;

import java.util.Date;
import java.util.Objects;

public class MeetVO3 {
	private String meet_no;
	private String meet_image;
	private String meet_name;
	private String meet_description;
	private String meet_county;
	private String meet_interest_name;
	private String meet_gender;
	private Integer meet_nop;
	private Integer meet_age;
	private Date meet_date;
	private String user_no;
	private String user_nickname;
	private Integer like_cnt;
	private Integer user_cnt;
	
	
	public MeetVO3() {}


	public MeetVO3(String meet_no, String meet_image, String meet_name, String meet_description, String meet_county,
			String meet_interest_name, String meet_gender, Integer meet_nop, Integer meet_age, Date meet_date,
			String user_no, String user_nickname, Integer like_cnt, Integer user_cnt) {
		super();
		this.meet_no = meet_no;
		this.meet_image = meet_image;
		this.meet_name = meet_name;
		this.meet_description = meet_description;
		this.meet_county = meet_county;
		this.meet_interest_name = meet_interest_name;
		this.meet_gender = meet_gender;
		this.meet_nop = meet_nop;
		this.meet_age = meet_age;
		this.meet_date = meet_date;
		this.user_no = user_no;
		this.user_nickname = user_nickname;
		this.like_cnt = like_cnt;
		this.user_cnt = user_cnt;
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
	
	public String getUser_nickname() {
		return user_nickname;
	}


	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
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
	public int hashCode() {
		return Objects.hash(like_cnt, meet_age, meet_county, meet_date, meet_description, meet_gender, meet_image,
				meet_interest_name, meet_name, meet_no, meet_nop, user_cnt, user_nickname, user_no);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetVO3 other = (MeetVO3) obj;
		return Objects.equals(like_cnt, other.like_cnt) && Objects.equals(meet_age, other.meet_age)
				&& Objects.equals(meet_county, other.meet_county) && Objects.equals(meet_date, other.meet_date)
				&& Objects.equals(meet_description, other.meet_description)
				&& Objects.equals(meet_gender, other.meet_gender) && Objects.equals(meet_image, other.meet_image)
				&& Objects.equals(meet_interest_name, other.meet_interest_name)
				&& Objects.equals(meet_name, other.meet_name) && Objects.equals(meet_no, other.meet_no)
				&& Objects.equals(meet_nop, other.meet_nop) && Objects.equals(user_cnt, other.user_cnt)
				&& Objects.equals(user_nickname, other.user_nickname) && Objects.equals(user_no, other.user_no);
	}


	@Override
	public String toString() {
		return "MeetVO3 [meet_no=" + meet_no + ", meet_image=" + meet_image + ", meet_name=" + meet_name
				+ ", meet_description=" + meet_description + ", meet_county=" + meet_county + ", meet_interest_name="
				+ meet_interest_name + ", meet_gender=" + meet_gender + ", meet_nop=" + meet_nop + ", meet_age="
				+ meet_age + ", meet_date=" + meet_date + ", user_no=" + user_no + ", user_nickname=" + user_nickname
				+ ", like_cnt=" + like_cnt + ", user_cnt=" + user_cnt + "]";
	}

	


	

}
