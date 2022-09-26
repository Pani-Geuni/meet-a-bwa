package test.com.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.sql.Date;

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

public class UserInsertOKAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String dir_path = request.getServletContext().getRealPath("/meet-a-bwa/resources/img/"); // 실경로(=실서버)에 저장
		System.out.println(dir_path);

		int fileSizeMax = 1024 * 1024 * 100;

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request); // is = > 멀티파트형인지 물음.

		// Multipart 요청이면 true, 일반요청이면 false
		if (isMultipartContent) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(fileSizeMax);
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setFileSizeMax(fileSizeMax);// 파일 사이즈 제한

			String user_image = "";
			
			String user_id = "";
			String user_pw = "";
			String user_name = "";
			String user_nickname = "";
			String user_email = "";
			String user_tel = "";
			Date user_birth = null;
			String user_gender = "";
			String user_interest = "";
			String user_city = "";
			String user_county = "";
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			String strDate = dateFormat.format(Calendar.getInstance().getTime());

			try {
				List<FileItem> items = sfu.parseRequest(request);
				for (FileItem item : items) {

					if (item.isFormField()) {
						if(item.getFieldName().equals("user_id")) {
							user_id = item.getString("UTF-8");
						}else if(item.getFieldName().equals("user_pw")) {
							user_pw =  item.getString("UTF-8");
						}else if(item.getFieldName().equals("user_name")) {
							user_name = item.getString("UTF-8");
						}else if(item.getFieldName().equals("user_nickname")) {
							user_nickname = item.getString("UTF-8");
						}else if(item.getFieldName().equals("user_email")) {
							user_email = item.getString("UTF-8");
						}else if(item.getFieldName().equals("user_tel")) {
							user_tel = item.getString("UTF-8");
						}
						else if(item.getFieldName().equals("user_birth")) {
							user_birth =formatter.parse(item.getString("UTF-8"));
						}
						else if(item.getFieldName().equals("user_gender")) {
							user_gender = item.getString("UTF-8");
						}else if(item.getFieldName().equals("user_interest")) {
							user_interest = item.getString("UTF-8");
						}else if(item.getFieldName().equals("user_city")) {
							user_city = item.getString("UTF-8");
						}else if(item.getFieldName().equals("user_county")) {
							user_county = item.getString("UTF-8");
						}


						//System.out.println("폼필드 키 : " + item.getFieldName());

						//System.out.println("폼필드 값 : " + item.getString("UTF-8"));

					} else {// upFile받기

						System.out.println("파일의 키 : " + item.getFieldName());
						System.out.println("파일 파일명 : " + item.getName());
						System.out.println("파일 컨텐츠 타입 : " + item.getContentType());
						System.out.println("파일 사이즈  : " + item.getSize());

						if(item.getSize()!=0) { // 사이즈가 0이 아닐때 실행 
						user_image = FilenameUtils.getName(item.getName());
							
						
						
						File saveFile = new File(dir_path, user_image); // dir_path: 업로드 경로

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
			
			
			uvo.setUser_image(user_image.length()==0?"/meet-a-bwa/resources/img/placeholder1.webp":user_image); // 0이면 img_001.jpg의 이미지를, 0이 아니면 img
			
			UserDAO u_dao = new UserDAOImpl();
			int result = u_dao.user_insert(uvo);
			System.out.println("result: "+result);

			if(result==1) {
//				if(result1==1&&result2==1) {
				request.getRequestDispatcher("/views/main/MAIN01.jsp").forward(request, response);
				}else
//					response.sendRedirect("u_insert.do");
					request.getRequestDispatcher("/views/user/USER02.jsp").forward(request, response);
			}
		} // end if << isMultipartContent
	
}
