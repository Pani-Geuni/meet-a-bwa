/**
 * 
 * @author 전판근
 * 모임 피드 로드 시 필요한 정보 불러오기
 *
 */

package test.com.meet_feed.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import test.com.meet.model.MeetUserVO;
import test.com.meet.model.MeetVO3;
import test.com.meetboard.model.MeetBoardDAO;
import test.com.meetboard.model.MeetBoardDAOImpl;
import test.com.meetboard.model.MeetBoardVO;
import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;
import test.com.vote.model.VoteVO;

public class MeetFeedSelectAll_Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String like_meet = request.getParameter("like_meet");
		
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		String cookie_userNo = "";
		
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
				}else if(cookie.getName().equals("user_no")) {
					cookie_userNo = cookie.getValue();
				}
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", true);
			map.put("nick_name", cookie_nickName);
			map.put("interest", cookie_interest);
			map.put("county", cookie_county);
			map.put("user_no", cookie_userNo);
			
			if (like_meet != null) {
				Cookie cookie = new Cookie("like_meet", like_meet);
				response.addCookie(cookie);
			}
			
			request.setAttribute("list", map);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			request.setAttribute("list", map);
		}
		
		
		String idx = request.getParameter("idx");
		
		// Feed 불러오기
		MeetBoardDAO dao = new MeetBoardDAOImpl();
		List<MeetBoardVO> vos = dao.board_selectAll(idx);
		
		request.setAttribute("vos", vos);
		
		// 모임 정보 불러오기
		MeetDAO mdao = new MeetDAOImpl();
		MeetVO3 mvo = new MeetVO3();
		mvo.setMeet_no(idx);
		
		MeetVO3 mvo3 = mdao.meet_selectOne(mvo);
		
		request.setAttribute("mvo3", mvo3);
		
		// 모임 가입한 유저 정보 불러오기 - 유저 리스트
		List<MeetUserVO> uvos = mdao.meetUser_selectAll(idx);
		List<String> m_list = new ArrayList<String>();
		
		for (MeetUserVO uvo : uvos) {
			m_list.add(uvo.getUser_no());
		}
		request.setAttribute("m_list", m_list);
		
		// 액티비티 불러오기
		ActivityDAO adao = new ActivityDAOImpl();
		List<ActivityVO2> avos = adao.activity_selectAll_main_feed(idx);
		
		request.setAttribute("avos", avos);
		
		// 투표 불러오기
		VoteDAO vdao = new VoteDAOImpl();
		List<VoteVO> vvos = vdao.vote_selectAll(idx); 
		
		request.setAttribute("vvos", vvos);

		request.getRequestDispatcher("views/meet/MEET02.jsp").forward(request, response);
	}
}
