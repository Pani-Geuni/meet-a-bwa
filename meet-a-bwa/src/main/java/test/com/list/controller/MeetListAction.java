package test.com.list.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MeetListAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Meet List Action");
		
		request.getRequestDispatcher("views/meet/MEET01.jsp").forward(request, response);
	}

}
