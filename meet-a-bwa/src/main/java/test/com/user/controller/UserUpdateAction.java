package test.com.user.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.user.model.UserDAO;
import test.com.user.model.UserDAOImpl;
import test.com.user.model.UserVO;

public class UserUpdateAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("user_no"));

		UserVO uvo = new UserVO();
		uvo.setUser_no(request.getParameter("user_no"));

		UserDAO u_dao = new UserDAOImpl();
		UserVO uvo2 = u_dao.user_selectOne(uvo);

		request.setAttribute("uvo2", uvo2);
		
        File file = new File("C:\\git-test\\meet-a-bwa\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\meet-a-bwa\\resources\\json\\city.json"); // File객체 생성

		if(file.exists()){ // 파일이 존재하면
            BufferedReader reader = new BufferedReader(new FileReader(file));

            System.out.println("파일내용 출력------------------");
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            System.out.println("------------------------------");

            reader.close();
        }

		RequestDispatcher rd = request.getRequestDispatcher("/views/user/USER03.jsp");
		rd.forward(request, response);
	}
}
