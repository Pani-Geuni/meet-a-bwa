package test.com.meetboard.model;

import java.util.List;

public interface MeetBoardDAO {
	public int board_insert(MeetBoardVO bvo);
	
	public List<MeetBoardVO> board_selectAll();
	
	public MeetBoardVO board_selectOne(MeetBoardVO bvo);
	
	public int board_delete(MeetBoardVO bvo);
}
