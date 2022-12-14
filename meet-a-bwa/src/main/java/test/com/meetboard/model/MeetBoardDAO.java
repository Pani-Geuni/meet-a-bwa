/**
 * 
 * @author 전판근
 *
 */

package test.com.meetboard.model;

import java.util.List;

public interface MeetBoardDAO {
	public int board_insert(MeetBoardVO bvo);
	
	public int board_update(MeetBoardVO bvo);
	
	public List<MeetBoardVO> board_selectAll(String idx);
	
	public MeetBoardVO board_selectOne(MeetBoardVO bvo);
	
	public int board_delete(MeetBoardVO bvo);
}
