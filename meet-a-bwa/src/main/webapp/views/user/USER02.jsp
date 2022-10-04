<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

<!--  <meta charset="UTF-8">-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

 <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/searchBar.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css"/>
    
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css"/>

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/user/withdrawal-popup.css" />

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/user/bin-popup.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/join.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
<script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
<script src="/meet-a-bwa/resources/js/common/login.js"></script>
<script src="/meet-a-bwa/resources/js/common/logout.js"></script>
<script src="/meet-a-bwa/resources/js/user/join/join.js"></script>
<script>
	function check() {
		//			$("#join_btn").click(function(){
		/* let id = $("#id").val().trim().length;
		let pw = $("#pw").val().trim().length;
		let pw_check = $("#pw_check").val().trim().length;
		let name = $("#user_name").val().trim().length;
		let nickname = $("#nickname").val().trim().length;
		let email = $("#email").val().trim().length;
		let tel = $("#tel").val().trim().length;
		let bitrh = $("#birth").val().length;
		let gender = $("#gender").val().length; */
		
		let id = $.trim($("#user_id").val()).length;
		let pw = $("#user_pw").val().length;
		let pw_check = $("#pw_check").val().length;
		let name = $.trim($("#name").val()).length;
		let nickname = $.trim($("#u_nickname").val()).length;
		let email = $.trim($("#email").val()).length;
		let tel = $.trim($("#tel").val()).length;
		let birth = $.trim($("#birth").val()).length;
		let gender = $.trim($("#gender").val()).length;

		console.log(id);
		console.log(pw);
		console.log(pw_check);
		console.log(name);
		console.log(u_nickname);
		console.log(email);
		console.log(tel);
		console.log(birth);
		console.log(gender);

		if (id > 0 && pw > 0 && pw_check > 0 && name > 0 && u_nickname > 0
				&& email > 0 && tel > 0 && bitrh > 0 && gender > 0 && pw > 7
				&& ($("#user_pw").val() === $("#pw_check").val())
				&& $("#user_id").attr("readonly") && $("#u_nickname").attr("readonly")
				&& $("#email").attr("readonly")) {

			let user_id = $("#user_id").val();
			console.log("가입 가능");
		} else {
			console.log("가입 불가능");

			//let arr_result = [id, pw,pw_check, name, nicknam,email, tel, birth, gender];
			
			if (id <= 0 || pw<=0 ||pw_check <= 0 || name <= 0 || u_nickname <= 0
					|| email <= 0 || tel <= 0 || birth <= 0 || gender <= 0) {
			//for(let i=0; i<arr_result.length(); i++){
				//$(".bin_obj").text([i].val()+"를 채워주세요!");
				$(".bin-popup").removeClass("blind");
				$(".ok").on("click", function(){
				  	$(".bin-popup").addClass("blind");
				  });
				//}//for
			} else if (pw < 7 || pw_check<7 || ($("#user_pw").val() !== $("#pw_check").val())) {
				$(".pwd-popup").removeClass("blind");
				$(".ok").on("click", function(){
				  	$(".pwd-popup").addClass("blind");
				  });
			} else if (!$("#user_id").attr("readonly")) {
				$(".id-popup").removeClass("blind");
				$(".ok").on("click", function(){
				  	$(".id-popup").addClass("blind");
				  });
			} else if (!$("#u_nickname").attr("readonly")) {
				$(".nickname-popup").removeClass("blind");
				$(".ok").on("click", function(){
				  	$(".nickname-popup").addClass("blind");
				  });
			} else if (!$("#email").attr("readonly")) {
				$(".email-popup").removeClass("blind");
				$(".ok").on("click", function(){
				  	$(".email-popup").addClass("blind");
				  });
			}
			return false;
		}

		//		    });
	}
</script>
<script src="/meet-a-bwa/resources/js/user/join/textCondition.js"></script>
<script src="/meet-a-bwa/resources/js/user/idCheck.js"></script>
<script src="/meet-a-bwa/resources/js/user/join/nickCheck.js"></script>
<script src="/meet-a-bwa/resources/js/user/join/emailCheck.js"></script>
<script src="/meet-a-bwa/resources/js/user/join/region.js"></script>
<script src="/meet-a-bwa/resources/js/user/join/interest.js"></script>
<script src="/meet-a-bwa/resources/js/user/profileImage.js"></script>

<title>밋:어봐</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp"></jsp:include>
	<!--  END HEADER INCLUDE -->
	<div id="bodyWrap">
		<form action="/meet-a-bwa/u_insertOK.do" method="post"
			enctype="multipart/form-data" onsubmit="return check();">
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
							src="/meet-a-bwa/resources/img/placeholder1.webp" width=150px;
							height=150px; id="image" />
						</label>
						<div class="img_btn">

							<!-- input type="image" src="../img/imageAddBtn2.svg" class="input-file-btn" for="input-file">
					<input type="file" name="upFile" id="input-file" class="input-file">< -->
							<!-- <input type="image" src="../img/imageDropBtn2.svg" id="delete-file1" value="삭제"> -->

							<label class="input-file-btn" for="input-file"> <img
								src="/meet-a-bwa/resources//img/imageAddBtn2.svg" width=50px;
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
					<div id="user_id_la">
						<label><span class="noChange">*</span> 아이디</label>
					</div>
					<input type="text" placeholder="아이디를 입력해주세요. (최대 10자)" id="user_id"
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
						<div id="user_pw_la">
							<label>비밀번호</label>
						</div>
						<input type="password"
							placeholder="비밀번호를 입력해주세요. (최소 8자 ~ 최대 15자)" id="user_pw" name="pw"
							value="" />
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
					<input type="text" placeholder="닉네임을 입력해주세요. (최대 10자)"
						id="u_nickname" name="u_nickname" value="" /> <input type="button"
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
							<input type="date" id="birth" name="birth">
						</p>
					</div>

					<div id="gender_div">
						<div id="gender_la">
							<label><span class="noChange">*</span> 성별</label>
						</div>
						<select id="gender" name="gender">
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
					<select id="interest" name="interest">
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
						<option class="city_list" value=''>도/시 선택</option>
						<option class="city_list" value='전체'>전체</option>
					</select> <select name='country' id="country" class=select>
						<option class="country_option" value=''>군/구 선택</option>
						<option class="country_option" value='전체'>전체</option>
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