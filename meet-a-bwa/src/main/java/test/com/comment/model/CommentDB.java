package test.com.comment.model;

public interface CommentDB {

	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String TEST_USER = "mab_test_db";
	String TEST_PASSWORD = "test1234";
	
	String SQL_COMMENT_INSERT
		= "INSERT INTO TEST_COMMENT(COMMENT_NO, MOTHER_NO, COMMENT_DATE, COMMENT_CONTENT, BOARD_NO, USER_NO) "
		+ "VALUES ('C'||SEQ_COMMENT.nextval, ?, SYSDATE, ?, ?, ?)";
	
	
	String SQL_COMMENT_SELECT_ALL
		= "SELECT * FROM COMMENT_VIEW WHERE BOARD_NO = ? ORDER BY COMMENT_NO DESC";
}
