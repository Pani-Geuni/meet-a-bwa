<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css" />
	
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />
	
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/my-meet.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />
	
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/list/meet-list.css" />
	
	<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
	<script src="/meet-a-bwa/resources/js/common/header.js"></script>
	<script src="/meet-a-bwa/resources/js/common/logout.js"></script>
	<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>

	<script>
    	$(function() {
    		// 상세 리스트 클릭 이벤트
	    	 $("#meet-list-section").on("click", ".content-list.meet-list", function(){
	    		 let idx = $(this).attr("idx");
	    		 location.href = "/meet-a-bwa/meet-main.do?idx="+idx;
	    	 });
    		
	    	 $("#meet-list-section").on("click", ".heartSection", function(event){
		   		 event.stopPropagation();
		   		 
		   		 if($.cookie("isLogin") == 'true'){
		   		 	// 좋아요 추가
			    		 if($(this).find(".afterLike_heart").hasClass("blind")){
				    		 location.href = "/meet-a-bwa/my_meet_like_insert.do?meet_no=" + $(this).attr("idx") + "&user_no=" + $.cookie("user_no");
			    		 }
			    		 // 좋아요 삭제
			    		 else{
				    		 location.href = "/meet-a-bwa/my_meet_like_delete.do?meet_no=" + $(this).attr("idx") + "&user_no=" + $.cookie("user_no");
			    		 }
		   		 }else{
		   			 $(".warning-layer").removeClass("blind");
		   		 }
	   	 	});
	    	
	    	// 모임 좋아요 처리
		   	 let like_meet_arr = $.cookie('like_meet');
		   	 if(like_meet_arr != undefined){
		  	 	like_meet_arr = like_meet_arr.split("/");
			    	 
		   		let meet_elements = $(".content-list.meet-list").slice();
			    	for(like_meet of like_meet_arr){
			    		for(list of meet_elements){
				    		if($(list).attr("idx") == like_meet) {
					    		$(list).find(".beforeLike_heart").addClass("blind");
					    		$(list).find(".afterLike_heart").removeClass("blind");
				    		}
			    		}
			    	}
		   	 }
    	})
    	
    </script>
    
<title>나의 모임 리스트</title>
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
				<h1 class="titleSection">나의 모임</h1>


				<div id="meet-list-section">
					<c:forEach var="mvo" items="${mvos}">
						<!-- start content_list div-->
						<div class="content-list meet-list" idx="${mvo.meet_no}">
							<div class="info-list-wrap">
								<div class="listCommon">
									<span class="content_title">${mvo.meet_name}</span>
								</div>

								<div class="description_list listCommon">
									<span class="content_description">
										${mvo.meet_description} </span>
								</div>

								<div class="listCommon">
									<div class="tagSection">
										<c:if test="${mvo.meet_county ne null}">
											<div class="loca_tag tag">
												<img src="/meet-a-bwa/resources/img/map.png" class="tag_img">
												<span class="location_name font_size_10">${mvo.meet_county}</span>
											</div>
										</c:if>

										<c:if test="${mvo.meet_interest_name ne null}">
											<div class="cate_tag tag">
												<span class="category_name font_size_10">${mvo.meet_interest_name}</span>
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
									<c:if test="${mvo.user_cnt ne null}">
										<div class="meet_member_info">
											<span class="member_cnt member_ment">${mvo.user_cnt}명</span>
											<span class="member_ment">참여 중</span>
										</div>
									</c:if>

									<c:if test="${mvo.meet_age != 0}">
										<!-- 조건있는 모임(조건없을 시 hide 클래스 추가) -->
										<div class="meet_condition">
											<img src="/meet-a-bwa/resources/img/line.svg" alt="line이미지"
												class="divide"> <span
												class="condition_bold condition_common"><b>모집</b></span> <span
												class="condition_regular condition_common">${mvo.meet_age}대</span>
										</div>
									</c:if>
								</div>

								<div class="likeWrap">
									<section class="heartSection" idx = "${ mvo.meet_no }">
										<img src="/meet-a-bwa/resources/img/heart-outlined.svg"
											alt='라인하트이미지' class="beforeLike_heart heartCommon" /> <img
											src="/meet-a-bwa/resources/img/heart-filled.svg" alt='풀하트이미지'
											class="afterLike_heart heartCommon blind" />
									</section>
									<span class="likeCnt">${mvo.like_cnt}</span>
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