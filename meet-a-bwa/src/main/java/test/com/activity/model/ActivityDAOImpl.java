package test.com.activity.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import test.com.user.model.UserDB;

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

}
