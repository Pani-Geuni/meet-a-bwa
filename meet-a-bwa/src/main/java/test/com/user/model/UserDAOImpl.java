package test.com.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserDAOImpl implements UserDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public UserDAOImpl() {
		System.out.println("DeptDAOimpl()...");

		try {
			Class.forName(DB_oracle.DRIVER_NAME);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//사용자 추가
	@Override
	public int user_insert(UserVO uvo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(DB_oracle.URL,DB_oracle.USER,DB_oracle.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_USER_INSERT);
			pstmt.setString(1, uvo.getUser_id());
			pstmt.setString(2, uvo.getUser_pw());
			pstmt.setString(3, uvo.getUser_name());
			pstmt.setString(4, uvo.getUser_nickname());
			pstmt.setString(4, uvo.getUser_email());
			pstmt.setString(4, uvo.getUser_tel());
			pstmt.setDate(5, (java.sql.Date) new Date()); //안되면 util로 받아보기
			pstmt.setString(6, uvo.getUser_gender());
			pstmt.setString(7, uvo.getUser_region());
			
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

	//사용자의 관심사 추가
	@Override
	public int interest_insert(InterestVO ivo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(DB_oracle.URL,DB_oracle.USER,DB_oracle.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_USER_INSERT_INTEREST);
			pstmt.setString(1, ivo.getInterest_name());

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
