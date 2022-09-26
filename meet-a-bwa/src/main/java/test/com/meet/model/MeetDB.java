package test.com.meet.model;

public interface MeetDB {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String TEST_USER = "mab_test_db";
	String TEST_PASSWORD = "test1234";
	
	String SQL_SELECT_ALL_LIKE = "select * from main_init_view where rownum between 1 and 10 order by like_cnt asc";
	String SQL_SELECT_ALL_INTEREST = "select * from main_init_view "
			+ "where MEET_INTEREST_NAME = ? AND rownum between 1 and 10"
			+ "order by like_cnt asc";
	String SQL_SELECT_ALL_COUNTY = "select * from main_init_view "
			+ "where MEET_COUNTY = ? AND rownum between 1 and 10 "
			+ "order by like_cnt asc";
	
}
