package test.com.vote.model;


public interface VoteDB {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "mab_test_db";
	String PASSWORD = "test1234";
	
	
	String SQL_VOTE_INSERT_M
		= "INSERT INTO TEST_VOTE(VOTE_NO, VOTE_TITLE, VOTE_CONTENT, VOTE_EOD, VOTE_STATE, USER_NO, MEET_NO) "
		+ "VALUES ('V'||SEQ_TEST_VOTE.NEXTVAL, ?, ?, ?, 'N', ?, ?)";
	String SQL_V_CONTENT_INSERT
		= "INSERT INTO TEST_VOTE_CONTENT(CONTENT_NO, VOTE_NO, VOTE_CONTENT) "
		+ "VALUES ('VC'||SEQ_TEST_VOTE_CONTENT.NEXTVAL, ?, ?)";
	
	String SQL_SELECT_LAST_VOTE_NO 
		= "SELECT * "
		+ "FROM ("
			+ "SELECT VOTE_NO "
			+ "FROM TEST_VOTE "
			+ "ORDER BY VOTE_NO DESC) "
		+ "WHERE ROWNUM = 1";
	String SQL_VOTE_UPDATE_M = "update set ";
	
	String SQL_VOTE_SELECT_ALL_M
		= "SELECT VOTE_NO, VOTE_TITLE, USER_NO, MEET_NO "
		+ "FROM TEST_VOTE v ORDER BY VOTE_NO DESC";
	
	String SQL_VOTE_SELECT_ONE_M
		= "SELECT VOTE_NO, VOTE_TITLE, USER_NO, MEET_NO "
				+ "FROM TEST_VOTE v WHERE VOTE_NO=? ORDER BY VOTE_NO DESC";
}
