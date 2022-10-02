package test.com.meet.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MeetDetailAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Meet Detail");
		
		request.getRequestDispatcher("views/meet/MEET07.jsp").forward(request, response);
	}
}
