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
			console.log("?????? ??????");
		} else {
			console.log("?????? ?????????");

			//let arr_result = [id, pw,pw_check, name, nicknam,email, tel, birth, gender];
			
			if (id <= 0 || pw<=0 ||pw_check <= 0 || name <= 0 || u_nickname <= 0
					|| email <= 0 || tel <= 0 || birth <= 0 || gender <= 0) {
			//for(let i=0; i<arr_result.length(); i++){
				//$(".bin_obj").text([i].val()+"??? ???????????????!");
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

<title>???:??????</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp"></jsp:include>
	<!--  END HEADER INCLUDE -->
	<div id="bodyWrap">
		<form action="/meet-a-bwa/u_insertOK.do" method="post"
			enctype="multipart/form-data" onsubmit="return check();">
			<div class="joinWrap">
				<h2 id="joinTitle">?????? ??????</h2>

				<p>
					<span class="noChange">*</span> : ?????? ??? ?????? ??????
				</p>
				<hr class="StartLine">
				<div id="img_la">
					<label for="img_header">????????? ??????</label>
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
							<!-- <input type="image" src="../img/imageDropBtn2.svg" id="delete-file1" value="??????"> -->

							<label class="input-file-btn" for="input-file"> <img
								src="/meet-a-bwa/resources//img/imageAddBtn2.svg" width=50px;
								height=50px;>
							</label> <input type="file" name="upFile" id="input-file"
								class="input-file">

							<button type="button" id="delete-file1" value="??????">
								<img src="/meet-a-bwa/resources/img/imageDropBtn2.svg"
									width=50px; height=50px; alt="??????">
							</button>

						</div>
					</section>
				</div>
				<div id="id_div">
					<div id="user_id_la">
						<label><span class="noChange">*</span> ?????????</label>
					</div>
					<input type="text" placeholder="???????????? ??????????????????. (?????? 10???)" id="user_id"
						name="id" value="" /> <input type="button" id="btn_idCheck"
						value="????????????"> <input type="button" id="btn_idRe"
						value="?????????" class="blind">
					<p class="toastText_idCheck blind"></p>

					<div id="toastWrap_id" class="hide">
						<p class="textCount_id blind">0???</p>
						<p class="toastText">???????????? ?????????????????????.</p>
					</div>
					<!-- <p class="toastText">???????????? ?????????????????????.</p> -->
				</div>

				<div id="pwWrap">
					<div id="pw_div">
						<div id="user_pw_la">
							<label>????????????</label>
						</div>
						<input type="password"
							placeholder="??????????????? ??????????????????. (?????? 8??? ~ ?????? 15???)" id="user_pw" name="pw"
							value="" />
						<div id="toastWrap_pw" class="hide">
							<p class="textCount_pw blind">0???</p>
							<p class="toastText_max">???????????? ?????????????????????.</p>
						</div>
						<!--toastWrap end-->
						<p class="toastText_min1 hide">?????? 8?????? ???????????? ??????????????????</p>
					</div>
					<!--pw_div end-->

					<div id="pw_check_div">
						<div id="pw_check_la">
							<label>???????????? ?????????</label>
						</div>
						<section class="pw_check_toastWrap">
							<section id="toastOutWrap">
								<input type="password" placeholder="??????????????? ?????? ??????????????????."
									id="pw_check" name="pw_check" value="" />
								<div id="toastWrap_pwcheck" class="hide">
									<!-- ?????? ?????? ????????? -->
									<p class="textCount_pwcheck blind">0???</p>
									<p class="toastText_max">???????????? ?????????????????????.</p>
								</div>
								<!--toastWrap end-->
								<p class="toastText_checkYes blind">??????????????? ???????????????.</p>
								<p class="toastText_checkNo blind">??????????????? ???????????? ????????????.</p>
								<p class="toastText_min2 hide">?????? 8?????? ???????????? ??????????????????</p>
								</section>
								</section>
					</div>
					<!--pw_check_div end-->
				</div>
				<!--pwWrap end-->

				<div id="name_div">
					<div id="name_la">
						<label><span class="noChange">*</span> ??????</label>
					</div>
					<input type="text" placeholder="????????? ??????????????????. (?????? 10???)" id="name"
						name="name" value="" />
					<div id="toastWrap_name" class="hide">
						<p class="textCount_name blind">0???</p>
						<p class="toastText">???????????? ?????????????????????.</p>
					</div>
					<!--toastWrap end-->
				</div>
				<!--name_div end-->

				<div id="nickname_div">
					<div id="nickname_la">
						<label>?????????</label>
					</div>
					<input type="text" placeholder="???????????? ??????????????????. (?????? 10???)"
						id="u_nickname" name="u_nickname" value="" /> <input type="button"
						id="btn_nickCheck" value="????????????">
					<!-- <span id="result"></span> -->
					<input type="button" id="btn_nickRe" value="?????????" class="blind">
					<p class="toastText_nickCheck blind"></p>
					<div id="toastWrap_nick" class="hide">
						<p class="textCount_nick blind">0???</p>
						<p class="toastText">???????????? ?????????????????????.</p>
					</div>
					<!--toastWrap end-->
				</div>
				<!--nickname_div end-->

				<div id="emailWrap">
					<div id="email_div">
						<div id="email_la">
							<label>?????????</label>
						</div>
						<input type="text" placeholder="???????????? ??????????????????. (?????? 40???)" id="email"
							name="email" value="" /> <input type="button" id="btn_emCheck"
							value="????????????">
						<!-- <span id="result"></span>  -->
						<input type="button" id="btn_emRe" value="?????????" class="blind">
						<p class="toastText_emailCheck blind"></p>
						<div id="toastWrap_email" class="hide">
							<p class="textCount_email blind">0???</p>
							<p class="toastText">???????????? ?????????????????????.</p>
						</div>
						<!--toastWrap end-->
					</div>
					<!--email_div end-->
				</div>
				<!--emailWrap end-->

				<div id="tel_div">
					<div id="tel_la">
						<label>????????????</label>
					</div>
					<input type="tel" placeholder="??????????????? ??????????????????. (?????? 13???)" id="tel"
						name="tel" value="" />
					<div id="toastWrap_tel" class="hide">
						<p class="textCount_tel blind">0???</p>
						<p class="toastText">???????????? ?????????????????????.</p>
					</div>
					<!--toastWrap end-->
				</div>
				<!--tel_div end-->


				<div id="birthGenderDiv">
					<div id="birth_div">
						<label><span class="noChange">*</span> ????????????</label>
						<p>
							<input type="date" id="birth" name="birth">
						</p>
					</div>

					<div id="gender_div">
						<div id="gender_la">
							<label><span class="noChange">*</span> ??????</label>
						</div>
						<select id="gender" name="gender">
							<option value="">??????</option>
							<option value="???">???</option>
							<option value="???">???</option>
						</select>
					</div>
				</div>

				<div id="interest_div">
					<div id="interest_la">
						<label>?????????</label>
					</div>
					<select id="interest" name="interest">
						<option value="" class="interest_opt">??????</option>
					</select>
				</div>

				<div id="tagWrap">
					<input type="button" class="delete_interest interest_result blind">
				</div>

				<div id="city_div">
					<div id="city_la">
						<label>?????? ??????</label>
					</div>
					<select id="city" name='city' class="input">
						<option class="city_list" value=''>???/??? ??????</option>
						<option class="city_list" value='??????'>??????</option>
					</select> <select name='country' id="country" class=select>
						<option class="country_option" value=''>???/??? ??????</option>
						<option class="country_option" value='??????'>??????</option>
					</select>
				</div>

				<input type="submit" id="join_btn" value="????????????" />
				<p class="LastWarning">
					<span class="noChange">*</span> : ?????? ??? ?????? ??????
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
				<label for="id">?????????</label> <input type="text" id="idInput"
					name="id" placeholder="????????? ??????" /> <label for="pw">????????????</label> <input
					type="password" id="pwInput" name="pw" placeholder="???????????? ??????" /> <input
					type="submit" onsubmit="check_length();" value="?????????"> <input
					type="button" value="?????????" id="login-popup-closeBtn">
			</form>

			<div class="login-bottom">
				<div>
					<a href="">ID ??????</a>
				</div>
				<div>
					<a href="">PW ??????</a>
				</div>
				<div>
					<a href="/meet-a-bwa/u_insert.do">????????????</a>
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
			?????? ???????????? <br /> ???????????????????
		</h1>

		<div class="btn-group">
			<a href="/meet-a-bwa/logoutOK.do">
				<button class="btn-logout">????????????</button>
			</a>
			<button class="btn-cancel">??????</button>
		</div>
	</div>
</div>
<!-- END LOGOUT POPUP -->
	<!-- ?????? -->
	<!-- not null -->
	<section class="bin-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p class="bin_obj">??? ????????? ???????????????!</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content2">
							<button class="ok">??????</button>
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
	<!-- ???????????? ?????? -->
	<section class="pwd-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p>??????????????? ??????????????????!</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content2">
							<button class="ok">??????</button>
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
	<!-- ???????????? -->
	<section class="id-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p>????????? ??????????????? ??????????????????!</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content2">
							<button class="ok">??????</button>
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
	<!-- ????????? ?????? -->
	<section class="nickname-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p>????????? ??????????????? ??????????????????!</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content2">
							<button class="ok">??????</button>
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
	<!-- ????????? ?????? -->
	<section class="email-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner">
						<section class="modal-content1">
							<p>????????? ??????????????? ??????????????????!</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content2">
							<button class="ok">??????</button>
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
	<!-- ????????? ?????? ?????? -->
	<section class="image-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content-inner2">
						<section class="modal-content1">
							<p class="font">???????????? ?????????</p>
							<p class="font">10KB ????????? ?????? ??????</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content3">
							<button class="ok">??????</button>
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