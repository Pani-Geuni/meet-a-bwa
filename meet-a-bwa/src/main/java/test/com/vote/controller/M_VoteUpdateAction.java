/**
 * 
 * @author 김예은
 * 모임 내에 투표 정보 수정
 *
 */

package test.com.vote.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;
import test.com.vote.model.VoteVO;

public class M_VoteUpdateAction {
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vote_no = request.getParameter("vote_no");
		String vote_title = request.getParameter("vote_title");
		String vote_description = request.getParameter("vote_description");
		String vote_eod = request.getParameter("vote_eod");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = null;
		java.sql.Timestamp eod = null ;
		
		try {
			date = formatter.parse(vote_eod);
			eod = new java.sql.Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		VoteVO vvo = new VoteVO();
		vvo.setVote_no(vote_no);
		vvo.setVote_title(vote_title);
		vvo.setVote_description(vote_description);
		vvo.setVote_eod(eod);
		
		VoteDAO dao = new VoteDAOImpl();
		int result = dao.update_vote(vvo);
		
		JSONObject obj = new JSONObject();
		if(result == 1) {
			obj.put("result", "update success");
		}else {
			obj.put("result", "update fail");
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}
}
