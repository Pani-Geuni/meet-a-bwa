package test.com.vote.model;

public interface VoteDAO {
	public int insert_meetVote(VoteVO vo);
	public int insert_voteContent(VoteContentVO vo);
	public String select_last_voteNO();
}
