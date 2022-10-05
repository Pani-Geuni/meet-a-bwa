/**
 * 
 * @author 전판근, 김예은
 *
 */

package test.com.common.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.activity.model.ActivityDAO;
import test.com.activity.model.ActivityDAOImpl;
import test.com.meet.model.MeetDAO;
import test.com.meet.model.MeetDAOImpl;

/**
 * Servlet implementation class LikeController
 */
@WebServlet({"/meet_like_delete.do", "/meet_like_insert.do", "/activity_like_delete.do", "/activity_like_insert.do"})
public class LikeController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet..." + sPath);
		
		if(sPath.equals("/meet_like_delete.do")) {
			String meet_no = request.getParameter("meet_no");
			String user_no = request.getParameter("user_no");
			
			MeetDAO dao = new MeetDAOImpl();
			int result = dao.delete_meet_like(meet_no, user_no);
			
			if(result == 1) {
				MeetDAO m_dao = new MeetDAOImpl();
				List<String> like_meetNo = m_dao.select_all_meet_like(user_no);
				
				HashSet<String> hashSet = new HashSet<String>(like_meetNo);
				
				String like_meetNo_one = "";
				
				for (String like_meet : hashSet) {
					if (meet_no.equals(like_meet)) {
						like_meetNo_one = like_meet;
					}
				}
				
				response.sendRedirect("/meet-a-bwa/meet-main.do?like_meet="+like_meetNo_one);
				
			}
		} else if(sPath.equals("/meet_like_insert.do")) {
			String meet_no = request.getParameter("meet_no");
			String user_no = request.getParameter("user_no");
			
			MeetDAO dao = new MeetDAOImpl();
			int result = dao.insert_meet_like(meet_no, user_no);
			
			if(result == 1) {
				
				MeetDAO m_dao = new MeetDAOImpl();
				List<String> like_meetNo = m_dao.select_all_meet_like(user_no);
				
				 HashSet<String> hashSet = new HashSet<String>(like_meetNo);
				
				 String like_meetNo_one = "";
				
				for (String like_meet : hashSet) {
					if (meet_no.equals(like_meet)) {
						like_meetNo_one = like_meet;
					}
				}
				
				response.sendRedirect("/meet-a-bwa/meet-main.do?like_meet="+like_meetNo_one);
			}
		} else if(sPath.equals("/main_activity_like_delete.do")) {
			String activity_no = request.getParameter("activity_no");
			String user_no = request.getParameter("user_no");
			
			ActivityDAO dao = new ActivityDAOImpl();
			int result = dao.delete_activity_like(activity_no, user_no);
			if(result == 1) {
				ActivityDAO a_dao = new ActivityDAOImpl();
				List<String> like_activityNo = a_dao.select_all_activity_like(user_no);
				String like_activityNo_str = String.join("/", like_activityNo);
				
				response.sendRedirect("/meet-a-bwa/index.do?like_activity="+like_activityNo_str);
			}
		} else if(sPath.equals("/main_activity_like_insert.do")) {
			String activity_no = request.getParameter("activity_no");
			String user_no = request.getParameter("user_no");
			
			ActivityDAO dao = new ActivityDAOImpl();
			int result = dao.insert_activity_like(activity_no, user_no);
			if(result == 1) {
				ActivityDAO a_dao = new ActivityDAOImpl();
				List<String> like_activityNo = a_dao.select_all_activity_like(user_no);
				String like_activityNo_str = String.join("/", like_activityNo);
				
				response.sendRedirect("/meet-a-bwa/index.do?like_activity="+like_activityNo_str);
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
