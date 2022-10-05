/**
 * 
 * @author 김예은
 * 액티비티 내에 투표 생성
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

import test.com.vote.model.VoteContentVO;
import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;
import test.com.vote.model.VoteVO;
public class A_VoteCreateAction {
	@SuppressWarnings("unchecked")  // JSONObject
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vote_title = request.getParameter("vote_title");
		String vote_description = request.getParameter("vote_description");
		String vote_eod = request.getParameter("vote_eod");
		String user_no = request.getParameter("user_no");
		String activity_no = request.getParameter("activity_no");
		String[] contents = request.getParameterValues("contents");
		
		// 포맷터        
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		// 문자열 -> Date       
		Date date = null;
		
		// java.util.Date to java.sql.Date
		java.sql.Timestamp eod = null ;
		try {
			date = formatter.parse(vote_eod);
			eod = new java.sql.Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}         
		
		
		VoteVO vo = new VoteVO();
		vo.setVote_title(vote_title);
		vo.setVote_description(vote_description);
		vo.setVote_eod(eod);
		vo.setUser_no(user_no);
		vo.setActivity_no(activity_no);
		
		VoteDAO v_dao = new VoteDAOImpl();
		int result1 = v_dao.insert_activityVote(vo);
		JSONObject obj = new JSONObject();
		
		if(result1 == 1) {
			for(String content : contents) {
				String vote_no = v_dao.select_last_voteNO();
				
				VoteContentVO cvo = new VoteContentVO();
				cvo.setVote_no(vote_no);
				cvo.setVote_content(content);
				
				int result2 = v_dao.insert_voteContent(cvo);
				if(result2 == 0) {
					obj.put("result", "insert fail");
					break;
				}
			}
			if(obj.size() == 0) {
				obj.put("result", "insert success");
			}
		}else {
			obj.put("result", "insert fail");
		}
		
		
		if(obj.size() == 0) {
			obj.put("result", "insert success");
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}
}