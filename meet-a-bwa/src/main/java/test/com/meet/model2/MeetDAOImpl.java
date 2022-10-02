package test.com.meet.model2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public int meet_insert(MeetVO mvo) {
		int flag=0;
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL,MeetDB.TEST_USER,MeetDB.TEST_PASSWORD);
			System.out.println("conn successed...");
			
			pstmt = conn.prepareStatement(MeetDB.SQL_MEET_INSERT);	
			
			pstmt.setString(1, mvo.getMeet_image()); 
			pstmt.setString(2, mvo.getMeet_name());
			pstmt.setString(3, mvo.getMeet_description());
			pstmt.setString(4, mvo.getMeet_city());
			pstmt.setString(5, mvo.getMeet_county());
			pstmt.setString(6, mvo.getMeet_interest_name());
			pstmt.setString(7, mvo.getMeet_gender());
			pstmt.setInt(8, mvo.getMeet_nop());
			pstmt.setInt(9, mvo.getMeet_age());
//			pstmt.setDate(9, (java.sql.Date) new Date());
			pstmt.setString(10, mvo.getUser_no()); 
			
			
			flag = pstmt.executeUpdate();
			
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
	public String select_meet_lastNo() {

		String meet_no = "";
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL,MeetDB.TEST_USER,MeetDB.TEST_PASSWORD);
			System.out.println("conn successed...");
			
			pstmt = conn.prepareStatement(MeetDB.SQL_MEET_SELECT_LAST_NO);	
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				meet_no = rs.getString("meet_no");
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
		
		return meet_no;
	}

	

	@Override
	public int meet_registered(String user_no, String meet_no) {
		int flag = 0;
		
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL,MeetDB.TEST_USER,MeetDB.TEST_PASSWORD);
			System.out.println("conn successed...");
			
			pstmt = conn.prepareStatement(MeetDB.SQL_MEET_REGISTERED);	
			
			pstmt.setString(1, meet_no); 
			pstmt.setString(2, user_no);
			
			flag = pstmt.executeUpdate();
			
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
	public int meet_leave(String user_no, String meet_no) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(MeetDB.URL,MeetDB.TEST_USER,MeetDB.TEST_PASSWORD);
			System.out.println("leave conn successed...");
			
			pstmt = conn.prepareStatement(MeetDB.SQL_MEET_LEAVE);
			
			pstmt.setString(1, user_no);
			pstmt.setString(2, meet_no);
			
			flag = pstmt.executeUpdate();
			
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
	public MeetVO meet_selectOne(MeetVO mvo) {
		MeetVO mvo2 = null;
		try {
			conn = DriverManager.getConnection(MeetDB.URL,MeetDB.TEST_USER,MeetDB.TEST_PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MeetDB.SQL_MEET_SELECT_ONE);
			
		    pstmt.setString(1, mvo.getMeet_no());    
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				mvo2 = new MeetVO();
				mvo2.setMeet_no(rs.getString("meet_no"));
				mvo2.setMeet_image(rs.getString("meet_image"));
				mvo2.setMeet_name(rs.getString("meet_name"));
				mvo2.setMeet_description(rs.getString("meet_description"));
				mvo2.setMeet_city(rs.getString("meet_city"));
				mvo2.setMeet_county(rs.getString("meet_county"));
				mvo2.setMeet_interest_name(rs.getString("meet_interest_name"));
				mvo2.setMeet_gender(rs.getString("meet_gender"));
				mvo2.setMeet_nop(rs.getInt("meet_nop"));
				mvo2.setMeet_age(rs.getInt("meet_age"));
				//avo2.setActivity_date(rs.getDate("activity_date"));
				//avo2.setUser_no(rs.getString("user_no"));
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
		return mvo2;
	}

	@Override
	public int meet_update(MeetVO mvo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(MeetDB.URL,MeetDB.TEST_USER,MeetDB.TEST_PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MeetDB.SQL_MEET_UPDATE);
			
			pstmt.setString(1, mvo.getMeet_image()); 
			pstmt.setString(2, mvo.getMeet_name());
			pstmt.setString(3, mvo.getMeet_description());
			pstmt.setString(4, mvo.getMeet_city());
			pstmt.setString(5, mvo.getMeet_county());
			pstmt.setString(6, mvo.getMeet_interest_name());
			pstmt.setString(7, mvo.getMeet_gender());
			pstmt.setInt(8, mvo.getMeet_nop());
			pstmt.setInt(9, mvo.getMeet_age());
//			pstmt.setDate(9, (java.sql.Date) new Date());
//			pstmt.setString(10, avo.getUser_no()); 
//			pstmt.setString(11, avo.getMeet_no()); 
			pstmt.setString(10, mvo.getMeet_no()); 
			
			
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
	public int meet_delete(MeetVO mvo) {
		System.out.println("delete()...");
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL,MeetDB.TEST_USER,MeetDB.TEST_PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MeetDB.SQL_MEET_DELETE);
			pstmt.setString(1, mvo.getMeet_no()); 
			
			flag=pstmt.executeUpdate();  // insert占쏙옙 executeUpdate占싱곤옙 占쏙옙占쏙옙타占쏙옙(flag)占쏙옙 占쌍억옙占� 占쏙옙
			
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




}
