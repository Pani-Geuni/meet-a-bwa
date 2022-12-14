/**
 * 
 * @author 김예은
 * 액티비티 내에 투표 참여 결과 추가
 *
 */

package test.com.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;
import test.com.vote.model.VoteResultVO;

public class A_VoteResult_InsertAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vote_no = request.getParameter("vote_no");
		String user_no = request.getParameter("user_no");
		String content_no = request.getParameter("content_no");
		String activity_no = request.getParameter("activity_no");
		
		VoteResultVO vo = new VoteResultVO();
		vo.setVote_no(vote_no);
		vo.setUser_no(user_no);
		vo.setContent_no(content_no);
		
		
		VoteDAO dao = new VoteDAOImpl();
		int result = dao.insert_result(vo);
		
		if(result == 1) {
			response.sendRedirect("/meet-a-bwa/activity-main.do?idx=" + activity_no);
		}
	}
}
