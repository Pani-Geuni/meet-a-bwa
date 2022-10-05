/**
 * @author 김예은
 * 이메일로 유저 비밀번호 찾기
 */

package test.com.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;

public class FindPwAction {
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		UserDAO dao = new UserDAOImpl();
		String pw = dao.selectOne_pw(email);
		
		JSONObject obj = new JSONObject();
		if(pw.length() > 0)
			obj.put("result", pw);
		else 
			obj.put("result", "not found");
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}
}
