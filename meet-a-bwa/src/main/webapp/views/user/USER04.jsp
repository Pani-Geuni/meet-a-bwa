<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css"/>
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css"/>
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css"/>

<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/mypage.css"/>

<title>마이 페이지</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp"></jsp:include>
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
	              <p><span>팡근님,</span> 안녕하세요.</p>
	              <p>golfzon@gmail.com</p>
	            </div>
	          </div>
	        </section>
        <!-- end user-info contentSection -->
        
        <ul class="my-menu-list" id="my-menu-list">
          <li>
            <a href="#">개인 정보 수정</a>
          </li>
          <li>
            <a href="./my-meet.html">나의 모임</a>
          </li>
          <li>
            <a href="#">나의 액티비티</a>
          </li>
        </ul>
        <!-- end my-meeting contentSection -->
		</div>
		
		<div id="footerWrap-mypage">
      		<h5>© Golfzon Tech Academy, Inc. All rights reserved.</h5>
    	</div>
	</section>
	<!-- end bodyWrap -->
</body>
</html>