 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css" />
	
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />
	
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/feed.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/meet-info.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/meet-detail.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-writer.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-update.css" />

	<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css"/>

	<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
	<script src="/meet-a-bwa/resources/js/common/header.js"></script>
	<script src="/meet-a-bwa/resources/js/meet/meet-member-list.js"></script>
	
	<title>모임 멤버 리스트</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="../../views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>
	<!--  END HEADER INCLUDE -->
	
	<div id="bodyWrap">
		<div id="contentWrapRow">
		
			<jsp:include page="../../views/common/meetLeftSideBar.jsp"></jsp:include>
			
			<c:choose>
			<c:when test="${ list.isLogin eq false || list.isLogin eq null }">
				<h1>로그인 하셈</h1>
			</c:when>
			
			<c:when test="${list.isLogin eq true}">
				<section class="feedWrap feed-member-list">
		          <div class="member-list-title">
		            <h1>멤버</h1>
		            <p id="all-member-count">3</p>
		          </div>
		          <div class="meet-member-list">
		            <ul>
		              <li>
		                <div class="feed-profile member-list">
		                  <div>
		                    <img src="/meet-a-bwa/resources/img/loopy.svg" alt="" />
		                  </div>
		                  <p class="user-nickname">팡팡팡</p>
		                  <span class="meet-user leader">리더</span>
		                  <p></p>
		                </div>
		              </li>
		              <li>
		                <div class="feed-profile member-list">
		                  <div>
		                    <img src="/meet-a-bwa/resources/img/loopy.svg" alt="" />
		                  </div>
		                  <p class="user-nickname">팡팡팡</p>
		                  <span class="meet-user operator">운영자</span>
		                  <p></p>
		                </div>
		              </li>
		              <li>
		                <div class="feed-profile member-list">
		                  <div>
		                    <img src="/meet-a-bwa/resources/img/loopy.svg" alt="" />
		                  </div>
		                  <p class="user-nickname">팡팡팡</p>
		                  <span class="meet-user"></span>
		                </div>
		              </li>
		            </ul>
		          </div>
		        </section>
				
	        
		        <aside class="meet-right-aside">
		          <div class="right-summary-list" id="event-summary-list">
		            <div class="right-summary-list-top">
		              <h1>모임 내 액티비티</h1>
		              <p><a href="#">+</a></p>
		            </div>
		            <ul class="right-summary-list-contents">
		              <li>
		                <a href="">액티비티1</a>
		              </li>
		              <li>
		                <a href="">액티비티2</a>
		              </li>
		              <li>
		                <a href="">액티비티3</a>
		              </li>
		              <li>
		                <a href="">액티비티4</a>
		              </li>
		              <li>
		                <a href="">액티비티5</a>
		              </li>
		              <li>
		                <a href="">액티비티6</a>
		              </li>
		            </ul>
		          </div>
		          <div class="right-summary-list" id="vote-summary-list">
		            <div class="right-summary-list-top">
		              <h1>투표</h1>
		              <p><a href="#">+</a></p>
		            </div>
		            <ul class="right-summary-list-contents">
		              <li>
		                <a href="">투표 1</a>
		              </li>
		              <li>
		                <a href="">투표 2</a>
		              </li>
		              <li>
		                <a href="">투표 3</a>
		              </li>
		              <li>
		                <a href="">투표 4</a>
		              </li>
		              <li>
		                <a href="">투표 5</a>
		              </li>
		            </ul>
		          </div>
		        </aside>
		      </c:when>
	        </c:choose>
		</div>
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
	<!-- END bodyWrap  -->
	
	<!-- ==================================== -->
<!-- 글쓰기 view 팝업 -->
<!-- ==================================== -->
<div class="write-popup-layer">
	<div class="popup-box">
		<div class="popup-top">
			<h1>글쓰기</h1>
		</div>
		<div class="popup-writer">
			<form action="b_insertOK.do" method="post" class="popup-writer">
				<input name="board_title" type="text" placeholder="제목" />
				<textarea name="board_content" id="content" placeholder="내용을 입력하세요."></textarea>
				<input name="meet_no" value="${ mvo3.meet_no }" style="display: none">
				<input name="user_no" value="${ list.user_no }" style="display: none">
				
				<div class="popup-btn-group">
					<button type="button" class="btn-cancel" onclick="writePopupHide()">취소</button>
					<button type="submit" class="btn-submit">게시</button>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- ==================================== -->
<!-- 글 업데이트 view 팝업 -->
<!-- ==================================== -->
<div class="update-popup-layer" data-popup="update">
	<div class="popup-box">
		<div class="popup-top">
			<h1>글 수정</h1>
		</div>
		<div class="popup-writer" id="popup-update">
			<input name="update_title" id="update_title" type="text"
				placeholder="제목" value="${ vo.board_title }" />
			<textarea name="update_content" id="update_content"
				placeholder="내용을 입력하세요.">${ vo.board_content }</textarea>

			<div class="popup-btn-group">
				<button type="button" class="btn-cancel" data-popup-close="update">취소</button>
				<button type="submit" class="btn-submit-update">게시</button>
			</div>
		</div>
	</div>
</div>

<!-- START LOGIN POPUP -->
<div class="login-layer blind">
	<div class="login-popup-wrap">
		<div class="login-top">
			<img id="logo" src="resources/img/logo.svg" alt="login logo image" />
		</div>

		<div class="login-middle">
			<form action="/meet-a-bwa/m_loginOK.do" class="login-form"
				method="post" id="loginForm">
				<label for="id">아이디</label> <input type="text" id="idInput"
					name="id" placeholder="아이디 입력" /> <label for="pw">비밀번호</label> <input
					type="password" id="pwInput" name="pw" placeholder="비밀번호 입력" /> <input
					type="submit" onsubmit="check_length();" value="로그인"> <input
					type="button" value="창닫기" id="login-popup-closeBtn">
			</form>

			<div class="login-bottom">
				<div>
					<a href="">ID 찾기</a>
				</div>
				<div>
					<a href="">PW 찾기</a>
				</div>
				<div>
					<a href="/meet-a-bwa/u_insert.do">회원가입</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END LOGIN POPUP -->

<!-- START LOGOUT POPUP -->
<div class="logout-layer blind">
	<div class="logout-popup-wrap">
		<img src="resources/img/worry.svg" alt="logout worry img" />
		<h1>
			정말 로그아웃 <br /> 하시겠습니까?
		</h1>

		<div class="btn-group">
			<a href="/meet-a-bwa/logoutOK.do">
				<button class="btn-logout">로그아웃</button>
			</a>
			<button class="btn-cancel">취소</button>
		</div>
	</div>
</div>
<!-- END LOGOUT POPUP -->
</body>


</html>