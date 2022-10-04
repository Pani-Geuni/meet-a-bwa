package test.com.activity.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.meet.model2.MeetDB;


public class ActivityDAOImpl implements ActivityDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ActivityDAOImpl() {

		try {
			Class.forName(ActivityDB.DRIVER_NAME);
			System.out.println("ActivityDAOImpl Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert_activity_like(String activity_no, String user_no) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(ActivityDB2.URL, ActivityDB2.USER, ActivityDB2.PASSWORD);
			pstmt = conn.prepareStatement(ActivityDB2.SQL_INSERT_LIKE);
			pstmt.setString(1, activity_no);    
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
	public String select_activity_lastNo() {
		String activity_no = "";
		
		try {
			conn = DriverManager.getConnection(ActivityDB.URL,ActivityDB.USER,ActivityDB.PASSWORD);
			System.out.println("conn successed...");
			
			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_SELECT_LAST_NO);	
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				activity_no = rs.getString("activity_no");
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
		
		return activity_no;
	}

	@Override
	public int activity_registered(String user_no, String activity_no) {
		int flag = 0;
		
		
		try {
			conn = DriverManager.getConnection(ActivityDB.URL,ActivityDB.USER,ActivityDB.PASSWORD);
			System.out.println("conn successed...");
			
			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_REGISTERED);		
			
			pstmt.setString(1, activity_no); 
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
	public int delete_activity_like(String activity_no, String user_no) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(ActivityDB2.URL, ActivityDB2.USER, ActivityDB2.PASSWORD);
			pstmt = conn.prepareStatement(ActivityDB2.SQL_DELETE_LIKE);
			pstmt.setString(1, activity_no);    
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
	public int activity_insert(ActivityVO avo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(ActivityDB.URL,ActivityDB.USER,ActivityDB.PASSWORD);
			System.out.println("conn successed...");
			
			System.out.println("Activity Impl ::: " + avo.getActivity_age());
			
			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_INSERT);
			pstmt.setString(1, avo.getActivity_image()); 
			pstmt.setString(2, avo.getActivity_name());
			pstmt.setString(3, avo.getActivity_description());
			pstmt.setString(4, avo.getActivity_city());
			pstmt.setString(5, avo.getActivity_county());
			pstmt.setString(6, avo.getActivity_interest_name());
			pstmt.setString(7, avo.getActivity_gender());
			pstmt.setInt(8, avo.getActivity_nop());
			pstmt.setInt(9, avo.getActivity_age());
//			pstmt.setDate(9, (java.sql.Date) new Date());
			pstmt.setString(10, avo.getUser_no()); 
			pstmt.setString(11, avo.getMeet_no()); 
			
			
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
	public List<ActivityVO2> selectAll10() {
		List<ActivityVO2> l_avo = new ArrayList<ActivityVO2>();
		
		try {
			conn = DriverManager.getConnection(ActivityDB2.URL, ActivityDB2.USER, ActivityDB2.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(ActivityDB2.SQL_SELECT_ALL_10);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ActivityVO2 avo = new ActivityVO2();				
				avo.setActivity_no(rs.getString("activity_no"));
				avo.setActivity_image(rs.getString("activity_image"));
				avo.setActivity_name(rs.getString("activity_name"));
				avo.setActivity_description(rs.getString("activity_description"));
				avo.setActivity_city(rs.getString("activity_city"));
				avo.setActivity_county(rs.getString("activity_county"));
				avo.setActivity_interest_name(rs.getString("activity_interest_name"));
				avo.setActivity_gender(rs.getString("activity_gender"));
				avo.setActivity_nop(rs.getInt("activity_nop"));
				avo.setActivity_age(rs.getInt("activity_age"));
				avo.setActivity_date(rs.getDate("activity_date"));
				avo.setUser_no(rs.getString("user_no"));
				avo.setMeet_no(rs.getString("meet_no"));
				avo.setLike_cnt(rs.getInt("like_cnt"));
				avo.setUser_cnt(rs.getInt("user_cnt"));
				
				l_avo.add(avo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l_avo;
	}

	@Override
	public List<ActivityVO2> selectCate10(String category) {
		List<ActivityVO2> l_avo = new ArrayList<ActivityVO2>();
		
		try {
			conn = DriverManager.getConnection(ActivityDB2.URL, ActivityDB2.USER, ActivityDB2.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(ActivityDB2.SQL_SELECT_CATE_10);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ActivityVO2 avo = new ActivityVO2();				
				avo.setActivity_no(rs.getString("activity_no"));
				avo.setActivity_name(rs.getString("activity_name"));
				avo.setActivity_description(rs.getString("activity_description"));
				avo.setActivity_city(rs.getString("activity_city"));
				avo.setActivity_county(rs.getString("activity_county"));
				avo.setActivity_interest_name(rs.getString("activity_interest_name"));
				avo.setActivity_gender(rs.getString("activity_gender"));
				avo.setActivity_nop(rs.getInt("activity_nop"));
				avo.setActivity_age(rs.getInt("activity_age"));
				avo.setActivity_date(rs.getDate("activity_date"));
				avo.setUser_no(rs.getString("user_no"));
				avo.setMeet_no(rs.getString("meet_no"));
				avo.setLike_cnt(rs.getInt("like_cnt"));
				avo.setUser_cnt(rs.getInt("user_cnt"));
				
				l_avo.add(avo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l_avo;
	}

	@Override
	public ActivityVO activity_selectOne(ActivityVO avo) {
		ActivityVO avo2 = null;
		try {
			conn = DriverManager.getConnection(ActivityDB.URL,ActivityDB.USER,ActivityDB.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_SELECT_ONE);
			
		    pstmt.setString(1, avo.getActivity_no());    
		   // pstmt.setString(1, "A1030");    
		    //pstmt.setString(2, avo.getUser_no());    
		    //pstmt.setString(3, avo.getMeet_no());    
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				avo2 = new ActivityVO();
				avo2.setActivity_no(rs.getString("activity_no"));
				avo2.setActivity_image(rs.getString("activity_image"));
				avo2.setActivity_name(rs.getString("activity_name"));
				avo2.setActivity_description(rs.getString("activity_description"));
				avo2.setActivity_city(rs.getString("activity_city"));
				avo2.setActivity_county(rs.getString("activity_county"));
				avo2.setActivity_interest_name(rs.getString("activity_interest_name"));
				avo2.setActivity_gender(rs.getString("activity_gender"));
				avo2.setActivity_nop(rs.getInt("activity_nop"));
				avo2.setActivity_age(rs.getInt("activity_age"));
				//avo2.setActivity_date(rs.getDate("activity_date"));
				//avo2.setUser_no(rs.getString("user_no"));
				//avo2.setMeet_no(rs.getString("meet_no"));
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
		return avo2;
	}

	@Override
	public int activity_update(ActivityVO avo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(ActivityDB.URL,ActivityDB.USER,ActivityDB.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_UPDATE);
			pstmt.setString(1, avo.getActivity_image()); 
			pstmt.setString(2, avo.getActivity_name());
			pstmt.setString(3, avo.getActivity_description());
			pstmt.setString(4, avo.getActivity_city());
			pstmt.setString(5, avo.getActivity_county());
			pstmt.setString(6, avo.getActivity_interest_name());
			pstmt.setString(7, avo.getActivity_gender());
			pstmt.setInt(8, avo.getActivity_nop());
			pstmt.setInt(9, avo.getActivity_age());
//			pstmt.setDate(9, (java.sql.Date) new Date());
//			pstmt.setString(10, avo.getUser_no()); 
//			pstmt.setString(11, avo.getMeet_no()); 
			pstmt.setString(10, avo.getActivity_no()); 
			
			
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
	public List<String> select_all_activity_like(String user_no) {
		List<String> list = new ArrayList<String>();
		
		try {
			conn = DriverManager.getConnection(ActivityDB2.URL, ActivityDB2.USER, ActivityDB2.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(ActivityDB2.SQL_SELECT_ALL_LIKE_ACTIVITY_NO);
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

	@Override
	public int activity_delete(ActivityVO avo) {
		System.out.println("delete()...");
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(ActivityDB.URL,ActivityDB.USER,ActivityDB.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_DELETE);
			pstmt.setString(1, avo.getActivity_no()); 
			
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

	@Override
	public List<ActivityVO2> activity_selectAll_main_feed(String meet_no) {
		
		System.out.println("Activity selectAll() in meet main");
		
		List<ActivityVO2> vos = new ArrayList<ActivityVO2>();
		
		try {
			conn = DriverManager.getConnection(ActivityDB2.URL, ActivityDB2.USER, ActivityDB2.PASSWORD);
			System.out.println("Activity SelectAll conn succeed");
			
			pstmt = conn.prepareStatement(ActivityDB2.SQL_SELECT_ALL_FEED);
			pstmt.setString(1, meet_no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ActivityVO2 vo = new ActivityVO2();
				System.out.print(rs.getString("ACTIVITY_NO") + " ");
				System.out.print(rs.getString("ACTIVITY_NAME") + " ");
				System.out.print(rs.getString("USER_NO") + " ");
				System.out.println(rs.getString("MEET_NO") + " ");
				
				vo.setActivity_no(rs.getString("ACTIVITY_NO"));
				vo.setActivity_name(rs.getString("ACTIVITY_NAME"));
				vo.setUser_no(rs.getString("USER_NO"));
				vo.setMeet_no(rs.getString("MEET_NO"));
				
				vos.add(vo);
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
		
		return vos;
	}

	@Override
	public ActivityVO3 activity_selectOne_main_feed(ActivityVO3 avo) {
		ActivityVO3 avo2 = null;
		try {
			conn = DriverManager.getConnection(ActivityDB.URL,ActivityDB.USER,ActivityDB.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_SELECT_ONE_MAIN_FEED);
			
		    pstmt.setString(1, avo.getActivity_no()); 
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				avo2 = new ActivityVO3();
				avo2.setActivity_no(rs.getString("activity_no"));
				avo2.setActivity_image(rs.getString("activity_image"));
				avo2.setActivity_name(rs.getString("activity_name"));
				avo2.setActivity_description(rs.getString("activity_description"));
				avo2.setActivity_city(rs.getString("activity_city"));
				avo2.setActivity_county(rs.getString("activity_county"));
				avo2.setActivity_interest_name(rs.getString("activity_interest_name"));
				avo2.setActivity_gender(rs.getString("activity_gender"));
				avo2.setActivity_nop(rs.getInt("activity_nop"));
				avo2.setActivity_age(rs.getInt("activity_age"));
				avo2.setActivity_date(rs.getDate("activity_date"));
				avo2.setUser_no(rs.getString("user_no"));
				avo2.setMeet_no(rs.getString("meet_no"));
				avo2.setLike_cnt(rs.getInt("like_cnt"));
				avo2.setUser_cnt(rs.getInt("user_cnt"));
				avo2.setUser_nickname(rs.getString("user_nickname"));
				System.out.println("sssssssssslike_cntssssssssss"+rs.getString("like_cnt"));
				System.out.println("sssssssssssuser_cntsssssssss"+rs.getString("user_cnt"));
				
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
		return avo2;
	}

	@Override
	public List<RegisteredVO> activity_select_registered(String activity_no) {
		System.out.println("Activity Leader()..");
		
		List<RegisteredVO> rvos = new ArrayList<RegisteredVO>();
		
		try {
			conn = DriverManager.getConnection(ActivityDB.URL, ActivityDB.USER, ActivityDB.PASSWORD);
			System.out.println("Activity SelectAll conn succeed");
			
			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_SELECT_REGISTERED);
			pstmt.setString(1, activity_no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RegisteredVO rvo = new RegisteredVO();
				
				rvo.setUser_no(rs.getString("user_no"));
				
				rvos.add(rvo);
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
		
		return rvos;
	}

	@Override
	public List<ActivityVO2> select_all_more_like(String category, String searchWord) {
		List<ActivityVO2> a_list = new ArrayList<ActivityVO2>();
		System.out.println("activity select all more like");
		try {
			conn = DriverManager.getConnection(ActivityDB2.URL, ActivityDB2.USER, ActivityDB2.PASSWORD);
			System.out.println("activity select all conn succeed");
			
			
			
			
			// 전체일 때와 카테고리를 골랐을 때 분기 처리 
			if (category.equals("전체")) {
				pstmt = conn.prepareStatement(ActivityDB2.SQL_SELECT_ALL_MORE_LIKE_ALL);
				pstmt.setString(1, "%" + searchWord + "%");
			} else {
				pstmt = conn.prepareStatement(ActivityDB2.SQL_SELECT_ALL_MORE_LIKE);
				pstmt.setString(1, "%" + searchWord + "%");
				pstmt.setString(2, category);
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ActivityVO2 avo = new ActivityVO2();
				
				avo.setActivity_no(rs.getString("activity_no"));
				avo.setActivity_image(rs.getString("activity_image"));
				avo.setActivity_name(rs.getString("activity_name"));
				avo.setActivity_description(rs.getString("activity_description"));
				avo.setActivity_county(rs.getString("activity_county"));
				avo.setActivity_interest_name(rs.getString("activity_interest_name"));
				avo.setActivity_gender(rs.getString("activity_gender"));
				avo.setActivity_nop(rs.getInt("activity_nop"));
				avo.setActivity_age(rs.getInt("activity_age"));
				avo.setActivity_date(rs.getDate("activity_date"));
				avo.setUser_no(rs.getString("user_no"));
				avo.setMeet_no(rs.getString("meet_no"));
				avo.setLike_cnt(rs.getInt("like_cnt"));
				avo.setUser_cnt(rs.getInt("user_cnt"));
				
				a_list.add(avo);
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
		
		return a_list;
	}
}
