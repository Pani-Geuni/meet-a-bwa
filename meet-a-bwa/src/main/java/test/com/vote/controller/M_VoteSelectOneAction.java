package test.com.vote.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOImpl;
import test.com.vote.model.VoteDAO;
import test.com.vote.model.VoteDAOImpl;
import test.com.vote.model.VoteJOIN_VO;
import test.com.vote.model.VoteVO;

public class M_VoteSelectOneAction {
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vote_no = request.getParameter("vote_no");
		System.out.println("SelectOne vote_no : " + vote_no);
		
		VoteVO vvo = new VoteVO();
		vvo.setVote_no(vote_no);
		
		VoteDAO vdao = new VoteDAOImpl();
		List<VoteJOIN_VO> list = vdao.vote_selectOne(vvo);
		
		MemberDAO mem_dao = new MemberDAOImpl();
		
		String vote_title = "";
		String vote_description = "";
		String vote_eod = "";
		String vote_state = "";
		String user_no = "";
		
		JSONObject obj_wrap = new JSONObject();
		JSONArray array = new JSONArray();
		
		for(VoteJOIN_VO vvo2 : list) {
			if(vote_title.equals("")) {
				vote_title = vvo2.getVote_title();
			}
			if(vote_description.equals("")) {
				vote_description = vvo2.getVote_description();
			}
			if(vote_eod.equals("")) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				vote_eod = formatter.format(vvo2.getVote_eod());
			}
			if(vote_state.equals("")) {
				vote_state = vvo2.getVote_state();
			}
			if(user_no.equals("")) {
				user_no = vvo2.getUser_no();
			}
			
			JSONObject obj = new JSONObject();
			obj.put("content_no", vvo2.getContent_no());
			obj.put("content", vvo2.getVote_content());
			array.add(obj);
		}
		
		obj_wrap.put("content_arr", array);
		obj_wrap.put("user_no", user_no);
		obj_wrap.put("user_name", mem_dao.selectOne_name(user_no));
		obj_wrap.put("vote_state", vote_state);
		obj_wrap.put("vote_eod", vote_eod);
		obj_wrap.put("vote_description", vote_description);
		obj_wrap.put("vote_title", vote_title);
		obj_wrap.put("vote_no", vote_no);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj_wrap);
	}
}
