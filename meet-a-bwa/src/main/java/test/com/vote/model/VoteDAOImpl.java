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
	public VoteVO vote_selectOne(VoteVO vvo) {

		System.out.println("vote selectAll()..");
		
		try {
			conn = DriverManager.getConnection(VoteDB.URL, VoteDB.USER, VoteDB.PASSWORD);
			System.out.println("Vote SelectOne conn secceed");
			
			pstmt = conn.prepareStatement(VoteDB.SQL_VOTE_SELECT_ONE_M);
			
			pstmt.setString(1, vvo.getVote_no());
			rs = pstmt.executeQuery();
			
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
		
		return vvo;
	}
}
