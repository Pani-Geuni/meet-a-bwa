package test.com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;
import test.com.user.model.UserVO;

public class idCheckAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("id"));
	    
		UserDAO u_dao = new UserDAOImpl();
	    UserVO uvo = new UserVO();
	    uvo.setUser_id(request.getParameter("id"));
		
	    UserVO uvo2 = u_dao.idCheck(uvo);
	    System.out.println("idCheck:"+uvo2);
	    
	    
	    response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Credentials", "true");
	    
	    PrintWriter out = response.getWriter();
	    if(uvo2 != null){
	    	out.print("{\"result\":\"Not OK\"}");
	    }else{
	    	out.print("{\"result\":\"OK\"}");
	    }
	}
}
