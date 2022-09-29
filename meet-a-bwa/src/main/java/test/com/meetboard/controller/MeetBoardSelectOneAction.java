package test.com.meetboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.meet.model.MeetDAO;
import test.com.meet.model.MeetDAOImpl;
import test.com.meet.model.MeetVO3;
import test.com.meetboard.model.MeetBoardDAO;
import test.com.meetboard.model.MeetBoardDAOImpl;
import test.com.meetboard.model.MeetBoardVO;

public class MeetBoardSelectOneAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetBoardDAO dao = new MeetBoardDAOImpl();
		
		if (request.getParameter("board_no") != null) {
			String board_no = request.getParameter("board_no");
			System.out.println("SelectOne board_no :" + board_no);
			
			MeetBoardVO bvo = new MeetBoardVO();
			
			bvo.setBoard_no(board_no);
			System.out.println("board_no check 1 : " + board_no);
			
			MeetBoardVO bvo2 = dao.board_selectOne(bvo);
			
			System.out.println("board_no check 2 : " + board_no);
			System.out.println("board of meet no check : " + bvo.getMeet_no());
			
			request.setAttribute("bvo2", bvo2);
			
			// 모임 정보 불러오기
			MeetDAO mdao = new MeetDAOImpl();
			MeetVO3 mvo = new MeetVO3();
			
			mvo.setMeet_no(bvo2.getMeet_no());
			
			MeetVO3 mvo3 = mdao.meet_selectOne(mvo);
			
			request.setAttribute("mvo3", mvo3);
			
			request.getRequestDispatcher("views/meet/MEET03.jsp").forward(request, response);
		} else {
			response.sendRedirect("meet-main.do");
		}
	}
}
