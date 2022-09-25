package test.com.meet.model;

public interface MeetDB {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String TEST_USER = "mab_test_db";
	String TEST_PASSWORD = "test1234";
	
	String SQL_SELECT_ALL_LIKE = "select meet_no, meet_name, meet_description, meet_date, user_no, like_cnt from main_init_view";
	
}
