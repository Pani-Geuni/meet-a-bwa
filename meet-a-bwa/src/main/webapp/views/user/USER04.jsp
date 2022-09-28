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

	<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/my-page.css"/>

	<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
    <script src="/meet-a-bwa/resources/js/common/header.js"></script>
    <script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>

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
	              <%-- <c:if test="${list.isLogin eq true} }"> --%>
	              <p><span>${ list.nick_name }님,</span> 안녕하세요.</p>
	              <p>golfzon@gmail.com</p>
	              <%-- </c:if> --%>
	            </div>
	          </div>
	        </section>
        <!-- end user-info contentSection -->
        
        <ul class="my-menu-list" id="my-menu-list">
          <li>
            <a href="#">개인 정보 수정</a>
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
		
		<div id="footerWrap-mypage">
      		<h5>© Golfzon Tech Academy, Inc. All rights reserved.</h5>
    	</div>
	</section>
	<!-- end bodyWrap -->
</body>
</html>