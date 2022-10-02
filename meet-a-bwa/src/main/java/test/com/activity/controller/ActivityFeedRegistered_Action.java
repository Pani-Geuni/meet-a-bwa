package test.com.activity.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.com.activity.model.RegisteredDAO;
import test.com.activity.model.RegisteredDAOImpl;
import test.com.activity.model.RegisteredVO;

public class ActivityFeedRegistered_Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//********************************헤더***********************************//
	HttpSession session = request.getSession();
	String session_user_id = (String) session.getAttribute("user_id");
	
	
	String cookie_interest = "";
	String cookie_county = "";
	String cookie_nickName = "";
	String cookie_userNo = "";
	
	
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
			}else if(cookie.getName().equals("user_no")) {
				cookie_userNo = cookie.getValue();
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isLogin", true);
		map.put("nick_name", cookie_nickName);
		map.put("interest", cookie_interest);
		map.put("county", cookie_county);
		map.put("user_no",cookie_userNo);
		
		request.setAttribute("list", map);
		
		System.out.println("Headercontroller");
		System.out.println(cookie_nickName);
	}else {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isLogin", false);
		request.setAttribute("list", map);
	}
	//**********************************************************************//
	RegisteredVO rvo = new RegisteredVO();
	rvo.setUser_no(request.getParameter("user_no"));
	
	System.out.println("ㅇㅇㅇㅇㅇㅇ:"+request.getParameter("activity_no"));
	
	RegisteredDAO r_dao = new RegisteredDAOImpl();
	int result = r_dao.activity_registered(rvo);
	
	System.out.println(result);
	if(result==1) {
		response.sendRedirect("/meet-a-bwa/activity-main.do?idx=" + request.getParameter("meet_no"));
	}else {
		response.sendRedirect("/meet-a-bwa/views/activity/ACTI02.jsp");
	}
	
		
		
	} // end if << isMultipartContent
}
