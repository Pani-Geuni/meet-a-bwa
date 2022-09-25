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
			pstmt.setString(1, uvo.getMember_id());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if(uvo.getMember_pw().equals(rs.getString("member_pw"))) {
					vo.setMember_no(rs.getString("member_no"));
					vo.setMember_id(rs.getString("member_id"));
					vo.setMember_name(rs.getString("member_name"));
					vo.setMember_nickname(rs.getString("member_nickname"));
					vo.setMember_email(rs.getString("member_email"));
					vo.setMember_tel(rs.getString("member_tel"));
					vo.setMember_birth(rs.getDate("member_birth"));
					vo.setMember_gender(rs.getString("member_gender"));
					vo.setMember_city(rs.getString("member_city"));
					vo.setMember_county(rs.getString("member_county"));
					vo.setMember_state(rs.getString("member_state"));
					vo.setMember_interest(rs.getString("member_interest"));
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
