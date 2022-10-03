package test.com.activity.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import test.com.activity.model.ActivityDAO;
import test.com.activity.model.ActivityDAOImpl;
import test.com.activity.model.ActivityVO;
import test.com.activity.model.RegisteredDAO;
import test.com.activity.model.RegisteredDAOImpl;
import test.com.activity.model.RegisteredVO;

public class ActivityFeedWithdrawal_Action {
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
	
	//RegisteredVO rvo = new RegisteredVO();
	//rvo.setUser_no(request.getParameter("user_no"));
	
	RegisteredDAO r_dao = new RegisteredDAOImpl();
	String activity_no = request.getParameter("activity_no");
			
	int result = r_dao.activity_withdrawal(cookie_userNo, activity_no);
	
	System.out.println("result:"+result);
	
	if (result == 1) {
		JSONObject obj = new JSONObject();
		
		obj.put("result", activity_no);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}else {
		response.sendRedirect("/meet-a-bwa/activity-main.do?idx="+activity_no);
	}
		

	} // end if << isMultipartContent
}
