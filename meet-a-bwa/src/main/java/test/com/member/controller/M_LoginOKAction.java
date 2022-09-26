package test.com.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.valves.rewrite.Substitution.MapElement;

import test.com.meet.model.MeetDAO;
import test.com.meet.model.MeetDAOImpl;
import test.com.meet.model.MeetVO2;
import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOImpl;
import test.com.member.model.MemberVO;

public class M_LoginOKAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberVO vo = new MemberVO();
		vo.setMember_id(id);
		vo.setMember_pw(pw);
		
		
		MemberDAO dao = new MemberDAOImpl();
		MemberVO vo2 = dao.login(vo);
		
		if(vo2.getMember_no() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member_id", vo2.getMember_id());
			
			// 쿠키 생성
			Cookie cookie1 = new Cookie("isLogin", "true");
			Cookie cookie2 = new Cookie("member_no", vo2.getMember_no());
			Cookie cookie3 = new Cookie("member_interest", vo2.getMember_interest());

			// 쿠키를 클라이언트로 전송
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", true);
			map.put("nick_name", vo2.getMember_nickname());
			map.put("interest", vo2.getMember_interest());
			map.put("county", vo2.getMember_county());
			
			request.setAttribute("list", map);
			
			MeetDAO m_dao = new MeetDAOImpl();
			List<MeetVO2> list = m_dao.select_like();
			request.setAttribute("m_list", list);
			
		}else {
			HttpSession session = request.getSession();
			session.removeAttribute("member_id");
			
			// 쿠키 생성
			Cookie cookie1 = new Cookie("isLogin", "false");
			Cookie cookie2 = new Cookie("member_no", "");
			Cookie cookie3 = new Cookie("member_interest", "");

			// 쿠키를 클라이언트로 전송
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			
			request.setAttribute("list", map);
		}
		
		request.getRequestDispatcher("/views/main/MAIN01.jsp").forward(request, response);
	}
}
