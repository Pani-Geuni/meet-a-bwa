<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

 <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/searchBar.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css"/>
    
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css"/>

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/user/edit-info.css" />

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/user/withdrawal-popup.css" />

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/user/bin-popup.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
<script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/login.js"></script>
<script src="/meet-a-bwa/resources/js/common/logout.js"></script>

<!-- <script src="/meet-a-bwa/resources/js/user/edit_info/edit_info.js"></script> -->
<script src="/meet-a-bwa/resources/js/user/edit_info/textCondition.js"></script>
<script src="/meet-a-bwa/resources/js/user/idCheck.js"></script>
<script src="/meet-a-bwa/resources/js/user/edit_info/nickCheck.js"></script>
<script src="/meet-a-bwa/resources/js/user/edit_info/emailCheck.js"></script>
<script src="/meet-a-bwa/resources/js/user/edit_info/region.js"></script>
<script src="/meet-a-bwa/resources/js/user/edit_info/interest.js"></script>
<script src="/meet-a-bwa/resources/js/user/profileImage.js"></script>
<script>
	//성별 출력
	$(function() {
		
		var user_id = '${user_id}'; //세션값 가져옴
		console.log(user_id);

		$("#gender").on("change", function() {
			console.log($(this).val());
		});

		$("#membership_withdrawal_btn").on("click", function() {
			$(".withdrawal-popup").removeClass("blind");
			$(".withdrawalOK").click(function() {
				$(".withdrawal-popup").addClass("blind");
					
					// $.cookie("user_no");
					
					location.replace("u_delete.do?user_no=" + $.cookie("user_no"));
				});
			});
			$(".cancle").click(function() {
				$(".withdrawal-popup").addClass("blind");
			});
		

	});
	
	
	function check() {

		console.log($("#id").val());
		
		let pw = $.trim($("#pw").val()).length;
		let pw_check = $.trim($("#pw_check").val()).length;
		let u_nickname = $.trim($("#u_nickname").val()).length;
		let email = $.trim($("#email").val()).length;
		let tel = $.trim($("#tel").val()).length;

		console.log(pw_check);
		console.log(nickname);
		console.log(email);
		console.log(tel);

		//if 절에 이미지 사이즈 용량 초과 조건 넣기
		if (pw_check > 0 && nickname > 0 && email > 0 && tel > 0
				&& ($("#pw").val() === $("#pw_check").val())
				&& $("#nickname").attr("readonly")
				&& $("#email").attr("readonly")) {
			console.log("가입 가능");
		} else {
			console.log("가입 불가능");
			if (pw <= 0 || pw_check <= 0 || nickname <= 0 || email <= 0
					|| tel <= 0) {
				$(".bin-popup").removeClass("blind");
				$(".ok").on("click", function() {
					$(".bin-popup").addClass("blind");
				});
			} else if (pw < 7 || pw_check < 7
					|| ($("#pw").val() !== $("#pw_check").val())) {
				$(".pwd-popup").removeClass("blind");
				$(".ok").on("click", function() {
					$(".pwd-popup").addClass("blind");
				});
			} else if ($("#nickname").attr("readonly", false)) {
				$(".nickname-popup").removeClass("blind");
				$(".ok").on("click", function() {
					$(".nickname-popup").addClass("blind");
				});
			} else if ($("#email").attr("readonly", false)) {
				$(".email-popup").removeClass("blind");
				$(".ok").on("click", function() {
					$(".email-popup").addClass("blind");
				});
			}
			return false;
		}

	}
