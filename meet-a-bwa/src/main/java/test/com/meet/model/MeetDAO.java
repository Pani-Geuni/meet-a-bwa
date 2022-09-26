package test.com.meet.model;

import java.util.List;

public interface MeetDAO {
	public List<MeetVO2> select_like(); // 좋아요 많은 순으로
	public List<MeetVO2> select_interest(String interest); // 좋아요 많은 순으로
	public List<MeetVO2> select_county(String interest); // 좋아요 많은 순으로
}
