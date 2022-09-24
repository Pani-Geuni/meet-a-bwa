package test.com.main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainInitAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        
		boolean isLogin =  Boolean.parseBoolean(request.getParameter("isLogin"));
		
		// 사용자가 로그인하고 메인페이지 로드했을 때
		if(isLogin) {
			System.out.println("isLogin : true");
			String userInterest = request.getParameter("userInterest");
			String userRegion = request.getParameter("userRegion");
			
			if(userInterest.equals("")) {
				// 사용자 지역에서 인기많은순으로 최대 10개 리스트 나열
				System.out.println("받아온 관심사 정보가 없습니다.");
			}else {
				// 사용자 관심사에 맞는 리스트 인기많은순으로 최대 10개 리스트 나열
			}
		}else { // 사용자가 로그인하지않고 메인페이지 로드했을 때
			// 인기많은순 내림차순으로 최대 10개 추천
			System.out.println("false");
		}
	}
}
