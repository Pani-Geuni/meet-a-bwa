package test.com.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;
import test.com.user.model.UserVO;

public class UserDeleteOKAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("user_no"));
		
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		
		//濡쒓렇�씤 O
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
			
			System.out.println("Headercontroller");
			System.out.println(cookie_nickName);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			request.setAttribute("list", map);
		}
		
		UserVO uvo = new UserVO();
		uvo.setUser_no(request.getParameter("user_no"));
		System.out.println(uvo);
		UserDAO dao = new UserDAOImpl();
		int result = dao.user_delete(uvo);
		System.out.println(result);
		if(result==1) {
			//request.getRequestDispatcher("/views/main/USER04.jsp?user_no"+user_no).forward(request, response);
			//request.getRequestDispatcher("/views/main/USER04.jsp").forward(request, response);
			request.getRequestDispatcher("/u_deleteOK.do?user_id"+session_user_id).forward(request, response);
			}else
				request.getRequestDispatcher("/u_update.do?user_id"+session_user_id).forward(request, response);
		}

}
