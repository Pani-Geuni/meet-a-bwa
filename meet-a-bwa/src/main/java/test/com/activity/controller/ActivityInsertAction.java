package test.com.activity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActivityInsertAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String meet_no = request.getParameter("idx");
		
		System.out.println(meet_no);
		
		request.getRequestDispatcher("views/activity/ACTI03.jsp").forward(request, response);
	}
}
