/**
 * 
 * @author 김예은
 *
 */
package test.com.event.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAOImpl implements EventDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public EventDAOImpl() {
		System.out.println("EventDAOImpl()...");

		try {
			Class.forName(EventDB.DRIVER_NAME);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert_event(EventVO vo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(EventDB.URL,EventDB.USER,EventDB.PASSWORD);
			pstmt = conn.prepareStatement(EventDB.SQL_INSERT_EVENT);
			
		    pstmt.setString(1, vo.getEvent_title());    
			pstmt.setString(2, vo.getEvent_description());
			pstmt.setTimestamp(3, vo.getEvent_d_day());
			pstmt.setString(4, vo.getActivity_no());
			pstmt.setString(5, vo.getUser_no());
			
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
	public int delete_event(String event_no) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(EventDB.URL,EventDB.USER,EventDB.PASSWORD);
			pstmt = conn.prepareStatement(EventDB.SQL_DELETE_EVENT);	
			pstmt.setString(1, event_no);
			flag=pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = -1;
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
	public int update_event(EventVO vo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(EventDB.URL,EventDB.USER,EventDB.PASSWORD);
			pstmt = conn.prepareStatement(EventDB.SQL_UPDATE_EVENT);	
			pstmt.setString(1, vo.getEvent_title());
			pstmt.setString(2, vo.getEvent_description());
			pstmt.setTimestamp(3, vo.getEvent_d_day());
			pstmt.setString(4, vo.getEvent_no());
			flag=pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = -1;
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
	
	public EventVO event_selectOne(String event_no) {
		EventVO vo  = new EventVO();
		
		try {
			conn = DriverManager.getConnection(EventDB.URL, EventDB.USER, EventDB.PASSWORD);
			pstmt = conn.prepareStatement(EventDB.SQL_EVENT_SELECT_ONE);
			pstmt.setString(1, event_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setEvent_no(rs.getString("event_no"));
				vo.setEvent_title(rs.getString("event_title"));
				vo.setEvent_description(rs.getString("event_description"));
				vo.setEvent_date(rs.getTimestamp("event_date"));
				vo.setEvent_d_day(rs.getTimestamp("event_d_day"));
				vo.setActivity_no(rs.getString("activity_no"));
				vo.setUser_no(rs.getString("user_no"));
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
		
		return vo;
	}

	@Override
	public List<EventVO> event_list_selectAll(String activity_no) {
		System.out.println("event selectAll()..");
		
		List<EventVO> evos = new ArrayList<EventVO>();
		
		try {
			conn = DriverManager.getConnection(EventDB.URL, EventDB.USER, EventDB.PASSWORD);
			System.out.println("Event List SelectAll conn secceed");
			
			pstmt = conn.prepareStatement(EventDB.SQL_EVENT_SELECT_ALL_A);
			pstmt.setString(1, activity_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EventVO evo = new EventVO();
				evo.setEvent_no(rs.getString("EVENT_NO"));
				evo.setEvent_title(rs.getString("EVENT_TITLE"));
				evo.setEvent_description(rs.getString("EVENT_DESCRIPTION"));
				evo.setEvent_date(rs.getTimestamp("EVENT_DATE"));
				evo.setEvent_d_day(rs.getTimestamp("EVENT_D_DAY"));
				evo.setActivity_no(rs.getString("ACTIVITY_NO"));
				evo.setUser_no(rs.getString("USER_NO"));
				
				evos.add(evo);
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
		
		return evos;
	}
}
