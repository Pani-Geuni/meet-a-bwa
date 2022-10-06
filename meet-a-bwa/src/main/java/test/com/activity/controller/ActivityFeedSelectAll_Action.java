/**
 * 
 * @author 최진실
 * 액티비티 내 필요한 정보 불어오기
 *
 */

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
import test.com.activity.model.ActivityVO3;
import test.com.activity.model.RegisteredVO;
import test.com.event.model.EventDAO;
import test.com.event.model.EventDAOImpl;
import test.com.event.model.EventVO;
import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;
import test.com.vote.model.VoteListVO;

public class ActivityFeedSelectAll_Action {
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String like_activity = request.getParameter("like_activity");
	
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		String cookie_userNo = "";
		
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
			
			if (like_activity != null) {
				Cookie cookie = new Cookie("like_activity", like_activity);
				response.addCookie(cookie);
			}
			
			request.setAttribute("list", map);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			request.setAttribute("list", map);
		}
		
		
		String idx = request.getParameter("idx");
		
		ActivityDAO a_dao = new ActivityDAOImpl();
		ActivityVO3 avo = new ActivityVO3();
		avo.setActivity_no(idx);
		
		ActivityVO3 avo2 = a_dao.activity_selectOne_main_feed(avo);
		
		request.setAttribute("avo2", avo2);
		
		//registered user
		List<RegisteredVO> rvos = a_dao.activity_select_registered(idx);
		request.setAttribute("rvos", rvos);
		
		// event
		EventDAO e_dao = new EventDAOImpl();
		List<EventVO> evos = e_dao.event_list_selectAll(idx);
		
		request.setAttribute("evos", evos);
		
		// vote
		VoteDAO v_dao = new VoteDAOImpl();
		List<VoteListVO> vvos = v_dao.vote_list_selectAll(idx); 
		
		request.setAttribute("vvos", vvos);
		
		if (like_activity != null) {
			response.sendRedirect("/meet-a-bwa/activity-main.do?idx="+idx);
		}
		else request.getRequestDispatcher("views/activity/ACTI02.jsp").forward(request, response);
	}
}
