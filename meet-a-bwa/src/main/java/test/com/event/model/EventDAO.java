package test.com.event.model;

import java.util.List;


public interface EventDAO {
	public int insert_event(EventVO vo);
	public List<EventVO> event_list_selectAll(String activity_no);
}
