package test.com.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet({ "/u_insert.do", "/u_insertOK.do", "/idCheck.do", "/nickCheck.do", "/emailCheck.do", "/u_update.do", "/u_updateOK.do","/u_delete.do","/u_deleteOK.do",
			"/m_loginOK.do", "/logoutOK.do", "/pw_find.do", "/id_find.do"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO u_dao = new UserDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet..." + sPath);

		if (sPath.equals("/u_insert.do")) {
			request.getRequestDispatcher("views/user/USER02.jsp").forward(request, response);
		}else if(sPath.equals("/idCheck.do")) {
			new IdCheckAction().execute(request,response);
		}else if(sPath.equals("/nickCheck.do")) {
			new NickCheckAction().execute(request,response);
		}else if(sPath.equals("/emailCheck.do")) {
			new EmailCheckAction().execute(request,response);
		}else if (sPath.equals("/u_update.do")) {
			new UserUpdateAction().execute(request, response);
		}else if(sPath.equals("/u_delete.do")) {
			new UserDeleteOKAction().execute(request, response);
		}else if(sPath.equals("/u_deleteOK.do")) {
			new LogoutOKAction().execute(request, response);
		}else if(sPath.equals("/logoutOK.do")) {
			new LogoutOKAction().execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String sPath = request.getServletPath();
		System.out.print("doPost:");
		System.out.println(sPath); 
		
		if (sPath.equals("/u_insertOK.do")) {
			new UserInsertOKAction().execute(request, response);
		}else if (sPath.equals("/u_updateOK.do")) {
			new UserUpdateOKAction().execute(request, response);
		}else if(sPath.equals("/m_loginOK.do")) {
			new LoginOKAction().execute(request, response);
		} else if(sPath.equals("/id_find.do")) {
			new FindIdAction().execute(request, response);
		} else if(sPath.equals("/pw_find.do")) {
			new FindPwAction().execute(request, response);
		}
	}

}
