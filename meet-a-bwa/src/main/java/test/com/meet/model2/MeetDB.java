package test.com.meet.model2;

public interface MeetDB {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String TEST_USER = "mab_test_db";
	String TEST_PASSWORD = "test1234";
	
	String SQL_MEET_INSERT = "insert into test_meet "
			+ "(meet_no, meet_image, meet_name, meet_description, meet_city, meet_county, meet_interest_name, meet_gender, meet_nop, meet_age, meet_date, user_no) "
			+ "values('M'||SEQ_TEST_MEET.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
	
	String SQL_MEET_SELECT_LAST_NO
		= "SELECT * "
		+ "FROM (SELECT MEET_NO "
		+ "    FROM TEST_MEET "
		+ "    ORDER BY MEET_NO DESC) "
		+ "WHERE ROWNUM = 1";
	
	String SQL_MEET_REGISTERED
		= "INSERT INTO TEST_MEET_REGISTERED(registered_no, meet_no, user_no) values ('MR'||SEQ_TEST_MEET_R.nextval, ?, ?)";
	
	String SQL_MEET_SELECT_ONE = "select meet_no, meet_image, meet_name, meet_description, meet_city, meet_county, meet_interest_name, meet_gender, meet_nop, meet_age  from test_meet where meet_no=?";
	
	String SQL_MEET_UPDATE = "update test_meet set meet_image=?, meet_name=?, meet_description=?,"
			+ "meet_city=?, meet_county=?, meet_interest_name=?, meet_gender=?, meet_nop=?, meet_age=?"
			+ "where meet_no=?";
	
	String SQL_MEET_DELETE = "delete from test_meet where meet_no=?";
	
}
