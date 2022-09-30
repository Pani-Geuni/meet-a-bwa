<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/common.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/header.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/searchBar.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/footer.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/user/bin-popup.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/update.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>

<script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
<script src="/meet-a-bwa/resources/js/common/login.js"></script>
<script src="/meet-a-bwa/resources/js/common/logout.js"></script>


<script src="/meet-a-bwa/resources/js/meet/update/update.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/textCondition.js"></script>

<script src="/meet-a-bwa/resources/js/meet/update/region.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/interest.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/profileImage.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/age.js"></script>

<script>
	$(function() {

		//$("#create_meeting").click(function(){

		// 1. NOT NULL 충족 - alert Popup 

		var user_id = '${user_id}'; //세션값 가져옴
		console.log(user_id);

		function check() {
			let meet_name = $("#meet_name").val().trim().length;
			let meet_description = $("#meet_description").val().trim().length;
			let nop = $("#numberofpeople").val();

			console.log(activity_name);
			console.log(activity_description);
			console.log(nop);
			console.log($("#age").val());

			if (meet_name > 0 && meet_description > 0 && nop != 0) {
				console.log("생성 가능");
				let user_id = $("#id").val();
			} else {
				console.log("생성 불가능");

				if (meet_name <= 0 || meet_description <= 0 || nop <= 0) {

					$(".bin-popup").removeClass("blind");
					$(".ok").on("click", function() {
						$(".bin-popup").addClass("blind");
					});
				}
				return false;
			}
		}
		//	});
	});
</script>

