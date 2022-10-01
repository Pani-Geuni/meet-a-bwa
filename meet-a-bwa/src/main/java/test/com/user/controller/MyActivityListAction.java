package test.com.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyActivityListAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("== my activity list ! ===");
		
		request.getRequestDispatcher("/views/user/USER06.jsp").forward(request, response);
	}
}
