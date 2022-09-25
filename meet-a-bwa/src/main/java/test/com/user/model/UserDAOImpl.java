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
			Class.forName(UserDB.DRIVER_NAME);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void jdbcConnectionTest() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(UserDB.URL, UserDB.USER, UserDB.PASSWORD);
			System.out.println("conn successed...");
			String sql = "select version() as version";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("version"));
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
	}
	//����� �߰�
	@Override
	public int user_insert(UserVO uvo,InterestVO ivo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(UserDB.SQL_USER_INSERT);
			pstmt = conn.prepareStatement(UserDB.SQL_USER_INSERT_INTEREST);
			pstmt.setString(1, uvo.getUser_id());
			pstmt.setString(2, uvo.getUser_pw());
			pstmt.setString(3, uvo.getUser_name());
			pstmt.setString(4, uvo.getUser_nickname());
			pstmt.setString(4, uvo.getUser_email());
			pstmt.setString(4, uvo.getUser_tel());
			pstmt.setDate(5, (java.sql.Date) new Date()); //�ȵǸ� util�� �޾ƺ���
			pstmt.setString(6, uvo.getUser_gender());
			pstmt.setString(1, ivo.getInterest_name());
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

	@Override
	public UserVO idCheck(UserVO uvo) {
		System.out.println("idCheck()...");
		
		UserVO uvo2 = null;
		
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(UserDB.SQL_ID_CHECK);
			pstmt.setString(1, uvo.getUser_id());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				uvo2 = new UserVO();
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
		
		return uvo2;
	}

	@Override
	public UserVO nickCheck(UserVO uvo) {
		System.out.println("nickCheck()...");
		
		UserVO uvo2 = null;
		
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(UserDB.SQL_NICK_CHECK);
			pstmt.setString(1, uvo.getUser_nickname());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				uvo2 = new UserVO();
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
		
		return uvo2;
	}

	@Override
	public UserVO emailCheck(UserVO uvo) {
		System.out.println("emailCheck()...");
		
		UserVO uvo2 = null;
		
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(UserDB.SQL_EMAIL_CHECK);
			pstmt.setString(1, uvo.getUser_email());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				uvo2 = new UserVO();
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
		
		return uvo2;
	}

	//������� ���ɻ� �߰�
//	@Override
//	public int interest_insert(InterestVO ivo) {
//		int flag=0;
//		try {
//			conn = DriverManager.getConnection(DB_oracle.URL,DB_oracle.USER,DB_oracle.PASSWORD);
//			System.out.println("conn successed...");
//			pstmt = conn.prepareStatement(DB_oracle.SQL_USER_INSERT_INTEREST);
//			pstmt.setString(1, ivo.getInterest_name());
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