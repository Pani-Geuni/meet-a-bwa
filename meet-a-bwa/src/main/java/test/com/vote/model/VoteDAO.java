package test.com.vote.model;
import java.util.List;

public interface VoteDAO {
	public int insert_meetVote(VoteVO vo);
	public int insert_voteContent(VoteContentVO vo);
	public String select_last_voteNO();
	public List<VoteVO> vote_selectAll();
	
	public List<VoteJOIN_VO> vote_selectOne(VoteVO vvo);
}
