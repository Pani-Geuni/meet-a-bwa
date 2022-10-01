package test.com.meet.model;

import java.util.List;

public interface MeetDAO {
	public int insert_meet_like(String meet_no, String user_no);
	public int delete_meet_like(String meet_no, String user_no);
	public List<MeetVO2> select_like(); // 좋아요 많은 순으로
	public List<MeetVO2> select_interest(String interest); // 좋아요 많은 순으로
	public List<MeetVO2> select_county(String interest); // 좋아요 많은 순으로
	public List<String> select_all_meet_like(String user_no); 
	
	public List<MeetVO2> select_all_more_like(String searchWord);	// 더보기 리스트 - 좋아요 많은 순
	public List<MeetVO2> select_all_more_interest(String interest, String searchWord);	// 더보기 리스트 - 관심사가 있을 시
	public List<MeetVO2> select_all_more_county(String county, String searchWord);	// 더보기 리스트 - 관심사가 없을 시
	
	public MeetVO3 meet_selectOne(MeetVO3 mvo3);
	public List<MeetUserVO> meetUser_selectAll(String meet_no);
}
