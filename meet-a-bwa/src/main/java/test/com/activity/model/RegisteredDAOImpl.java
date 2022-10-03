package test.com.activity.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisteredDAOImpl implements RegisteredDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public RegisteredDAOImpl() {

		try {
			Class.forName(ActivityDB.DRIVER_NAME);
			System.out.println("ActivityDAOImpl Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int activity_withdrawal(String user_no, String activity_no) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(ActivityDB.URL, ActivityDB.USER, ActivityDB.PASSWORD);
			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_WITHDRAWAL);
			pstmt.setString(1, activity_no);
			pstmt.setString(2, user_no);

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
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
		}
		return flag;
	}

	@Override
	public int activity_registered(String user_no, String activity_no) {
		int flag = 0;

		try {
			conn = DriverManager.getConnection(ActivityDB.URL, ActivityDB.USER, ActivityDB.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_REGISTERED);

			pstmt.setString(1, activity_no);
			pstmt.setString(2, user_no);

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
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
		}

		return flag;
	}



//	@Override
//	public int activity_registered(RegisteredVO rvo) {
//		int flag=0;
//		try {
//			conn = DriverManager.getConnection(ActivityDB.URL, ActivityDB.USER, ActivityDB.PASSWORD);
//			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_REGISTERED);
//			pstmt.setString(1, rvo.getActivity_no());    
//			pstmt.setString(2, rvo.getUser_no());
//			
//			flag=pstmt.executeUpdate(); 
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(rs!=null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(pstmt!=null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return flag;
//	}

}
