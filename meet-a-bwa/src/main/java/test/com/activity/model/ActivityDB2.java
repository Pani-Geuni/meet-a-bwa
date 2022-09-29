package test.com.activity.model;

public interface ActivityDB2 {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "mab_test_db";
	String PASSWORD = "test1234";

	String SQL_SELECT_ALL_10 = "select activity_no, activity_image, activity_name, activity_description, activity_city, activity_county, activity_interest_name, activity_gender, activity_nop, activity_age, activity_date, user_no, meet_no, like_cnt, user_cnt "
			+ "from activity_join_view "
			+ "where rownum between 1 and 10"
			+ "order by activity_no";
	String SQL_SELECT_CATE_10 = "select activity_no, activity_image, activity_name, activity_description, activity_city, activity_county, activity_interest_name, activity_gender, activity_nop, activity_age, activity_date, user_no, meet_no, like_cnt, user_cnt "
			+ "from activity_join_view "
			+ "where activity_interest_name = ? AND rownum between 1 and 10"
			+ "order by activity_no";
	
	String SQL_SELECT_ALL_LIKE_ACTIVITY_NO
	= "SELECT ACTIVITY_NO FROM TEST_ACTIVITY_LIKE WHERE USER_NO = ? ";
	
}
