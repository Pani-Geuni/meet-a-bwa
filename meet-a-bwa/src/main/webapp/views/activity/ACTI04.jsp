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

<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/bin-popup.css" />

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/activity/update.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
 <script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
<script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/login.js"></script>
<script src="/meet-a-bwa/resources/js/common/logout.js"></script>

<script>
	//$(function() {

		//var user_id = '${user_id}'; //세션값 가져옴
		//console.log(user_id);

		/* $("#membership_withdrawal_btn").on("click", function() {
			$(".withdrawal-popup").removeClass("blind");
			$(".withdrawalOK").click(function() {
				$(".withdrawal-popup").addClass("blind");
					
					// $.cookie("user_no");
					
					location.replace("u_delete.do?user_no=" + $.cookie("user_no"));
				});
			});
			$(".cancle").click(function() {
				$(".withdrawal-popup").addClass("blind");
			}); *//* 탈퇴는 액티비티 피드에서 구현 */

//	});

	function check() {
		let activity_name = $("#activity_name").val().trim().length;
        let activity_description =$("#activity_description").val().trim().length;
        let nop = $("#numberofpeople").val();

        console.log(activity_name);
        console.log(activity_description);
        console.log(nop);
        //console.log($("#age").val());

        if(activity_name>0&&activity_description>0&&nop!=0){
                console.log("생성 가능");
                let user_id = $("#id").val();
        }else {
			console.log("생성 불가능");

			if (activity_name<=0||activity_description<=0||nop<=0) {

				$(".bin-popup").removeClass("blind");
				$(".ok").on("click", function(){
				  	$(".bin-popup").addClass("blind");
				 });
			} 
		return false;
		}
	}
</script>

