package test.com.vote.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VoteDAOImpl implements VoteDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public VoteDAOImpl() {
		System.out.println("VoteDAOImpl()...");

		try {
			Class.forName(VoteDB.DRIVER_NAME);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert_meetVote(VoteVO vvo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			System.out.println("user insert db conn successed...");
			pstmt = conn.prepareStatement(VoteDB.SQL_VOTE_INSERT_M);
			
		    pstmt.setString(1, vvo.getVote_title());    
			pstmt.setString(2, vvo.getVote_content());
			pstmt.setDate(3, vvo.getVote_eod());
			pstmt.setString(4, vvo.getUser_no());
			pstmt.setString(5, vvo.getMeet_no());
			
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
	public int insert_voteContent(VoteContentVO vvo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			System.out.println("user insert db conn successed...");
			pstmt = conn.prepareStatement(VoteDB.SQL_V_CONTENT_INSERT);
			
		    pstmt.setString(1, vvo.getVote_no());    
			pstmt.setString(2, vvo.getVote_content());
			
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
	public String select_last_voteNO() {
		String vote_no = "";
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			pstmt = conn.prepareStatement(VoteDB.SQL_SELECT_LAST_VOTE_NO);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vote_no = rs.getString("vote_no");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		
		return vote_no;
	}
	
	
}
