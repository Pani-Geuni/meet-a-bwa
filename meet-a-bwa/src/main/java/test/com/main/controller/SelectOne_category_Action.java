/**
 * 
 * @author 김예은
 * 액티비티 카테고리 눌렀던 것 그대로 로드될 떄 눌림표시하기위한 로직
 *
 */

package test.com.main.controller;

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

public class SelectOne_category_Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
				
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
			
			
			MeetDAO m_dao = new MeetDAOImpl();
			List<MeetVO2> list;
			
			if(cookie_interest == null) {
				list = m_dao.select_county(cookie_county);
			}else {
				list = m_dao.select_interest(cookie_interest);
			}
			request.setAttribute("u_list", list);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			request.setAttribute("list", map);
			
			MeetDAO m_dao = new MeetDAOImpl();
			List<MeetVO2> list = m_dao.select_like();
			request.setAttribute("u_list", list);
		}
		
		ActivityDAO dao2 = new ActivityDAOImpl();
		if(category.equals("전체")) {
			List<ActivityVO2> list2 = dao2.selectAll10();
			request.setAttribute("a_list", list2);
		}else {
			List<ActivityVO2> list2 = dao2.selectCate10(category);
			request.setAttribute("a_list", list2);
		}
		request.setAttribute("checkCategory", category);
		
		request.getRequestDispatcher("/views/main/MAIN01.jsp").forward(request, response);

	}
}
