package test.com.user.model;

public interface UserDAO {

	public int user_insert(UserVO uvo);
	public UserVO idCheck(UserVO uvo);
	public UserVO nickCheck(UserVO uvo);
	public UserVO emailCheck(UserVO uvo);
	
//	public int interest_insert(InterestVO ivo);
}
