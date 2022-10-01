package test.com.vote.model;

import java.util.Objects;

public class VoteListVO {
	private String vote_no;
	private String vote_title; 
	private String vote_description;
	private String vote_eod; 
	private String vote_state; 
	private String user_no; 
	private String activity_no;
	private Integer user_cnt; 
	
	public VoteListVO() {
		
	}

	public VoteListVO(String vote_no, String vote_title, String vote_description, String vote_eod, String vote_state,
			String user_no, String activity_no, Integer user_cnt) {
		super();
		this.vote_no = vote_no;
		this.vote_title = vote_title;
		this.vote_description = vote_description;
		this.vote_eod = vote_eod;
		this.vote_state = vote_state;
		this.user_no = user_no;
		this.activity_no = activity_no;
		this.user_cnt = user_cnt;
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

	public String getVote_eod() {
		return vote_eod;
	}

	public void setVote_eod(String vote_eod) {
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

	public String getActivity_no() {
		return activity_no;
	}

	public void setActivity_no(String activity_no) {
		this.activity_no = activity_no;
	}

	public Integer getUser_cnt() {
		return user_cnt;
	}

	public void setUser_cnt(Integer user_cnt) {
		this.user_cnt = user_cnt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activity_no, user_cnt, user_no, vote_description, vote_eod, vote_no, vote_state,
				vote_title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoteListVO other = (VoteListVO) obj;
		return Objects.equals(activity_no, other.activity_no) && Objects.equals(user_cnt, other.user_cnt)
				&& Objects.equals(user_no, other.user_no) && Objects.equals(vote_description, other.vote_description)
				&& Objects.equals(vote_eod, other.vote_eod) && Objects.equals(vote_no, other.vote_no)
				&& Objects.equals(vote_state, other.vote_state) && Objects.equals(vote_title, other.vote_title);
	}

	@Override
	public String toString() {
		return "VoteVO2 [vote_no=" + vote_no + ", vote_title=" + vote_title + ", vote_description=" + vote_description
				+ ", vote_eod=" + vote_eod + ", vote_state=" + vote_state + ", user_no=" + user_no + ", activity_no="
				+ activity_no + ", user_cnt=" + user_cnt + "]";
	}

	

}
