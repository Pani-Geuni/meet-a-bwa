package test.com.meet.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.activity.controller.ActivityDeleteAction;
import test.com.activity.controller.ActivityInsertAction;
import test.com.activity.controller.ActivityInsertOKAction;
import test.com.activity.controller.ActivityUpdateAction;
import test.com.activity.controller.ActivityUpdateOKAction;

/**
 * Servlet implementation class MeemController
 */
@WebServlet({"/m_insert.do", "/m_insertOK.do", "/m_update.do", "/m_updateOK.do", "/m_delete.do" })
public class MeetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...");
		String sPath = request.getServletPath();
		System.out.println(sPath);

		if (sPath.equals("/m_insert.do")) {
			new MeetInsertAction().execute(request, response);
		}else if (sPath.equals("/m_update.do")) {
			new MeetUpdateAction().execute(request, response);
		}else if(sPath.equals("/m_delete.do")) {
			new MeetyDeleteAction().execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // �ѱ� ���� ����
		// doGet(request, response);
		String sPath = request.getServletPath();
		System.out.print("doPost:");
		System.out.println(sPath); // ������ ����Ʈ
		if (sPath.equals("/m_insertOK.do")) {
			new MeetInsertOKAction().execute(request, response);
		}else if (sPath.equals("/m_updateOK.do")) {
			new MeetUpdateOKAction().execute(request, response);
		}
	}

}
