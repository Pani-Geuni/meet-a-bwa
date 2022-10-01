package test.com.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;

public class A_VoteStateUpdateAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vote_no = request.getParameter("vote_no");
		String meet_no = request.getParameter("meet_no");
		
		System.out.println("vote_no : " + vote_no);
		System.out.println("meet_no : " + meet_no);
		
		VoteDAO dao = new VoteDAOImpl();
		int result = dao.update_voteState(vote_no);
		if(result == 1) {
			response.sendRedirect("/meet-a-bwa/meet-main.do?idx=" + meet_no);
		}
	}
}
