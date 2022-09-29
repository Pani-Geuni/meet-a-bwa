package test.com.member.model;


public interface MemberDB {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "mab_test_db";
	String PASSWORD = "test1234";
	
		
	String SQL_ID_CHECK = "select * from test_user where user_id=?";
	String SQL_SELECT_ONE_NAME = "select user_name from test_user where user_no=?";
}
