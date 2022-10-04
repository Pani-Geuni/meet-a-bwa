package test.com.activity.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.activity.model.ActivityDAO;
import test.com.activity.model.ActivityDAOImpl;
import test.com.meet_feed.controller.MeetFeedSelectAll_Action;

/**
 * Servlet implementation class ActivityFeedController
 */
@WebServlet({"/activity-main.do", "/a_registered.do", "/a_withdrawal.do", "/activity_like_delete_feed.do", "/activity_like_insert_feed.do"})
public class ActivityFeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityFeedController() {
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

		if (sPath.equals("/activity-main.do")) {
			new ActivityFeedSelectAll_Action().execute(request, response);
		}else if (sPath.equals("/a_registered.do")) {
			new ActivityFeedRegistered_Action().execute(request, response);
		}else if (sPath.equals("/a_withdrawal.do")) {
			new ActivityFeedWithdrawal_Action().execute(request, response);
		} else if(sPath.equals("/activity_like_delete_feed.do")) {
			String activity_no = request.getParameter("activity_no");
			String user_no = request.getParameter("user_no");
			
			ActivityDAO dao = new ActivityDAOImpl();
			int result = dao.delete_activity_like(activity_no, user_no);
			if(result == 1) {
				ActivityDAO a_dao = new ActivityDAOImpl();
				List<String> like_activityNo = a_dao.select_all_activity_like(user_no);
				String like_activityNo_str = String.join("/", like_activityNo);
				
				response.sendRedirect("/meet-a-bwa/activity-main.do?like_activity="+like_activityNo_str);
			}
		} else if(sPath.equals("/activity_like_insert_feed.do")) {
			String activity_no = request.getParameter("activity_no");
			String user_no = request.getParameter("user_no");
			
			ActivityDAO dao = new ActivityDAOImpl();
			int result = dao.insert_activity_like(activity_no, user_no);
			if(result == 1) {
				ActivityDAO a_dao = new ActivityDAOImpl();
				List<String> like_activityNo = a_dao.select_all_activity_like(user_no);
				String like_activityNo_str = String.join("/", like_activityNo);
				
				response.sendRedirect("/meet-a-bwa/activity-main.do?like_activity="+like_activityNo_str);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
