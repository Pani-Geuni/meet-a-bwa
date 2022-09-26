package test.com.meetboard.model;

public interface MeetBoardDB {

	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String TEST_USER = "mab_test_db";
	String TEST_PASSWORD = "test1234";
	
	String SQL_MEET_BOARD_POST_INSERT = "INSERT INTO MEETBOARD(BOARD_NO, BOARD_TITLE, BOARD_CONTENT, BOARD_DATE, USER_NO, MEET_NO) VALUES ('B'||SEQ_MEETBOARD.nextval, ?, ?, SYSDATE, 'U1001', 'M1001')";
}
