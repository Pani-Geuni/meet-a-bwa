package test.com.meetboard.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MeetBoardDAOImpl implements MeetBoardDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	public MeetBoardDAOImpl() {
		System.out.println("MeetBoardDAOImpl()...");
		
		try {
			Class.forName(MeetBoardDB.DRIVER_NAME);
			System.out.println("Meet Board Driver succeed");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int board_insert(MeetBoardVO bvo) {
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(MeetBoardDB.URL, MeetBoardDB.TEST_USER, MeetBoardDB.TEST_PASSWORD);
			System.out.println("MemberBoard conn succeed...");
			
			pstmt = conn.prepareStatement(MeetBoardDB.SQL_MEET_BOARD_POST_INSERT);
			
			pstmt.setString(1, bvo.getBoard_title());
			pstmt.setString(2, bvo.getBoard_content());
			
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
	public List<MeetBoardVO> board_selectAll() {
		System.out.println("board selectAll()...");
		
		List<MeetBoardVO> vos = new ArrayList<MeetBoardVO>();
		
		try {
			conn = DriverManager.getConnection(MeetBoardDB.URL, MeetBoardDB.TEST_USER, MeetBoardDB.TEST_PASSWORD);
			System.out.println("MemberBoard selectAll conn succeed...");
			
			// 전체 글 불러오기
			pstmt = conn.prepareStatement(MeetBoardDB.SQL_MEET_BOARD_SELECT_ALL_TEST);
			rs = pstmt.executeQuery();
			
			System.out.println("TTEST");
			
			while(rs.next()) {
				System.out.print(rs.getString("BOARD_NO") + " ");
				System.out.print(rs.getString("BOARD_TITLE") + " ");
				System.out.print(rs.getString("BOARD_CONTENT") + " ");
				System.out.print(rs.getDate("BOARD_DATE") + " ");
				System.out.print(rs.getString("USER_NO") + " ");
				System.out.print(rs.getString("MEET_NO") + " ");
				System.out.println(rs.getString("USER_NAME"));
				
				
				MeetBoardVO vo = new MeetBoardVO();
				vo.setBoard_no(rs.getString("BOARD_NO"));
				vo.setBoard_title(rs.getString("BOARD_TITLE"));
				vo.setBoard_content(rs.getString("BOARD_CONTENT"));
				vo.setBoard_date(rs.getDate("BOARD_DATE"));
				vo.setUser_no(rs.getString("USER_NO"));
				vo.setUser_name(rs.getString("USER_NAME"));
			
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


}
