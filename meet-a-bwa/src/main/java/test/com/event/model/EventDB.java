package test.com.event.model;

public interface EventDB {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "mab_test_db";
	String PASSWORD = "test1234";
	
	String SQL_INSERT_ACTIVITY 
		= "insert into TEST_EVENT(EVENT_NO, EVENT_TITLE, EVENT_DESCRIPTION, EVENT_DATE, EVENT_D_DAY, ACTIVITY_NO, USER_NO) "
		+ "values ('E'||SEQ_TEST_EVENT.NEXTVAL, ? , ? , sysdate, ?, ?, ?)";
	String SQL_EVENT_SELECT_ALL_A = "SELECT EVENT_NO, EVENT_TITLE, EVENT_DESCRIPTION, EVENT_DATE , EVENT_D_DAY, ACTIVITY_NO, USER_NO FROM TEST_EVENT WHERE ACTIVITY_NO=? ORDER BY EVENT_NO DESC";
}
