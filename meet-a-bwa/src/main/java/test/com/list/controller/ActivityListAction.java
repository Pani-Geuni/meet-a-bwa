/**
 * 
 * @author 전판근
 * 액티비티 더보기 / 검색 리스트
 *
 */

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

import test.com.activity.model.ActivityDAO;
import test.com.activity.model.ActivityDAOImpl;
import test.com.activity.model.ActivityVO2;

public class ActivityListAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String searchWord = request.getParameter("searchWord");
		String like_activity = request.getParameter("like_activity");
		
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		String cookie_category = "";
		
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
					}else if(cookie.getName().equals("category")) {
						cookie_category = cookie.getValue();
					}
				}
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", true);
			map.put("nick_name", cookie_nickName);
			map.put("interest", cookie_interest);
			map.put("county", cookie_county);
			map.put("category", cookie_category);
			
			if (like_activity != null) {
				Cookie cookie = new Cookie("like_activity", like_activity);
				response.addCookie(cookie);
			}
			
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
		
		ActivityDAO adao = new ActivityDAOImpl();
		List<ActivityVO2> a_list = null;
		
		a_list = adao.select_all_more_like(category, searchWord);
		
		request.setAttribute("a_list", a_list);
		request.setAttribute("checkCategory", category);
		
		request.getRequestDispatcher("views/activity/ACTI01.jsp").forward(request, response);
	}
}
