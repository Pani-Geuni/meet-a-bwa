package test.com.meet.controller2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.com.meet.model.MeetDAO;
import test.com.meet.model.MeetDAOImpl;
import test.com.meet.model.MeetUserVO;
import test.com.meet.model.MeetVO3;

public class MeetDetailAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		String cookie_userNo = "";
		
		//로그인 O
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
		
		// 모임 정보 불러오기
		MeetDAO mdao = new MeetDAOImpl();
		MeetVO3 mvo = new MeetVO3();
		mvo.setMeet_no(idx);
				
		MeetVO3 mvo3 = mdao.meet_selectOne(mvo);
				
		request.setAttribute("mvo3", mvo3);
		
		// 모임 가입한 유저 정보 불러오기 - 유저 리스트
		List<MeetUserVO> uvos = mdao.meetUser_selectAll(idx);
		List<String> m_list = new ArrayList<String>();
				
		for (MeetUserVO uvo : uvos) {
			System.out.println(uvo.getUser_no());
				m_list.add(uvo.getUser_no());
		}
		request.setAttribute("m_list", m_list);
		
		request.getRequestDispatcher("views/meet/MEET07.jsp").forward(request, response);
	}
}
