<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/searchBar.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/list/meet-list.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
<script src="/meet-a-bwa/resources/js/common/login.js"></script>
<script src="/meet-a-bwa/resources/js/common/logout.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>

<script src="/meet-a-bwa/resources/js/meet/create/create.js"></script>

<script>
	$(function() {
		var user_id = '${user_id}'; //세션값 가져옴
		
		// 상세 리스트 클릭 이벤트
		$("#meet-list-section").on("click", ".content-list.meet-list", function() {
			let idx = $(this).attr("idx");
			location.href = "/meet-a-bwa/meet-main.do?idx=" + idx;
		});
		
		$("#meet-list-section").on("click", ".heartSection", function(event){
	   		 event.stopPropagation();
	   		 
	   		 if($.cookie("isLogin") == 'true'){
	   		 	// 좋아요 추가
		    		 if($(this).find(".afterLike_heart").hasClass("blind")){
			    		 location.href = "/meet-a-bwa/main_meet_like_insert.do?meet_no=" + $(this).attr("idx") + "&user_no=" + $.cookie("user_no");
		    		 }
		    		 // 좋아요 삭제
		    		 else{
			    		 location.href = "/meet-a-bwa/main_meet_like_delete.do?meet_no=" + $(this).attr("idx") + "&user_no=" + $.cookie("user_no");
		    		 }
	   		 }else{
	   			 $(".warning-layer").removeClass("blind");
	   		 }
   	 	});
		
		// 모임 좋아요 처리
	   	 let like_meet_arr = $.cookie('like_meet');
	   	 if(like_meet_arr != undefined){
	  	 		like_meet_arr = like_meet_arr.split("/");
		    	 
	   		 let meet_elements = $(".content_list.meet-list").slice();
		    	 for(like_meet of like_meet_arr){
		    		 for(list of meet_elements){
			    		 if($(list).attr("idx") == like_meet) {
				    		 $(list).find(".beforeLike_heart").addClass("blind");
				    		 $(list).find(".afterLike_heart").removeClass("blind");
			    		 }
		    		 }
		    	 }
	   	 }
	   	 
	  	// 경고 팝업 닫기 버튼 클릭 이벤트
    	 $(".warning-close").click(function(){
    		 $(".warning-layer").addClass("blind");
    	 });
   	 
	})
</script>


<title>모임 리스트</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="../../views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>
	<!--  END HEADER INCLUDE -->

	<div id="bodyWrap">
		<!--  START SEARCHBAR INCLUDE -->
		<jsp:include page="../../views/common/searchBar.jsp"></jsp:include>
		<!--  END SEARCHBAR INCLUDE -->

		<div id="contentWrap">
			<div class="mainContent">
				<div class="titleSection">
					<section class="title titleLeft">
						<section id="beforeLogin_recommend">
							<span class="comment">관심이 있는 모임을 보여드려요!</span>
						</section>
					</section>

					<section class="title titleRight">
						<c:if test="${ list.isLogin eq true}">
							<button class="btn-create-meet">모임 생성</button>
						</c:if>
						<span id="plusBtn_meet" class="plusBtn">정렬</span>
					</section>
				</div>

				<div id="meet-list-section">
					<c:if test="${ mlvos.size() != 0}">
						<c:forEach var="mlvo" items="${mlvos}">
							<div class="content-list meet-list" idx="${ mlvo.meet_no }">
								<div class="info-list-wrap">
									<div class="listCommon">
										<span class="content_title">${mlvo.meet_name}</span>
									</div>

									<div class="description_list listCommon">
										<span class="content_description">
											${mlvo.meet_description} </span>
									</div>

									<div class="listCommon">
										<div class="tagSection">
											<c:if test="${mlvo.meet_county ne null}">
												<div class="loca_tag tag">
													<img src="/meet-a-bwa/resources/img/map.png"
														class="tag_img"> <span
														class="location_name font_size_10">${mlvo.meet_county}</span>
												</div>
											</c:if>

											<c:if test="${mlvo.meet_interest_name ne null}">
												<div class="cate_tag tag">
													<span class="category_name font_size_10">${mlvo.meet_interest_name}</span>
												</div>
											</c:if>
										</div>
									</div>

									<div class="content_img">
										<img src="${ mlvo.meet_image }"
											class="list_img">
									</div>
								</div>


								<div class="bottomWrap">
									<div class="meet_info">
										<c:if test="${mlvo.user_cnt ne null}">
											<div class="meet_member_info">
												<span class="member_cnt member_ment">${mlvo.user_cnt}명</span>
												<span class="member_ment">참여 중</span>
											</div>
										</c:if>

										<c:if test="${mlvo.meet_age != 0}">
											<!-- 조건있는 모임(조건없을 시 hide 클래스 추가) -->
											<div class="meet_condition">
												<img src="/meet-a-bwa/resources/img/line.svg" alt="line이미지"
													class="divide"> <span
													class="condition_bold condition_common"><b>모집</b></span> <span
													class="condition_regular condition_common">${mlvo.meet_age}대</span>
											</div>
										</c:if>
									</div>

									<div class="likeWrap">
										<section class="heartSection" idx = "${ mlvo.meet_no }">
											<img src="/meet-a-bwa/resources/img/heart-outlined.svg"
												alt='라인하트이미지' class="beforeLike_heart heartCommon" /> <img
												src="/meet-a-bwa/resources/img/heart-filled.svg"
												alt='풀하트이미지' class="afterLike_heart heartCommon blind" />
										</section>
										<span class="likeCnt">${mlvo.like_cnt}</span>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${ mlvos.size() == 0}">
						<div class="no-list-wrap">
							<img class="no-list-img"
								src="/meet-a-bwa/resources/img/blue_warning.svg" alt='파란 경고 이미지' />
							<p class="no-list-txt">관련된 모임이 존재하지 않습니다.</p>
						</div>
					</c:if>
				</div>
				<!-- end meet-list-section -->
			</div>
		</div>
	</div>
</body>
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
<!-- START WARNING POPUP -->
        <div class="warning-layer blind">
         <div class="warning-popup-wrap">
         	<div class = "warning-img-section">
	            <img src="resources/img/warning.svg" alt="경고 이미지"/>
         	</div>
            <h1 id = "warning-text">
             	로그인 후 이용가능한 기능입니다.
            </h1>
      
            <div class="btn-group">
              <button class="warning-close">취소</button>
            </div>
       	  </div>
        </div>
        <!-- END WARNING POPUP -->
</html>