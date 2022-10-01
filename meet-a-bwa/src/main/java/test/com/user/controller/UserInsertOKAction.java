package test.com.user.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
//import java.util.Date;
import java.util.List;

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
		String dir_path = request.getServletContext().getRealPath("/resources/img/"); // �ǰ��(=�Ǽ���)�� ����
		System.out.println(dir_path);
		
		int fileSizeMax = 1024 * 1024 * 100;

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request); // is = > ��Ƽ��Ʈ������ ����.

		// Multipart ��û�̸� true, �Ϲݿ�û�̸� false
		if (isMultipartContent) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(fileSizeMax);
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setFileSizeMax(fileSizeMax);// ���� ������ ����

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
						}else if(item.getFieldName().equals("u_nickname")) {
							user_nickname = item.getString("UTF-8");
						}else if(item.getFieldName().equals("email")) {
							user_email = item.getString("UTF-8");
						}else if(item.getFieldName().equals("tel")) {
							user_tel = item.getString("UTF-8");
						}
						else if(item.getFieldName().equals("birth")) {
							user_birth =java.sql.Date.valueOf(item.getString("UTF-8")); //getDate �غ���
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


						//System.out.println("���ʵ� Ű : " + item.getFieldName());

						//System.out.println("���ʵ� �� : " + item.getString("UTF-8"));

					} else {// upFile�ޱ�

						System.out.println("������ Ű : " + item.getFieldName());
						System.out.println("���� ���ϸ� : " + item.getName());
						System.out.println("���� ������ Ÿ�� : " + item.getContentType());
						System.out.println("���� ������  : " + item.getSize());

						if(item.getSize()!=0) { // ����� 0�� �ƴҶ� ���� 
						user_image = FilenameUtils.getName(item.getName());
							
						
						System.out.println("ddddddddddddddddd:"+user_image);
						File saveFile = new File(dir_path, user_image); // dir_path: ���ε� ���

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
			System.out.println("InsertOKAction:"+user_birth);
			uvo.setUser_gender(user_gender);
			uvo.setUser_interest(user_interest);
			uvo.setUser_city(user_city);
			uvo.setUser_county(user_county);
			
//			System.out.println("please:"+user_image.length());
			System.out.println("please:"+user_image);
			uvo.setUser_image(user_image==null?"/meet-a-bwa/resources/img/placeholder1.webp":"/meet-a-bwa/resources/img/"+user_image); // 0�̸� img_001.jpg�� �̹�����, 0�� �ƴϸ� img
			
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
//	
}
