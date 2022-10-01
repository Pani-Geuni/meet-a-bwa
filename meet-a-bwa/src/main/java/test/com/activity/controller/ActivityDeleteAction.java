package test.com.activity.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.com.activity.model.ActivityDAO;
import test.com.activity.model.ActivityDAOImpl;
import test.com.activity.model.ActivityVO;


public class ActivityDeleteAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("activity_no"));
		
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		
		//嚥≪뮄�젃占쎌뵥 O
		if(session_user_id != null) {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("user_interest")) {
					cookie_interest = cookie.getValue();
				}else if(cookie.getName().equals("user_county")) {
					cookie_county = cookie.getValue();
				}else if(cookie.getName().equals("nick_name")) {
					cookie_nickName = cookie.getValue();
				}
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", true);
			map.put("nick_name", cookie_nickName);
			map.put("interest", cookie_interest);
			map.put("county", cookie_county);
			
			request.setAttribute("list", map);
			
			System.out.println("Headercontroller");
			System.out.println(cookie_nickName);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			request.setAttribute("list", map);
		}
		
		ActivityVO avo = new ActivityVO();
		avo.setActivity_no(request.getParameter("activity_no"));
		
		System.out.println("ㅇㅇㅇㅇㅇㅇ:"+request.getParameter("meet_no"));
		
		ActivityDAO a_dao = new ActivityDAOImpl();
		int result = a_dao.activity_delete(avo);
		
		System.out.println(result);
		if(result==1) {
			response.sendRedirect("/meet-a-bwa/meet-main.do?idx=" + request.getParameter("meet_no"));
		}else
			response.sendRedirect("/meet-a-bwa/views/activity/ACTI02.jsp");
		}

}