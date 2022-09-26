package test.com.main.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		MeetDAO dao = new MeetDAOImpl();
		List<MeetVO2> list = dao.select_like();
		
		System.out.println(list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isLogin", false);
		
		request.setAttribute("list", map);
		request.setAttribute("m_list", list);
		
		request.getRequestDispatcher("/views/main/MAIN01.jsp").forward(request, response);
			
	}
}
