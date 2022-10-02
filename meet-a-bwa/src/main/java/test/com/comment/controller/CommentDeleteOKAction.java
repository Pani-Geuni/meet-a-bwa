package test.com.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import test.com.comment.model.CommentDAO;
import test.com.comment.model.CommentDAOImpl;
import test.com.comment.model.CommentVO;

public class CommentDeleteOKAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommentDAO cdao = new CommentDAOImpl();
		CommentVO cvo = new CommentVO();
		
		String comment_no = request.getParameter("comment_no");
		
		cvo.setComment_no(comment_no);
		
		int result = cdao.comment_delete(cvo);
		
		if (result == 1) {
			JSONObject obj = new JSONObject();
			
			obj.put("result", (String) cvo.getComment_no());
			
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(obj);
			
			
		}
	}
}
