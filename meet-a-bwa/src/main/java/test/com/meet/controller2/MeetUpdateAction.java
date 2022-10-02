package test.com.meet.controller2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.com.meet.model2.MeetDAO;
import test.com.meet.model2.MeetDAOImpl;
import test.com.meet.model2.MeetVO;

public class MeetUpdateAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println(request.getParameter("activity_no"));
	
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
		map.put("user_no", cookie_userNo);
		
		request.setAttribute("list", map);
		
		System.out.println("Headercontroller");
		System.out.println(cookie_nickName);
	}else {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isLogin", false);
		request.setAttribute("list", map);
	}
	//**********************************************************************//

	
	MeetVO mvo = new MeetVO();
	mvo.setMeet_no(request.getParameter("meet_no"));
	mvo.setUser_no(request.getParameter("user_no"));
	

	System.out.println("meet_no:::::" + mvo.getMeet_no());
	System.out.println("user_no:::::" + cookie_userNo);
	
	MeetDAO m_dao = new MeetDAOImpl();
	MeetVO mvo2 = m_dao.meet_selectOne(mvo);
	
	System.out.println("+============== update check");
	System.out.println(mvo2.getMeet_image());
	System.out.println("+==============");

	request.setAttribute("mvo2", mvo2);

//	RequestDispatcher rd = request.getRequestDispatcher("/views/activity/ACTI04.jsp");
//	rd.forward(request, response);
	
	request.getRequestDispatcher("/views/meet/MEET06.jsp").forward(request, response);
}
}
