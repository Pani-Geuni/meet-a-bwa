package test.com.user.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public interface DB_oracle {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "meetabwa";
	
	String PASSWORD = "meetabwa";
	
//	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	String strDate = dateFormat.format(Calendar.getInstance().getTime());
		
	String SQL_USER_INSERT = "insert into test_test_user(user_no, user_image, user_id, user_pw, user_name, user_nickname, user_email, user_tel, user_birth, user_gender, user_region, user_state) values('S'||SEQ_TEST.nextval,?,?,?,?,?,?,?,TO_DATE('?-?-?', 'yyyy-mm-dd'),?,?,'y')";
	String SQL_USER_INSERT_INTEREST = "insert into test_test_interest(interest_no, interest_name, user_no) values('I'||SEQ_TEST2.nextval,?,'S'||SEQ_TEST.currval )";
}
