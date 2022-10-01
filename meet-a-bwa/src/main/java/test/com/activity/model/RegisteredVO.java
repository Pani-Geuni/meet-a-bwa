package test.com.activity.model;

import java.util.Objects;

public class RegisteredVO {
	private String registered_no;
	private String activity_no;
	private String user_no;
	
	public RegisteredVO() {}

	public RegisteredVO(String registered_no, String activity_no, String user_no) {
		super();
		this.registered_no = registered_no;
		this.activity_no = activity_no;
		this.user_no = user_no;
	}

	public String getRegistered_no() {
		return registered_no;
	}

	public void setRegistered_no(String registered_no) {
		this.registered_no = registered_no;
	}

	public String getActivity_no() {
		return activity_no;
	}

	public void setActivity_no(String activity_no) {
		this.activity_no = activity_no;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	@Override
	public String toString() {
		return "ActivityRegisteredVO [registered_no=" + registered_no + ", activity_no=" + activity_no + ", user_no="
				+ user_no + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(activity_no, registered_no, user_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisteredVO other = (RegisteredVO) obj;
		return Objects.equals(activity_no, other.activity_no) && Objects.equals(registered_no, other.registered_no)
				&& Objects.equals(user_no, other.user_no);
	}
	
	
	
}
