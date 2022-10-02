package test.com.comment.model;

import java.util.Date;
import java.util.Objects;

public class CommentVO {
	
	private String comment_no;
	private String mother_no;
	private Date comment_date;
	private String comment_content;
	private String board_no;
	private String user_no;
	private String user_nickname;
	
	public CommentVO() {}

	public CommentVO(String comment_no, String mother_no, Date comment_date, String comment_content, String board_no,
			String user_no, String user_nickname) {
		super();
		this.comment_no = comment_no;
		this.mother_no = mother_no;
		this.comment_date = comment_date;
		this.comment_content = comment_content;
		this.board_no = board_no;
		this.user_no = user_no;
		this.user_nickname = user_nickname;
	}

	public String getComment_no() {
		return comment_no;
	}

	public void setComment_no(String comment_no) {
		this.comment_no = comment_no;
	}

	public String getMother_no() {
		return mother_no;
	}

	public void setMother_no(String mother_no) {
		this.mother_no = mother_no;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public String getBoard_no() {
		return board_no;
	}

	public void setBoard_no(String board_no) {
		this.board_no = board_no;
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
		return "CommentVO [comment_no=" + comment_no + ", mother_no=" + mother_no + ", comment_date=" + comment_date
				+ ", comment_content=" + comment_content + ", board_no=" + board_no + ", user_no=" + user_no
				+ ", user_nickname=" + user_nickname + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(board_no, comment_content, comment_date, comment_no, mother_no, user_nickname, user_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentVO other = (CommentVO) obj;
		return Objects.equals(board_no, other.board_no) && Objects.equals(comment_content, other.comment_content)
				&& Objects.equals(comment_date, other.comment_date) && Objects.equals(comment_no, other.comment_no)
				&& Objects.equals(mother_no, other.mother_no) && Objects.equals(user_nickname, other.user_nickname)
				&& Objects.equals(user_no, other.user_no);
	}

	
	
}
