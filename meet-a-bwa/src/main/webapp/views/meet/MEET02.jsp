<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.meetboard.model.MeetBoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/common.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/header.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css"/>

<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/searchBar.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/meet-detail.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/feed.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/meet-info.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/post-detail.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/post-writer.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/post-update.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/post-delete.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css"/>
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/meet/delete-popup.js"></script>
<script src="/meet-a-bwa/resources/js/meet/post-write-popup.js"></script>

<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>


<title>모임 피드</title>
</head>
<body>

	<!--  START HEADER INCLUDE -->
	<jsp:include page="../../views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>

	<div id="bodyWrap">
		<div id="contentWrapRow">
			<aside class="meet-detail-aside">
				<div class="meet-profile-img">
					<img src="/meet-a-bwa/resources/img/sample/sample-img-01.png"
						alt="샘플 대표 이미지" />
				</div>
				<div class="meet-detail-aside-top">
					<h1 class="meet-deatil-aside-title">금요일은 소고기 먹는 날 날날날날날날</h1>
					<div class="heart-common">
						<img class="img-heart-filled"
							src="/meet-a-bwa/resources/img/heart-filled.svg" alt="좋아요 이미지" />
						<img class="img-heart-outlined blind"
							src="/meet-a-bwa/resources/img/heart-outlined.svg"
							alt="좋아요 테두리 이미지" /> <span>9789</span>
					</div>
				</div>
				<div class="meet-summary-info">
					<p>
						<a href="/meet-a-bwa/meet-member.do">멤버 22명</a>
					</p>
					<p>리더 팡근</p>
				</div>

				<div class="tagSection">
					<div class="loca_tag tag">
						<img src="/meet-a-bwa/resources/img/map.png" class="tag_img" /> <span
							class="location_name font_size_10">경안동</span>
					</div>
					<div class="cate_tag tag">
						<span class="category_name font_size_10">자전거</span>
					</div>
				</div>

					<!-- 로그인 전 -->
						<!-- <button type="button" class="btn-meet join"> -->
				<c:choose>
					<c:when test="${ list.isLogin eq false || list.isLogin eq null }">
						<button type="button" class="btn-meet join">
							<a href="#">모임 가입하기</a>
						</button>
					</c:when>

				
				<c:when test="${list.isLogin eq true}">
					<button type="button" class="btn-meet"
						onclick="writePopupShow()">글쓰기</button>
					<button type="button" class="btn-meet">
						<a href="">액티비티 개설</a>
					</button>
	
					<a class="meet-detail-link" href="./meet-info-detail.html">모임
						자세히 보기</a>
				</c:when>
				</c:choose>
			</aside>

			<c:choose>
				<c:when test="${ list.isLogin eq false || list.isLogin eq null }">
					<!-- <section class="feedWrap-not-login">
						<div class="feed-not-login">
							<img alt="경고 이미지" src="/meet-a-bwa/resources/img/worry.svg">
							<h1>아직 로그인을 안하셨어요 로그인 후 이용해주세요</h1>
						</div>
					</section> -->
					<section class="meet-info-wrap">
          <div class="meet-info-top">
            <h1 class="meet-info-title">모임소개</h1>
            <button class="btn-meet-info-edit"></button>
            <button class="btn-meet-info-remove"></button>
          </div>

          <div class="meet-info-tag">
            <h3>모임 정보</h3>
            <div class="tagSection">
              <div class="loca_tag tag">
                <img src="/meet-a-bwa/resources/img/map.png" class="tag_img" />
                <span class="location_name font_size_10">경안동</span>
              </div>
              <div class="cate_tag tag">
                <span class="category_name font_size_10">자전거</span>
              </div>
            </div>
          </div>

          <div class="meet-info-content">
            <pre>
