package test.com.activity.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import test.com.user.model.UserDB;

public class ActivityDAOImpl implements ActivityDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ActivityDAOImpl() {

		try {
			Class.forName(UserDB.DRIVER_NAME);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int activity_insert(ActivityVO avo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(ActivityDB.URL,ActivityDB.USER,ActivityDB.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(ActivityDB.SQL_ACTIVITY_INSERT);
			pstmt.setString(1, avo.getActivity_name());
			pstmt.setString(2, avo.getActivity_description());
			pstmt.setString(3, avo.getActivity_city());
			pstmt.setString(4, avo.getActivity_county());
			pstmt.setString(5, avo.getActivity_interest_name());
			pstmt.setString(6, avo.getActivity_gender());
			pstmt.setInt(7, avo.getActivity_nop());
			pstmt.setInt(8, avo.getActivity_age());
//			pstmt.setDate(9, (java.sql.Date) new Date());
			pstmt.setString(9, avo.getUser_no()); 
			pstmt.setString(10, avo.getMeet_no()); 
			
			
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
