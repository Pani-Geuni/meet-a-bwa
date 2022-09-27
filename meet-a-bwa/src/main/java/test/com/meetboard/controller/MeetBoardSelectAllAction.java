package test.com.meetboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.meetboard.model.MeetBoardDAO;
import test.com.meetboard.model.MeetBoardDAOImpl;
import test.com.meetboard.model.MeetBoardVO;

public class MeetBoardSelectAllAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetBoardDAO dao = new MeetBoardDAOImpl();
		
		List<MeetBoardVO> vos = dao.board_selectAll();
		
		request.setAttribute("vos", vos);
		
		request.getRequestDispatcher("views/meet/MEET02.jsp").forward(request, response);
	}
}
