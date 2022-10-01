package test.com.meet.model;

import java.util.List;

public interface MeetDAO {
	public int insert_meet_like(String meet_no, String user_no);
	public int delete_meet_like(String meet_no, String user_no);
	public List<MeetVO2> select_like(); // 좋아요 많은 순으로
	public List<MeetVO2> select_interest(String interest); // 좋아요 많은 순으로
	public List<MeetVO2> select_county(String interest); // 좋아요 많은 순으로
	public List<String> select_all_meet_like(String user_no); 
	
	public MeetVO3 meet_selectOne(MeetVO3 mvo3);
	public List<MeetUserVO> meetUser_selectAll(String meet_no);
}
