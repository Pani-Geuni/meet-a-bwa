package test.com.member.model;

import java.util.List;

import test.com.activity.model.ActivityVO2;
import test.com.meet.model.MeetVO;
import test.com.meet.model.MeetVO4;

public interface MemberDAO {
	public String selectOne_name(String no);
	public MemberVO login(MemberVO uvo);
	
	public MemberVO selectOne_mypage(String no);
	
	public List<MeetVO4> selectAll_myMeet(String user_no);
	
	public List<ActivityVO2> selectAll_myActivity(String user_no);
}
