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
@WebServlet({ "/u_insert.do", "/u_insertOK.do" })
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
		System.out.println("doGet...");
		String sPath = request.getServletPath();
		System.out.println(sPath);

		if (sPath.equals("/u_insert.do")) {
			request.getRequestDispatcher("user/JOIN01.jsp").forward(request, response);
		} else if (sPath.equals("/u_insertOK.do")) {
			response.sendRedirect("/u_insert.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
		// doGet(request, response);
		String sPath = request.getServletPath();
		System.out.print("doPost:");
		System.out.println(sPath); // 서버에 프린트
		if (sPath.equals("/u_insertOK.do")) {
			new UserInsertOKAction().execute(request, response);
		}
	}

}
