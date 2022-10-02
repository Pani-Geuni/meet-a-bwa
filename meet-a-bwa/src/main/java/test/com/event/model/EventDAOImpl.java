package test.com.event.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.vote.model.VoteDB;
import test.com.vote.model.VoteListVO;
import test.com.vote.model.VoteVO;

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
			pstmt = conn.prepareStatement(EventDB.SQL_INSERT_ACTIVITY);
			
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
