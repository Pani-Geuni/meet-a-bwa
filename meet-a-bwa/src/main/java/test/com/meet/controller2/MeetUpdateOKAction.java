package test.com.meet.controller2;

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

import test.com.meet.model2.MeetDAO;
import test.com.meet.model2.MeetDAOImpl;
import test.com.meet.model2.MeetVO;

public class MeetUpdateOKAction {
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//********************************헤더***********************************//
		HttpSession session = request.getSession();
		String session_user_id = (String) session.getAttribute("user_id");
		
		String cookie_interest = "";
		String cookie_county = "";
		String cookie_nickName = "";
		
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
				}
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLogin", true);
			map.put("nick_name", cookie_nickName);
			map.put("interest", cookie_interest);
			map.put("county", cookie_county);
			
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

			String meet_no ="";
			String meet_image = "";
			String meet_name = "";
			String meet_description = "";
			String meet_city = "";
			String meet_county = "";
			String meet_interest_name = "";
			String meet_gender = "";
			Integer meet_nop=0;
			Integer meet_age=0;
//			String meet_date = "";
			String user_no = "";

			try {
				List<FileItem> items = sfu.parseRequest(request);
				for (FileItem item : items) {

					if (item.isFormField()) {
						if(item.getFieldName().equals("meet_no")) {
							meet_no = item.getString("UTF-8");
						}else if(item.getFieldName().equals("image")) {
							meet_image = item.getString("UTF-8");
						}else if(item.getFieldName().equals("meet_name")) {
							meet_name =  item.getString("UTF-8");
						}else if(item.getFieldName().equals("meet_description")) {
							meet_description = item.getString("UTF-8");
						}else if(item.getFieldName().equals("city")) {
							meet_city = item.getString("UTF-8");
						}else if(item.getFieldName().equals("country")) {
							meet_county = item.getString("UTF-8");
						}else if(item.getFieldName().equals("interest")) {
							meet_interest_name = item.getString("UTF-8");
						}else if(item.getFieldName().equals("gender")) {
							meet_gender = item.getString("UTF-8");
						}else if(item.getFieldName().equals("nop")) {
							meet_nop = Integer.parseInt(item.getString("UTF-8")); 
						}else if(item.getFieldName().equals("age")) {
							String age_re = item.getString("UTF-8").replace("대", "");
							meet_age = Integer.parseInt(age_re);
						}else if(item.getFieldName().equals("user_no")) {
							user_no = item.getString("UTF-8");
						}


						//System.out.println("占쏙옙占십듸옙 키 : " + item.getFieldName());

						//System.out.println("占쏙옙占십듸옙 占쏙옙 : " + item.getString("UTF-8"));

					} else {// upFile占쌨깍옙

						System.out.println("파일의 키 : " + item.getFieldName());
						System.out.println("파일 파일명 : " + item.getName());
						System.out.println("파일 컨텐츠 타입 : " + item.getContentType());
						System.out.println("파일 사이즈  : " + item.getSize());

						if(item.getSize()!=0) { 
						meet_image = FilenameUtils.getName(item.getName());
							

						File saveFile = new File(dir_path, meet_image); // dir_path: 占쏙옙占싸듸옙 占쏙옙占�

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
			

			
			MeetVO mvo = new MeetVO();
			mvo.setMeet_no(meet_no);
			mvo.setMeet_name(meet_name);
			mvo.setMeet_description(meet_description);
			mvo.setMeet_city(meet_city);
			mvo.setMeet_county(meet_county);
			mvo.setMeet_interest_name(meet_interest_name);
			mvo.setMeet_gender(meet_gender);
			mvo.setMeet_nop(meet_nop);
			mvo.setMeet_age(meet_age);
			
			MeetDAO test_dao = new MeetDAOImpl();
			
			MeetVO mvo2 = test_dao.meet_selectOne(mvo);
			
			if (meet_image.equals("")) {
				// 이전의 이미지가 없을 때
				meet_image = "/meet-a-bwa/resources/img/default-image2.png";
				
				// 기존의 이미지가 있는데, 모임 수정 시 이미지는 변경하지 않을 때.
				if (!mvo2.getMeet_image().equals(meet_image)) {
					meet_image = mvo2.getMeet_image();
				}
			} else {
				// 변경 된 이미지가 있을 때 
				meet_image = "/meet-a-bwa/resources/img/" + meet_image;
			}
			
			mvo.setMeet_image(meet_image);
			
			MeetDAO m_dao = new MeetDAOImpl();
			int result = m_dao.meet_update(mvo);

			System.out.println("result: " + result);

			if(result==1) {
					response.sendRedirect("/meet-a-bwa/meet-main.do?idx=" + meet_no);
				} else {
					response.sendRedirect("a_update.do?meet_no=" + meet_no);
				}
			}
		} // end if << isMultipartContent
}
