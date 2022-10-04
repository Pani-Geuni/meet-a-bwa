package test.com.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOImpl;

public class FindPwAction {
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println("pw : " + email);
		
		MemberDAO dao = new MemberDAOImpl();
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
