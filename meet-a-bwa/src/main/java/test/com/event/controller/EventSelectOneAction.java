/**
 * 
 * @author 김예은
 * 이벤트 상세 보기
 *
 */

package test.com.event.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import test.com.event.model.EventDAO;
import test.com.event.model.EventDAOImpl;
import test.com.event.model.EventVO;
import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;

public class EventSelectOneAction {
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String event_no = request.getParameter("event_no");
		
		EventDAO dao = new EventDAOImpl();
		EventVO vo = dao.event_selectOne(event_no);
		
		UserDAO m_dao = new UserDAOImpl();
		String name = m_dao.selectOne_name(vo.getUser_no());
		
		JSONObject obj = new JSONObject();
		obj.put("event_no", vo.getEvent_no());
		obj.put("event_title", vo.getEvent_title());
		obj.put("event_description", vo.getEvent_description());
		obj.put("activity_no", vo.getActivity_no());
		obj.put("user_no", vo.getUser_no());
		obj.put("user_name", name);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = formatter.format(vo.getEvent_date());
		obj.put("event_date", date);
		
		String d_day = formatter.format(vo.getEvent_d_day());
		obj.put("event_d_day", d_day);
		
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
		
	}
}
