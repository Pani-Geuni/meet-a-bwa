package test.com.meetboard.model;

public interface MeetBoardDB {

	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String TEST_USER = "mab_test_db";
	String TEST_PASSWORD = "test1234";
	
	String SQL_MEET_BOARD_POST_INSERT = "INSERT INTO MEETBOARD(BOARD_NO, BOARD_TITLE, BOARD_CONTENT, BOARD_DATE, USER_NO, MEET_NO) VALUES ('B'||SEQ_MEETBOARD.nextval, ?, ?, SYSDATE, 'U1002', 'M1001')";
	
//	String SQL_MEET_BOARD_SELECT_ALL_TEST = "SELECT * FROM MEETBOARD order by BOARD_NO desc";
	
//	테스트 피드 불러오기 -> user와 meet board만 left join 함
	String SQL_MEET_BOARD_SELECT_ALL_TEST = "SELECT USER_NO, USER_NAME, BOARD_NO, BOARD_TITLE, BOARD_CONTENT, BOARD_DATE, MEET_NO FROM MEETBOARD_USER_VIEW ORDER BY BOARD_NO DESC";
}