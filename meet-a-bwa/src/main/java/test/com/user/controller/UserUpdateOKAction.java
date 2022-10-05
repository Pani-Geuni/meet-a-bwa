/**
 * @author 최진실
 * 회원 수정 처리
 */

package test.com.user.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
//import java.util.Date;
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

public class UserUpdateOKAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		String cookie_userno="";
		
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

			String user_no =null;
			String user_image = "";
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
						if(item.getFieldName().equals("user_no")) {
							user_no = item.getString("UTF-8");
						}else if(item.getFieldName().equals("image")) {
							user_image = item.getString("UTF-8");
						}
						else if(item.getFieldName().equals("id")) {
							user_id = item.getString("UTF-8");
						}else if(item.getFieldName().equals("pw")) {
							user_pw =  item.getString("UTF-8");
						}else if(item.getFieldName().equals("name")) {
							user_name = item.getString("UTF-8");
						}else if(item.getFieldName().equals("u_nickname")) {
							user_nickname = item.getString("UTF-8");
						}else if(item.getFieldName().equals("email")) {
							user_email = item.getString("UTF-8");
						}else if(item.getFieldName().equals("tel")) {
							user_tel = item.getString("UTF-8");
						}
						else if(item.getFieldName().equals("birth")) {
							user_birth =java.sql.Date.valueOf(item.getString("UTF-8")); 
							System.out.println("insertOKAction:" + (user_birth instanceof Date));
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
						if (item.getSize() != 0) {
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
			uvo.setUser_no(user_no);
			uvo.setUser_image(user_image==null?"/meet-a-bwa/resources/img/placeholder1.webp":"/meet-a-bwa/resources/img/"+user_image);
			uvo.setUser_pw(user_pw);
			uvo.setUser_nickname(user_nickname);
			uvo.setUser_email(user_email);
			uvo.setUser_tel(user_tel);
			uvo.setUser_interest(user_interest);
			uvo.setUser_city(user_city);
			uvo.setUser_county(user_county);
			
			//image 
			UserDAO test_dao = new UserDAOImpl();
			UserVO uvo2 = test_dao.user_selectOne(uvo);
			
			if (user_image.equals("")) {
				// 이전의 이미지가 없을 때
				user_image = "/meet-a-bwa/resources/img/default-image2.png";
				
				// 기존의 이미지가 있는데, 모임 수정 시 이미지는 변경하지 않을 때.
				if (!uvo2.getUser_image().equals(user_image)) {
					user_image = uvo2.getUser_image();
				}
			} else {
				// 변경 된 이미지가 있을 때 
				user_image = "/meet-a-bwa/resources/img/" + user_image;
			}
			
			uvo.setUser_image(user_image);
			
			
			UserDAO u_dao = new UserDAOImpl();
			int result = u_dao.user_update(uvo);

			if(result==1) {
				response.sendRedirect("/meet-a-bwa/mypage.do");
			}else
				response.sendRedirect("u_update.do" + cookie_userno);
			}
		
		} 
	
}