옛 말에 그런 말이 있죠
"금요일은 소고기를 먹어라"
- 맛있는 소고기와 와인을 먹어요
- 즐거운 이야기를 나눠요
- 지갑은 비우고 배는 가득 채우는 모임이에요🙌
- 아 참! 사실 그런 예삼ㄹ은 없어요. 그냥 맛있게 먹어요!
            </pre>
          </div>

          <div class="meet-info-detail">
            <h3>모임 정보</h3>
            <div>
              <p>모임 개설일</p>
              <span>2022년 08월</span>
            </div>
            <div>
              <p>멤버 수</p>
              <span>22명</span>
            </div>
          </div>
        </section>
				</c:when>

				<c:when test="${list.isLogin eq true}">

					<section class="feedWrap">
						<article>
							<!--  START SEARCHBAR INCLUDE -->
							<jsp:include page="/views/common/searchBar.jsp"></jsp:include>
							<!--  END SEARCHBAR INCLUDE -->
							<div class="meet-notification">
								<div class="notification-title">
									<h3>공지</h3>
									<a href="./post-detail.html">
										<p>공지내용 공지내용 공지내용 공지내용 공지내용공지내용 공지내용 공지내용 공지내용 공지내용공지내용
											공지내용 공지내용 공지내용 공지내용공지내용 공지내용 공지내용 공지내용 공지내용</p>
									</a>
								</div>
							</div>
							<!-- end meet-notification -->

							<div class="all-feed">

								<c:choose>
									<c:when test="${ empty vos }">
										<div class="feed-empty">
											<h1>현재 모임에 작성된 글이 없어요!</h1>
											<p>모임에 글을 작성해 소통해봐요!</p>
										</div>
									</c:when>
									<c:when test="${ not empty vos }">
										<c:forEach var="vo" items="${ vos }">
											<div class="feed">
												<div class="feed-profile">
													<div class="user-info">
														<div>
															<img src="/meet-a-bwa/resources/img/loopy.svg"
																alt="프로필 이미지" />
														</div>
														<p class="user-nickname">${ vo.user_name }</p>
														<p class="write-date">${ vo.board_date }</p>
													</div>

													<div class="post-more-select">
														<img class="img-more"
															src="/meet-a-bwa/resources/img/more.svg" alt="" />

														<ul class="post-option-list" idx="${ vo.board_no }">
															<li class="post-option-item" data-popup-open="update">수정하기</li>
															<li class="post-option-item" data-popup-open="delete">
																삭제하기</li>
														</ul>
													</div>
												</div>
												<div class="feed-post">
													<a href="b_selectOne.do?board_no=${ vo.board_no }">
														<p>${ vo.board_content }</p>
													</a>
												</div>
												<div class="feed-options">
													<p>
														<a href="#">댓글</a>
													</p>
												</div>
											</div>
											<!-- end one feed -->
										</c:forEach>
									</c:when>
								</c:choose>
							</div>
							<!-- end all feed -->
						</article>
					</section>
					<aside class="meet-right-aside">
						<div class="right-summary-list" id="event-summary-list">
							<div class="right-summary-list-top">
								<h1>모임 내 액티비티</h1>
								<p>
									<a href="#">+</a>
								</p>
							</div>
							<ul class="right-summary-list-contents">
								<li><a href="">액티비티1</a></li>
								<li><a href="">액티비티2</a></li>
								<li><a href="">액티비티3</a></li>
								<li><a href="">액티비티4</a></li>
								<li><a href="">액티비티5</a></li>
								<li><a href="">액티비티6</a></li>
							</ul>
						</div>
						<div class="right-summary-list" id="vote-summary-list">
							<div class="right-summary-list-top">
								<h1>투표</h1>
								<p>
									<a href="/meet-a-bwa/m_vote_create.do">+</a>
								</p>
							</div>
							<ul class="right-summary-list-contents">
								<li><a href="">투표 1</a></li>
								<li><a href="">투표 2</a></li>
								<li><a href="">투표 3</a></li>
								<li><a href="">투표 4</a></li>
								<li><a href="">투표 5</a></li>
							</ul>
						</div>
					</aside>
				</c:when>
			</c:choose>
		</div>
			<!--  START HEADER INCLUDE -->
			<jsp:include page="../../views/common/footer.jsp"></jsp:include>
	    <!--  END HEADER INCLUDE -->
	</div>
</body>

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
		      <form action="/meet-a-bwa/m_loginOK.do" class="login-form" method="post" id = "loginForm">
		        <label for="id">아이디</label>
		        <input type="text" id = "idInput" name = "id" placeholder="아이디 입력"/>
		
	            <label for="pw">비밀번호</label>
		        <input type="password" id = "pwInput" name = "pw" placeholder="비밀번호 입력"/>
		        
		        <input type="submit" onsubmit = "check_length();" value = "로그인">
		        <input type = "button" value = "창닫기" id = "login-popup-closeBtn">
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