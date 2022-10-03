package test.com.event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EventController
 */
@WebServlet({"/event_create.do", "/event_delete.do", "/event_update.do",  "/event_view.do"})
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet() : " + sPath);
		
		if(sPath.equals("/event_view.do")) {
			new EventSelectOneAction().execute(request, response);
		} else if(sPath.equals("/event_delete.do")) {
			new EventDeleteAction().execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doPost() : " + sPath);
		
		if(sPath.equals("/event_create.do")) {
			new EventInsertAction().execute(request, response);
		} else if(sPath.equals("/event_update.do")) {
			new EventUpdateAction().execute(request, response);
		}
	}

}
