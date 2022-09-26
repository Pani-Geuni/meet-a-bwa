package test.com.meetboard.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class MeetBoardDAOImpl implements MeetBoardDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	public MeetBoardDAOImpl() {
		System.out.println("MeetBoardDAOImpl()...");
		
		try {
			Class.forName(MeetBoardDB.DRIVER_NAME);
			System.out.println("Meet Board Driver succeed");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int board_insert(MeetBoardVO bvo) {
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(MeetBoardDB.URL, MeetBoardDB.TEST_USER, MeetBoardDB.TEST_PASSWORD);
			System.out.println("MemberBoard conn succeed...");
			
			pstmt = conn.prepareStatement(MeetBoardDB.SQL_MEET_BOARD_POST_INSERT);
			
			pstmt.setString(1, bvo.getBoard_title());
			pstmt.setString(2, bvo.getBoard_content());
			
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


}
