package test.com.user.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public interface UserDB {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "meetabwa";
	String PASSWORD = "meetabwa";
	
//	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	String strDate = dateFormat.format(Calendar.getInstance().getTime());
		
	
	String SQL_USER_INSERT = "insert into test_user(user_no, user_image, user_id, user_pw, user_name, user_nickname, user_email, user_tel, user_birth, user_gender, user_interest, user_city, user_county, user_state) values('U'||SEQ_TEST.nextval,?,?,?,?,?,?,?,?,?,?,?,?,'Y')";
	String SQL_USER_UPDATE = "update test_user set user_image=?, user_pw=?, user_nickname=?, user_email=?, user_tel=?, user_interest=?, user_city=?, user_county=? where user_no='S1074'";
	String SQL_ID_CHECK = "select * from test_user where user_id=?";
	String SQL_NICK_CHECK = "select * from test_user where user_nickname=?";
	String SQL_EMAIL_CHECK = "select * from test_user where user_email=?";
	String SQL_USER_SELECT_ONE = "select * from test_user where user_no=?";
	String SQL_USER_DELETE = "update test_user set user_state='N'";
}
