package test.com.meet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetDAOImpl implements MeetDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MeetDAOImpl() {
		System.out.println("MeetDAOImpl()...");
		
		try {
			Class.forName(MeetDB.DRIVER_NAME);
			System.out.println("Driver Successed...");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MeetVO2> select_like() {
		List<MeetVO2> l_mvo = new ArrayList<MeetVO2>();
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL, MeetDB.TEST_USER, MeetDB.TEST_PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(MeetDB.SQL_SELECT_ALL_LIKE);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MeetVO2 mvo = new MeetVO2();				
				mvo.setMeet_no(rs.getString("meet_no"));
				mvo.setMeet_image(rs.getString("meet_image"));
				mvo.setMeet_name(rs.getString("meet_name"));
				mvo.setMeet_description(rs.getString("meet_name"));
				mvo.setMeet_county(rs.getString("meet_county"));
				mvo.setMeet_interest_name(rs.getString("meet_interest_name"));
				mvo.setMeet_gender(rs.getString("meet_gender"));
				mvo.setMeet_nop(rs.getInt("meet_nop"));
				mvo.setMeet_age(rs.getInt("meet_age"));
				mvo.setMeet_date(rs.getDate("meet_date"));
				mvo.setUser_no(rs.getString("user_no"));
				mvo.setLike_cnt(rs.getInt("like_cnt"));
				mvo.setUser_cnt(rs.getInt("user_cnt"));
				
				l_mvo.add(mvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l_mvo;
	}

	@Override
	public List<MeetVO2> select_interest(String interest) {
		List<MeetVO2> l_mvo = new ArrayList<MeetVO2>();
		System.out.println("interest : " + interest);
		try {
			conn = DriverManager.getConnection(MeetDB.URL, MeetDB.TEST_USER, MeetDB.TEST_PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(MeetDB.SQL_SELECT_ALL_INTEREST);
			pstmt.setString(1, interest);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MeetVO2 mvo = new MeetVO2();				
				mvo.setMeet_no(rs.getString("meet_no"));
				mvo.setMeet_image(rs.getString("meet_image"));
				mvo.setMeet_name(rs.getString("meet_name"));
				mvo.setMeet_description(rs.getString("meet_name"));
				mvo.setMeet_county(rs.getString("meet_county"));
				mvo.setMeet_interest_name(rs.getString("meet_interest_name"));
				mvo.setMeet_gender(rs.getString("meet_gender"));
				mvo.setMeet_nop(rs.getInt("meet_nop"));
				mvo.setMeet_age(rs.getInt("meet_age"));
				mvo.setMeet_date(rs.getDate("meet_date"));
				mvo.setUser_no(rs.getString("user_no"));
				mvo.setLike_cnt(rs.getInt("like_cnt"));
				mvo.setUser_cnt(rs.getInt("user_cnt"));
				
				l_mvo.add(mvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l_mvo;
	}

	@Override
	public List<MeetVO2> select_county(String county) {
		List<MeetVO2> l_mvo = new ArrayList<MeetVO2>();
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL, MeetDB.TEST_USER, MeetDB.TEST_PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(MeetDB.SQL_SELECT_ALL_COUNTY);
			pstmt.setString(1, county);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MeetVO2 mvo = new MeetVO2();				
				mvo.setMeet_no(rs.getString("meet_no"));
				mvo.setMeet_image(rs.getString("meet_image"));
				mvo.setMeet_name(rs.getString("meet_name"));
				mvo.setMeet_description(rs.getString("meet_name"));
				mvo.setMeet_county(rs.getString("meet_county"));
				mvo.setMeet_interest_name(rs.getString("meet_interest_name"));
				mvo.setMeet_gender(rs.getString("meet_gender"));
				mvo.setMeet_nop(rs.getInt("meet_nop"));
				mvo.setMeet_age(rs.getInt("meet_age"));
				mvo.setMeet_date(rs.getDate("meet_date"));
				mvo.setUser_no(rs.getString("user_no"));
				mvo.setLike_cnt(rs.getInt("like_cnt"));
				mvo.setUser_cnt(rs.getInt("user_cnt"));
				
				l_mvo.add(mvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l_mvo;
	}

	@Override
	public MeetVO2 meet_selectOne(MeetVO2 mvo2) {
		System.out.println("meet selectOne()...");
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL, MeetDB.TEST_USER, MeetDB.TEST_PASSWORD);
			System.out.println("Meet selectOne conn succeed...");
			
			pstmt = conn.prepareStatement(MeetDB.SQL_SELECT_ONE_MEET);
			
			pstmt.setString(1, mvo2.getMeet_no());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString("MEET_NO") + " ");
				System.out.print(rs.getString("MEET_NAME") + " ");
				System.out.print(rs.getString("MEET_DESCRIPTION") + " ");
				System.out.print(rs.getString("MEET_COUNTY") + " ");
				System.out.print(rs.getString("MEET_INTEREST_NAME") + " ");
				
				mvo2.setMeet_no(rs.getString("MEET_NO"));
				mvo2.setMeet_image(rs.getString("MEET_IMAGE"));
				mvo2.setMeet_name(rs.getString("MEET_NAME"));
				mvo2.setMeet_description(rs.getString("MEET_DESCRIPTION"));
				mvo2.setMeet_county(rs.getString("MEET_COUNTY"));
				mvo2.setMeet_interest_name(rs.getString("MEET_INTEREST_NAME"));
				mvo2.setMeet_gender(rs.getString("MEET_GENDER"));
				mvo2.setMeet_nop(rs.getInt("MEET_NOP"));
				mvo2.setMeet_date(rs.getDate("MEET_DATE"));
				mvo2.setUser_no(rs.getString("USER_NO"));
				mvo2.setLike_cnt(rs.getInt("LIKE_CNT"));
				mvo2.setUser_cnt(rs.getInt("USER_CNT"));
			}
			
		} catch (SQLException e) {
            System.out.println("SQLException1 : " + e);
        } catch (Exception e) {
            System.out.println("Exception1 : " + e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("SQLException2 : " + e);
                }
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("SQLException3 : " + e);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQLException4 : " + e);
                }
            }
        }
		
		return mvo2;
	}

	@Override
	public List<String> select_all_meet_like(String user_no) {
		List<String> list = new ArrayList<String>();
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL, MeetDB.TEST_USER, MeetDB.TEST_PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(MeetDB.SQL_SELECT_ALL_LIKE_MEET_NO);
			pstmt.setString(1, user_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String meet_no = rs.getString("meet_no");
				
				list.add(meet_no);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<String> select_all_activity_like(String user_no) {
		List<String> list = new ArrayList<String>();
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL, MeetDB.TEST_USER, MeetDB.TEST_PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(MeetDB.SQL_SELECT_ALL_LIKE_ACTIVITY_NO);
			pstmt.setString(1, user_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String activity_no = rs.getString("activity_no");
				
				list.add(activity_no);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
