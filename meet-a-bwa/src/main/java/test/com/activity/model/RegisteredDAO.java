package test.com.activity.model;

public interface RegisteredDAO {

	int activity_registered(String user_no, String activity_no);
	int activity_withdrawal(String user_no, String activity_no);

}
