package test.com.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.comment.model.CommentDAO;
import test.com.comment.model.CommentDAOImpl;
import test.com.comment.model.CommentVO;

public class CommentInsertOKAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Comment Insert OK Action");
		
		String mother_no = request.getParameter("mother_no");
		String comment_content = request.getParameter("comment_content");
		String board_no = request.getParameter("board_no");
		String user_no = request.getParameter("user_no");
		
		CommentVO cvo = new CommentVO();
		
		cvo.setMother_no(mother_no);
		cvo.setComment_content(comment_content);
		cvo.setBoard_no(board_no);
		cvo.setUser_no(user_no);
		
		CommentDAO cdao = new CommentDAOImpl();
		
		int result = cdao.comment_insert(cvo);
		
		if (result == 1)
			response.sendRedirect("/meet-a-bwa/b_selectOne.do?board_no=" + board_no);
		else 
			response.sendRedirect("/meet-a-bwa/b_selectOne.do?board_no=" + board_no);
	}
}
