package test.com.vote.model;

import java.util.List;

public interface VoteDAO {
	public List<VoteVO> vote_selectAll();
	
	public VoteVO vote_selectOne(VoteVO vvo);
}
