/**
 * @author 김예은, 최진실, 전판근
 */
package test.com.user.model;

public interface UserDB {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "mab_test_db";
	String PASSWORD = "test1234";
	
	String SQL_USER_INSERT = "insert into test_user(user_no, user_image, user_id, user_pw, user_name, user_nickname, user_email, user_tel, user_birth, user_gender, user_interest, user_city, user_county, user_state) values('U'||SEQ_TEST_USER.nextval,?,?,?,?,?,?,?,?,?,?,?,?,'Y')";
	String SQL_USER_UPDATE = "update test_user set user_image=?, user_pw=?, user_nickname=?, user_email=?, user_tel=?, user_interest=?, user_city=?, user_county=? where user_no=?";
	String SQL_ID_CHECK = "select * from test_user where user_id=?";
	String SQL_NICK_CHECK = "select * from test_user where user_nickname=?";
	String SQL_EMAIL_CHECK = "select * from test_user where user_email=?";
	String SQL_USER_SELECT_ONE = "select * from test_user where user_no=?";
	String SQL_USER_DELETE = "update test_user set user_state=? where user_no=?";
	
	
	String SQL_SELECT_ONE_NAME = "select user_name from test_user where user_no=?";
	String SQL_SELECT_ONE_ID = "select user_id from test_user where user_email=?";
	String SQL_SELECT_ONE_PW = "select user_pw from test_user where user_email=?";
	String SQL_SELECT_ONE_MYPAGE 
		= "SELECT USER_NO, USER_IMAGE, USER_ID, USER_NAME, USER_NICKNAME, USER_EMAIL "
		+ "FROM TEST_USER "
		+ "WHERE USER_NO = ?";
	
	String SQL_SELECT_ALL_M_REGISTERED = "select * from reg_user_like_view where user_no=?";
	String SQL_SELECT_ALL_A_REGISTERED = "SELECT * FROM ACTI_REG_USER_LIKE_VIEW WHERE USER_NO=?";

}
