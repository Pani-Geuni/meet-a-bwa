package test.com.member.model;


public interface MemberDB {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "mab_test_db";
	String PASSWORD = "test1234";
	
		
	String SQL_ID_CHECK = "select * from test_user where user_id=?";
	String SQL_SELECT_ONE_NAME = "select user_name from test_user where user_no=?";
	String SQL_SELECT_ONE_MYPAGE 
		= "SELECT USER_NO, USER_IMAGE, USER_ID, USER_NAME, USER_NICKNAME, USER_EMAIL "
		+ "FROM TEST_USER "
		+ "WHERE USER_NO = ?";
	
	String SQL_SELECT_ALL_M_REGISTERED = "select * from reg_user_like_view where user_no=?";
	String SQL_SELECT_ALL_A_REGISTERED = "SELECT * FROM ACTI_REG_USER_LIKE_VIEW WHERE USER_NO=?";
}
