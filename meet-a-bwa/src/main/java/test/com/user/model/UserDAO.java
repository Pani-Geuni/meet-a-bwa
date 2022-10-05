package test.com.user.model;

import java.util.List;

import test.com.activity.model.ActivityVO2;
import test.com.meet.model.MeetVO4;

public interface UserDAO {

	public int user_insert(UserVO uvo);
	public UserVO idCheck(UserVO uvo);
	public UserVO nickCheck(UserVO uvo);
	public UserVO emailCheck(UserVO uvo);
	public UserVO user_selectOne(UserVO uvo);
	public int user_update(UserVO uvo);
	public int user_delete(UserVO uvo);
	
	public String selectOne_name(String no);
	public String selectOne_id(String email);
	public String selectOne_pw(String email);
	public UserVO login(UserVO uvo);
	
	public UserVO selectOne_mypage(String no);
	
	public List<MeetVO4> selectAll_myMeet(String user_no);
	
	public List<ActivityVO2> selectAll_myActivity(String user_no);
}
