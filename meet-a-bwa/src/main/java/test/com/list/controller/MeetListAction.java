package test.com.list.controller;

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
import test.com.meet.model.MeetVO2;

public class MeetListAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Meet List Action");
		
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
			
			request.setAttribute("list", map);
			
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
		}
		
		String type = request.getParameter("type");
		String typeData = request.getParameter("typeData");
		String searchWord = request.getParameter("searchWord");
		
		System.out.println("type : " + type);
		System.out.println("typeData : " + typeData);
		System.out.println("searchWord : " + searchWord);
		
		MeetDAO mldao = new MeetDAOImpl();
		List<MeetVO2> mlvos = null;
		
		// 검색어가 없을 때의 더보기
//		if (typeData.equals("전체")) {
//			if (type.equals("like"))
//				mlvos = mldao.select_like();
//		}
		if (type.equals("like")) {
			System.out.println("-============-------");
			mlvos = mldao.select_all_more_like(searchWord);
		} else if (type.equals("interest")) {
			if (typeData.equals("전체")) {
				System.out.println("-============");
				mlvos = mldao.select_all_more_like(searchWord);
			} else {
				mlvos = mldao.select_all_more_interest(typeData, searchWord);				
			}
		} else if (type.equals("county")) {
			mlvos = mldao.select_all_more_county(typeData, searchWord);
		}
		request.setAttribute("mlvos", mlvos);
		
		request.getRequestDispatcher("views/meet/MEET01.jsp").forward(request, response);
	}

}
