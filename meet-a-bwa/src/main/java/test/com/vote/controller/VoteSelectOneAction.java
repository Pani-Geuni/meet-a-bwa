package test.com.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;
import test.com.vote.model.VoteVO;

public class VoteSelectOneAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VoteDAO vdao = new VoteDAOImpl();
		
		if (request.getParameter("vote_no") != null) {
			String vote_no = request.getParameter("vote_no");
			System.out.println("SelectOne vote_no : " + vote_no);
			
			VoteVO vvo = new VoteVO();
			
			vvo.setVote_no(vote_no);
			
			VoteVO vvo2 = vdao.vote_selectOne(vvo);
			
			System.out.println("vvo2");
			System.out.println(vvo2.getVote_no() + " " + vvo2.getVote_title() + " " + vvo2.getVote_content());
			
			request.setAttribute("vvo2", vvo2);
		}
	}
}
