<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.meetboard.model.MeetBoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/common.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/header.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/toast.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/searchBar.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/meet-detail.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/feed.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/meet-info.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/post-detail.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/post-writer.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/post-update.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/meet/post-delete.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/vote/vote_common.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/vote/vote_create.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/vote/vote_update.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/vote/vote_view.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>

<!-- DATE PICKER -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/meet-a-bwa/resources/js/common/datePicker_ko.js"></script>

<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>

<script src="/meet-a-bwa/resources/js/meet/delete-popup.js"></script>
<script src="/meet-a-bwa/resources/js/meet/post-write-popup.js"></script>


<script src="/meet-a-bwa/resources/js/vote/vote_common.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_create.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_update.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_select.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_view.js"></script>

<script>
	$(function() {
		// 오른쪽 섹션 - 투표 생성 버튼 클릭 (+)
		$("#vote_create_btn").click(function() {
			$(".vote-create-update-wrap").removeClass("blind");
			$("#event-create").removeClass("blind");
		});

	});
</script>

<title>모임 피드</title>
</head>
<body>

	<!--  START HEADER INCLUDE -->
	<jsp:include page="../../views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>

	<div id="bodyWrap">
		<div id="contentWrapRow">
			<jsp:include page="../../views/common/meetLeftSideBar.jsp"></jsp:include>

			<c:choose>
				<c:when test="${ list.isLogin eq false || list.isLogin eq null }">
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
									<span class="location_name font_size_10">${ mvo3.meet_county }</span>
								</div>
								<div class="cate_tag tag">
									<span class="category_name font_size_10">${ mvo3.meet_interest_name }</span>
								</div>
							</div>
						</div>

						<div class="meet-info-content">
							<pre>${ mvo3.meet_description }</pre>
						</div>

						<div class="meet-info-detail">
							<h3>모임 정보</h3>
							<div>
								<p>모임 개설일</p>
								<span>${ mvo3.meet_date }</span>
							</div>
							<div>
								<p>멤버 수</p>
								<span>${ mvo3.user_cnt }명</span>
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
													
													
													<c:if test="${ vo.user_no eq list.user_no }">
													<div class="post-more-select">
														<img class="img-more"
															src="/meet-a-bwa/resources/img/more.svg" alt="" />

														<ul class="post-option-list" idx="${ vo.board_no }">
															<li class="post-option-item" data-popup-open="update">수정하기</li>
															<li class="post-option-item" data-popup-open="delete">
																삭제하기</li>
														</ul>
													</div>
													</c:if>
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
								<li><p>액티비티1</p></li>
								<li><p>액티비티2</p></li>
							</ul>
						</div>
						<div class="right-summary-list" id="vote-summary-list">
							<div class="right-summary-list-top">
								<h1>투표</h1>
								<p id="vote_create_btn">
									<!-- <a href="/meet-a-bwa/m_vote_create.do"> -->
									+
									<!-- </a> -->
								</p>
							</div>
							<ul class="right-summary-list-contents">
								<c:forEach var="vvo" items="${ vvos }">
									<li class="vote-list-item" idx= "${ vvo.vote_no }"><p>${ vvo.vote_title }<p></li>
								</c:forEach>
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
<!-- *******************  -->
<!-- delete popup SECTION -->
<!-- *******************  -->




<!-- *******************  -->
<!--  투표 확인 -->
<!-- *******************  -->

