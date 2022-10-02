package test.com.vote.model;


public interface VoteDB {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "mab_test_db";
	String PASSWORD = "test1234";
	
	
	String SQL_VOTE_INSERT_M
		= "INSERT INTO TEST_VOTE(VOTE_NO, VOTE_TITLE, VOTE_DESCRIPTION, VOTE_EOD, VOTE_STATE, USER_NO, MEET_NO) "
		+ "VALUES ('V'||SEQ_TEST_VOTE.NEXTVAL, ?, ?, ?, 'Y', ?, ?)";
	String SQL_VOTE_INSERT_A
	= "INSERT INTO TEST_VOTE(VOTE_NO, VOTE_TITLE, VOTE_DESCRIPTION, VOTE_EOD, VOTE_STATE, USER_NO, ACTIVITY_NO) "
			+ "VALUES ('V'||SEQ_TEST_VOTE.NEXTVAL, ?, ?, ?, 'Y', ?, ?)";
	String SQL_V_CONTENT_INSERT
		= "INSERT INTO TEST_VOTE_CONTENT(CONTENT_NO, VOTE_NO, VOTE_CONTENT) "
		+ "VALUES ('VC'||SEQ_TEST_VOTE_CONTENT.NEXTVAL, ?, ?)";
	String SQL_RESERT_INSERT
		= "INSERT INTO TEST_VOTE_RESULT(VOTE_RESULT_NO, VOTE_NO, USER_NO, CONTENT_NO) "
		+ "VALUES ('VR'||SEQ_TEST_VOTE_RESULT.NEXTVAL, ?, ?, ?)";
	
	String SQL_VOTE_UPDATE
		= "UPDATE TEST_VOTE SET  VOTE_TITLE = ?, VOTE_DESCRIPTION = ?, VOTE_EOD = ?"
		+ "WHERE VOTE_NO = ?";
	String SQL_VOTE_STATE_UPDATE
		= "UPDATE TEST_VOTE SET  VOTE_STATE = 'N'"
			+ "WHERE VOTE_NO = ?";
	String SQL_RESERT_UPDATE
		= "update test_vote_result set content_no = ? "
		+ "where vote_no = ? AND user_no = ? ";
	
	String SQL_DELETE_RESULT = "delete from test_vote_result where vote_no = ?";
	String SQL_DELETE_CONTENT = "delete from test_vote_content where vote_no = ?";
	String SQL_DELETE_VOTE = "delete from test_vote where vote_no = ?";
	
	String SQL_SELECT_LAST_VOTE_NO 
		= "SELECT * "
		+ "FROM ("
			+ "SELECT VOTE_NO "
			+ "FROM TEST_VOTE "
			+ "ORDER BY VOTE_NO DESC) "
		+ "WHERE ROWNUM = 1";
	
	String SQL_VOTE_SELECT_ALL_M
		= "SELECT VOTE_NO, VOTE_TITLE, USER_NO, MEET_NO "
		+ "FROM TEST_VOTE ORDER BY VOTE_NO DESC";
	
	String SQL_VOTE_SELECT_ONE_M
		= "select test_vote.vote_no, vote_title, vote_description, vote_eod, vote_state, user_no, meet_no, activity_no, content_no, vote_content "
		+ "from test_vote left join test_vote_content on test_vote.vote_no = test_vote_content.vote_no "
		+ "where test_vote.vote_no = ? "
		+ "order by content_no";
	
	String SQL_VOTE_ALL_RESULT_SELECT_ONE = "select * from (select * from test_vote_result order by content_no) where vote_no = ?";
	String SQL_VOTE_MY_RESULT_SELECT_ONE = "select * from test_vote_result where vote_no = ? AND user_no = ?";
	String SQL_VOTE_SELECT_ALL_A = "SELECT VOTE_NO, VOTE_TITLE, VOTE_DESCRIPTION, VOTE_EOD , VOTE_STATE, USER_NO, ACTIVITY_NO, USER_CNT FROM VOTE_USER_VIEW WHERE ACTIVITY_NO=? ORDER BY VOTE_NO DESC";
}
