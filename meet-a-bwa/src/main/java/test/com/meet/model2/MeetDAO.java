package test.com.meet.model2;


public interface MeetDAO {
	public int meet_insert(MeetVO mvo);
	public MeetVO meet_selectOne(MeetVO mvo);
	public int meet_update(MeetVO mvo);
	public int meet_delete(MeetVO mvo); 
}
