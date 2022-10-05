/**
 * 
 * @author 김예은
 *
 */
package test.com.vote.model;

import java.util.Objects;

public class VoteResultVO {

	private String vote_result_no;
	private String vote_no;
	private String user_no;
	private String content_no;
	
	
	public VoteResultVO() {
	}


	public VoteResultVO(String vote_result_no, String vote_no, String user_no, String content_no) {
		super();
		this.vote_result_no = vote_result_no;
		this.vote_no = vote_no;
		this.user_no = user_no;
		this.content_no = content_no;
	}


	public String getVote_result_no() {
		return vote_result_no;
	}


	public void setVote_result_no(String vote_result_no) {
		this.vote_result_no = vote_result_no;
	}


	public String getVote_no() {
		return vote_no;
	}


	public void setVote_no(String vote_no) {
		this.vote_no = vote_no;
	}


	public String getUser_no() {
		return user_no;
	}


	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}


	public String getContent_no() {
		return content_no;
	}


	public void setContent_no(String content_no) {
		this.content_no = content_no;
	}


	@Override
	public int hashCode() {
		return Objects.hash(content_no, user_no, vote_no, vote_result_no);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoteResultVO other = (VoteResultVO) obj;
		return Objects.equals(content_no, other.content_no) && Objects.equals(user_no, other.user_no)
				&& Objects.equals(vote_no, other.vote_no) && Objects.equals(vote_result_no, other.vote_result_no);
	}


	@Override
	public String toString() {
		return "VoteResult [vote_result_no=" + vote_result_no + ", vote_no=" + vote_no + ", user_no=" + user_no
				+ ", content_no=" + content_no + "]";
	}
	
	
	
}
