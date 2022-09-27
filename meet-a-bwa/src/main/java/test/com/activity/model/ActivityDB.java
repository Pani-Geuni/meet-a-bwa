package test.com.activity.model;

public interface ActivityDB {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "meetabwa";
	String PASSWORD = "meetabwa";

	
	public static final String SQL_ACTIVITY_INSERT = "insert into test_activity"
			+ "(activity_no, activity_name, activity_description, activity_city, activity_county, activity_interest_name, "
			+ "activity_gender, activity_nop, activity_age, activity_date, user_no, meet_no)"
			+ "values('A'||SEQ_ACTI_TEST.nextval, ?,?,?,?,?,?,?,?, TO_DATE(SYSDATE, 'yyyy-mm-dd'), ? , ?)";
	
}
