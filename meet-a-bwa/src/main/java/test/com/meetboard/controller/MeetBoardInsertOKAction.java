package test.com.meetboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.meetboard.model.MeetBoardDAO;
import test.com.meetboard.model.MeetBoardDAOImpl;
import test.com.meetboard.model.MeetBoardVO;

public class MeetBoardInsertOKAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========= insert OK =========");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String meet_no = request.getParameter("meet_no");
		String user_no = request.getParameter("user_no");
		
		System.out.println(board_title);
		System.out.println(board_content);
		System.out.println(meet_no);
		System.out.println(user_no);
		
		System.out.println("=================");
		
		MeetBoardDAO dao = new MeetBoardDAOImpl();
		
		MeetBoardVO bvo = new MeetBoardVO();
		
		bvo.setBoard_title(board_title);
		bvo.setBoard_content(board_content);
		bvo.setMeet_no(meet_no);
		bvo.setUser_no(user_no);
		
		int result = dao.board_insert(bvo);
		
		System.out.println("result : " + result);
		
		if (result == 1)
			response.sendRedirect("/meet-a-bwa/meet-main.do?idx=" + meet_no);
		else
			response.sendRedirect("/meet-a-bwa/meet-main.do?idx=" + meet_no);
	}
}
