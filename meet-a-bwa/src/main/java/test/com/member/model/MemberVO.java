package test.com.member.model;
import java.util.Date;
import java.util.Objects;

public class MemberVO {

	private String user_no;
	private String user_image; 
	private String user_id; 
	private String user_pw;
	private String user_name;
	private String user_nickname;
	private String user_email;
	private String user_tel;
	private Date user_birth;
	private String user_gender;
	private String user_city;
	private String user_county;
	private String user_state;
	private String user_interest;
	
	public MemberVO() {}

	public MemberVO(String user_no, String user_image, String user_id, String user_pw, String user_name,
			String user_nickname, String user_email, String user_tel, Date user_birth, String user_gender,
			String user_city, String user_county, String user_state, String user_interest) {
		super();
		this.user_no = user_no;
		this.user_image = user_image;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_nickname = user_nickname;
		this.user_email = user_email;
		this.user_tel = user_tel;
		this.user_birth = user_birth;
		this.user_gender = user_gender;
		this.user_city = user_city;
		this.user_county = user_county;
		this.user_state = user_state;
		this.user_interest = user_interest;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public Date getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(Date user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_city() {
		return user_city;
	}

	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}

	public String getUser_county() {
		return user_county;
	}

	public void setUser_county(String user_county) {
		this.user_county = user_county;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public String getUser_interest() {
		return user_interest;
	}

	public void setUser_interest(String user_interest) {
		this.user_interest = user_interest;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user_birth, user_city, user_county, user_email, user_gender, user_id, user_image,
				user_interest, user_name, user_nickname, user_no, user_pw, user_state, user_tel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(user_birth, other.user_birth) && Objects.equals(user_city, other.user_city)
				&& Objects.equals(user_county, other.user_county) && Objects.equals(user_email, other.user_email)
				&& Objects.equals(user_gender, other.user_gender) && Objects.equals(user_id, other.user_id)
				&& Objects.equals(user_image, other.user_image) && Objects.equals(user_interest, other.user_interest)
				&& Objects.equals(user_name, other.user_name) && Objects.equals(user_nickname, other.user_nickname)
				&& Objects.equals(user_no, other.user_no) && Objects.equals(user_pw, other.user_pw)
				&& Objects.equals(user_state, other.user_state) && Objects.equals(user_tel, other.user_tel);
	}

	@Override
	public String toString() {
		return "MemberVO [user_no=" + user_no + ", user_image=" + user_image + ", user_id=" + user_id + ", user_pw="
				+ user_pw + ", user_name=" + user_name + ", user_nickname=" + user_nickname + ", user_email="
				+ user_email + ", user_tel=" + user_tel + ", user_birth=" + user_birth + ", user_gender=" + user_gender
				+ ", user_city=" + user_city + ", user_county=" + user_county + ", user_state=" + user_state
				+ ", user_interest=" + user_interest + "]";
	}
	
	

}
