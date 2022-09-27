package test.com.meet.model;

public interface MeetDB {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String TEST_USER = "mab_test_db";
	String TEST_PASSWORD = "test1234";
	
	String SQL_SELECT_ALL_LIKE 
		= "SELECT meet_no, meet_image, meet_name, meet_description, meet_county, meet_interest_name, meet_gender, meet_nop, meet_age, meet_date, user_no, like_cnt, user_cnt "
		+ "FROM MEET_JOIN_VIEW "
		+ "WHERE ROWNUM BETWEEN 1 AND 10 "
		+ "ORDER BY LIKE_CNT ASC";
	String SQL_SELECT_ALL_INTEREST 
		= "SELECT meet_no, meet_image, meet_name, meet_description, meet_county, meet_interest_name, meet_gender, meet_nop, meet_age, meet_date, user_no, like_cnt, user_cnt "
		+ "FROM MEET_JOIN_VIEW "
		+ "WHERE MEET_INTEREST_NAME = ? AND ROWNUM BETWEEN 1 AND 10 "
		+ "ORDER BY LIKE_CNT ASC";
	String SQL_SELECT_ALL_COUNTY 
		= "SELECT meet_no, meet_image, meet_name, meet_description, meet_county, meet_interest_name, meet_gender, meet_nop, meet_age, meet_date, user_no, like_cnt, user_cnt "
		+ "FROM MEET_JOIN_VIEW "
		+ "WHERE MEET_COUNTY = ? AND ROWNUM BETWEEN 1 AND 10 "
		+ "ORDER BY LIKE_CNT ASC";
	
}
