package test.com.member.model;

public interface MemberDAO {
	public String selectOne_name(String no);
	public MemberVO login(MemberVO uvo);
	
	public MemberVO selectOne_mypage(String no);
}
