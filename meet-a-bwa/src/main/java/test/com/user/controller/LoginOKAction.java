/**
 * @author 김예은
 * 로그아웃 처리
 */
package test.com.user.controller;

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
import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;
import test.com.user.model.UserVO;

public class LoginOKAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserVO vo = new UserVO();
		vo.setUser_id(id);
		vo.setUser_pw(pw);
		
		UserDAO dao = new UserDAOImpl();
		UserVO vo2 = dao.login(vo);
		
		// 회원 정보가 없거나 탈퇴한 회원의 로그인은 허용하지않음
		if(vo2.getUser_no() != null && !vo2.getUser_state().equals("N")) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", id);
			
			Cookie cookie1 = new Cookie("isLogin", "true");
			Cookie cookie2 = new Cookie("user_no", vo2.getUser_no());
			Cookie cookie3 = new Cookie("user_interest", vo2.getUser_interest());
			Cookie cookie4 = new Cookie("user_county", vo2.getUser_county());
			Cookie cookie5 = new Cookie("nick_name", vo2.getUser_nickname());
			
			MeetDAO m_dao = new MeetDAOImpl();
			List<String> like_meetNo = m_dao.select_all_meet_like(vo2.getUser_no());
			String like_meetNo_str = String.join("/", like_meetNo);
			Cookie cookie6 = new Cookie("like_meet", like_meetNo_str);
			
			ActivityDAO a_dao = new ActivityDAOImpl();
			List<String> like_activityNo = a_dao.select_all_activity_like(vo2.getUser_no());
			String like_activityNo_str = String.join("/", like_activityNo);
			Cookie cookie7 = new Cookie("like_activity", like_activityNo_str);

			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			response.addCookie(cookie4);
			response.addCookie(cookie5);
			response.addCookie(cookie6);
			response.addCookie(cookie7);
			
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", true);
			map.put("nick_name", vo2.getUser_nickname());
			map.put("interest", vo2.getUser_interest());
			map.put("county", vo2.getUser_county());
			
			request.setAttribute("list", map);
			
			List<MeetVO2> list;
			if(vo2.getUser_interest() == null) {
				list = m_dao.select_county(vo2.getUser_county());
			}else {
				list = m_dao.select_interest(vo2.getUser_interest());
			}

			request.setAttribute("u_list", list);
			
		}else {
			HttpSession session = request.getSession();
			session.removeAttribute("user_id");
			
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(int i = 0; i< cookies.length; i++){
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
			
			Cookie cookie1 = new Cookie("isLogin", "false");
			Cookie cookie2 = new Cookie("login_result", "fail");
			

			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			Map<String, Object> login_result = new HashMap<String, Object>();
			login_result.put("login_result", "fail");
			request.setAttribute("login_result", login_result);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			request.setAttribute("list", map);
			
			MeetDAO m_dao = new MeetDAOImpl();
			List<MeetVO2> list = m_dao.select_like();
			request.setAttribute("u_list", list);
		}
		
		ActivityDAO dao2 = new ActivityDAOImpl();
		List<ActivityVO2> list2 = dao2.selectAll10();
		request.setAttribute("a_list", list2);
		request.setAttribute("checkCategory", "전체");

		request.getRequestDispatcher("/views/main/MAIN01.jsp").forward(request, response);
	}
}
