package test.com.event.model;

import java.util.List;


public interface EventDAO {
	public int insert_event(EventVO vo);
	public int delete_event(String event_no);
	public int update_event(EventVO vo);
	public List<EventVO> event_list_selectAll(String activity_no);
	public EventVO event_selectOne(String activity_no);
}
