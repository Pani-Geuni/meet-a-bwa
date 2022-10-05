/**
 * 
 * @author 김예은
 *
 */
package test.com.vote.model;

import java.util.Objects;

public class VoteContentVO {
	private String content_no;
	private String vote_no;
	private String vote_content;
	
	public VoteContentVO() {}

	public VoteContentVO(String content_no, String vote_no, String vote_content) {
		super();
		this.content_no = content_no;
		this.vote_no = vote_no;
		this.vote_content = vote_content;
	}

	public String getContent_no() {
		return content_no;
	}

	public void setContent_no(String content_no) {
		this.content_no = content_no;
	}

	public String getVote_no() {
		return vote_no;
	}

	public void setVote_no(String vote_no) {
		this.vote_no = vote_no;
	}

	public String getVote_content() {
		return vote_content;
	}

	public void setVote_content(String vote_content) {
		this.vote_content = vote_content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content_no, vote_content, vote_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoteContentVO other = (VoteContentVO) obj;
		return Objects.equals(content_no, other.content_no) && Objects.equals(vote_content, other.vote_content)
				&& Objects.equals(vote_no, other.vote_no);
	}

	@Override
	public String toString() {
		return "VoteContentVO [content_no=" + content_no + ", vote_no=" + vote_no + ", vote_content=" + vote_content
				+ "]";
	}

	
}
