package test.com.event.model;

import java.sql.Timestamp;
import java.util.Objects;

public class EventVO {
	private String event_no;
	private String event_title;
	private String event_description;
	private Timestamp event_date;
	private Timestamp event_d_day;
	private String activity_no;
	private String user_no;
	
	
	public EventVO() {}


	public EventVO(String event_no, String event_title, String event_description, Timestamp event_date,
			Timestamp event_d_day, String activity_no, String user_no) {
		super();
		this.event_no = event_no;
		this.event_title = event_title;
		this.event_description = event_description;
		this.event_date = event_date;
		this.event_d_day = event_d_day;
		this.activity_no = activity_no;
		this.user_no = user_no;
	}


	public String getEvent_no() {
		return event_no;
	}


	public void setEvent_no(String event_no) {
		this.event_no = event_no;
	}


	public String getEvent_title() {
		return event_title;
	}


	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}


	public String getEvent_description() {
		return event_description;
	}


	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}


	public Timestamp getEvent_date() {
		return event_date;
	}


	public void setEvent_date(Timestamp event_date) {
		this.event_date = event_date;
	}


	public Timestamp getEvent_d_day() {
		return event_d_day;
	}


	public void setEvent_d_day(Timestamp event_d_day) {
		this.event_d_day = event_d_day;
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
	public int hashCode() {
		return Objects.hash(activity_no, event_d_day, event_date, event_description, event_no, event_title, user_no);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventVO other = (EventVO) obj;
		return Objects.equals(activity_no, other.activity_no) && Objects.equals(event_d_day, other.event_d_day)
				&& Objects.equals(event_date, other.event_date)
				&& Objects.equals(event_description, other.event_description)
				&& Objects.equals(event_no, other.event_no) && Objects.equals(event_title, other.event_title)
				&& Objects.equals(user_no, other.user_no);
	}


	@Override
	public String toString() {
		return "EventVO [event_no=" + event_no + ", event_title=" + event_title + ", event_description="
				+ event_description + ", event_date=" + event_date + ", event_d_day=" + event_d_day + ", activity_no="
				+ activity_no + ", user_no=" + user_no + "]";
	}
	
	
}
