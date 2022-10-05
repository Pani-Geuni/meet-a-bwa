/**
 * 
 * @author 전판근
 *
 */

package test.com.meetboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MeetBoardController
 */
@WebServlet({"/b_insertOK.do", "/b_selectOne.do", "/b_deleteOK.do", "/b_updateOK.do" })
public class MeetBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doPost..." + sPath);
		
		if (sPath.equals("/b_selectOne.do")) {
			new MeetBoardSelectOneAction().execute(request, response);
		} else if (sPath.equals("/b_deleteOK.do")) {
			new MeetBoardDeleteOKAction().execute(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String sPath = request.getServletPath();
		System.out.println("doPost..." + sPath);
		
		if (sPath.equals("/b_insertOK.do")) {
			new MeetBoardInsertOKAction().execute(request, response);
		} else if (sPath.equals("/b_updateOK.do")) {
			new MeetBoardUpdateOKAction().execute(request, response);
		}
	}

}
