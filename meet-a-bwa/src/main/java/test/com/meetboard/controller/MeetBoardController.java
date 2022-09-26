package test.com.meetboard.controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.meetboard.model.MeetBoardDAO;
import test.com.meetboard.model.MeetBoardDAOImpl;
import test.com.meetboard.model.MeetBoardVO;

/**
 * Servlet implementation class MeetBoardController
 */
@WebServlet("/b_insertOK.do")
public class MeetBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MeetBoardDAO dao = new MeetBoardDAOImpl(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sPath = request.getServletPath();
		System.out.println("doPost..." + sPath);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String sPath = request.getServletPath();
		System.out.println("doPost..." + sPath);
		
		if (sPath.equals("/b_insertOK.do")) {
			String board_title = request.getParameter("board_title");
			String board_content = request.getParameter("board_content");
			
			System.out.println(board_title);
			System.out.println(board_content);
			
			MeetBoardVO bvo = new MeetBoardVO();
			
			bvo.setBoard_title(board_title);
			bvo.setBoard_content(board_content);
			
			int result = dao.board_insert(bvo);
			
			System.out.println("result : " + result);
			
			if (result == 1)
				response.sendRedirect("meet-main.do");
			else
				response.sendRedirect("meet-main.do");
			
		}
	}

}
