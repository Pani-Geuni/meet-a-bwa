package test.com.activity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.user.controller.UserDeleteOKAction;

/**
 * Servlet implementation class ActivityController
 */
@WebServlet({ "/a_insert.do", "/a_insertOK.do", "/a_update.do", "/a_updateOK.do", "/a_delete.do" })
public class ActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...");
		String sPath = request.getServletPath();
		System.out.println(sPath);

		if (sPath.equals("/a_insert.do")) {
			new ActivityInsertAction().execute(request, response);
		}else if (sPath.equals("/a_update.do")) {
			new ActivityUpdateAction().execute(request, response);
		}else if(sPath.equals("/a_delete.do")) {
			new ActivityDeleteAction().execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		System.out.print("doPost:");
		System.out.println(sPath);

		if (sPath.equals("/a_insertOK.do")) {
			new ActivityInsertOKAction().execute(request, response);
		}else if (sPath.equals("/a_updateOK.do")) {
			new ActivityUpdateOKAction().execute(request, response);
		}
	}

}
