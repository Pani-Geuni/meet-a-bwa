package test.com.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MemberDAOImpl implements MemberDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public MemberDAOImpl() {
		System.out.println("MemberDAOImpl()...");

		try {
			Class.forName(MemberDB.DRIVER_NAME);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public MemberVO login(MemberVO uvo) {
		MemberVO vo = new MemberVO();
		
		try {
			conn = DriverManager.getConnection(MemberDB.URL,MemberDB.USER,MemberDB.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB.SQL_ID_CHECK);
			pstmt.setString(1, uvo.getUser_id());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if(uvo.getUser_pw().equals(rs.getString("user_pw"))) {
					vo.setUser_no(rs.getString("user_no"));
					vo.setUser_id(rs.getString("user_id"));
					vo.setUser_name(rs.getString("user_name"));
					vo.setUser_nickname(rs.getString("user_nickname"));
					vo.setUser_email(rs.getString("user_email"));
					vo.setUser_tel(rs.getString("user_tel"));
					vo.setUser_birth(rs.getDate("user_birth"));
					vo.setUser_gender(rs.getString("user_gender"));
					vo.setUser_city(rs.getString("user_city"));
					vo.setUser_county(rs.getString("user_county"));
					vo.setUser_state(rs.getString("user_state"));
					vo.setUser_interest(rs.getString("user_interest"));
				}
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
		
		return vo;
	}


}
