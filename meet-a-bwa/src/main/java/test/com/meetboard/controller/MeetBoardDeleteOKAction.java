package test.com.meetboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import test.com.meetboard.model.MeetBoardDAO;
import test.com.meetboard.model.MeetBoardDAOImpl;
import test.com.meetboard.model.MeetBoardVO;

public class MeetBoardDeleteOKAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_no = request.getParameter("board_no");
		System.out.println("SelectOne board_no :" + board_no);
		
		MeetBoardDAO dao = new MeetBoardDAOImpl();
		MeetBoardVO bvo = new MeetBoardVO();
		
		bvo.setBoard_no(board_no);
		
		
		int result = dao.board_delete(bvo);
		
		if (result == 1) {
			JSONObject obj = new JSONObject();
			System.out.println(bvo.getBoard_no());
			
			obj.put("result", (String) bvo.getBoard_no());
			
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(obj);
		}
	}
}
