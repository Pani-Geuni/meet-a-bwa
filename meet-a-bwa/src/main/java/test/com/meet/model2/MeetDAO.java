package test.com.meet.model2;


public interface MeetDAO {
	public int meet_insert(MeetVO mvo);
	public String select_meet_lastNo();
	public MeetVO meet_selectOne(MeetVO mvo);
	public int meet_registered(String user_no, String meet_no);
	public int meet_update(MeetVO mvo);
	public int meet_delete(MeetVO mvo); 
}
