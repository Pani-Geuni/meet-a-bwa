package test.com.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;
import test.com.user.model.UserVO;

public class UserUpdateAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("user_no"));

		UserVO uvo = new UserVO();
		uvo.setUser_no(request.getParameter("user_no"));

		UserDAO u_dao = new UserDAOImpl();
		UserVO uvo2 = u_dao.user_selectOne(uvo);

		request.setAttribute("uvo2", uvo2);

		RequestDispatcher rd = request.getRequestDispatcher("/views/user/USER03.jsp");
		rd.forward(request, response);
	}
}
