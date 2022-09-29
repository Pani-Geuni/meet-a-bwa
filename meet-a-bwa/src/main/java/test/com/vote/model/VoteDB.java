package test.com.vote.model;


public interface VoteDB {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "mab_test_db";
	String PASSWORD = "test1234";
	
	
	String SQL_VOTE_INSERT_M
		= "INSERT INTO TEST_VOTE(VOTE_NO, VOTE_TITLE, VOTE_CONTENT, VOTE_EOD, VOTE_STATE, USER_NO, MEET_NO) "
		+ "VALUES ('V'||SEQ_TEST_VOTE.NEXTVAL, ?, ?, ?, 'N', ?, ?)";
	String SQL_VOTE_UPDATE_M = "update set ";
	
	String SQL_VOTE_SELECT_ALL_M
		= "SELECT VOTE_NO, VOTE_TITLE, USER_NO, MEET_NO "
		+ "FROM TEST_VOTE v ORDER BY VOTE_NO DESC";
}
