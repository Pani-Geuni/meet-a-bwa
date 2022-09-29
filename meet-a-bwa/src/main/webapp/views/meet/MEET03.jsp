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
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/meet-detail.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-detail.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-writer.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-update.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-delete.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>

<script src="/meet-a-bwa/resources/js/meet/select-list.js"></script>
<script src="/meet-a-bwa/resources/js/meet/delete-popup.js"></script>
<script src="/meet-a-bwa/resources/js/meet/post-write-popup.js"></script>
<title>게시글 상세 페이지</title>
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
		
			
			<section class="post-detail">
          <div class="post-detail-top">
            <h1 class="post-detail-title" id="post-detail-title">
              ${ bvo2.board_title }
            </h1>
            <div class="post-user-info">
              <div class="user-info">
                <div class="user-info-profile">
                  <img src="/meet-a-bwa/resources/img/loopy.svg" alt="프로필 이미지" />
                </div>
                <p class="user-nickname">${ bvo2.user_name }</p>
                <p class="write-date">${ bvo2.board_date }</p>
              </div>
              <div class="post-more-select">
              	<img class="img-more" src="/meet-a-bwa/resources/img/more.svg" alt="" />
              		<ul class="post-option-list" idx="${ bvo2.board_no }">
              			<li class="post-option-item" data-popup-open="update">수정하기</li>
              			<li class="post-option-item" data-popup-open="delete">삭제하기</li>
					</ul>
			  </div>
            </div>
          </div>

          <pre class="post-detail-content">${ bvo2.board_content }</pre>

          <div class="coment-wrap">
            <form action="#" class="form-comment">
              <textarea placeholder="댓글을 남겨주세요."></textarea>
              <button type="submit">등록</button>
            </form>

            <div class="user-comments">
              <div class="user-comment">
                <div class="comment-user-info">
                  <div class="comment-user-info-profile">
                    <img src="/meet-a-bwa/resources/img/loopy.svg" alt="프로필 이미지" />
                  </div>
                  <p class="comment-user-nickname">트루</p>
                  <p class="comment-write-date">2022.09.12</p>
                </div>
                <pre class="post-detail-comment">
댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글</pre
                >
              </div>
            </div>
            <div class="user-comments">
              <div class="user-comment">
                <div class="comment-user-info">
                  <div class="comment-user-info-profile">
                    <img src="/meet-a-bwa/resources/img/loopy.svg" alt="프로필 이미지" />
                  </div>
                  <p class="comment-user-nickname">옌두목</p>
                  <p class="comment-write-date">2022.09.12</p>
                </div>
                <pre class="post-detail-comment">
댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글</pre
                >
              </div>
            </div>
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
              <p><a href="m_vote_create.do">+</a></p>
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
		</div>
	</div>
</body>

<!-- ==================================== -->
<!-- 글쓰기 view 팝업 -->
<!-- ==================================== -->
<div class="write-popup-layer" data-popup="update">
	<div class="popup-box">
		<div class="popup-top">
        	<h1>글쓰기</h1>
        </div>
        <div class="popup-writer">
          	<form action="b_insertOK.do" method="post" class="popup-writer">
            	<input name="board_title" type="text" placeholder="제목" />
	            <textarea
	              name="board_content"
	              id="content"
	              placeholder="내용을 입력하세요."
	            ></textarea>
	            
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
            	<input name="update_title" id="update_title" type="text" placeholder="제목" value="${ bvo2.board_title }"/>
	            <textarea
	              name="update_content"
	              id="update_content"
	              placeholder="내용을 입력하세요."
	            >${ bvo2.board_content }</textarea>
	            
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

<!-- *******************  -->
<!-- delete popup SECTION -->
<!-- *******************  -->
  <div class="delete-popup-layer" data-popup="delete">
    <div class="delete-popup-wrap">
      <img src="/meet-a-bwa/resources/img/worry.svg" alt="" />
      <h1>정말 삭제 하시겠습니까?</h1>

      <div class="btn-group">
        <button id="btn-delete" class="btn-delete" data-popup-close="delete">삭제</button>
        <button class="btn-cancel" data-popup-close="delete">취소</button>
      </div>
    </div>
  </div>
</html>