package test.com.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDAOImpl implements UserDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
//	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    
	public UserDAOImpl() {
		System.out.println("DeptDAOimpl()...");

		try {
			Class.forName(UserDB.DRIVER_NAME);
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
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
			System.out.println("user insert db conn successed...");
			pstmt = conn.prepareStatement(UserDB.SQL_USER_INSERT);
			
			 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        String formattedDate = simpleDateFormat.format(uvo.getUser_birth());
		        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
		    pstmt.setString(1, uvo.getUser_image());    
			pstmt.setString(2, uvo.getUser_id());
			pstmt.setString(3, uvo.getUser_pw());
			pstmt.setString(4, uvo.getUser_name());
			pstmt.setString(5, uvo.getUser_nickname());
			pstmt.setString(6, uvo.getUser_email());
			pstmt.setString(7, uvo.getUser_tel());
			System.out.println("DAOImpl:"+date1);
			System.out.println(date1 instanceof Date);
			pstmt.setDate(8,date1); //안되면 util로 받아보기
			pstmt.setString(9, uvo.getUser_gender());
			pstmt.setString(10, uvo.getUser_interest());
			pstmt.setString(11, uvo.getUser_city());
			pstmt.setString(12, uvo.getUser_county());
			
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
			System.out.println("user join id check conn successed...");
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


	//占쏙옙占쏙옙占쏙옙占� 占쏙옙占심삼옙 占쌩곤옙
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
