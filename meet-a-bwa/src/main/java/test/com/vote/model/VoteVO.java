/**
 * 
 * @author 김예은
 *
 */
package test.com.vote.model;

import java.sql.Timestamp;
import java.util.Objects;

public class VoteVO {
	private String vote_no;
	private String vote_title; 
	private String vote_description;
	private Timestamp vote_eod; 
	private String vote_state; 
	private String user_no; 
	private String meet_no; 
	private String activity_no;
	
	public VoteVO() {
		
	}

	public VoteVO(String vote_no, String vote_title, String vote_description, Timestamp vote_eod, String vote_state,
			String user_no, String meet_no, String activity_no) {
		super();
		this.vote_no = vote_no;
		this.vote_title = vote_title;
		this.vote_description = vote_description;
		this.vote_eod = vote_eod;
		this.vote_state = vote_state;
		this.user_no = user_no;
		this.meet_no = meet_no;
		this.activity_no = activity_no;
	}

	public String getVote_no() {
		return vote_no;
	}

	public void setVote_no(String vote_no) {
		this.vote_no = vote_no;
	}

	public String getVote_title() {
		return vote_title;
	}

	public void setVote_title(String vote_title) {
		this.vote_title = vote_title;
	}

	public String getVote_description() {
		return vote_description;
	}

	public void setVote_description(String vote_description) {
		this.vote_description = vote_description;
	}

	public Timestamp getVote_eod() {
		return vote_eod;
	}

	public void setVote_eod(Timestamp vote_eod) {
		this.vote_eod = vote_eod;
	}

	public String getVote_state() {
		return vote_state;
	}

	public void setVote_state(String vote_state) {
		this.vote_state = vote_state;
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

	public String getActivity_no() {
		return activity_no;
	}

	public void setActivity_no(String activity_no) {
		this.activity_no = activity_no;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activity_no, meet_no, user_no, vote_description, vote_eod, vote_no, vote_state, vote_title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoteVO other = (VoteVO) obj;
		return Objects.equals(activity_no, other.activity_no) && Objects.equals(meet_no, other.meet_no)
				&& Objects.equals(user_no, other.user_no) && Objects.equals(vote_description, other.vote_description)
				&& Objects.equals(vote_eod, other.vote_eod) && Objects.equals(vote_no, other.vote_no)
				&& Objects.equals(vote_state, other.vote_state) && Objects.equals(vote_title, other.vote_title);
	}

	@Override
	public String toString() {
		return "VoteVO [vote_no=" + vote_no + ", vote_title=" + vote_title + ", vote_description=" + vote_description
				+ ", vote_eod=" + vote_eod + ", vote_state=" + vote_state + ", user_no=" + user_no + ", meet_no="
				+ meet_no + ", activity_no=" + activity_no + "]";
	}

	

}
