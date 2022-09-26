package test.com.user.controller;

import java.io.IOException;
import java.text.ParseException;

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
@WebServlet({ "/u_insert.do", "/u_insertOK.do", "/idCheck.do", "/nickCheck.do", "/emailCheck.do" })
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
		} 
		else if (sPath.equals("/u_insertOK.do")) {
			response.sendRedirect("/u_insert.do");
		}
		
		else if(sPath.equals("/idCheck.do")) {
			new IdCheckAction().execute(request,response);
		}else if(sPath.equals("/nickCheck.do")) {
			new NickCheckAction().execute(request,response);
		}else if(sPath.equals("/emailCheck.do")) {
			new EmailCheckAction().execute(request,response);
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
			try {
				new UserInsertOKAction().execute(request, response);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
