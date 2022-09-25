package test.com.main.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import test.com.meet.model.MeetDAO;
import test.com.meet.model.MeetDAOImpl;
import test.com.meet.model.MeetVO2;

public class MainInitAction {
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        
		boolean isLogin =  Boolean.parseBoolean(request.getParameter("isLogin"));
		
		// 사용자가 로그인했을 때
		if(isLogin) {
			String userInterest = request.getParameter("userInterest");
			String userRegion = request.getParameter("userRegion");
			
			if(userInterest.equals("")) {
				// 설정한 관심사 없을 때
				// 사용자 지역에 있는 리스트 인기순으로 나열
				System.out.println("설정한 관심사가 없습니다.");
			}else {
				// 설정한 관심사 있을 때
			}
		}else { // 사용자가 로그인하지 않았을 때
			// 좋아요 많은 순으로 
			System.out.println("false");
			
			MeetDAO dao = new MeetDAOImpl();
			List<MeetVO2> list = dao.select_like();
			JSONObject obj_wrap = new JSONObject();
			JSONArray arr = new JSONArray();
			
			for(MeetVO2 vo : list) {
				JSONObject obj = new JSONObject();
				obj.put("meet_no", vo.getMeet_no());
				obj.put("meet_name", vo.getMeet_name());
				obj.put("meet_description", vo.getMeet_description());
				
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = transFormat.format(vo.getMeet_date());
				
				obj.put("meet_date", date);
				obj.put("user_no", vo.getUser_no());
				obj.put("like_cnt", vo.getLike_cnt());

				arr.add(obj);
			}
			
			obj_wrap.put("list_length", list.size());
			obj_wrap.put("list", arr);
			System.out.println(obj_wrap);
			

			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(obj_wrap);
			
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("/views/main/MAIN01.jsp").forward(request, response);
		}
	}
}
