package test.com.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;
import test.com.vote.model.VoteResultVO;

public class M_VoteResult_updateAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vote_no = request.getParameter("vote_no");
		String user_no = request.getParameter("user_no");
		String content_no = request.getParameter("content_no");
		String meet_no = request.getParameter("meet_no");
		
		VoteResultVO vo = new VoteResultVO();
		vo.setVote_no(vote_no);
		vo.setUser_no(user_no);
		vo.setContent_no(content_no);
		
		System.out.println("vote_no : " + vote_no);
		System.out.println("user_no : " + user_no);
		System.out.println("content_no : " + content_no);
		
		
		VoteDAO dao = new VoteDAOImpl();
		int result = dao.update_result(vo);
		
		if(result == 1) {
			response.sendRedirect("/meet-a-bwa/meet-main.do?idx=" + meet_no);
		}
	}
}
