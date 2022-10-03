package test.com.list.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActivityListAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Activity List Action");
		
		
		String category = request.getParameter("category");
		String searchWord = request.getParameter("searchWord");
		System.out.println("category : " + category);
		System.out.println("searchWord : " + searchWord);
		
		request.getRequestDispatcher("views/activity/ACTI01.jsp").forward(request, response);
	}
}
