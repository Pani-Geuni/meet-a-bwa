/**
 * @author 최진실
 * 회원 가입 처리
 */
package test.com.user.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;
import test.com.user.model.UserVO;

public class UserInsertOKAction {

   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      HttpSession session = request.getSession();
      String session_user_id = (String) session.getAttribute("user_id");
      
      String cookie_interest = "";
      String cookie_county = "";
      String cookie_nickName = "";
      
      if(session_user_id != null) {
         Cookie[] cookies = request.getCookies();
         for(Cookie cookie : cookies) {
            if(cookie.getName().equals("user_interest")) {
               cookie_interest = cookie.getValue();
            }else if(cookie.getName().equals("user_county")) {
               cookie_county = cookie.getValue();
            }else if(cookie.getName().equals("nick_name")) {
               cookie_nickName = cookie.getValue();
            }else if (cookie.getName().equals("user_no"));
         }
         
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("isLogin", true);
         map.put("nick_name", cookie_nickName);
         map.put("interest", cookie_interest);
         map.put("county", cookie_county);
         
         request.setAttribute("list", map);
         
      }else {
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("isLogin", false);
         request.setAttribute("list", map);
      }
      
      String dir_path = request.getServletContext().getRealPath("/resources/img/");
      
      int fileSizeMax = 1024 * 1024 * 100;
      boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);

      if (isMultipartContent) {

         DiskFileItemFactory factory = new DiskFileItemFactory();
         factory.setSizeThreshold(fileSizeMax);
         ServletFileUpload sfu = new ServletFileUpload(factory);
         sfu.setFileSizeMax(fileSizeMax);

         String user_image = null;
         
         String user_id = null;
         String user_pw = null;
         String user_name = null;
         String user_nickname = null;
         String user_email = null;
         String user_tel = null;
         Date user_birth = null;
         String user_gender = null;
         String user_interest = null;
         String user_city = null;
         String user_county = null;
         

         try {
            List<FileItem> items = sfu.parseRequest(request);
            for (FileItem item : items) {

               if (item.isFormField()) {
                  if(item.getFieldName().equals("id")) {
                     user_id = item.getString("UTF-8");
                  }else if(item.getFieldName().equals("pw")) {
                     user_pw =  item.getString("UTF-8");
                  }else if(item.getFieldName().equals("name")) {
                     user_name = item.getString("UTF-8");
                  }else if(item.getFieldName().equals("nickname")) {
                     user_nickname = item.getString("UTF-8");
                  }else if(item.getFieldName().equals("email")) {
                     user_email = item.getString("UTF-8");
                  }else if(item.getFieldName().equals("tel")) {
                     user_tel = item.getString("UTF-8");
                  }
                  else if(item.getFieldName().equals("birth")) {
                     user_birth =java.sql.Date.valueOf(item.getString("UTF-8"));
                  }
                  else if(item.getFieldName().equals("gender")) {
                     user_gender = item.getString("UTF-8");
                  }else if(item.getFieldName().equals("interest")) {
                     user_interest = item.getString("UTF-8");
                  }else if(item.getFieldName().equals("city")) {
                     user_city = item.getString("UTF-8");
                  }else if(item.getFieldName().equals("country")) {
                     user_county = item.getString("UTF-8");
                  }

               } else {
                  if(item.getSize()!=0) {
	                  user_image = FilenameUtils.getName(item.getName());
	                  
	                  File saveFile = new File(dir_path, user_image);
	
	                  try {
	                     item.write(saveFile);
	                  } catch (Exception e) {
	                     e.printStackTrace();
	                  }
                  }
               }
            } 

         } catch (FileUploadException e) {
            e.printStackTrace();
         }
         

         
         UserVO uvo = new UserVO();
         uvo.setUser_id(user_id);
         uvo.setUser_pw(user_pw);
         uvo.setUser_name(user_name);
         uvo.setUser_nickname(user_nickname);
         uvo.setUser_email(user_email);
         uvo.setUser_tel(user_tel);
         uvo.setUser_birth(user_birth);
         uvo.setUser_gender(user_gender);
         uvo.setUser_interest(user_interest);
         uvo.setUser_city(user_city);
         uvo.setUser_county(user_county);
         uvo.setUser_image(user_image==null?"/meet-a-bwa/resources/img/placeholder1.webp":"/meet-a-bwa/resources/img/"+user_image); // 0占싱몌옙 img_001.jpg占쏙옙 占싱뱄옙占쏙옙占쏙옙, 0占쏙옙 占싣니몌옙 img
         
         UserDAO u_dao = new UserDAOImpl();
         int result = u_dao.user_insert(uvo);

         if(result==1) {
            response.sendRedirect("/meet-a-bwa/index.do");
         }else
               request.getRequestDispatcher("/views/user/USER02.jsp").forward(request, response);
         }
      } 
}