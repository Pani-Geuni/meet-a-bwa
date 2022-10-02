package test.com.comment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public CommentDAOImpl() {
		System.out.println("CommentDAOImpl()...");
		
		try {
			Class.forName(CommentDB.DRIVER_NAME);
			System.out.println("Comment Driver succeed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int comment_insert(CommentVO cvo) {
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(CommentDB.URL, CommentDB.TEST_USER, CommentDB.TEST_PASSWORD);
			System.out.println("Comment conn succeed....");
			
			pstmt = conn.prepareStatement(CommentDB.SQL_COMMENT_INSERT);
			
			pstmt.setString(1, cvo.getMother_no());
			pstmt.setString(2, cvo.getComment_content());
			pstmt.setString(3, cvo.getBoard_no());
			pstmt.setString(4, cvo.getUser_no());
			
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
	public List<CommentVO> comment_selectAll(String board_no) {
		System.out.println("comment selectAll()...");
		
		List<CommentVO> cvos = new ArrayList<CommentVO>();
		
		try {
			conn = DriverManager.getConnection(CommentDB.URL, CommentDB.TEST_USER, CommentDB.TEST_PASSWORD);
			pstmt = conn.prepareStatement(CommentDB.SQL_COMMENT_SELECT_ALL);
			pstmt.setString(1, board_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString("COMMENT_NO") + " ");
				System.out.print(rs.getString("MOTHER_NO") + " ");
				System.out.print(rs.getDate("COMMENT_DATE") + " ");
				System.out.print(rs.getString("COMMENT_CONTENT") + " ");
				System.out.print(rs.getString("BOARD_NO") + " ");
				System.out.print(rs.getString("USER_NO") + " ");
				System.out.println(rs.getString("USER_NICKNAME") + " ");
				
				CommentVO vo = new CommentVO();
				vo.setComment_no(rs.getString("COMMENT_NO"));
				vo.setMother_no(rs.getString("MOTHER_NO"));
				vo.setComment_date(rs.getDate("COMMENT_DATE"));
				vo.setComment_content(rs.getString("COMMENT_CONTENT"));
				vo.setBoard_no(rs.getString("BOARD_NO"));
				vo.setUser_no(rs.getString("USER_NO"));
				vo.setUser_nickname(rs.getString("USER_NICKNAME"));
				
				cvos.add(vo);
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
		
		return cvos;
	}

}
