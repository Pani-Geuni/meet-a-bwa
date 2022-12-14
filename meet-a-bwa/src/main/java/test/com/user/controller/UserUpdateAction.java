/**
 * @author 최진실
 * 회원 수정 처리
 */

package test.com.user.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;
import test.com.user.model.UserVO;

public class UserUpdateAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		String cookie_userNo = "";
		
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
			
			request.setAttribute("list", map);
			
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			request.setAttribute("list", map);
		}
		

		UserVO uvo = new UserVO();
		uvo.setUser_no(cookie_userNo);

		UserDAO u_dao = new UserDAOImpl();
		UserVO uvo2 = u_dao.user_selectOne(uvo);

		request.setAttribute("uvo2", uvo2);
		
        File file = new File("C:\\git-test\\meet-a-bwas\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\meet-a-bwa\\resources\\json\\city.json"); // File객체 생성

		if(file.exists()){ // 파일이 존재하면
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        }

		RequestDispatcher rd = request.getRequestDispatcher("/views/user/USER03.jsp");
		rd.forward(request, response);
	}
}
