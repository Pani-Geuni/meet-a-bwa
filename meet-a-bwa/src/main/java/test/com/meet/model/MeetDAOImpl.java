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
	public int insert_meet_like(String meet_no, String user_no) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(MeetDB.URL, MeetDB.TEST_USER, MeetDB.TEST_PASSWORD);
			pstmt = conn.prepareStatement(MeetDB.SQL_INSERT_LIKE);
			pstmt.setString(1, meet_no);    
			pstmt.setString(2, user_no);
			
			flag=pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	@Override
	public int delete_meet_like(String meet_no, String user_no) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(MeetDB.URL, MeetDB.TEST_USER, MeetDB.TEST_PASSWORD);
			pstmt = conn.prepareStatement(MeetDB.SQL_DELETE_LIKE);
			pstmt.setString(1, meet_no);    
			pstmt.setString(2, user_no);
			
			flag=pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
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
				mvo.setMeet_description(rs.getString("meet_description"));
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
				mvo.setMeet_description(rs.getString("meet_description"));
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
				mvo.setMeet_description(rs.getString("meet_description"));
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
	public MeetVO3 meet_selectOne(MeetVO3 mvo3) {
		System.out.println("meet selectOne()...");
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL, MeetDB.TEST_USER, MeetDB.TEST_PASSWORD);
			System.out.println("Meet selectOne conn succeed...");
			
			pstmt = conn.prepareStatement(MeetDB.SQL_SELECT_ONE_MEET_INFO);
			
			pstmt.setString(1, mvo3.getMeet_no());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString("MEET_NO") + " ");
				System.out.print(rs.getString("MEET_NAME") + " ");
				System.out.print(rs.getString("MEET_DESCRIPTION") + " ");
				System.out.print(rs.getString("MEET_COUNTY") + " ");
				System.out.println(rs.getString("MEET_INTEREST_NAME") + " ");
				
				mvo3.setMeet_no(rs.getString("MEET_NO"));
				mvo3.setMeet_image(rs.getString("MEET_IMAGE"));
				mvo3.setMeet_name(rs.getString("MEET_NAME"));
				mvo3.setMeet_description(rs.getString("MEET_DESCRIPTION"));
				mvo3.setMeet_county(rs.getString("MEET_COUNTY"));
				mvo3.setMeet_interest_name(rs.getString("MEET_INTEREST_NAME"));
				mvo3.setMeet_gender(rs.getString("MEET_GENDER"));
				mvo3.setMeet_nop(rs.getInt("MEET_NOP"));
				mvo3.setMeet_date(rs.getDate("MEET_DATE"));
				mvo3.setUser_no(rs.getString("USER_NO"));
				mvo3.setUser_nickname(rs.getString("USER_NICKNAME"));
				mvo3.setLike_cnt(rs.getInt("LIKE_CNT"));
				mvo3.setUser_cnt(rs.getInt("USER_CNT"));
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
		
		return mvo3;
	}

	@Override
	public List<MeetUserVO> meetUser_selectAll(String meet_no) {

		System.out.println("meet user registered selectAll()...");
		
		List<MeetUserVO> uvos = new ArrayList<MeetUserVO>();
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL, MeetDB.TEST_USER, MeetDB.TEST_PASSWORD);
			
			// 모임에 가입한 유저 멤버 불러오기
			pstmt = conn.prepareStatement(MeetDB.SQL_SELECT_ALL_MEET_REGISTERED);
			pstmt.setString(1, meet_no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				System.out.print(rs.getString("REGISTERED_NO"));
				System.out.print(rs.getString("MEET_NO"));
				System.out.print(rs.getString("USER_NO"));
				System.out.println(rs.getString("USER_NICKNAME"));
				MeetUserVO uvo = new MeetUserVO();
				
				uvo.setRegistered_no(rs.getString("REGISTERED_NO"));
				uvo.setMeet_no(rs.getString("MEET_NO"));
				uvo.setUser_no(rs.getString("USER_NO"));
				uvo.setUser_nickname(rs.getString("USER_NICKNAME"));
				
				uvos.add(uvo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return uvos;
	}
	

}
