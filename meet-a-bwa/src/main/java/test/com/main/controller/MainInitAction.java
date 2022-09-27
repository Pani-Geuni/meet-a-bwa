package test.com.main.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.activity.model.ActivityDAO;
import test.com.activity.model.ActivityDAOImpl;
import test.com.activity.model.ActivityVO2;
import test.com.meet.model.MeetDAO;
import test.com.meet.model.MeetDAOImpl;
import test.com.meet.model.MeetVO2;

public class MainInitAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isLogin", false);
		
		MeetDAO dao = new MeetDAOImpl();
		List<MeetVO2> list = dao.select_like();
		System.out.println(list);
		
		ActivityDAO dao2 = new ActivityDAOImpl();
		List<ActivityVO2> list2 = dao2.selectAll10();
		System.out.println("list2 : ");
		System.out.println(list2);
		
		request.setAttribute("list", map);
		request.setAttribute("u_list", list);
		request.setAttribute("a_list", list2);
		
		request.getRequestDispatcher("/views/main/MAIN01.jsp").forward(request, response);
			
	}
}
