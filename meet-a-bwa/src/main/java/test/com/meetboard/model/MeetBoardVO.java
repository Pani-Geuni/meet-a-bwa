package test.com.meetboard.model;

import java.util.Date;
import java.util.Objects;

public class MeetBoardVO {
	
	private String board_no;
	private String board_title;
	private String board_content;
	private Date board_date;
	private String user_no;
	private String meet_no;
	
	public MeetBoardVO() {}

	public MeetBoardVO(String board_no, String board_title, String board_content, Date board_date, String user_no,
			String meet_no) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_date = board_date;
		this.user_no = user_no;
		this.meet_no = meet_no;
	}

	public String getBoard_no() {
		return board_no;
	}

	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
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

	@Override
	public String toString() {
		return "MeetBoardVO [board_no=" + board_no + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_date=" + board_date + ", user_no=" + user_no + ", meet_no=" + meet_no + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(board_content, board_date, board_no, board_title, meet_no, user_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetBoardVO other = (MeetBoardVO) obj;
		return Objects.equals(board_content, other.board_content) && Objects.equals(board_date, other.board_date)
				&& Objects.equals(board_no, other.board_no) && Objects.equals(board_title, other.board_title)
				&& Objects.equals(meet_no, other.meet_no) && Objects.equals(user_no, other.user_no);
	}
	
	
}
