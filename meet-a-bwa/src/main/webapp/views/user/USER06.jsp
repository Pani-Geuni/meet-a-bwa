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

<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/my-meet.css"/>
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/list/activity-list.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/logout.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
<script>
	$(function() {
		$("#activity-list-section").on("click", ".content-list.activity-list",  function(){
			 let idx = $(this).attr("idx");
			 console.log(idx)
			 location.href = "/meet-a-bwa/activity-main.do?idx="+idx;
		});
		
		$("#activity-list-section").on("click", ".heartSection", function(event){
	   		 event.stopPropagation();
	   		 
	   		 if($.cookie("isLogin") == 'true'){
	   		 	// 좋아요 추가
		    		 if($(this).find(".afterLike_heart").hasClass("blind")){
			    		 location.href = "/meet-a-bwa/my_activity_like_insert.do?activity_no=" + $(this).attr("idx") + "&user_no=" + $.cookie("user_no");
		    		 }
		    		 // 좋아요 삭제
		    		 else{
			    		 location.href = "/meet-a-bwa/my_activity_like_delete.do?activity_no=" + $(this).attr("idx") + "&user_no=" + $.cookie("user_no");
		    		 }
	   		 }else{
	   			 $(".warning-layer").removeClass("blind");
	   		 }
  	 	});
		
		// 모임 좋아요 처리
	   	 let like_meet_arr = $.cookie('like_activity');
	   	 if(like_meet_arr != undefined){
	  	 	like_meet_arr = like_meet_arr.split("/");
		    	 
	   		let meet_elements = $(".content-list.activity-list").slice();
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

<title>나의 액티비티 리스트</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="../../views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>
	<!--  END HEADER INCLUDE -->

<section id="bodyWrap">
      <div id="contentWrap">
        <div class="mainContent">
          <h1 class="titleSection">나의 액티비티</h1>

          <div id="activity-list-section">
					<c:forEach var="avo" items="${avos}">
						<!-- start content_list div-->
						<div class="content-list activity-list" idx="${avo.activity_no}">
							<div class="info-list-wrap">
								<div class="listCommon">
									<span class="content_title">${avo.activity_name}</span>
								</div>

								<div class="description_list listCommon">
									<span class="content_description">
										${avo.activity_description} </span>
								</div>

								<div class="listCommon">
									<div class="tagSection">
										<c:if test="${avo.activity_county ne null}">
											<div class="loca_tag tag">
												<img src="/meet-a-bwa/resources/img/map.png" class="tag_img">
												<span class="location_name font_size_10">${avo.activity_county}</span>
											</div>
										</c:if>

										<c:if test="${avo.activity_interest_name ne null}">
											<div class="cate_tag tag">
												<span class="category_name font_size_10">${avo.activity_interest_name}</span>
											</div>
										</c:if>
									</div>
								</div>

								<div class="content_img">
									<img src="/meet-a-bwa/resources/img/loopy.svg" class="list_img">
								</div>
							</div>


							<div class="bottomWrap">
								<div class="meet_info">
									<c:if test="${avo.user_cnt ne null}">
										<div class="meet_member_info">
											<span class="member_cnt member_ment">${avo.user_cnt}명</span>
											<span class="member_ment">참여 중</span>
										</div>
									</c:if>

									<c:if test="${avo.activity_age != 0}">
										<!-- 조건있는 모임(조건없을 시 hide 클래스 추가) -->
										<div class="meet_condition">
											<img src="/meet-a-bwa/resources/img/line.svg" alt="line이미지"
												class="divide"> <span
												class="condition_bold condition_common"><b>모집</b></span> <span
												class="condition_regular condition_common">${avo.activity_age}대</span>
										</div>
									</c:if>
								</div>

								<div class="likeWrap">
									<section class="heartSection" idx = "${ avo.activity_no }">
										<img src="/meet-a-bwa/resources/img/heart-outlined.svg"
											alt='라인하트이미지' class="beforeLike_heart heartCommon" /> <img
											src="/meet-a-bwa/resources/img/heart-filled.svg" alt='풀하트이미지'
											class="afterLike_heart heartCommon blind" />
									</section>
									<span class="likeCnt">${avo.like_cnt}</span>
								</div>
							</div>
						</div>
						<!-- end content_list div -->
					</c:forEach>
				</div>
        </div>
      </div>
    </section>
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
</html>