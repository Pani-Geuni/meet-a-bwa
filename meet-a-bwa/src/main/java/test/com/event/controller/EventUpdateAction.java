/**
 * 
 * @author 김예은
 * 이벤트 내용 수정
 *
 */

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

public class EventUpdateAction {
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String event_no = request.getParameter("event_no");
		String event_title = request.getParameter("event_title");
		String event_description = request.getParameter("event_description");
		String event_d_day = request.getParameter("event_d_day");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = null;
		java.sql.Timestamp d_day = null ;
		
		try {
			date = formatter.parse(event_d_day);
			d_day = new java.sql.Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		EventVO vo = new EventVO();
		vo.setEvent_title(event_title);
		vo.setEvent_description(event_description);
		vo.setEvent_d_day(d_day);
		vo.setEvent_no(event_no);
		
		EventDAO dao = new EventDAOImpl();
		int result = dao.update_event(vo);

		
		JSONObject obj = new JSONObject();
		if(result == 1) {
			obj.put("result", "update success");
		}else {
			obj.put("result", "update fail");
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}
}
