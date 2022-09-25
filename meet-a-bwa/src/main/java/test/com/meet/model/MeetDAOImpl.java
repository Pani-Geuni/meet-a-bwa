package test.com.meet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetDAOImpl implements MeetDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MeetDAOImpl() {
		System.out.println("EmpDAOimpl()...");
		
		try {
			Class.forName(MeetDB.DRIVER_NAME);
			System.out.println("Driver Successed...");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MeetVO2> select_like() {
		List<MeetVO2> l_mvo = new ArrayList<MeetVO2>();
		
		try {
			conn = DriverManager.getConnection(MeetDB.URL, MeetDB.TEST_USER, MeetDB.TEST_PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(MeetDB.SQL_SELECT_ALL_LIKE);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MeetVO2 mvo = new MeetVO2();				
				mvo.setMeet_no(rs.getString("meet_no"));
				mvo.setMeet_name(rs.getString("meet_name"));
				mvo.setMeet_description(rs.getString("meet_name"));
				mvo.setMeet_date(rs.getDate("meet_date"));
				mvo.setUser_no(rs.getString("user_no"));
				mvo.setLike_cnt(rs.getInt("like_cnt"));
				
				l_mvo.add(mvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l_mvo;
	}

}
