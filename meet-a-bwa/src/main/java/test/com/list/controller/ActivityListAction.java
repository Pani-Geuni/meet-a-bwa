package test.com.list.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.activity.model.ActivityDAO;
import test.com.activity.model.ActivityDAOImpl;
import test.com.activity.model.ActivityVO2;

public class ActivityListAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Activity List Action");
		
		
		String category = request.getParameter("category");
		String searchWord = request.getParameter("searchWord");
		System.out.println("category : " + category);
		System.out.println("searchWord : " + searchWord);
		
		ActivityDAO adao = new ActivityDAOImpl();
		List<ActivityVO2> a_list = null;
		
		a_list = adao.select_all_more_like(category, searchWord);
		
		request.setAttribute("a_list", a_list);
		
		request.getRequestDispatcher("views/activity/ACTI01.jsp").forward(request, response);
	}
}
