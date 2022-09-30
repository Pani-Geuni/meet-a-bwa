package test.com.meet.model;

import java.util.Objects;

public class MeetUserVO {
	private String registered_no;
	private String meet_no;
	private String user_no;
	private String user_nickname;
	public String getRegistered_no() {
		return registered_no;
	}
	public void setRegistered_no(String registered_no) {
		this.registered_no = registered_no;
	}
	public String getMeet_no() {
		return meet_no;
	}
	public void setMeet_no(String meet_no) {
		this.meet_no = meet_no;
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
	
	@Override
	public String toString() {
		return "MeetUserVO [registered_no=" + registered_no + ", meet_no=" + meet_no + ", user_no=" + user_no
				+ ", user_nickname=" + user_nickname + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(meet_no, registered_no, user_nickname, user_no);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetUserVO other = (MeetUserVO) obj;
		return Objects.equals(meet_no, other.meet_no) && Objects.equals(registered_no, other.registered_no)
				&& Objects.equals(user_nickname, other.user_nickname) && Objects.equals(user_no, other.user_no);
	}
	
	
}
