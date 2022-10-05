/**
 * 
 * @author 김예은
 * 이벤트 삭제 후 원래 페이지로 복귀
 *
 */

package test.com.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.event.model.EventDAO;
import test.com.event.model.EventDAOImpl;


public class EventDeleteAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String event_no = request.getParameter("event_no");
		String activity_no = request.getParameter("activity_no");
		
		EventDAO dao = new EventDAOImpl();
		int result = dao.delete_event(event_no);
		if(result == 1) {
			response.sendRedirect("/meet-a-bwa/activity-main.do?idx=" + activity_no);
		}
	}
}
