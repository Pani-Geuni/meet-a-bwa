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
	href="/meet-a-bwa/resources/css/common/footer.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/update.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>

<script src="/meet-a-bwa/resources/js/meet/update/update.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/textCondition.js"></script>

<script src="/meet-a-bwa/resources/js/user/region.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/interest.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/profileImage.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/age.js"></script>

<title>모임 수정</title>
</head>
<body>

	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp"></jsp:include>
	<!--  END HEADER INCLUDE -->
	<div id="bodyWrap">
	
	<form action="meet_insertOK.do" method="post" enctype="multipart/form-data">

		<div class="meetingCUDWrap">
			<h2 id="meetTitle">모임 수정</h2>
			<hr class="StartLine">
			<div id="img_la">
			<label for="img_header">프로필 사진</label>
			</div>
			<div id="imgWrap">
				<section class="img_body">
				<div id="input-image">
				<img src="/meet-a-bwa/resources/img/default-image2.png" width=300px; height=200px; id="image" />
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
				</div> <input type="text" placeholder="모임이름을 입력해주세요. (10자 이내)" id="meet_name" name="meet_name" value="" />
				<p class="textCount_name blind">0자</p>
				<div id = "toastWrap_name" class="hide">
					<p class="toastText">글자수를 초과하였습니다.</p>
					</div>
			</div><!--namediv end-->
			
			<section id="introducediv">
				<section id="introduceLa"> <label>모임 소개</label></section>
				<section class="textLengthWrap">
				<textarea rows="8" cols="36" placeholder="모임에 대해서 자세하게 설명해주세요." id="meet_description"
					name="meet_description"></textarea>
					<section class="textLength">
						<p class="textCount">0자</p>
						<p class="textTotal">/500자</p>
					</section><!--textLength end-->
					<div id = "toastWrap_des" class="hide">
						<p class="toastText">글자수를 초과하였습니다.</p>
						</div>
				</section><!--textLengthWrap end-->
				</section> <!--introducediv end-->

			<div id="citydiv">
				<div id="cityLa"> <label>활동 지역</label> </div> <select id="city" name='city' class="input">
					<option value=''>도/시 선택</option>
					<option value='전체'>전체</option>
					<option value='서울특별시'>서울특별시</option>
					<option value='부산광역시'>부산광역시</option>
					<option value='대구광역시'>대구광역시</option>
					<option value='인천광역시'>인천광역시</option>
					<option value='광주광역시'>광주광역시</option>
					<option value='대전광역시'>대전광역시</option>
					<option value='울산광역시'>울산광역시</option>
					<option value='경기도'>경기도</option>
					<option value='강원도'>강원도</option>
					<option value='충청북도'>충청북도</option>
					<option value='충청남도'>충청남도</option>
					<option value='전라북도'>전라북도</option>
					<option value='전라남도'>전라남도</option>
					<option value='경상북도'>경상북도</option>
					<option value='경상남도'>경상남도</option>
					<option value='제주특별자치도'>제주특별자치도</option>
				</select> <select name='country' id="country" class=select>
					<option class="country_option">군/구 선택</option>
				</select>
				</div>
				
				<div id="interestdiv">
					<div id="interestLa"> <label>활동 카테고리</label> </div>
					 <select id="interest">
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
					<section id="genderLa"> <label>성별</label></section>
					<select id="gender">
						<option value="">선택</option>
						<option value="여">여</option>
						<option value="남">남</option>
					</select>
				</section>
				<section id="nop">
					<section id="nopLa"> <label>인원 수</label> </section>
					<select id="numberofpeople" class="numberofpeople">
						<optgroup id="num">
							<option value="">선택</option>
						</optgroup>
	
						<!-- <c:forEach  var="i" begin="1" end="20">
						<option>${i}</option>
					  </c:forEach> -->
					</select>
				</section>
				<section id="ageWrap">
					<section id="ageHeader"> <label>연령대</label> </section>
					<select id="ageBody" class="ageBody">
						<optgroup id="ageRange">
							<option value="">선택</option>
						</optgroup>
					</select>
					<div id="tagWrap_age">
						<input type="button" id="delete_age" class="age_result blind">
					</div>
				</section><!--ageWrap end-->
				</section><!--conditionBody end-->
				</section> <!--conditionWrap end-->
	

			<input type="button" id="update_meet_information_btn" value="모임정보수정" />

			</div>
		
			<!--  START HEADER INCLUDE -->
			<jsp:include page="../../views/common/footer.jsp"></jsp:include>
			<!--  END HEADER INCLUDE -->
	</form>
</div>
</body>
</html>