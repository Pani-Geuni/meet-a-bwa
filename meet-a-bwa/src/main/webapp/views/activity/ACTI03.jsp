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

<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/bin-popup.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/activity/create.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>

<script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
   <script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>

<script src="/meet-a-bwa/resources/js/activity/create/create.js"></script>
<script src="/meet-a-bwa/resources/js/activity/create/textCondition.js"></script>



<title>액티비티 생성</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp"></jsp:include>
	<!--  END HEADER INCLUDE -->
	<div id="bodyWrap">
		<div class="innerBodyWrap">

			<div class="activityCUDWrap">
				<h2 id="activityTitle">액티비티 생성</h2>
				<hr class="StartLine">
				<div id="img_la">
					<label for="img_header">프로필 사진</label>
				</div>
				<div id="imgWrap">
					<section class="img_body">
						<div id="input-image">
							<img src="/meet-a-bwa/resources/img/default-image2.png"
								width=300px; height=200px; id="image" name="image"/>
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
						id="activity_name" name="activity_name" value="" />
					<p class="textCount_name blind">0자</p>
					<div id="toastWrap_name" class="hide">
						<p class="toastText">글자수를 초과하였습니다.</p>
					</div>
				</div>
				<!--namediv end-->

				<section id="introducediv">
					<section id="introduceLa">
						<label>액티비티 소개</label>
					</section>
					<section class="textLengthWrap">
						<textarea rows="8" cols="36" placeholder="액티비티에 대해서 자세하게 설명해주세요."
							id="activity_description" name="activity_description"></textarea>
						<!-- maxlength="500" -->
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
					<select id="city" name='city' class="input">
						<option class="city_list" value=''>도/시 선택</option>
						<option class="city_list" value='전체'>전체</option>
					</select> <select name='country' id="country" class=select>
						<option class="country_option" value=''>군/구 선택</option>
						<option class="country_option" value='전체'>전체</option>
					</select>
				</div>
				<!--citydiv end-->

				<div id="interestdiv">
					<div id="interestLa">
						<label>활동 카테고리</label>
					</div>
					<select id="interest" name="interest">
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
						<h5>* 액티비티에 가입할 회원들을 아래 선택 항목(성별,인원 수, 연령대) 기준으로 제한합니다.</h5>
					</section>
					<!--conditionHeader end-->
					<section class="conditionBody">
						<section id="genderdiv">
							<section id="genderLa">
								<label>성별</label>
							</section>
							<select id="gender" name="gender">
								<option value="">선택</option>
								<option value="여">여</option>
								<option value="남">남</option>
							</select>
						</section>
						
						<section id="nop">
							<section id="nopLa">
								<label>인원 수 (필수입력)</label>
							</section>
							<select id="numberofpeople" class="numberofpeople" name="nop">
								<!-- <optgroup id="num">
									<option value="0">선택</option>
								</optgroup> -->
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
							<select id="ageBody" class="ageBody" name="age">
									<option value="0">선택</option>
									<c:forEach  var="i" begin="10" end="100" step="10">
                    				<option><span>${i}</span><span>대</span></option>
                    				</c:forEach> 
							</select>
							<div id="tagWrap_age">
								<input type="button" class=" delete_age age_result blind">
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
					<input type="text" id="user_no" name="user_no" values="<c:out value='${user_no}'/>">
				</section>
				<section class="blind">
					<label for="user_no">meet_no:</label>
					<input type="text" id="user_no" name="user_no" values="<c:out value='${meet_no}'/>">
				</section>
				<!-- ************************************************************* -->

				<input type="button" id="create_activity" value="액티비티 생성" />
			

			</div>

			<!--  START HEADER INCLUDE -->
			<jsp:include page="../../views/common/footer.jsp"></jsp:include>
			<!--  END HEADER INCLUDE -->
		</div> <!-- innerBodyWrap end -->
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