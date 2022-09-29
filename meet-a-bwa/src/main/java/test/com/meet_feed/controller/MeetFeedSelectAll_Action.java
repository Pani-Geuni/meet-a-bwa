package test.com.meet_feed.controller;

import java.io.IOException;
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
import test.com.meet.model.MeetVO3;
import test.com.meetboard.model.MeetBoardDAO;
import test.com.meetboard.model.MeetBoardDAOImpl;
import test.com.meetboard.model.MeetBoardVO;

public class MeetFeedSelectAll_Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		
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
				}
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", true);
			map.put("nick_name", cookie_nickName);
			map.put("interest", cookie_interest);
			map.put("county", cookie_county);
			
			request.setAttribute("list", map);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			request.setAttribute("list", map);
		}
		
		
		
		String idx = request.getParameter("idx");
		
		MeetBoardDAO dao = new MeetBoardDAOImpl();
		
		// Feed 불러오기
		List<MeetBoardVO> vos = dao.board_selectAll();
		
		request.setAttribute("vos", vos);
		
		// 모임 정보 불러오기
		MeetDAO mdao = new MeetDAOImpl();
		MeetVO3 mvo = new MeetVO3();
		mvo.setMeet_no(idx);
		
		MeetVO3 mvo3 = mdao.meet_selectOne(mvo);
		
		request.setAttribute("mvo3", mvo3);
		
		request.getRequestDispatcher("views/meet/MEET02.jsp").forward(request, response);
	}
}
