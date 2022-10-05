package test.com.activity.model;

public interface ActivityDB {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "mab_test_db";
	String PASSWORD = "test1234";
	
	
	public static final String SQL_ACTIVITY_INSERT = "insert into test_activity"
			+ "(activity_no, activity_image, activity_name, activity_description, activity_city, activity_county, activity_interest_name, "
			+ "activity_gender, activity_nop, activity_age, activity_date, user_no, meet_no)"
			+ "values('A'||SEQ_TEST_ACTIVITY.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ? , ?)";
	
	String SQL_ACTIVITY_UPDATE = "update test_activity set activity_image=?, activity_name=?, activity_description=?,"
			+ "activity_city=?, activity_county=?, activity_interest_name=?, activity_gender=?, activity_nop=?, activity_age=?"
			+ "where activity_no=?";
	
	String SQL_ACTIVITY_SELECT_ONE = "select activity_no, activity_image, activity_name, activity_description, activity_city, activity_county, activity_interest_name, activity_gender, activity_nop, activity_age  from test_activity where activity_no=?";
	
	String SQL_ACTIVITY_DELETE = "delete from test_activity where activity_no=?";
	
	String SQL_ACTIVITY_SELECT_ONE_MAIN_FEED = "SELECT * FROM ACTI_REG_LIKE_NICK_VIEW WHERE ACTIVITY_NO = ?";
	String SQL_ACTIVITY_SELECT_REGISTERED ="select user_no from test_activity_registered where activity_no=?";
	String SQL_ACTIVITY_SELECT_LAST_NO = "SELECT * FROM (SELECT ACTIVITY_NO FROM TEST_ACTIVITY ORDER BY ACTIVITY_NO DESC) WHERE ROWNUM = 1";
	String SQL_ACTIVITY_REGISTERED = "INSERT INTO TEST_ACTIVITY_REGISTERED(registered_no, activity_no, user_no) values ('AR'||SEQ_TEST_ACTIVITY_R.nextval, ?, ?)";
	String SQL_ACTIVITY_WITHDRAWAL = "DELETE FROM TEST_ACTIVITY_REGISTERED WHERE ACTIVITY_NO=? AND USER_NO=?";
	
	String SQL_INSERT_LIKE
		= "INSERT INTO TEST_ACTIVITY_LIKE(ACTIVITY_LIKE_NO, ACTIVITY_NO, USER_NO) "
		+ "VALUES ('AL'||SEQ_TEST_ACTIVITY_L.NEXTVAL, ?, ?)";
	String SQL_DELETE_LIKE
		= "DELETE FROM TEST_ACTIVITY_LIKE WHERE ACTIVITY_NO = ? AND USER_NO = ?";
	
	String SQL_SELECT_ALL_10 
		= "select * from ( "
				+ "select activity_no, activity_image, activity_name, activity_description, activity_city, activity_county, activity_interest_name, activity_gender, activity_nop, activity_age, activity_date, user_no, meet_no, like_cnt, user_cnt "
				+ "from activity_join_view order by like_cnt desc, activity_no desc) "
		+ "where rownum between 1 and 10";
	String SQL_SELECT_CATE_10 = "select activity_no, activity_image, activity_name, activity_description, activity_city, activity_county, activity_interest_name, activity_gender, activity_nop, activity_age, activity_date, user_no, meet_no, like_cnt, user_cnt "
			+ "from activity_join_view "
			+ "where activity_interest_name = ? AND rownum between 1 and 10"
			+ "order by activity_no";
	String SQL_SELECT_ALL_LIKE_ACTIVITY_NO = "SELECT ACTIVITY_NO FROM TEST_ACTIVITY_LIKE WHERE USER_NO = ? ";
	String SQL_SELECT_ALL_FEED 
		= "SELECT * "
		+ "FROM ACTIVITY_JOIN_VIEW "
		+ "WHERE MEET_NO = ? "
		+ "ORDER BY ACTIVITY_NO DESC";

	String SQL_SELECT_ALL_MORE_LIKE
		= "SELECT * "
		+ "FROM ACTI_USER_LIKE_VIEW "
		+ "WHERE ACTIVITY_NAME LIKE ? AND ACTIVITY_INTEREST_NAME = ?"
		+ "ORDER BY LIKE_CNT DESC, ACTIVITY_NO ASC";
	
	String SQL_SELECT_ALL_MORE_LIKE_ALL
		= "SELECT * "	
			+ "FROM ACTI_USER_LIKE_VIEW "
			+ "WHERE ACTIVITY_NAME LIKE ?"
			+ "ORDER BY LIKE_CNT DESC, ACTIVITY_NO ASC";
	
	String SQL_ACTIVITY_SELECT_LIKE = "SELECT COUNT(USER_NO) FROM TEST_ACTIVITY_LIKE WHERE USER_NO = 'U1002' AND ACTIVITY_NO ='A1002' GROUP BY USER_NO";
}
