package test.com.vote.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VoteDAOImpl implements VoteDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public VoteDAOImpl() {
		System.out.println("VoteDAOImpl()...");

		try {
			Class.forName(VoteDB.DRIVER_NAME);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public int insert_meetVote(VoteVO vvo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			System.out.println("user insert db conn successed...");
			pstmt = conn.prepareStatement(VoteDB.SQL_VOTE_INSERT_M);
			
		    pstmt.setString(1, vvo.getVote_title());    
			pstmt.setString(2, vvo.getVote_description());
			pstmt.setTimestamp(3, vvo.getVote_eod());
			pstmt.setString(4, vvo.getUser_no());
			pstmt.setString(5, vvo.getMeet_no());
			
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
	public int insert_activityVote(VoteVO vvo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			System.out.println("user insert db conn successed...");
			pstmt = conn.prepareStatement(VoteDB.SQL_VOTE_INSERT_A);
			
			pstmt.setString(1, vvo.getVote_title());    
			pstmt.setString(2, vvo.getVote_description());
			pstmt.setTimestamp(3, vvo.getVote_eod());
			pstmt.setString(4, vvo.getUser_no());
			pstmt.setString(5, vvo.getActivity_no());
			
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
	public int insert_voteContent(VoteContentVO vvo) {
		int flag=0;
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			System.out.println("user insert db conn successed...");
			pstmt = conn.prepareStatement(VoteDB.SQL_V_CONTENT_INSERT);
			
		    pstmt.setString(1, vvo.getVote_no());    
			pstmt.setString(2, vvo.getVote_content());
			
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
	public int delete_result(String vote_no) {
		int flag=0;
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			System.out.println("SQL_DELETE_RESULT db conn successed...");
			pstmt = conn.prepareStatement(VoteDB.SQL_DELETE_RESULT);
		    pstmt.setString(1, vote_no);
			flag=pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = -1;
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
	public int delete_content(String vote_no) {
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			System.out.println("delete_content db conn successed...");
			pstmt = conn.prepareStatement(VoteDB.SQL_DELETE_CONTENT);
			pstmt.setString(1, vote_no);
			flag=pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = -1;
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
	public int delete_vote(String vote_no) {
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			System.out.println("delete_vote db conn successed...");
			pstmt = conn.prepareStatement(VoteDB.SQL_DELETE_VOTE);
			pstmt.setString(1, vote_no);
			flag=pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = -1;
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
	public String select_last_voteNO() {
		String vote_no = "";
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			pstmt = conn.prepareStatement(VoteDB.SQL_SELECT_LAST_VOTE_NO);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vote_no = rs.getString("vote_no");
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
		
		return vote_no;
	}


	@Override
	public List<VoteVO> vote_selectAll() {
		System.out.println("vote selectAll()..");
		
		List<VoteVO> vos = new ArrayList<VoteVO>();
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL, VoteDB.USER, VoteDB.PASSWORD);
			System.out.println("Vote SelectAll conn secceed");
			
			pstmt = conn.prepareStatement(VoteDB.SQL_VOTE_SELECT_ALL_M);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VoteVO vo = new VoteVO();
				vo.setVote_no(rs.getString("VOTE_NO"));
				vo.setVote_title(rs.getString("VOTE_TITLE"));
				vo.setUser_no(rs.getString("USER_NO"));
				vo.setMeet_no(rs.getString("MEET_NO"));
				
				vos.add(vo);
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
		
		return vos;
	}
	
	@Override
	public List<VoteJOIN_VO> vote_selectOne(VoteVO vvo) {
		List<VoteJOIN_VO> list = new ArrayList<VoteJOIN_VO>();
		System.out.println("vote_selectOne()..");
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL, VoteDB.USER, VoteDB.PASSWORD);
			pstmt = conn.prepareStatement(VoteDB.SQL_VOTE_SELECT_ONE_M);
			pstmt.setString(1, vvo.getVote_no());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VoteJOIN_VO vvo2 = new VoteJOIN_VO();
				vvo2.setVote_no(rs.getString("VOTE_NO"));
				vvo2.setVote_title(rs.getString("VOTE_TITLE"));
				vvo2.setVote_description(rs.getString("VOTE_DESCRIPTION"));
				vvo2.setVote_eod(rs.getTimestamp("VOTE_EOD"));
				vvo2.setVote_state(rs.getString("VOTE_STATE"));
				vvo2.setUser_no(rs.getString("USER_NO"));
				vvo2.setMeet_no(rs.getString("MEET_NO"));
				vvo2.setActivity_no(rs.getString("ACTIVITY_NO"));
				vvo2.setContent_no(rs.getString("CONTENT_NO"));
				vvo2.setVote_content(rs.getString("VOTE_CONTENT"));
				
				list.add(vvo2);
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
		
		return list;
	}
	
	@Override
	public List<VoteResultVO> vr_selectOne(String vote_no) {
		List<VoteResultVO> list = new ArrayList<VoteResultVO>();
		System.out.println("vr_selectOne()..");
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL, VoteDB.USER, VoteDB.PASSWORD);
			pstmt = conn.prepareStatement(VoteDB.SQL_VOTE_ALL_RESULT_SELECT_ONE);
			pstmt.setString(1, vote_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VoteResultVO vo = new VoteResultVO();
				vo.setVote_result_no(rs.getString("vote_result_no"));
				vo.setVote_no(rs.getString("vote_no"));
				vo.setUser_no(rs.getString("user_no"));
				vo.setContent_no(rs.getString("content_no"));
				
				list.add(vo);
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
		
		return list;
	}
	
	public String myVr_selectOne(String vote_no, String user_no) {
		String content_no = "";
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL, VoteDB.USER, VoteDB.PASSWORD);
			pstmt = conn.prepareStatement(VoteDB.SQL_VOTE_MY_RESULT_SELECT_ONE);
			pstmt.setString(1, vote_no);
			pstmt.setString(2, user_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				content_no = rs.getString("content_no");
				System.out.println(vote_no + " " + user_no);
				System.out.println("content_no ?? content_no: " + content_no);
			}
		} catch (SQLException e) {
            System.out.println("SQLException1 : " + e);
            content_no = "error";
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
		
		return content_no;
	}


	@Override
	public int insert_result(VoteResultVO vo) {
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			System.out.println("delete_vote db conn successed...");
			pstmt = conn.prepareStatement(VoteDB.SQL_RESERT_INSERT);
			pstmt.setString(1, vo.getVote_no());
			pstmt.setString(2, vo.getUser_no());
			pstmt.setString(3, vo.getContent_no());
			flag = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = -1;
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
	public int update_result(VoteResultVO vo) {
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			pstmt = conn.prepareStatement(VoteDB.SQL_RESERT_UPDATE);
			pstmt.setString(1, vo.getContent_no());
			pstmt.setString(2, vo.getVote_no());
			pstmt.setString(3, vo.getUser_no());
			flag = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = -1;
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
	public int update_vote(VoteVO vo) {
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			pstmt = conn.prepareStatement(VoteDB.SQL_VOTE_UPDATE);
			pstmt.setString(1, vo.getVote_title());
			pstmt.setString(2, vo.getVote_description());
			pstmt.setTimestamp(3, vo.getVote_eod());
			pstmt.setString(4, vo.getVote_no());
			flag = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = -1;
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
	public int update_voteState(String vote_no) {
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL,VoteDB.USER,VoteDB.PASSWORD);
			pstmt = conn.prepareStatement(VoteDB.SQL_VOTE_STATE_UPDATE);
			pstmt.setString(1, vote_no);
			flag = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = -1;
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
	public List<VoteListVO> vote_list_selectAll(String activity_no) {
System.out.println("vote selectAll()..");
		
		List<VoteListVO> vvos = new ArrayList<VoteListVO>();
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL, VoteDB.USER, VoteDB.PASSWORD);
			System.out.println("Vote List SelectAll conn secceed");
			
			pstmt = conn.prepareStatement(VoteDB.SQL_VOTE_SELECT_ALL_A);
			pstmt.setString(1, activity_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VoteListVO vvo = new VoteListVO();
				vvo.setVote_no(rs.getString("VOTE_NO"));
				vvo.setVote_title(rs.getString("VOTE_TITLE"));
				vvo.setVote_description(rs.getString("VOTE_DESCRIPTION"));
				vvo.setVote_eod(rs.getTimestamp("VOTE_EOD"));
				vvo.setVote_state(rs.getString("VOTE_STATE"));
				vvo.setUser_no(rs.getString("USER_NO"));
				vvo.setActivity_no(rs.getString("ACTIVITY_NO"));
				vvo.setUser_cnt(rs.getInt("USER_CNT"));
				
				vvos.add(vvo);
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
		
		return vvos;
	}
}
