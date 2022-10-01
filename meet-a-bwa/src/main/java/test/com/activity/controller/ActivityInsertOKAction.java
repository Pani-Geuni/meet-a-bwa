package test.com.activity.controller;

import java.io.File;
import java.io.IOException;
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

import test.com.activity.model.ActivityDAO;
import test.com.activity.model.ActivityDAOImpl;
import test.com.activity.model.ActivityVO;

public class ActivityInsertOKAction {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//********************************헤더***********************************//
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		String cookie_userNo = "";
		
		
		//嚥≪뮄�젃占쎌뵥 O
		if(session_user_id != null) {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("user_interest")) {
					cookie_interest = cookie.getValue();
				}else if(cookie.getName().equals("user_county")) {
					cookie_county = cookie.getValue();
				}else if(cookie.getName().equals("nick_name")) {
					cookie_nickName = cookie.getValue();
				}else if(cookie.getName().equals("user_no")) {
					cookie_userNo = cookie.getValue();
				}
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", true);
			map.put("nick_name", cookie_nickName);
			map.put("interest", cookie_interest);
			map.put("county", cookie_county);
			map.put("user_no",cookie_userNo);
			
			request.setAttribute("list", map);
			
			System.out.println("Headercontroller");
			System.out.println(cookie_nickName);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", false);
			request.setAttribute("list", map);
		}
		//**********************************************************************//
		
		String dir_path = request.getServletContext().getRealPath("/resources/img"); 
		System.out.println(dir_path);

		int fileSizeMax = 1024 * 1024 * 100;

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request); 
		
		if (isMultipartContent) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(fileSizeMax);
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setFileSizeMax(fileSizeMax);

			String activity_image = "";
			String activity_name = "";
			String activity_description = "";
			String activity_city = "";
			String activity_county = "";
			String activity_interest_name = "";
			String activity_gender = "";
			Integer activity_nop=0;
			Integer activity_age=0;
//			String activity_date = "";
			String user_no = "";
			String meet_no = "";

			try {
				List<FileItem> items = sfu.parseRequest(request);
				for (FileItem item : items) {

					if (item.isFormField()) {
						if(item.getFieldName().equals("image")) {
							activity_image = item.getString("UTF-8");
						}else if(item.getFieldName().equals("activity_name")) {
							activity_name =  item.getString("UTF-8");
						}else if(item.getFieldName().equals("activity_description")) {
							activity_description = item.getString("UTF-8");
						}else if(item.getFieldName().equals("city")) {
							activity_city = item.getString("UTF-8");
						}else if(item.getFieldName().equals("country")) {
							activity_county = item.getString("UTF-8");
						}else if(item.getFieldName().equals("interest")) {
							activity_interest_name = item.getString("UTF-8");
						}else if(item.getFieldName().equals("gender")) {
							activity_gender = item.getString("UTF-8");
						}else if(item.getFieldName().equals("nop")) {
							activity_nop = Integer.parseInt(item.getString("UTF-8")); 
						}else if(item.getFieldName().equals("age")) {
							String age_re = item.getString("UTF-8").replace("대", "");
							activity_age = Integer.parseInt(age_re);
						}else if(item.getFieldName().equals("user_no")) {
							user_no = item.getString("UTF-8"); 
							System.out.println("user_no:"+user_no);
						}else if(item.getFieldName().equals("meet_no")) {
							meet_no = item.getString("UTF-8"); 
							System.out.println("meet_no:"+meet_no);
						}


						//System.out.println("占쏙옙占십듸옙 키 : " + item.getFieldName());

						//System.out.println("占쏙옙占십듸옙 占쏙옙 : " + item.getString("UTF-8"));

					} else {// upFile占쌨깍옙

						System.out.println("파일의 키 : " + item.getFieldName());
						System.out.println("파일 파일명 : " + item.getName());
						System.out.println("파일 컨텐츠 타입 : " + item.getContentType());
						System.out.println("파일 사이즈  : " + item.getSize());

						if(item.getSize()!=0) { 
						activity_image = FilenameUtils.getName(item.getName());
							
						
						
						File saveFile = new File(dir_path, activity_image); // dir_path: 占쏙옙占싸듸옙 占쏙옙占�

						try {
							item.write(saveFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
						}
					}
				} // end for loop

			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			

			
			ActivityVO avo = new ActivityVO();
			avo.setActivity_name(activity_name);
			avo.setActivity_description(activity_description);
			avo.setActivity_city(activity_city);
			avo.setActivity_county(activity_county);
			avo.setActivity_interest_name(activity_interest_name);
			avo.setActivity_gender(activity_gender);
			avo.setActivity_nop(activity_nop);
			avo.setActivity_age(activity_age);
			avo.setUser_no(user_no);
			//avo.setUser_no(cookie_userNo);
			avo.setMeet_no(meet_no);
			
			
			
			avo.setActivity_image(activity_image==""?"/meet-a-bwa/resources/img/default-image2":"/meet-a-bwa/resources/img/"+activity_image); // 0占싱몌옙 img_001.jpg占쏙옙 占싱뱄옙占쏙옙占쏙옙, 0占쏙옙 占싣니몌옙 img
			
			ActivityDAO a_dao = new ActivityDAOImpl();
			int result = a_dao.activity_insert(avo);

			System.out.println("result: "+result);

			if(result==1) {
				response.sendRedirect("/meet-a-bwa/meet-main.do?idx=" + meet_no);
			}else {
				//response.sendRedirect("/meet-a-bwa/meet-main.do?idx=" + meet_no);
				response.sendRedirect("a_insert.do?meet_no=" + meet_no);
			}
			
			}
		} // end if << isMultipartContent
}
