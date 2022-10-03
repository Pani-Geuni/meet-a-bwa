package test.com.event.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import test.com.event.model.EventDAO;
import test.com.event.model.EventDAOImpl;
import test.com.event.model.EventVO;
import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;

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
