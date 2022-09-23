<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/common.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/header.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/footer.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/join.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
<script src="/meet-a-bwa/resources/js//user/join/join.js"></script>
<script src="/meet-a-bwa/resources/js/user/join/textCondition.js"></script>
<script src="/meet-a-bwa/resources/js/user/idCheck.js"></script>
<script src="/meet-a-bwa/resources/js/user/nickCheck.js"></script>
<script src="/meet-a-bwa/resources/js/user/emailCheck.js"></script>
<script src="/meet-a-bwa/resources/js/user/region.js"></script>
<script src="/meet-a-bwa/resources/js/user/interest.js"></script>
<script src="/meet-a-bwa/resources/js/user/profileImage.js"></script>

<title>밋:어봐</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp"></jsp:include>
	<!--  END HEADER INCLUDE -->
	<div id="bodyWrap">
	<form action="joinOK.do" method="post" enctype="multipart/form-data">
		<div class="joinWrap">
			<h2 id="joinTitle">회원 가입</h2>

			<p>
				<span class="noChange">*</span> : 가입 후 변경 불가
			</p>
			<hr class="StartLine">
			<div id="img_la">
				<label for="img_header">프로필 사진</label>
			</div>
			<div id="imgWrap">
				<section class="img_body">
					<label id="input-image" for="input-file"> <img
						src="/meet-a-bwa/resources/img/placeholder1.webp" width=150px; height=150px;
						id="image" />
					</label>
					<div class="img_btn">

						<!-- input type="image" src="../img/imageAddBtn2.svg" class="input-file-btn" for="input-file">
					<input type="file" name="upFile" id="input-file" class="input-file">< -->
						<!-- <input type="image" src="../img/imageDropBtn2.svg" id="delete-file1" value="삭제"> -->

						<label class="input-file-btn" for="input-file"> <img
							src="/meet-a-bwa/resources//img/imageAddBtn2.svg" width=50px; height=50px;>
						</label> <input type="file" name="upFile" id="input-file"
							class="input-file">

						<button type="button" id="delete-file1" value="삭제">
							<img src="/meet-a-bwa/resources//img/imageDropBtn2.svg" width=50px; height=50px;
								alt="삭제">
						</button>

					</div>
				</section>
			</div>
			<div id="id_div">
				<div id="id_la">
					<label><span class="noChange">*</span> 아이디</label>
				</div>
				<input type="text" placeholder="아이디를 입력해주세요. (최대 10자)" id="id"
					name="id" value="" /> <input type="button" id="btn_idCheck"
					value="중복체크"> <input type="button" id="btn_idRe"
					value="재입력" class="blind">
				<p class="toastText_idCheck blind"></p>

				<div id="toastWrap_id" class="hide">
					<p class="textCount_id blind">0자</p>
					<p class="toastText">글자수를 초과하였습니다.</p>
				</div>
				<!-- <p class="toastText">글자수를 초과하였습니다.</p> -->
			</div>

			<div id="pwWrap">
				<div id="pw_div">
					<div id="pw_la">
						<label>비밀번호</label>
					</div>
					<input type="password" placeholder="비밀번호를 입력해주세요. (최소 8자 ~ 최대 15자)"
						id="pw" name="pw" value="" />
					<div id="toastWrap_pw" class="hide">
						<p class="textCount_pw blind">0자</p>
						<p class="toastText_max">글자수를 초과하였습니다.</p>
					</div>
					<!--toastWrap end-->
					<p class="toastText_min1 hide">최소 8글자 이상으로 입력해주세요</p>
				</div>
				<!--pw_div end-->

				<div id="pw_check_div">
					<div id="pw_check_la">
						<label>비밀번호 재입력</label>
					</div>
					<section class="pw_check_toastWrap">
						<section id="toastOutWrap">
							<input type="password" placeholder="비밀번호를 다시 입력해주세요."
								id="pw_check" name="pw_check" value="" />
							<div id="toastWrap_pwcheck" class="hide">
								<!-- 왼쪽 마진 줘야함 -->
								<p class="textCount_pwcheck blind">0자</p>
								<p class="toastText_max">글자수를 초과하였습니다.</p>
							</div>
							<!--toastWrap end-->
							<p class="toastText_checkYes blind">비밀번호가 일치합니다.</p>
							<p class="toastText_checkNo blind">비밀번호가 일치하지 않습니다.</p>
							<p class="toastText_min2 hide">최소 8글자 이상으로 입력해주세요</p>
				</div>
				<!--pw_check_div end-->
			</div>
			<!--pwWrap end-->

			<div id="name_div">
				<div id="name_la">
					<label><span class="noChange">*</span> 이름</label>
				</div>
				<input type="text" placeholder="이름을 입력해주세요. (최대 10자)" id="name"
					name="name" value="" />
				<div id="toastWrap_name" class="hide">
					<p class="textCount_name blind">0자</p>
					<p class="toastText">글자수를 초과하였습니다.</p>
				</div>
				<!--toastWrap end-->
			</div>
			<!--name_div end-->

			<div id="nickname_div">
				<div id="nickname_la">
					<label>닉네임</label>
				</div>
				<input type="text" placeholder="닉네임을 입력해주세요. (최대 10자)" id="nickname"
					name="nickname" value="" /> <input type="button"
					id="btn_nickCheck" value="중복체크">
				<!-- <span id="result"></span> -->
				<input type="button" id="btn_nickRe" value="재입력" class="blind">
				<p class="toastText_nickCheck blind"></p>
				<div id="toastWrap_nick" class="hide">
					<p class="textCount_nick blind">0자</p>
					<p class="toastText">글자수를 초과하였습니다.</p>
				</div>
				<!--toastWrap end-->
			</div>
			<!--nickname_div end-->

			<div id="emailWrap">
				<div id="email_div">
					<div id="email_la">
						<label>이메일</label>
					</div>
					<input type="text" placeholder="이메일을 입력해주세요. (최대 40자)" id="email"
						name="email" value="" /> <input type="button" id="btn_emCheck"
						value="중복체크">
					<!-- <span id="result"></span>  -->
					<input type="button" id="btn_emRe" value="재입력" class="blind">
					<p class="toastText_emailCheck blind"></p>
					<div id="toastWrap_email" class="hide">
						<p class="textCount_email blind">0자</p>
						<p class="toastText">글자수를 초과하였습니다.</p>
					</div>
					<!--toastWrap end-->
				</div>
				<!--email_div end-->
			</div>
			<!--emailWrap end-->

			<div id="tel_div">
				<div id="tel_la">
					<label>전화번호</label>
				</div>
				<input type="tel" placeholder="전화번호를 입력해주세요. (최대 13자)" id="tel"
					name="tel" value="" />
				<div id="toastWrap_tel" class="hide">
					<p class="textCount_tel blind">0자</p>
					<p class="toastText">글자수를 초과하였습니다.</p>
				</div>
				<!--toastWrap end-->
			</div>
			<!--tel_div end-->


			<div id="birthGenderDiv">
				<div id="birth_div">
					<label><span class="noChange">*</span> 생년월일</label>
					<p>
						<input type="date" id="birth">
					</p>
				</div>

				<div id="gender_div">
					<div id="gender_la">
						<label><span class="noChange">*</span> 성별</label>
					</div>
					<select id="gender">
						<option value="">선택</option>
						<option value="여">여</option>
						<option value="남">남</option>
					</select>
				</div>
			</div>

			<div id="interest_div">
				<div id="interest_la">
					<label>관심사</label>
				</div>
				<select id="interest">
					<option value="" class="interest_opt">선택</option>
				</select>
			</div>

			<div id="tagWrap">
				<input type="button" class="delete_interest interest_result blind">
			</div>

			<div id="city_div">
				<div id="city_la">
					<label>활동 지역</label>
				</div>
				<select id="city" name='city' class="input">
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

			<input type="submit" id="join_btn" value="회원가입" />
			<p class="LastWarning">
				<span class="noChange">*</span> : 가입 후 변경 불가
			</p>
		</div>
			<!--  START HEADER INCLUDE -->
			<jsp:include page="../../views/common/footer.jsp"></jsp:include>
			<!--  END HEADER INCLUDE -->
	</form>
</div>

</body>
</html>