<script src="/meet-a-bwa/resources/js/activity/update/age.js"></script>
<script src="/meet-a-bwa/resources/js/activity/update/region.js"></script>
<script src="/meet-a-bwa/resources/js/activity/update/interest.js"></script>
<script src="/meet-a-bwa/resources/js/activity/update/textCondition.js"></script>
<script src="/meet-a-bwa/resources/js/activity/update/profileImage.js"></script>
<script src="/meet-a-bwa/resources/js/activity/update/updateOK.js"></script>
<title>액티비티 수정</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp"></jsp:include>
	<!--  END HEADER INCLUDE -->
	<div id="bodyWrap">
		<form action="/meet-a-bwa/a_updateOK.do" method="post"
			enctype="multipart/form-data" onsubmit="return check();">

			<div class="activityCUDWrap">
				<section class="blind">
					<label for="activity_no">activity_no:</label>${avo2.activity_no}<input
						id="activity_no" name="activity_no" value="${avo2.activity_no}">
				</section>
				<h2 id="activityTitle">액티비티 수정</h2>
				<hr class="StartLine">
				<div id="img_la">
					<label for="img_header">프로필 사진</label>
				</div>
				<div id="imgWrap">
					<section class="img_body">
						<div id="input-image">
							<img src="${avo2.activity_image}" width=300px; height=200px;
								id="image" name="image" />
						</div>
						<div class="img_btn_meet_activity">
							<label class="input-file-btn" for="input-file"> <img
								src="/meet-a-bwa/resources/img/imageAddBtn2.svg" width=70px;
								height=70px;>
							</label> <input type="file" name="upFile" id="input-file"
								class="input-file">

							<button type="button" id="delete-file2" value="삭제">
								<img src="/meet-a-bwa/resources/img/imageDropBtn2.svg"
									width=70px; height=70px; alt="삭제">
							</button>
						</div>
					</section>
				</div>
				<div id="namediv">
					<div id="nameLa">
						<label>액티비티 이름</label>
					</div>
					<input type="text" placeholder="액티비티 이름을 입력해주세요. (10자 이내)"
						id="activity_name" name="activity_name"
						value="${avo2.activity_name}" />
					<p class="textCount_name blind">0자</p>
					<div id="toastWrap_name" class="hide">
						<p class="toastText">글자수를 초과하였습니다.</p>
					</div>
				</div>

				<section id="introducediv">
					<section id="introduceLa">
						<label>액티비티 소개</label>
					</section>
					<section class="textLengthWrap">
						<textarea rows="8" cols="36" maxlength="500"
							placeholder="액티비티에 대해서 자세하게 설명해주세요." id="activity_description"
							name="activity_description" value="${avo2.activity_description}">${avo2.activity_description}</textarea>
						<section class="textLength">
							<p class="textCount">0자</p>
							<p class="textTotal">/500자</p>
						</section>
						<!--textLength end-->
						<div id="toastWrap_des" class="hide">
							<p class="toastText">글자수를 초과하였습니다.</p>
						</div>
					</section>
					<!--textLengthWrap end-->
				</section>
				<!--introducediv end-->

				<div id="city_div">
					<div id="city_la">
						<label>활동 지역</label>
					</div>
					<select id="city" name='city' class="input"
						value="${avo2.activity_city}">
						<option class="city_list" value='${avo2.activity_city}'>${avo2.activity_city}</option>
						<option class="city_list" value=''>도/시 선택</option>
						<option class="city_list" value='전체'>전체</option>
					</select> <select name='country' id="country" class=select
						value="${avo2.activity_county}">
						<option class="country_option" value='${avo2.activity_county}'>${avo2.activity_county}</option>
						<option class="country_option" value=''>군/구 선택</option>
						<option class="country_option" value='전체'>전체</option>
					</select>
				</div>
				<!--citydiv end-->

				<div id="interestdiv">
					<div id="interestLa">
						<label>활동 카테고리</label>
					</div>
					<select id="interest" value="${avo2.activity_interest_name}" name="interest">
						<option value="${avo2.activity_interest_name}" class="interest_opt">${avo2.activity_interest_name}</option>
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
					</section>
					<!--conditionHeader end-->
					<section class="conditionBody">
						<section id="genderdiv">
							<section id="genderLa">
								<label>성별</label>
							</section>
							<select id="gender" value="${avo2.activity_gender}" name="gender">
								<option value="${avo2.activity_gender}">${avo2.activity_gender}</option>
								<option value="">선택</option>
								<option value="여">여</option>
								<option value="남">남</option>
							</select>
						</section>
						
						<section id="nop">
							<section id="nopLa">
								<label>인원 수 (필수입력)</label>
							</section>
							<select id="numberofpeople" class="numberofpeople" name="nop" value="${avo2.activity_nop}">
									<option value="${avo2.activity_nop}">${avo2.activity_nop}</option>
									<option value="0">선택</option>
									<c:forEach  var="i" begin="1" end="20">
                    				<option>${i}</option>
                  					</c:forEach> 
							</select>
						</section>
						
						<section id="ageWrap">
							<section id="ageHeader">
								<label>연령대</label>
							</section>
							<select id="ageBody" class="ageBody" name="age" value="${avo2.activity_age}">
								<option value="${avo2.activity_age}">${avo2.activity_age}<span>대</span></option>
								<option value="0">선택</option>
									<c:forEach var="i" begin="10" end="100" step="10">
                    				<option><span>${i}</span><span>대</span></option>
                    				</c:forEach> 
							</select>
							<div id="tagWrap_age">
								<input type="button" class="delete_age age_result blind">
							</div>
						</section>
						<!--ageWrap end-->
					</section>
					<!--conditionBody end-->
				</section>
				<!--conditionWrap end-->

				<!-- ************************************************************* -->
				<!-- 액티비티 개설자와 해당 모임 -->
				<section class="blind">
					<label for="user_no">user_no:</label>
					<input type="text" id="user_no" name="user_no" value="${avo2.user_no}">
				</section>
				<section class="blind">
					<label for="meet_no">meet_no:</label>
					<input type="text" id="meet_no" name="meet_no" value="${avo2.meet_no }">
				</section>
				<!-- ************************************************************* -->

				
				<input type="submit" id="update_activity_information_btn"
					value="액티비티정보수정" />

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