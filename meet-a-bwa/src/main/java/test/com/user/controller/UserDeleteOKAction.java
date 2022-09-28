package test.com.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;
import test.com.user.model.UserVO;

public class UserDeleteOKAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("user_no"));

		UserVO uvo = new UserVO();
		uvo.setUser_no(request.getParameter("user_no"));
		UserDAO dao = new UserDAOImpl();
		int result = dao.user_delete(uvo);
		System.out.println(result);
		if(result==1) {
			//request.getRequestDispatcher("/views/main/USER04.jsp?user_no"+user_no).forward(request, response);
			request.getRequestDispatcher("/views/main/USER04.jsp").forward(request, response);
			}else
				request.getRequestDispatcher("/views/user/u_update.do?user_no"+request.getParameter("user_no")).forward(request, response);
		}

}
