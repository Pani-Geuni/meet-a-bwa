package test.com.activity.model;

public interface ActivityDB2 {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "mab_test_db";
	String PASSWORD = "test1234";
	
	String SQL_INSERT_LIKE
		= "INSERT INTO TEST_ACTIVITY_LIKE(ACTIVITY_LIKE_NO, ACTIVITY_NO, USER_NO) "
		+ "VALUES ('AL'||SEQ_TEST_ACTIVITY_L.NEXTVAL, ?, ?)";
	String SQL_DELETE_LIKE
		= "DELETE FROM TEST_ACTIVITY_LIKE WHERE ACTIVITY_NO = ? AND USER_NO = ?";

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
	
	
	String SQL_SELECT_ALL_FEED 
		= "SELECT * "
		+ "FROM ACTIVITY_JOIN_VIEW "
		+ "WHERE MEET_NO = ? "
		+ "ORDER BY ACTIVITY_NO DESC";
}
