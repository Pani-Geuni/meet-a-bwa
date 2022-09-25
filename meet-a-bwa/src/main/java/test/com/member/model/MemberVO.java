package test.com.member.model;
import java.util.Date;
import java.util.Objects;

public class MemberVO {

	private String member_no;
	private String member_image; 
	private String member_id; 
	private String member_pw;
	private String member_name;
	private String member_nickname;
	private String member_email;
	private String member_tel;
	private Date member_birth;
	private String member_gender;
	private String member_city;
	private String member_county;
	private String member_state;
	private String member_interest;
	
	public MemberVO() {}

	public MemberVO(String member_no, String member_image, String member_id, String member_pw, String member_name,
			String member_nickname, String member_email, String member_tel, Date member_birth, String member_gender,
			String member_city, String member_county, String member_state, String member_interest) {
		super();
		this.member_no = member_no;
		this.member_image = member_image;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_nickname = member_nickname;
		this.member_email = member_email;
		this.member_tel = member_tel;
		this.member_birth = member_birth;
		this.member_gender = member_gender;
		this.member_city = member_city;
		this.member_county = member_county;
		this.member_state = member_state;
		this.member_interest = member_interest;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public String getMember_image() {
		return member_image;
	}

	public void setMember_image(String member_image) {
		this.member_image = member_image;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_tel() {
		return member_tel;
	}

	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}

	public Date getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(Date member_birth) {
		this.member_birth = member_birth;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public String getMember_city() {
		return member_city;
	}

	public void setMember_city(String member_city) {
		this.member_city = member_city;
	}

	public String getMember_county() {
		return member_county;
	}

	public void setMember_county(String member_county) {
		this.member_county = member_county;
	}

	public String getMember_state() {
		return member_state;
	}

	public void setMember_state(String member_state) {
		this.member_state = member_state;
	}
	
	public String getMember_interest() {
		return member_interest;
	}
	
	public void setMember_interest(String member_interest) {
		this.member_interest = member_interest;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(member_birth, member_city, member_county, member_email, member_gender, member_id,
				member_image, member_interest, member_name, member_nickname, member_no, member_pw, member_state,
				member_tel);
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
		return Objects.equals(member_birth, other.member_birth) && Objects.equals(member_city, other.member_city)
				&& Objects.equals(member_county, other.member_county)
				&& Objects.equals(member_email, other.member_email)
				&& Objects.equals(member_gender, other.member_gender) && Objects.equals(member_id, other.member_id)
				&& Objects.equals(member_image, other.member_image)
				&& Objects.equals(member_interest, other.member_interest)
				&& Objects.equals(member_name, other.member_name)
				&& Objects.equals(member_nickname, other.member_nickname) && Objects.equals(member_no, other.member_no)
				&& Objects.equals(member_pw, other.member_pw) && Objects.equals(member_state, other.member_state)
				&& Objects.equals(member_tel, other.member_tel);
	}

	@Override
	public String toString() {
		return "MemberVO [member_no=" + member_no + ", member_image=" + member_image + ", member_id=" + member_id
				+ ", member_pw=" + member_pw + ", member_name=" + member_name + ", member_nickname=" + member_nickname
				+ ", member_email=" + member_email + ", member_tel=" + member_tel + ", member_birth=" + member_birth
				+ ", member_gender=" + member_gender + ", member_city=" + member_city + ", member_county="
				+ member_county + ", member_state=" + member_state + ", member_interest=" + member_interest + "]";
	}

	

}
