package test.com.comment.model;

import java.util.List;

public interface CommentDAO {
	
	public int comment_insert(CommentVO cvo);
	
	public List<CommentVO> comment_selectAll(String board_no);
	
	public int comment_delete(CommentVO cvo);
}