<div id="vote-view-wrap" class="blind">
	<!-- START voteWrap -->
	<div id="voteWrap">
		<div id="divWrap" class="vote_section">
			<div id="header_wrap" class="wrap_common">
				<span id="view-title">투표 제목 부분입니다.</span> <img
					src="/meet-a-bwa/resources/img/more-vertical.png" alt="더보기 세로 이미지"
					id="more_vertival" />
				<!-- 숨기고 싶을 때, select_custom 제거 후 blind 추가-->
				<!-- 보이고 싶을 때, select_custom 추가 후 blind 제거-->
				<div id="dropdown" class="blind">
					<img src="/meet-a-bwa/resources/img/vector.png"
						alt="셀렉트 before 이미지" id="select_img" />
					<ul class="select_list_wrap">
						<li class="select_list" id="update">수정</li>
						<li class="select_list" id="delete">삭제</li>
					</ul>
				</div>
			</div>
			<div id="body_wrap" class="wrap_common">
				<!-- START 투표 설명란 -->
				<!-- START 투표 설명없으면, class blind 추가 -->
				<fieldset id="description_field">
					<legend class="field_title">투표 설명</legend>
					<div id="vote_view_description">
						<p id="text_area">
							2022년 8월 28일 액티비티 후 저녁 메뉴에 관한 투표입니다.<br> 2022년 8월 28일 액티비티 후
							저녁 메뉴에 관한 투표입니다.<br> 2022년 8월 28일 액티비티 후 저녁 메뉴에 관한 투표입니다.<br>
							2022년 8월 28일 액티비티 후 저녁 메뉴에 관한 투표입니다.
						</p>
					</div>
				</fieldset>
				<!-- END 투표 설명란 -->

				<!-- START 투표 선택란 -->
				<div id="choice_wrap">
					<!-- START choiceList-->
					<div class="choiceList">
						<section class="txt_wrap_section">
							<section class="txt_section">
								<span class="txt">항목 타이틀 자리</span>
								<!-- 결과보여줄 때, blind 제거 -->
								<span class="choice_mem_cnt blind"></span>
							</section>

							<!-- 결과보여줄 때, blind 제거해서 -->
							<span class="list_percentage_wrap blind"> <!-- 해당 항목이 선택받은 퍼센테이지를 width로 대입해 보이게 하기-->
								<span class="list_percentage"></span>
							</span>
						</section>

						<div class="out_circle">
							<!-- 보일 때 choice 추가-->
							<!-- 가릴 때 choice 삭제-->
							<div class="in_circle"></div>
						</div>
					</div>
					<!-- END choiceList -->
					<!-- START choiceList-->
					<div class="choiceList">
						<section class="txt_wrap_section">
							<section class="txt_section">
								<span class="txt">항목 타이틀 자리</span>
								<!-- 결과보여줄 때, blind 제거 -->
								<span class="choice_mem_cnt blind"></span>
							</section>

							<!-- 결과보여줄 때, blind 제거해서 -->
							<span class="list_percentage_wrap blind"> <!-- 해당 항목이 선택받은 퍼센테이지를 width로 대입해 보이게 하기-->
								<span class="list_percentage"></span>
							</span>
						</section>

						<div class="out_circle">
							<div class="in_circle"></div>
						</div>
					</div>
					<!-- END choiceList -->
				</div>
				<!-- END 투표 선택란 -->
			</div>

			<div id="footer_wrap" class="wrap_common">
				<section id="footer_info">
					<span class="info_common">작성자 정상윤</span> <span class="info_common"
						id="end_date">투표마감:2022-09-01 오전10:00</span>
				</section>

				<section class="btn_section blind">
					<input type="button" id="voteBtn" class="btnCommon" value="투표하기" />
				</section>
				<section class="btn_section">
					<input type="button" id="re_voteBtn" class="btnCommon"
						value="재투표하기" />
				</section>
				<section class="btn_section blind">
					<input type="button" id="re_voteBtn" class="btnCommon" value="닫기" />
				</section>
			</div>
		</div>

	</div>
	<!-- END voteWrap -->

	<div id="confirmWrap" class="blind">
		<div id="confirm_head">
			<img
				src="/meet-a-bwa/resources/img/fluent_more-horizontal-20-regular.png"
				id="more-horizontal" />
		</div>
		<div id="confirm_txt_wrap">
			<span id="confirm_txt">삭제하시겠습니까?</span>
		</div>
		<div id="confirm_btn_wrap">
			<input type="button" id="yesBtn" class="confirm_btn_common" value="예" />
			<input type="button" id="noBtn" class="confirm_btn_common"
				value="아니오" />
		</div>
	</div>
</div>



<!-- *******************  -->
<!-- 이벤트 생성 / 수정 -->
<!-- *******************  -->

