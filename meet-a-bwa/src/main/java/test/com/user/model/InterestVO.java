package test.com.user.model;

import java.util.Objects;

public class InterestVO {

	private String interest_no;
	private String interest_name;
	private String user_no;
	
	public InterestVO() {}

	public InterestVO(String interest_no, String interest_name, String user_no) {
		super();
		this.interest_no = interest_no;
		this.interest_name = interest_name;
		this.user_no = user_no;
	}

	public String getInterest_no() {
		return interest_no;
	}

	public void setInterest_no(String interest_no) {
		this.interest_no = interest_no;
	}

	public String getInterest_name() {
		return interest_name;
	}

	public void setInterest_name(String interest_name) {
		this.interest_name = interest_name;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	@Override
	public int hashCode() {
		return Objects.hash(interest_name, interest_no, user_no);
	}
	
	@Override
	public String toString() {
		return "InterestVO [interest_no=" + interest_no + ", interest_name=" + interest_name + ", user_no=" + user_no
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InterestVO other = (InterestVO) obj;
		return Objects.equals(interest_name, other.interest_name) && Objects.equals(interest_no, other.interest_no)
				&& Objects.equals(user_no, other.user_no);
	}
	
	
}