<title>모임 수정</title>
</head>
<body>

	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp"></jsp:include>
	<!--  END HEADER INCLUDE -->
	<div id="bodyWrap">
	
	<form action="/meet-a-bwa/m_updateOK.do" method="post" enctype="multipart/form-data" onsubmit="return check();">

		<div class="meetingCUDWrap">
		<section class="blind">
					<label for="meet_no">meet_no:</label>${mvo2.meet_no}<input
						id="meet_no" name="meet_no" value="${mvo2.meet_no}">
				</section>
			<h2 id="meetTitle">모임 수정</h2>
			<hr class="StartLine">
			<div id="img_la">
			<label for="img_header">프로필 사진</label>
			</div>
			<div id="imgWrap">
				<section class="img_body">
				<div id="input-image">
				<img src="${mvo2.meet_image}" width=300px; height=200px; id="image" />
				</div>
				<div class="img_btn_meet_activity"> 
					<label class="input-file-btn" for="input-file">
						<img src="/meet-a-bwa/resources/img//imageAddBtn2.svg" width=70px; height=70px;>
					</label>
					<input type="file" name="upFile" id="input-file" class="input-file">

					<button type="button" id="delete-file2" value="삭제">
					<img src="/meet-a-bwa/resources/img/imageDropBtn2.svg" width=70px; height=70px; alt="삭제">
					</button>
				</div>
				</section>
			</div>
			<div id="namediv">
				<div id="nameLa">
					<label>모임 이름</label>
				</div> <input type="text" placeholder="모임이름을 입력해주세요. (10자 이내)" id="meet_name" name="meet_name" value="${mvo2.meet_name}" />
				<p class="textCount_name blind">0자</p>
				<div id = "toastWrap_name" class="hide">
					<p class="toastText">글자수를 초과하였습니다.</p>
					</div>
			</div><!--namediv end-->
			
			<section id="introducediv">
				<section id="introduceLa"> <label>모임 소개</label></section>
				<section class="textLengthWrap">
				<textarea rows="8" cols="36" placeholder="모임에 대해서 자세하게 설명해주세요." id="meet_description"
					name="meet_description" value="${mvo2.meet_description}">${mvo2.meet_description}</textarea>
					<section class="textLength">
						<p class="textCount">0자</p>
						<p class="textTotal">/500자</p>
					</section><!--textLength end-->
					<div id = "toastWrap_des" class="hide">
						<p class="toastText">글자수를 초과하였습니다.</p>
						</div>
				</section><!--textLengthWrap end-->
				</section> <!--introducediv end-->

			
				<div id="city_div">
					<div id="city_la">
						<label>활동 지역</label>
					</div>
					<select id="city" name='city' class="input" value="${mvo2.meet_city}">
						<option class="city_list" value='${mvo2.meet_city}'>${mvo2.meet_city}</option>
						<option class="city_list" value=''>도/시 선택</option>
						<option class="city_list" value='전체'>전체</option>
					</select> <select name='country' id="country" class=select value="${mvo2.meet_county}">
						<option class="country_option" value='${mvo2.meet_county}'>${mvo2.meet_county}</option>
						<option class="country_option" value=''>군/구 선택</option>
						<option class="country_option" value='전체'>전체</option>
					</select>
				</div>
				<!--citydiv end-->

				<div id="interestdiv">
					<div id="interestLa">
						<label>활동 카테고리</label>
					</div>
					<select id="interest" name="interest" value="${mvo2.meet_interest_name}">
						<option value="${mvo2.meet_interest_name}" class="interest_opt">${mvo2.meet_interest_name}</option>
						<option value="" class="interest_opt">선택</option>
					</select>
				</div>
	
			<div id="tagWrap">
				<input type="button" class="delete_interest interest_result blind">
			</div>			
		
	
				<!--*************** 모임 가입 조건*************** -->
				<section class="conditionWrap">
				<section class="conditionHeader">
				<hr class="conditionLine">
				<h5>*모임에 가입할 회원들을 아래 선택 항목(성별,인원 수, 연령대) 기준으로 제한합니다.</h5>
				</section> <!--conditionHeader end-->
					<section class="conditionBody">
						<section id="genderdiv">
							<section id="genderLa">
								<label>성별</label>
							</section>
							<select id="gender" name="gender" value="${mvo2.meet_gender}">
								<option value="${mvo2.meet_gender}">${mvo2.meet_gender}</option>
								<option value="">선택</option>
								<option value="여">여</option>
								<option value="남">남</option>
							</select>
						</section>

						<section id="nop">
							<section id="nopLa">
								<label>인원 수 (필수입력)</label>
							</section>
							<select id="numberofpeople" class="numberofpeople" name="nop" value="${mvo2.meet_nop}">
								<option value="${mvo2.meet_nop}">${mvo2.meet_nop}</option>
								<option value="0">선택</option>
								<c:forEach var="i" begin="1" end="20">
									<option>${i}</option>
								</c:forEach>
							</select>
						</section>

						<section id="ageWrap">
							<section id="ageHeader">
								<label>연령대</label>
							</section>
							<select id="ageBody" class="ageBody" name="age" value="${mvo2.meet_age}">
								<option value="${mvo2.meet_age}">${mvo2.meet_age}<span>대</span></option>
								<option value="0">선택</option>
								<c:forEach var="i" begin="10" end="100" step="10">
									<option><span>${i}</span><span>대</span></option>
								</c:forEach>
							</select>
							<div id="tagWrap_age">
								<input type="button" class=" delete_age age_result blind">
							</div>
				</section><!--ageWrap end-->
				</section><!--conditionBody end-->
				</section> <!--conditionWrap end-->
	
				<section class="blind">
					<label for="meet_no">meet_no:</label>${mvo2.meet_no}<input
						id="meet_no" name="meet_no" value="${mvo2.meet_no}">
				</section>
				
				<!-- ************************************************************* -->
				<!-- 액티비티 개설자와 해당 모임 -->
				<section class="blind">
					<label for="user_no">user_no:</label>
					<input type="text" id="user_no" name="user_no" value="${mvo2.user_no}">
				</section>
				<!-- ************************************************************* -->
			<input type="submit" id="update_meet_information_btn" value="모임정보수정" />

			</div>
		
			<!--  START HEADER INCLUDE -->
			<jsp:include page="../../views/common/footer.jsp"></jsp:include>
			<!--  END HEADER INCLUDE -->
	</form>
</div>
<!-- 팝업 -->
	<!-- not null -->
	<section class="bin-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p class="bin_obj">빈 항목을 채워주세요!</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content2">
							<button class="ok">확인</button>
						</section>
						<!--modal-content3-->
					</section>
					<!--modal-content-inner end-->
				</div>
				<!--modal-content-wrap end-->
			</div>
			<!--modal-wrap end-->
		</div>
		<!--model-bg end-->
	</section>
	<!-- 이미지 용량 초과 -->
	<section class="image-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner2">
						<section class="modal-content1">
							<p class="font">첨부파일 사이즈</p>
							<p class="font">10KB 이내로 등록 가능</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content3">
							<button class="ok">확인</button>
						</section>
						<!--modal-content3-->
					</section>
					<!--modal-content-inner end-->
				</div>
				<!--modal-content-wrap end-->
			</div>
			<!--modal-wrap end-->
		</div>
		<!--model-bg end-->
	</section>
</body>
</html>