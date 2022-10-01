package test.com.main.controller;

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
import test.com.meet.model.MeetDAO;
import test.com.meet.model.MeetDAOImpl;
import test.com.meet.model.MeetVO2;

public class MainInitAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String like_meet = request.getParameter("like_meet");
		String like_activity = request.getParameter("like_activity");
		
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		System.out.println("INIT session_user_id : " + session_user_id);
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		
		//로그인 O
		if(session_user_id != null) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) { // NullPointerException 처리
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("user_interest")) {
						cookie_interest = cookie.getValue();
					}else if(cookie.getName().equals("user_county")) {
						cookie_county = cookie.getValue();
					}else if(cookie.getName().equals("nick_name")) {
						cookie_nickName = cookie.getValue();
					}
				}
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", true);
			map.put("nick_name", cookie_nickName);
			map.put("interest", cookie_interest);
			map.put("county", cookie_county);
			if(like_meet != null) {
				Cookie cookie = new Cookie("like_meet", like_meet);
				response.addCookie(cookie);
			}
			if(like_activity != null) {
				Cookie cookie1 = new Cookie("like_activity", like_activity);
				response.addCookie(cookie1);
			}
			
			request.setAttribute("list", map);
			
			
			MeetDAO m_dao = new MeetDAOImpl();
			List<MeetVO2> list;
			
			if(cookie_interest == null) {
				list = m_dao.select_county(cookie_county);
			}else {
				list = m_dao.select_interest(cookie_interest);
			}
			System.out.println(list);
			request.setAttribute("u_list", list);
			
		}else {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) { // NullPointerException 처리
				for(int i = 0; i< cookies.length; i++){
					// 유효시간을 0초 설정 삭제하는 효과
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			request.setAttribute("list", map);
			
			MeetDAO m_dao = new MeetDAOImpl();
			List<MeetVO2> list = m_dao.select_like();
			System.out.println(list);
			request.setAttribute("u_list", list);
		}
		
		ActivityDAO dao2 = new ActivityDAOImpl();
		List<ActivityVO2> list2 = dao2.selectAll10();
		
		request.setAttribute("a_list", list2);
		request.setAttribute("checkCategory", "전체");
		
		request.getRequestDispatcher("/views/main/MAIN01.jsp").forward(request, response);
		
	}
}
