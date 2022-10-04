package test.com.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.activity.model.ActivityVO2;
import test.com.meet.model.MeetVO4;


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

	@Override
	public String selectOne_id(String email) {
		String id = "";

		try {
			conn = DriverManager.getConnection(MemberDB.URL, MemberDB.USER, MemberDB.PASSWORD);
			pstmt = conn.prepareStatement(MemberDB.SQL_SELECT_ONE_ID);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				id = rs.getString("user_id");
			}
			
		} catch (SQLException e) {
            System.out.println("SQLException1 : " + e);
        } catch (Exception e) {
            System.out.println("Exception1 : " + e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("SQLException2 : " + e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("SQLException3 : " + e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQLException4 : " + e);
                }
            }
        }
		
		return id;
	}
	@Override
	public String selectOne_pw(String email) {
		String pw = "";

		try {
			conn = DriverManager.getConnection(MemberDB.URL, MemberDB.USER, MemberDB.PASSWORD);
			pstmt = conn.prepareStatement(MemberDB.SQL_SELECT_ONE_PW);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pw = rs.getString("user_pw");
			}
			
		} catch (SQLException e) {
            System.out.println("SQLException1 : " + e);
        } catch (Exception e) {
            System.out.println("Exception1 : " + e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("SQLException2 : " + e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("SQLException3 : " + e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQLException4 : " + e);
                }
            }
        }
		
		return pw;
	}
	@Override
	public String selectOne_name(String no) {
		String name = "";

		try {
			conn = DriverManager.getConnection(MemberDB.URL, MemberDB.USER, MemberDB.PASSWORD);
			pstmt = conn.prepareStatement(MemberDB.SQL_SELECT_ONE_NAME);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				name = rs.getString("user_name");
			}
			
		} catch (SQLException e) {
            System.out.println("SQLException1 : " + e);
        } catch (Exception e) {
            System.out.println("Exception1 : " + e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("SQLException2 : " + e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("SQLException3 : " + e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQLException4 : " + e);
                }
            }
        }
		
		return name;
	}

	@Override
	public MemberVO selectOne_mypage(String no) {

		MemberVO vo = new MemberVO();
		
		try {
			conn = DriverManager.getConnection(MemberDB.URL, MemberDB.USER, MemberDB.PASSWORD);
			pstmt = conn.prepareStatement(MemberDB.SQL_SELECT_ONE_MYPAGE);
			pstmt.setString(1, no);		// user_no 넣기
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString("USER_NO") + " ");
				System.out.print(rs.getString("USER_IMAGE") + " ");
				System.out.print(rs.getString("USER_ID") + " ");
				System.out.print(rs.getString("USER_NAME") + " ");
				System.out.print(rs.getString("USER_NICKNAME") + " ");
				System.out.println(rs.getString("USER_EMAIL"));
				
				vo.setUser_no(rs.getString("USER_NO"));
				vo.setUser_image(rs.getString("USER_IMAGE"));
				vo.setUser_id(rs.getString("USER_ID"));
				vo.setUser_name(rs.getString("USER_NAME"));
				vo.setUser_nickname(rs.getString("USER_NICKNAME"));
				vo.setUser_email(rs.getString("USER_EMAIL"));
			}
			
		} catch (SQLException e) {
            System.out.println("SQLException1 : " + e);
        } catch (Exception e) {
            System.out.println("Exception1 : " + e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("SQLException2 : " + e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("SQLException3 : " + e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQLException4 : " + e);
                }
            }
        }
		
		return vo;
	}

	@Override
	public List<MeetVO4> selectAll_myMeet(String user_no) {
		
		System.out.println("my meet list selectAll()...");
		
		List<MeetVO4> mvos = new ArrayList<MeetVO4>();
		
		try {
			conn = DriverManager.getConnection(MemberDB.URL, MemberDB.USER, MemberDB.PASSWORD);
			pstmt = conn.prepareStatement(MemberDB.SQL_SELECT_ALL_M_REGISTERED);
			pstmt.setString(1, user_no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString("REGISTERED_NO") + " ");
				System.out.print(rs.getString("USER_NO") + " ");
				System.out.print(rs.getString("MEET_NO") + " ");
				System.out.print(rs.getString("MEET_NAME") + " ");
				System.out.print(rs.getString("MEET_DESCRIPTION") + " ");
				System.out.print(rs.getString("MEET_COUNTY") + " ");
				System.out.print(rs.getString("MEET_INTEREST_NAME") + " ");
				System.out.print(rs.getString("MEET_GENDER") + " ");
				System.out.print(rs.getInt("MEET_NOP") + " ");
				System.out.print(rs.getInt("MEET_AGE") + " ");
				System.out.print(rs.getInt("LIKE_CNT") + " ");
				System.out.println(rs.getInt("USER_CNT") + " ");
				
				MeetVO4 mvo = new MeetVO4();
				
				mvo.setRegistered_no(rs.getString("REGISTERED_NO"));
				mvo.setUser_no(rs.getString("USER_NO"));
				mvo.setMeet_no(rs.getString("MEET_NO"));
				mvo.setMeet_name(rs.getString("MEET_NAME"));
				mvo.setMeet_description(rs.getString("MEET_DESCRIPTION"));
				mvo.setMeet_county(rs.getString("MEET_COUNTY"));
				mvo.setMeet_interest_name(rs.getString("MEET_INTEREST_NAME"));
				mvo.setMeet_gender(rs.getString("MEET_GENDER"));
				mvo.setMeet_nop(rs.getInt("MEET_NOP"));
				mvo.setMeet_age(rs.getInt("MEET_AGE"));
				mvo.setLike_cnt(rs.getInt("LIKE_CNT"));
				mvo.setUser_cnt(rs.getInt("USER_CNT"));
				
				mvos.add(mvo);
			}
			
		} catch (SQLException e) {
            System.out.println("SQLException1 : " + e);
        } catch (Exception e) {
            System.out.println("Exception1 : " + e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("SQLException2 : " + e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("SQLException3 : " + e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQLException4 : " + e);
                }
            }
        }
		return mvos;
	}

	@Override
	public List<ActivityVO2> selectAll_myActivity(String user_no) {
		
		System.out.println("my activity list selectAll()...");
		
		List<ActivityVO2> avos = new ArrayList<ActivityVO2>();
		
		try {
			conn = DriverManager.getConnection(MemberDB.URL, MemberDB.USER, MemberDB.PASSWORD);
			pstmt = conn.prepareStatement(MemberDB.SQL_SELECT_ALL_A_REGISTERED);
			pstmt.setString(1, user_no);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getString("MEET_NO") + " ");
				System.out.print(rs.getString("REGISTERED_NO") + " ");
				System.out.print(rs.getString("ACTIVITY_NO") + " ");
				System.out.print(rs.getString("USER_NO") + " ");
				System.out.print(rs.getString("ACTIVITY_IMAGE") + " ");
				System.out.print(rs.getString("ACTIVITY_NAME") + " ");
				System.out.print(rs.getString("ACTIVITY_DESCRIPTION") + " ");
				System.out.print(rs.getString("ACTIVITY_CITY") + " ");
				System.out.print(rs.getString("ACTIVITY_INTEREST_NAME") + " ");
				System.out.print(rs.getString("ACTIVITY_GENDER") + " ");
				System.out.print(rs.getString("ACTIVITY_NOP") + " ");
				System.out.print(rs.getString("ACTIVITY_AGE") + " ");
				System.out.print(rs.getString("ACTIVITY_DATE") + " ");
				System.out.print(rs.getString("LIKE_CNT") + " ");
				System.out.println(rs.getString("USER_CNT") + " ");
				
				ActivityVO2 avo = new ActivityVO2();
				
				avo.setMeet_no(rs.getString("MEET_NO"));
				avo.setActivity_no(rs.getString("ACTIVITY_NO"));
				avo.setUser_no(rs.getString("USER_NO"));
				avo.setActivity_image(rs.getString("ACTIVITY_IMAGE"));
				avo.setActivity_name(rs.getString("ACTIVITY_NAME"));
				avo.setActivity_description(rs.getString("ACTIVITY_DESCRIPTION"));
				avo.setActivity_city(rs.getString("ACTIVITY_CITY"));
				avo.setActivity_interest_name(rs.getString("ACTIVITY_INTEREST_NAME"));
				avo.setActivity_gender(rs.getString("ACTIVITY_GENDER"));
				avo.setActivity_nop(rs.getInt("ACTIVITY_NOP"));
				avo.setActivity_age(rs.getInt("ACTIVITY_AGE"));
				avo.setActivity_date(rs.getDate("ACTIVITY_DATE"));
				avo.setLike_cnt(rs.getInt("LIKE_CNT"));
				avo.setUser_cnt(rs.getInt("USER_CNT"));
				
				avos.add(avo);
			}
		} catch (SQLException e) {
            System.out.println("SQLException1 : " + e);
        } catch (Exception e) {
            System.out.println("Exception1 : " + e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("SQLException2 : " + e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("SQLException3 : " + e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQLException4 : " + e);
                }
            }
        }
		
		return avos;
	}

}
