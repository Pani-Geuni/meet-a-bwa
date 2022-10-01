package test.com.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;


public class A_VoteDeleteAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vote_no = request.getParameter("vote_no");
		String activity_no = request.getParameter("activity_no");
		
		VoteDAO v_dao = new VoteDAOImpl();
		int result_result = v_dao.delete_result(vote_no);
		int result_content = v_dao.delete_content(vote_no);
		int result_vote = v_dao.delete_vote(vote_no);
		
		if(result_result != -1 && result_content != -1 && result_vote != -1) {
			response.sendRedirect("/meet-a-bwa/activity-main.do?idx=" + activity_no);
		}
		
	}
}
