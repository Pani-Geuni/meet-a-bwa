/**
 * @author 김예은, 최진실
 */
package test.com.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import test.com.activity.model.ActivityVO2;
import test.com.meet.model.MeetVO4;

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
	
	@Override
	public UserVO login(UserVO uvo) {
		UserVO vo = new UserVO();
		
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);

			pstmt = conn.prepareStatement(UserDB.SQL_ID_CHECK);
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
		}
		
		return vo;
	}

	@Override
	public String selectOne_id(String email) {
		String id = "";

		try {
			conn = DriverManager.getConnection(UserDB.URL, UserDB.USER, UserDB.PASSWORD);
			pstmt = conn.prepareStatement(UserDB.SQL_SELECT_ONE_ID);
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
			conn = DriverManager.getConnection(UserDB.URL, UserDB.USER, UserDB.PASSWORD);
			pstmt = conn.prepareStatement(UserDB.SQL_SELECT_ONE_PW);
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
			conn = DriverManager.getConnection(UserDB.URL, UserDB.USER, UserDB.PASSWORD);
			pstmt = conn.prepareStatement(UserDB.SQL_SELECT_ONE_NAME);
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
	public UserVO selectOne_mypage(String no) {
		UserVO vo = new UserVO();
		
		try {
			conn = DriverManager.getConnection(UserDB.URL, UserDB.USER, UserDB.PASSWORD);
			pstmt = conn.prepareStatement(UserDB.SQL_SELECT_ONE_MYPAGE);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
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
		List<MeetVO4> mvos = new ArrayList<MeetVO4>();
		
		try {
			conn = DriverManager.getConnection(UserDB.URL, UserDB.USER, UserDB.PASSWORD);
			pstmt = conn.prepareStatement(UserDB.SQL_SELECT_ALL_M_REGISTERED);
			pstmt.setString(1, user_no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
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
		List<ActivityVO2> avos = new ArrayList<ActivityVO2>();
		
		try {
			conn = DriverManager.getConnection(UserDB.URL, UserDB.USER, UserDB.PASSWORD);
			pstmt = conn.prepareStatement(UserDB.SQL_SELECT_ALL_A_REGISTERED);
			pstmt.setString(1, user_no);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
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
	

	//사용자 추가
	@Override
	public int user_insert(UserVO uvo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
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
			pstmt.setDate(8, date1);
			pstmt.setString(9, uvo.getUser_gender());
			pstmt.setString(10, uvo.getUser_interest());
			pstmt.setString(11, uvo.getUser_city());
			pstmt.setString(12, uvo.getUser_county());
			
			flag = pstmt.executeUpdate(); 
			
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
		UserVO uvo2 = null;
		
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
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
		}
		
		return uvo2;
	}

	@Override
	public UserVO nickCheck(UserVO uvo) {
		UserVO uvo2 = null;
		
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
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
		}
		
		return uvo2;
	}

	@Override
	public UserVO emailCheck(UserVO uvo) {
		UserVO uvo2 = null;
		
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
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
		}
		
		return uvo2;
	}


	@Override
	public UserVO user_selectOne(UserVO uvo) {
		UserVO uvo2 = null;
		
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
			pstmt = conn.prepareStatement(UserDB.SQL_USER_SELECT_ONE);
		    pstmt.setString(1, uvo.getUser_no());    
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				uvo2 = new UserVO();
				uvo2.setUser_no(rs.getString("user_no"));
				uvo2.setUser_image(rs.getString("user_image"));
				uvo2.setUser_id(rs.getString("user_id"));
				uvo2.setUser_pw(rs.getString("user_pw"));
				uvo2.setUser_name(rs.getString("user_name"));
				uvo2.setUser_nickname(rs.getString("user_nickname"));
				uvo2.setUser_email(rs.getString("user_email"));
				uvo2.setUser_tel(rs.getString("user_tel"));
				uvo2.setUser_birth(rs.getDate("user_birth"));
				uvo2.setUser_gender(rs.getString("user_gender"));
				uvo2.setUser_interest(rs.getString("user_interest"));
				uvo2.setUser_city(rs.getString("user_city"));
				uvo2.setUser_county(rs.getString("user_county"));
				uvo2.setUser_state(rs.getString("user_state"));
			}
			
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
		return uvo2;
	}


	@Override
	public int user_update(UserVO uvo) {
		int flag=0;
		
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
			pstmt = conn.prepareStatement(UserDB.SQL_USER_UPDATE);

		    pstmt.setString(1, uvo.getUser_image());    
			pstmt.setString(2, uvo.getUser_pw());
			pstmt.setString(3, uvo.getUser_nickname());
			pstmt.setString(4, uvo.getUser_email());
			pstmt.setString(5, uvo.getUser_tel());
			pstmt.setString(6, uvo.getUser_interest());
			pstmt.setString(7, uvo.getUser_city());
			pstmt.setString(8, uvo.getUser_county());
			pstmt.setString(9, uvo.getUser_no());
			
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
	public int user_delete(UserVO uvo) {
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(UserDB.URL,UserDB.USER,UserDB.PASSWORD);
			pstmt = conn.prepareStatement(UserDB.SQL_USER_DELETE);
			pstmt.setString(1, "N"); 
			pstmt.setString(2, uvo.getUser_no()); 
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
