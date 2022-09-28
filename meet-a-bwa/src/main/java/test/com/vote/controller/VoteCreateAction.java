package test.com.vote.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoteCreateAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vote_title = request.getParameter("vote_title");
		String vote_content = request.getParameter("vote_content");
		String vote_eod = request.getParameter("vote_eod");
		String user_no = request.getParameter("user_no");
		String meet_no = request.getParameter("meet_no");
		String[] contents = request.getParameterValues("contents");
		
		System.out.println("vote_title : " + vote_title);
		System.out.println("vote_content : " + vote_content);
		System.out.println("vote_eod : " + vote_eod);
		System.out.println("user_no : " + user_no);
		System.out.println("meet_no : " + meet_no);
		
		
		for(String content : contents) {
			System.out.println("content : " + content);
		}
		
       
		// 포맷터        
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		
		// 문자열 -> Date       
		Date date = null;
		try {
			date = formatter.parse(vote_eod);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         
		System.out.println(date);
	}
}
