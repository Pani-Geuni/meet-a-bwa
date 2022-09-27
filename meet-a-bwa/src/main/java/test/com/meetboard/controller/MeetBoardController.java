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
@WebServlet({"/b_insertOK.do", "/b_selectOne.do" })
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
		
		if (sPath.equals("/b_selectOne.do")) {
			MeetBoardDAO dao = new MeetBoardDAOImpl();
			
			if (request.getParameter("board_no") != null) {
				String board_no = request.getParameter("board_no");
				System.out.println("SelectOne board_no :" + board_no);
				
				MeetBoardVO bvo = new MeetBoardVO();
				
				bvo.setBoard_no(board_no);
				System.out.println("board_no check 1 : " + board_no);
				
				MeetBoardVO bvo2 = dao.board_selectOne(bvo);
				
				System.out.println("board_no check 2 : " + board_no);
				
				request.setAttribute("bvo2", bvo2);
				
				request.getRequestDispatcher("views/meet/MEET03.jsp").forward(request, response);
			} else {
				response.sendRedirect("meet-main.do");
			}
		}
		
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