<!-- Start voteWrap -->
<div id="voteWrap" class="vote-create-update-wrap blind">
	<!-- Start vote_popup -->
	<div id="vote_popup">

		<!-- 이벤트 생성일 때 SHOW -->
		<div id="event-create" class="blind">
			<h1 id="title">투표 생성</h1>

			<!-- Start sectionWrap -->
			<div id='sectionWrap'>
				<section id="titleSection" class="section_common">
					<h4 class="section_title">투표 제목</h4>
					<section id="title_section">
						<input type="text" id="vote_title" class="common"
							placeholder="투표 제목"> <span id="title_text_length"
							class="text_length">0/15</span>
					</section>
				</section>

				<section id="endDateSection" class="section_common">
					<h4 class="section_title">투표 마감 날짜 설정</h4>
					<div id="pickerWrap">
						<input type="text" id="vote_endDate" class="dateCommon"
							autocomplete="off" placeholder="날짜를 선택해주세요." readonly>
						<!-- START TIMEPICKER -->
						<div id="timepicker_box" class="dateCommon">
							<section id="timeSection">
								<span id="timeValue">--:--:--</span>
							</section>

							<section id="timeImgSection">
								<img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
									alt="시계이미지" />
							</section>

							<div id="customTimePicker" class="blind">
								<div id="ampm_choice">
									<ul id="ampm_listWrap">
										<li class="sample ampm-list"></li>
									</ul>
								</div>
								<div id="time_choice" class="choiceCommon">
									<ul id="time_listWrap">
										<li class="sample time-list"></li>
									</ul>
								</div>
								<div id="minute_choice" class="choiceCommon">
									<ul id="minute_listWrap">
										<li class="sample minute-list"></li>
									</ul>
								</div>
							</div>
						</div>
						<!-- END TIMEPICKER -->
					</div>
				</section>

				<section class="section_common">
					<h4 class="section_title">투표 내용</h4>
					<section>
						<textarea id="vote_description" class="common" placeholder="투표 내용"></textarea>
						<span id="description_text_length" class="text_length">0/150</span>
					</section>
				</section>

				<section id="voteSection" class="section_common">
					<h4 class="section_title">투표 항목</h4>

					<div id="vote_list_Wrap">
						<!-- SAMPLE VOTE LIST -->
						<div class="vote_list sample blind">
							<label class="list_title"></label> <input type="text"
								class="list_text" /> <img
								src="/meet-a-bwa/resources/img/close.svg" alt="항목 삭제 이미지"
								class="removeBtn" />
						</div>
					</div>
				</section>
				<input type="button" id="vote_list_plusBtn" value="투표 항목 추가" />
			</div>
			<!-- END sectionWrap -->

			<div id="btnWrap">
				<input type="button" id="vote_createBtn" class="btnCommon"
					value="투표 만들기"> <input type="button" id="vote_cancleBtn"
					class="btnCommon" value="취소">
			</div>
		</div>
		<!-- END 투표 생성 -->

		<!--  이벤트 수정일 때 SHOW -->
		<div id="event-update" class="blind">
			<div id="topSection">
				<h1 id="update-title">투표 수정</h1>
				<img src="/meet-a-bwa/resources/img/close.svg" alt="close이미지"
					id="closeBtn" />
			</div>

			<!-- Start sectionWrap -->
			<div id='sectionWrap'>
				<section id="titleSection" class="section_common">
					<h4 class="section_title">투표 제목</h4>
					<section id="title_section">
						<input type="text" id="vote_title" class="common"
							placeholder="투표 제목" value=""> <span
							id="title_text_length" class="text_length">0/15</span>
					</section>
				</section>

				<section id="endDateSection" class="section_common">
					<h4 class="section_title">투표 마감 시간/날짜 설정</h4>
					<div id="pickerWrap">
						<input type="text" id="vote_endDate" class="dateCommon"
							autocomplete="off" placeholder="날짜를 선택해주세요." readonly>
						<div id="timepicker_box" class="dateCommon">
							<section id="timeSection">
								<span id="timeValue">--:--:--</span>
							</section>

							<section id="timeImgSection">
								<img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
									alt="시계이미지" />
							</section>

							<div id="customTimePicker" class="blind">
								<div id="ampm_choice">
									<ul id="ampm_listWrap">
										<li class="sample ampm-list"></li>
									</ul>
								</div>
								<div id="time_choice" class="choiceCommon">
									<ul id="time_listWrap">
										<li class="sample time-list"></li>
									</ul>
								</div>
								<div id="minute_choice" class="choiceCommon">
									<ul id="minute_listWrap">
										<li class="sample minute-list"></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</section>

				<section class="section_common">
					<h4 class="section_title">투표 내용</h4>
					<section>
						<textarea id="vote_description" class="common" placeholder="투표 내용"></textarea>
						<span id="description_text_length" class="text_length">0/150</span>
					</section>
				</section>

				<section id="voteSection" class="section_common">
					<h4 class="section_title">투표 항목</h4>

					<div id="vote_list_Wrap">
						<!-- SAMPLE VOTE LIST -->
						<div class="vote_list sample blind">
							<label class="list_title"></label> <input type="text"
								class="list_text" value="" /> <img
								src="/meet-a-bwa/resources/img/close.svg" alt="항목 삭제 이미지"
								class="removeBtn" />
						</div>
					</div>
				</section>
				<input type="button" id="vote_list_plusBtn" value="투표 항목 추가" />

			</div>
			<!-- END sectionWrap -->

			<div id="btnWrap">
				<input type="button" id="vote_updateBtn" class="btnCommon"
					value="투표 수정">
			</div>
		</div>
		<!-- END 투표 수정 -->
	</div>
	<!-- END vote_popup -->

</div>
<!-- END voteWrap -->


<!-- START toastWrap -->
<!-- 필요할 때, hide 없애고 fade-in 클래스 추가-->
<div id="toastWrap" class="hide">
	<span id="toast_txt"></span>
</div>
<!-- END toastWrap -->
</html>