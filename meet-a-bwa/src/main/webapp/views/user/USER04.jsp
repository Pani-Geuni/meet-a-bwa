<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.com.meetboard.model.MeetBoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css"/>
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css"/>
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css"/>
	
	
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/my-page.css"/>
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css"/>

	<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
    <script src="/meet-a-bwa/resources/js/common/header.js"></script>
    <script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
    <script src="/meet-a-bwa/resources/js/user/myPage.js"></script>

<title>마이 페이지</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="../../views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>
	<!--  END HEADER INCLUDE -->
	
	<section id="bodyWrap">
		<div id="contentWrap">
			<section class="contentSection" id="user-info">
	          <h1 class="sectionTitle">마이 페이지</h1>
	          <div id="user-content">
	            <div id="user-profile-img">
	              <img src="/meet-a-bwa/resources/img/loopy.svg" alt="" />
	            </div>
	            <div id="user-contents">
	              <p><span>${ vo.user_nickname }님,</span> 안녕하세요.</p>
	              <p>${ vo.user_email }</p>
	            </div>
	          </div>
	        </section>
        <!-- end user-info contentSection -->
        
        <ul class="my-menu-list" id="my-menu-list">
          <li>
            <p class="edit-user-info">개인 정보 수정</p>
          </li>
          <li>
            <a href="/meet-a-bwa/views/user/USER05.jsp">나의 모임</a>
          </li>
          <li>
            <a href="#">나의 액티비티</a>
          </li>
        </ul>
        <!-- end my-meeting contentSection -->
		</div>
		
		<!-- START LOGOUT POPUP -->
        <div class="logout-layer blind">
         <div class="logout-popup-wrap">
            <img src="resources/img/worry.svg" alt="logout worry img"/>
            <h1>
              정말 로그아웃 <br />
              하시겠습니까?
            </h1>
      
            <div class="btn-group">
	            <a href = "/meet-a-bwa/logoutOK.do">
	              <button class="btn-logout">로그아웃</button>
	            </a>
              <button class="btn-cancel">취소</button>
            </div>
       	  </div>
        </div>
        <!-- END LOGOUT POPUP -->
		
		<div id="footerWrap-mypage">
      		<h5>© Golfzon Tech Academy, Inc. All rights reserved.</h5>
    	</div>
	</section>
	<!-- end bodyWrap -->
</body>
</html>