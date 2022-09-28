package test.com.common.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HeaderController
 */
@WebServlet({"/mypage.do", "/main.do"})
public class HeaderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet..." + sPath);
		
		if(sPath.equals("/mypage.do")) {
//			TODO : 추후 Action 추가해야 함.
			
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
			
			request.getRequestDispatcher("/views/user/USER04.jsp").forward(request, response);
		}else if(sPath.equals("/main.do")) {
			request.getRequestDispatcher("/views/main/MAIN01.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost..." + request.getServletPath());
		
		
	}

}
