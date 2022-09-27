package test.com.meetboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import test.com.meetboard.model.MeetBoardDAO;
import test.com.meetboard.model.MeetBoardDAOImpl;
import test.com.meetboard.model.MeetBoardVO;


/**
 * Servlet implementation class MeetBoardController
 */
@WebServlet({"/b_insertOK.do", "/b_selectOne.do", "/b_deleteOK.do" })
public class MeetBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
       
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
			new MeetBoardSelectOneAction().execute(request, response);
		} else if (sPath.equals("/b_deleteOK.do")) {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String sPath = request.getServletPath();
		System.out.println("doPost..." + sPath);
		
		if (sPath.equals("/b_insertOK.do")) {
			new MeetBoardInsertOKAction().execute(request, response);
		}
	}

}
