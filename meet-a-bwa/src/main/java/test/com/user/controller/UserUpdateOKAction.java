package test.com.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;


import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;
import test.com.user.model.UserVO;

public class UserUpdateOKAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String dir_path = request.getServletContext().getRealPath("/resources/img/"); // 실경로(=실서버)에 저장
		System.out.println(dir_path);

		int fileSizeMax = 1024 * 1024 * 100;

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request); // is = > 멀티파트형인지 물음.

		// Multipart 요청이면 true, 일반요청이면 false
		if (isMultipartContent) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(fileSizeMax);
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setFileSizeMax(fileSizeMax);// 파일 사이즈 제한

			String user_no =null;
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
			
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			//long checkFileSize = 0;

			try {
				List<FileItem> items = sfu.parseRequest(request);
				for (FileItem item : items) {

					if (item.isFormField()) {
						if(item.getFieldName().equals("user_no")) {
							user_no = item.getString("UTF-8");
						}
						else if(item.getFieldName().equals("id")) {
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
							user_birth =java.sql.Date.valueOf(item.getString("UTF-8")); //getDate 해보기
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


						//System.out.println("폼필드 키 : " + item.getFieldName());

						//System.out.println("폼필드 값 : " + item.getString("UTF-8"));

					} else {// upFile받기

						System.out.println("파일의 키 : " + item.getFieldName());
						System.out.println("파일 파일명 : " + item.getName());
						System.out.println("파일 컨텐츠 타입 : " + item.getContentType());
						System.out.println("파일 사이즈  : " + item.getSize());
						//checkFileSize = item.getSize();
						if (item.getSize() != 0) {
//							response.sendRedirect("u_update.do?user_no=" + user_no);
//						else {
							user_image = FilenameUtils.getName(item.getName());

							File saveFile = new File(dir_path, user_image); // dir_path: �뾽濡쒕뱶 寃쎈줈

							try {
								item.write(saveFile);
							} catch (Exception e) {
								e.printStackTrace();
							}
//						}
					}
				} // end for loop
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			

//			if(checkFileSize!=0) { // 사이즈가 0이 아닐때 실행 
			UserVO uvo = new UserVO();
//			uvo.setUser_no(user_no);
//			uvo.setUser_id(user_id);
//			uvo.setUser_image(user_image);
			uvo.setUser_image(user_image==null?"/meet-a-bwa/resources/img/placeholder1.webp":"/meet-a-bwa/resources/img/"+user_image);
			uvo.setUser_pw(user_pw);
//			uvo.setUser_name(user_name);
			uvo.setUser_nickname(user_nickname);
			uvo.setUser_email(user_email);
			uvo.setUser_tel(user_tel);
//			uvo.setUser_birth(user_birth);
//			System.out.println("InsertOKAction:"+user_birth);
//			uvo.setUser_gender(user_gender);
			uvo.setUser_interest(user_interest);
			uvo.setUser_city(user_city);
			uvo.setUser_county(user_county);
			
//			System.out.println("please:"+user_image);
//			uvo.setUser_image(user_image==null?"/meet-a-bwa/resources/img/placeholder1.webp":user_image); // 0이면 img_001.jpg의 이미지를, 0이 아니면 img
			
			System.out.println(user_image);
			System.out.println(user_pw);
			System.out.println(user_nickname);
			System.out.println(user_email);
			System.out.println(user_tel);
			System.out.println(user_birth);
			System.out.println(user_gender);
			System.out.println(user_interest);
			System.out.println(user_city);
			System.out.println(user_county);
			
			UserDAO u_dao = new UserDAOImpl();
			int result = u_dao.user_update(uvo);
			System.out.println("result: "+result);

			if(result==1) {
				//request.getRequestDispatcher("/views/main/USER04.jsp?user_no"+user_no).forward(request, response);
				request.getRequestDispatcher("/views/user/USER04.jsp").forward(request, response);
				}else
//					request.getRequestDispatcher("/views/user/u_update.do?user_no"+user_no).forward(request, response);
			request.getRequestDispatcher("/views/user/USER03.jsp").forward(request, response);
			}
//		 }// end if
		
		} // end if << isMultipartContent
	
}
