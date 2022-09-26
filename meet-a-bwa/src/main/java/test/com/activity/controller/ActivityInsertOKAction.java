package test.com.activity.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import test.com.activity.model.ActivityDAO;
import test.com.activity.model.ActivityDAOImpl;
import test.com.activity.model.ActivityVO;
import test.com.user.model.InterestVO;
import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;
import test.com.user.model.UserVO;

public class ActivityInsertOKAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir_path = request.getServletContext().getRealPath("/meet-a-bwa/resources/img"); // 실경로(=실서버)에 저장
		System.out.println(dir_path);

		int fileSizeMax = 1024 * 1024 * 100;

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request); // is = > 멀티파트형인지 물음.

		// Multipart 요청이면 true, 일반요청이면 false
		if (isMultipartContent) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(fileSizeMax);
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setFileSizeMax(fileSizeMax);// 파일 사이즈 제한

			String activity_image = "";
			String activity_name = "";
			String activity_description = "";
			String activity_city = "";
			String sctivity_county = "";
			String activity_interest_name = "";
			String activity_gender = "";
			Integer activity_nop=0;
			Integer activity_age=0;
//			String activity_date = "";
			String user_no = "";
			String meet_no="";

			try {
				List<FileItem> items = sfu.parseRequest((RequestContext) request);
				for (FileItem item : items) {

					if (item.isFormField()) {
						if(item.getFieldName().equals("activity_image")) {
							activity_image = item.getString("UTF-8");
						}else if(item.getFieldName().equals("activity_name")) {
							activity_name =  item.getString("UTF-8");
						}else if(item.getFieldName().equals("activity_description")) {
							activity_description = item.getString("UTF-8");
						}else if(item.getFieldName().equals("activity_city")) {
							activity_city = item.getString("UTF-8");
						}else if(item.getFieldName().equals("activity_interest_name")) {
							activity_interest_name = item.getString("UTF-8");
						}else if(item.getFieldName().equals("activity_gender")) {
							activity_gender = item.getString("UTF-8");
						}else if(item.getFieldName().equals("activity_nop")) {
							activity_nop = Integer.parseInt(item.getString("UTF-8")); 
						}else if(item.getFieldName().equals("activity_age")) {
							activity_age = Integer.parseInt(item.getString("UTF-8"));
						}else if(item.getFieldName().equals("user_no")) {
							user_no = item.getString("UTF-8");
						}else if(item.getFieldName().equals("meet_no")) {
							meet_no = item.getString("UTF-8");
						}


						//System.out.println("폼필드 키 : " + item.getFieldName());

						//System.out.println("폼필드 값 : " + item.getString("UTF-8"));

					} else {// upFile받기

						System.out.println("파일의 키 : " + item.getFieldName());
						System.out.println("파일 파일명 : " + item.getName());
						System.out.println("파일 컨텐츠 타입 : " + item.getContentType());
						System.out.println("파일 사이즈  : " + item.getSize());

						if(item.getSize()!=0) { // 사이즈가 0이 아닐때 실행 
						activity_image = FilenameUtils.getName(item.getName());
							
						
						
						File saveFile = new File(dir_path, activity_image); // dir_path: 업로드 경로

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
			avo.setActivity_county(sctivity_county);
			avo.setActivity_interest_name(activity_interest_name);
			avo.setActivity_nop(activity_nop);
			avo.setActivity_gender(activity_gender);
			avo.setUser_no(user_no);
			avo.setMeet_no(meet_no);
			
			
			
			avo.setActivity_image(activity_image.length()==0?"/meet-a-bwa/resources/img/default-image2":activity_image); // 0이면 img_001.jpg의 이미지를, 0이 아니면 img
			
			ActivityDAO a_dao = new ActivityDAOImpl();
			int result = a_dao.activity_insert(avo);

			System.out.println("result: "+result);

			if(result==1) {
//				if(result1==1&&result2==1) {
				response.sendRedirect("main_init.do");
				}else
					response.sendRedirect("a_insert.do");
			}
		} // end if << isMultipartContent
}