</script>
<title>밋:어봐</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp"></jsp:include>
	<!--  END HEADER INCLUDE -->
	<div id="bodyWrap">
		<form action="/meet-a-bwa/u_updateOK.do" method="post"
			enctype="multipart/form-data" onsubmit="return check();">

			<div class="OuterWrap">
				<section class="blind">
					<label for="user_no">user_no:</label>${uvo2.user_no}<input
						id="user_no" name="user_no" value="${uvo2.user_no}">
				</section>
				<h2 id="editperinfoTitle">개인정보수정</h2>
				<p>
					<span class="noChange">*</span> : 수정 불가 항목
				</p>
				<hr class="StartLine">
				<div id="img_la">
					<label for="img_header">프로필 사진</label>
				</div>
				<div id="imgWrap">
					<section class="img_body">
						<label id="input-image" for="input-file"> <img
							src="${uvo2.user_image}" width=150px; height=150px; id="image" name="image"/>
						</label>
						<div class="img_btn">

							<label class="input-file-btn" for="input-file"> <img
								src="/meet-a-bwa/resources/img/imageAddBtn2.svg" width=50px;
								height=50px;>
							</label> <input type="file" name="upFile" id="input-file"
								class="input-file">

							<button type="button" id="delete-file1" value="삭제">
								<img src="/meet-a-bwa/resources/img/imageDropBtn2.svg"
									width=50px; height=50px; alt="삭제">
							</button>
						</div>
					</section>
				</div>

				<div id="id_div">
					<div id="id_la">
						<label><span class="noChange">*</span> 아이디</label>
					</div>
					<input type="text" placeholder="아이디를 입력해주세요 (최대 15자)" id="id" name="id"
						value="${uvo2.user_id}" readonly />
				</div>

				<div id="pwWrap">
					<div id="pw_div">
						<div id="pw_la">
							<label>비밀번호</label>
						</div>
						<input type="password"
							placeholder="비밀번호를 입력해주세요. (최소 8자 ~ 최대 15자)" id="pw" name="pw"
							value="${uvo2.user_pw}" />
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
							</section>
						</section>
					</div>
					<!--pw_check_div end-->
				</div>
				<!--pwWrap end-->

				<div id="name_div">
					<div id="name_la">
						<label><span class="noChange">*</span> 이름</label>
					</div>
					<input type="text" placeholder="이름을 입력해주세요. (최대 10자)" id="name"
						name="name" value="${uvo2.user_name}" readonly />
				</div>
				<!--name_div end-->

				<div id="nickname_div">
					<div id="nickname_la">
						<label>닉네임</label>
					</div>
					<input type="text" placeholder="닉네임을 입력해주세요. (최대 10자)"
						id="u_nickname" name="u_nickname" value="${uvo2.user_nickname}" />
					<p class="blind" id="origin_nickname">${uvo2.user_nickname}</p>
					<input type="button" id="btn_nickCheck" value="중복체크">
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
							name="email" value="${uvo2.user_email}" />
						<p class="blind" id="origin_email">${uvo2.user_email}</p>
						<input type="button" id="btn_emCheck" value="중복체크">
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
						name="tel" value="${uvo2.user_tel}" />
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
							<input type="text" id="birth" name="birth"
						value="${uvo2.user_birth}" readonly />
						</p>
					</div>

					<div id="gender_div">
						<div id="gender_la">
							<label><span class="noChange">*</span> 성별</label>
						</div>
						<input type="text" id="gender" name="gender"
						value="${uvo2.user_gender}" readonly />
					</div>
				</div>

				<div id="interest_div">
					<div id="interest_la">
						<label>관심사</label>
					</div>
					<select id="interest" name="interest" value="${uvo2.user_interest}">
						<option class="interest_opt" value="${uvo2.user_interest}">${uvo2.user_interest}</option>
						<option value="" class="interest_opt">선택</option>
					</select>
				</div>

				<div id="tagWrap">
					<input type="button" class="delete_interest interest_result blind" >
					<input type="button"
						class="delete_interest interest_result uvo2_interest"
						value="${uvo2.user_interest} X">
				</div>

				<div id="city_div">
					<div id="city_la">
						<label>활동 지역</label>
					</div>
					<select id="city" name='city' class="input" value="${uvo2.user_city}">
						<option class="city_list" value='${uvo2.user_city}'>${uvo2.user_city}</option>
						<option class="city_list" value=''>도/시 선택</option>
						<option class="city_list" value='전체'>전체</option>
					</select> <select name='country' id="country" class=select  value="${uvo2.user_county}">
						<option class="country_option" value='${uvo2.user_county}'>${uvo2.user_county}</option>
						<option class="country_option" value='전체'>전체</option>
					</select>
				</div>

				<section class="blind" >
					<label for="user_state">user_state:</label><input id="user_state"
						name="user_state" value="${uvo2.user_state}">
				</section>

				<div class="btnWrap">
					<input type="submit" id="edit_member_information_btn"
						value="회원정보수정" /> <input type="button"
						id="membership_withdrawal_btn" value="회원탈퇴" />
				</div>

			</div>
			<!--  START HEADER INCLUDE -->
			<jsp:include page="../../views/common/footer.jsp"></jsp:include>
			<!--  END HEADER INCLUDE -->
		</form>
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
	<!-- 팝업 -->
	<!-- 탈퇴 재확인 -->
	<section class="withdrawal-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p>정말 탈퇴하시겠습니까?</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content2">
							<button class="withdrawalOK">확인</button>
							<button class="cancle">취소</button>
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
	<!-- not null -->
	<section class="bin-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p>빈 항목을 채워주세요!</p>
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
	<!-- 비밀번호 확인 -->
	<section class="pwd-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p>비밀번호를 확인해주세요!</p>
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
	<!-- 중복확인 -->
	<section class="id-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p>아이디 중복체크를 완료해주세요!</p>
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
	<!-- 닉네임 확인 -->
	<section class="nickname-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p>닉네임 중복체크를 완료해주세요!</p>
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
	<!-- 이메일 확인 -->
	<section class="email-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p>이메일 중복체크를 완료해주세요!</p>
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