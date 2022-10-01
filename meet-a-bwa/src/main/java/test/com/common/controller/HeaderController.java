package test.com.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.user.controller.MyMeetListAction;
import test.com.user.controller.MyPageAction;

/**
 * Servlet implementation class HeaderController
 */
@WebServlet({"/mypage.do", "/my-meet.do"})
public class HeaderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet..." + sPath);
		
		if(sPath.equals("/mypage.do")) {
			new MyPageAction().execute(request, response);
		} else if(sPath.equals("/my-meet.do")) {
			new MyMeetListAction().execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost..." + request.getServletPath());
		
		
	}

}
