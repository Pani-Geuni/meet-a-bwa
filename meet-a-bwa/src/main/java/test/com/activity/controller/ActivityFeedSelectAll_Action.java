package test.com.activity.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.com.activity.model.ActivityDAO;
import test.com.activity.model.ActivityDAOImpl;
import test.com.activity.model.ActivityVO2;
import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;
import test.com.vote.model.VoteVO;

public class ActivityFeedSelectAll_Action {
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		String cookie_userNo = "";
		
		//濡쒓렇�씤 O
		if(session_user_id != null) {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("user_interest")) {
					cookie_interest = cookie.getValue();
				}else if(cookie.getName().equals("user_county")) {
					cookie_county = cookie.getValue();
				}else if(cookie.getName().equals("nick_name")) {
					cookie_nickName = cookie.getValue();
				}else if(cookie.getName().equals("user_no")) {
					cookie_userNo = cookie.getValue();
				}
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", true);
			map.put("nick_name", cookie_nickName);
			map.put("interest", cookie_interest);
			map.put("county", cookie_county);
			map.put("user_no", cookie_userNo);
			
			request.setAttribute("list", map);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			request.setAttribute("list", map);
		}
		
		
		String idx = request.getParameter("idx");
		
		
		// activity-cnt(user)-cnt(like)
		ActivityDAO a_dao = new ActivityDAOImpl();
		ActivityVO2 avo = new ActivityVO2();
		avo.setActivity_no(idx);
		
		ActivityVO2 avo2 = a_dao.activity_selectOne_main_feed(avo);
		
		request.setAttribute("avo2", avo2);
		
		// event
//		EventDAO e_dao = new EventDAOImpl();
//		List<EventVO> evos = e_dao.event_selectAll(idx);
//		
//		request.setAttribute("evos", evos);
		
		// vote
		VoteDAO v_dao = new VoteDAOImpl();
		List<VoteVO> vvos = v_dao.vote_selectAll(); 
		
		request.setAttribute("vvos", vvos);
		
		request.getRequestDispatcher("views/activity/ACTI02.jsp").forward(request, response);
	}
}