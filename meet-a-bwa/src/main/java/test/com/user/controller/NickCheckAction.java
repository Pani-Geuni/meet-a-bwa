/**
 * @author 최진실
 * 회원가입 시 닉네임 중복 체크
 */

package test.com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;
import test.com.user.model.UserVO;

public class NickCheckAction {

   public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       UserDAO u_dao = new UserDAOImpl();
       UserVO uvo = new UserVO();
       uvo.setUser_nickname(request.getParameter("u_nickname"));
      
       UserVO uvo2 = u_dao.nickCheck(uvo);
       
       
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