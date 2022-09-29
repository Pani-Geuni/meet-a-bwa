package test.com.activity.model;

public interface ActivityDB {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "mab_test_db";
	String PASSWORD = "test1234";
	

	
	public static final String SQL_ACTIVITY_INSERT = "insert into test_activity"
			+ "(activity_no, activity_name, activity_description, activity_city, activity_county, activity_interest_name, "
			+ "activity_gender, activity_nop, activity_age, activity_date, user_no, meet_no)"
			+ "values('A'||SEQ_TEST_ACTIVITY.nextval, ?,?,?,?,?,?,?,?, TO_DATE(SYSDATE, 'yyyy-mm-dd'), ? , ?)";
	
	String SQL_ACTIVITY_UPDATE = "update test_activity set activity_image=?, activity_name=?, activity_description=?,"
			+ "activity_city=?, activity_county=?, activity_interest_name=?, activity_gender=?, activity_nop=?, activity_age=?"
			+ "where activity_no=?";
	
	String SQL_ACTIVITY_SELECT_ONE = null;
	
}
