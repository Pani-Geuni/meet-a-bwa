package test.com.meetboard.controller;

import java.io.IOException;
import java.util.HashMap;
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

public class MeetBoardSelectOneAction {
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
		
		
		MeetBoardDAO dao = new MeetBoardDAOImpl();
		
		if (request.getParameter("board_no") != null) {
			String board_no = request.getParameter("board_no");
			System.out.println("SelectOne board_no :" + board_no);
			
			MeetBoardVO bvo = new MeetBoardVO();
			
			bvo.setBoard_no(board_no);
			System.out.println("board_no check 1 : " + board_no);
			
			MeetBoardVO bvo2 = dao.board_selectOne(bvo);
			
			System.out.println("board_no check 2 : " + board_no);
			System.out.println("board of meet no check : " + bvo.getMeet_no());
			
			request.setAttribute("bvo2", bvo2);
			
			// 모임 정보 불러오기
			MeetDAO mdao = new MeetDAOImpl();
			MeetVO3 mvo = new MeetVO3();
			
			mvo.setMeet_no(bvo2.getMeet_no());
			
			MeetVO3 mvo3 = mdao.meet_selectOne(mvo);
			
			request.setAttribute("mvo3", mvo3);
			
			request.getRequestDispatcher("views/meet/MEET03.jsp").forward(request, response);
		} else {
			response.sendRedirect("meet-main.do");
		}
	}
}
