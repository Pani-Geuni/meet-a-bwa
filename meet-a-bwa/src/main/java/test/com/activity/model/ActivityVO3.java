package test.com.activity.model;

import java.util.Date;
import java.util.Objects;

public class ActivityVO3 {

	private String activity_no;
	private String activity_image;
	private String activity_name;
	private String activity_description;
	private String activity_city;
	private String activity_county;
	private String activity_interest_name;
	private String activity_gender;
	private Integer activity_nop;
	private Integer activity_age;
	private Date activity_date;
	private String user_no;
	private String meet_no;
	private Integer like_cnt;
	private Integer user_cnt;
	private String user_nickname;
	
	public ActivityVO3() {}

	public ActivityVO3(String activity_no, String activity_image, String activity_name, String activity_description,
			String activity_city, String activity_county, String activity_interest_name, String activity_gender,
			Integer activity_nop, Integer activity_age, Date activity_date, String user_no, String meet_no,
			Integer like_cnt, Integer user_cnt, String user_nickname) {
		super();
		this.activity_no = activity_no;
		this.activity_image = activity_image;
		this.activity_name = activity_name;
		this.activity_description = activity_description;
		this.activity_city = activity_city;
		this.activity_county = activity_county;
		this.activity_interest_name = activity_interest_name;
		this.activity_gender = activity_gender;
		this.activity_nop = activity_nop;
		this.activity_age = activity_age;
		this.activity_date = activity_date;
		this.user_no = user_no;
		this.meet_no = meet_no;
		this.like_cnt = like_cnt;
		this.user_cnt = user_cnt;
		this.user_nickname = user_nickname;
	}

	public String getActivity_no() {
		return activity_no;
	}

	public void setActivity_no(String activity_no) {
		this.activity_no = activity_no;
	}

	public String getActivity_image() {
		return activity_image;
	}

	public void setActivity_image(String activity_image) {
		this.activity_image = activity_image;
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public String getActivity_description() {
		return activity_description;
	}

	public void setActivity_description(String activity_description) {
		this.activity_description = activity_description;
	}

	public String getActivity_city() {
		return activity_city;
	}

	public void setActivity_city(String activity_city) {
		this.activity_city = activity_city;
	}

	public String getActivity_county() {
		return activity_county;
	}

	public void setActivity_county(String activity_county) {
		this.activity_county = activity_county;
	}

	public String getActivity_interest_name() {
		return activity_interest_name;
	}

	public void setActivity_interest_name(String activity_interest_name) {
		this.activity_interest_name = activity_interest_name;
	}

	public String getActivity_gender() {
		return activity_gender;
	}

	public void setActivity_gender(String activity_gender) {
		this.activity_gender = activity_gender;
	}

	public Integer getActivity_nop() {
		return activity_nop;
	}

	public void setActivity_nop(Integer activity_nop) {
		this.activity_nop = activity_nop;
	}

	public Integer getActivity_age() {
		return activity_age;
	}

	public void setActivity_age(Integer activity_age) {
		this.activity_age = activity_age;
	}

	public Date getActivity_date() {
		return activity_date;
	}

	public void setActivity_date(Date activity_date) {
		this.activity_date = activity_date;
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

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activity_age, activity_city, activity_county, activity_date, activity_description,
				activity_gender, activity_image, activity_interest_name, activity_name, activity_no, activity_nop,
				like_cnt, meet_no, user_cnt, user_nickname, user_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityVO3 other = (ActivityVO3) obj;
		return Objects.equals(activity_age, other.activity_age) && Objects.equals(activity_city, other.activity_city)
				&& Objects.equals(activity_county, other.activity_county)
				&& Objects.equals(activity_date, other.activity_date)
				&& Objects.equals(activity_description, other.activity_description)
				&& Objects.equals(activity_gender, other.activity_gender)
				&& Objects.equals(activity_image, other.activity_image)
				&& Objects.equals(activity_interest_name, other.activity_interest_name)
				&& Objects.equals(activity_name, other.activity_name) && Objects.equals(activity_no, other.activity_no)
				&& Objects.equals(activity_nop, other.activity_nop) && Objects.equals(like_cnt, other.like_cnt)
				&& Objects.equals(meet_no, other.meet_no) && Objects.equals(user_cnt, other.user_cnt)
				&& Objects.equals(user_nickname, other.user_nickname) && Objects.equals(user_no, other.user_no);
	}

	@Override
	public String toString() {
		return "ActivityVO3 [activity_no=" + activity_no + ", activity_image=" + activity_image + ", activity_name="
				+ activity_name + ", activity_description=" + activity_description + ", activity_city=" + activity_city
				+ ", activity_county=" + activity_county + ", activity_interest_name=" + activity_interest_name
				+ ", activity_gender=" + activity_gender + ", activity_nop=" + activity_nop + ", activity_age="
				+ activity_age + ", activity_date=" + activity_date + ", user_no=" + user_no + ", meet_no=" + meet_no
				+ ", like_cnt=" + like_cnt + ", user_cnt=" + user_cnt + ", user_nickname=" + user_nickname + "]";
	}

	
	
}
