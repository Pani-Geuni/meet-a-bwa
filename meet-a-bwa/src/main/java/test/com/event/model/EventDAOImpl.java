package test.com.event.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
