<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/common.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/header.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/common/footer.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/toast.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/vote/vote_common.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/vote/vote_create.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/vote/vote_update.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/vote/vote_view.css" />

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/event/event_common.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/event/event_create.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/event/event_update.css" />
<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/event/event_view.css" />

<link rel="stylesheet"
	href="/meet-a-bwa/resources/css/activity/feed.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>

<!-- DATE PICKER -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/meet-a-bwa/resources/js/common/datePicker_ko.js"></script>

<script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
<script src="/meet-a-bwa/resources/js/common/login.js"></script>
<script src="/meet-a-bwa/resources/js/common/logout.js"></script>
<script src="/meet-a-bwa/resources/js/activity/feed.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_select_a.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_create_a.js"></script>

<script src="/meet-a-bwa/resources/js/event/event_create.js"></script>
<script src="/meet-a-bwa/resources/js/event/event_view.js"></script>

<script>
   $(function() {
      
      $(".likeWrap").on("click", ".heartSection", function(event){
          event.stopPropagation();

          if($.cookie("isLogin") == 'true'){
              // ????????? ??????
              if($(".heartSection").find(".afterLike_heart").hasClass("blind")){
                 location.href = "/meet-a-bwa/activity_like_insert.do?activity_no=" + $(".heartSection").attr("idx") + "&user_no=" + $.cookie("user_no");
              }
              // ????????? ??????
              else{
                 location.href = "/meet-a-bwa/activity_like_delete.do?activity_no=" + $(".heartSection").attr("idx") + "&user_no=" + $.cookie("user_no");
              }
          }else{
             $(".warning-layer").removeClass("blind");
          }
       });
       
 		let like_activity_arr = $.cookie('like_activity');
 		
       if(like_activity_arr != undefined){
          like_activity_arr = like_activity_arr.split("/");
           
           for(like_activity of like_activity_arr){
                 if($(".heartSection").attr("idx") == like_activity) {
                	 $(".heartSection").find(".beforeLike_heart").addClass("blind");
                	 $(".heartSection").find(".afterLike_heart").removeClass("blind");
                 }
           }
        } 
       
		// ?????? ?????? ?????? ?????? ?????? ?????????
		$(".warning-close").click(function(){
	       $(".warning-layer").addClass("blind");
	    });

		let idx = "";
		$(".activityUpdateBtn").click(function() {
			location.href = "/meet-a-bwa/a_update.do?activity_no="+ $("#activity_no").val();
		});
		
		function ajax_load(idx) {
         $.ajax({
            url : "/meet-a-bwa/a_update.do",
            type : "GET",
            data : {
               activity_no : idx
            },

            dataType : "json",
            success : function(res) {
            },
            error : function(res, status, text) {
               console.log(text)
            }
         });
      }

      $(".activityDeleteBtn").click(function() {
         $(".activityDelete-popup").removeClass("blind");
         $(".delete").click(function() {
         	$(".activityDelete-popup").addClass("blind");
            location.href = "/meet-a-bwa/a_delete.do?activity_no="+ $("#activity_no").val();
         });
         $(".cancle").click(function() {
            $(".activityDelete-popup").addClass("blind");
         });
      });
   });
</script>

<title>???????????? ?????? ?????????</title>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>
	<!--  END HEADER INCLUDE -->

	<div id="bodyWrap" class="bodyWrap">
		<div id="contentWrap" class="bodyWrap">
			<div id="innercontentWrap">
				<div id="meetLeftWrap">
					<div class="act-profile-img">
						<img src="${avo2.activity_image}" alt="default ?????????" id="meetImg">
					</div>
					<div class="act-detail-aside-top">
						<h1 class="act-deatil-aside-title">${avo2.activity_name}</h1>
						<div class="likeWrap">
							<section class="heartSection" idx="${avo2.activity_no}">
								<img src="/meet-a-bwa/resources/img/heart-outlined.svg"
									alt='?????????????????????' class="beforeLike_heart heartCommon" /> <img
									src="/meet-a-bwa/resources/img/heart-filled.svg" alt='??????????????????'
									class="afterLike_heart heartCommon blind" />
							</section>
							<span class="likeCnt">${avo2.like_cnt}</span>
						</div>
					</div>
					<div class="act-summary-info">
						<p>
							<span>?????? : </span> <span>${avo2.user_cnt}</span> <span>???</span>
						</p>
						<p>
							<span> ?????? : </span> <span>${avo2.user_nickname}</span>
						</p>
					</div>

					<div class="tagSection">
						<c:if test="${ avo2.activity_city ne null }">
							<div class="loca_tag tag">
								<img src="/meet-a-bwa/resources/img/map.png" class="tag_img">
								<span class="location_name font_size_10">${avo2.activity_city}</span>
							</div>
						</c:if>
						<c:if test="${ avo2.activity_county ne null }">
							<div class="loca_tag tag">
								<img src="/meet-a-bwa/resources/img/map.png" class="tag_img">
								<span class="location_name font_size_10">${avo2.activity_county}</span>
							</div>
						</c:if>
						<c:if test="${ avo2.activity_interest_name ne null }">
							<div class="cate_tag tag">
								<span class="category_name font_size_10">${avo2.activity_interest_name}</span>
							</div>
						</c:if>
						<c:if test="${ avo2.activity_age ne 0 }">
							<div class="age_tag tag">
								<span class="category_name font_size_10">${avo2.activity_age}???</span>
							</div>
						</c:if>
						<c:if test="${ avo2.activity_gender ne null }">
							<div class="gen_tag tag">
								<span class="category_name font_size_10">${avo2.activity_gender}</span>
							</div>
						</c:if>
					</div>


					<!-- ?????? ??? -->
					<!-- ?????????, ????????? -->
					<c:choose>
						<c:when
							test="${(list.isLogin eq false || list.isLogin eq null) || ((not fn:containsIgnoreCase(rvos, list.user_no) && (avo2.user_no ne list.user_no)))}">
							<button type="button" id="join_activity_btn"
								idx="${avo2.activity_no}">
								<a>???????????? ????????????</a>
							</button>
						</c:when>
					</c:choose>

				</div>
				<!--meetLeftWrap end-->

				<div id="innerbodyWrap">
					<section id="intro">
						<section class="blind">
							<label for="activity_no">activity_no:</label>${avo2.activity_no}<input
								id="activity_no" name="activity_no" value="${avo2.activity_no}">
						</section>
						<section id="introHeader">
							<h3 id="introTitle">???????????? ??????</h3>
							<!--???????????? ???????????? ????????? ??????/?????? ??????-->
							<!--user?????? ????????? ?????? ??????-->
							<c:choose>
								<c:when
									test="${(list.isLogin eq true) && (avo2.user_no eq list.user_no)}">
									<input type="image" src="/meet-a-bwa/resources/img/edit.svg"
										class="activityUpdateBtn font_size_10" value="??????">
									<input type="image" src="/meet-a-bwa/resources/img/remove.svg"
										class="activityDeleteBtn font_size_10" value="??????">
								</c:when>

								<c:when
									test="${(list.isLogin eq true) && (fn:containsIgnoreCase(rvos, list.user_no))}">
									<input type="image" src="/meet-a-bwa/resources/img/exit.svg"
										class="activityExitBtn font_size_10" value="??????"
										idx="${avo2.activity_no}">
								</c:when>
							</c:choose>

						</section>
						<hr class="firstLine">
						<section id="innerIntro">
							<section id="IntroInfo">
								<h4 class="introInfo">???????????? ??????</h4>
								<ul class="introInfoUl">
									<li class="openDate">???????????? ????????? : ${avo2.activity_date}</li>
									<li class="nop">?????? ??? : ${avo2.user_cnt}???</li>
								</ul>
							</section>
							<!--introInfo end-->
							<hr class="secondLine">
							<section id="IntroDescription">
								<p class="IntroDescription">${avo2.activity_description}</p>
							</section>
							<!--IntroDescription end-->
							<!-- <hr class="thirdLine"> -->
						</section>
						<!--innerIntro end-->
					</section>
					<!--intro end-->



					<!--///////////////////////////////////////////////?????? ???(?????????, ??????, ???????????? ?????? ???)/////////////////////////////////////////////-->
					<!--///////////////////////////////////////////////?????? ???(?????????, ??????, ???????????? ?????? ???)/////////////////////////////////////////////-->
					<!--///////////////////////////////////////////////?????? ???(?????????, ??????, ???????????? ?????? ???)//////////////////////////////////////////////-->


					<c:choose>
						<c:when
							test="${(list.isLogin eq false || list.isLogin eq null) || (not fn:containsIgnoreCase(rvos, list.user_no))}">
							<div id="pheed_1">
								<p id="defaultPheedText_1">??????????????? ???????????? ??? ?????? ????????? ???????????????!</p>
							</div>
						</c:when>



						<c:when
							test="${(list.isLogin eq true || list.isLogin ne null) && (fn:containsIgnoreCase(rvos, list.user_no))}">
							<section id="pheed" class="pheed">

								<section class="voteApplication">
									<section class="pheedVote">
										<section class="pheedVoteHeader">
											<h4 class="pheedVoteHeaderText">??????</h4>
											<button class="addBtn" id="vote_create_btn">
												<img class="imgBtn" src="/meet-a-bwa/resources/img/add.png"
													alt="">
											</button>
										</section>

										<section class="pheedVoteBody">
											<c:forEach var="vvos" items="${vvos}">
												<section class="blind">
													<label for="activity_no">activity_no:</label><input
														id="activity_no" name="activity_no"
														value="${vvos.activity_no}">
												</section>
												<c:if test="${empty vvos}">
													<p id="VotedefaultPheedText">????????? ????????? ????????????.</p>
												</c:if>
												<c:if test="${vvos ne null}">
													<section>
														<div class="content_list_activity event-list vote_action"
															idx="${vvos.vote_no}">
															<section class="blind">
																<label for="vote_no">vote_no:</label>${vvos.vote_no}<input
																	id="vote_no" name="vote_no" value="${vvos.vote_no}">
															</section>
															<section class="blind">
																<label for="vote_state">vote_state:</label>${vvos.vote_state}<input
																	id="vote_state" name="vote_state"
																	value="${vvos.vote_state}">
															</section>
															<section class="blind">
																<label for="user_no">user_no:</label>${vvos.user_no}<input
																	id="usre_no" name="user_no" value="${vvos.user_no}">
															</section>
															<section class="blind">
																<label for="activity_no">vote_no:</label>${vvos.activity_no}<input
																	id="activity_no" name="activity_no"
																	value="${vvos.activity_no}">
															</section>
															<div class="vote-list-wrap" idx="${vvos.vote_no}">
																<div class="listCommon">
																	<span class="content_title">${vvos.vote_title}</span>
																</div>
																<div class="description_list listCommon">
																	<span class="content_description">
																		${vvos.vote_description}</span>
																</div>
																<div class="meet_info">
																	<div class="meet_member_info">
																		<span class="member_cnt member_ment">${vvos.user_cnt}???</span>
																		<span class="member_ment">?????? ???</span>
																	</div>
																	<img src="/meet-a-bwa/resources/img/smallLine.png"
																		class="smallLine">
																	<div class="period_info">
																		<span class="member_ment">?????? ?????? : </span> <span
																			class="member_ment">${vvos.vote_eod}</span>
																	</div>
																</div>
															</div>
														</div>
													</section>
												</c:if>
											</c:forEach>
										</section>
									</section>


									<section class="pheedEvent">
										<section class="pheedEventHeader">
											<h4 class="pheedEventHeaderText">?????????</h4>
											<button class="addBtn" id="event_create_btn">
												<img class="imgBtn" src="/meet-a-bwa/resources/img/add.png"
													alt="">
											</button>
										</section>

										<section class="pheedEventBody">
											<c:forEach var="evos" items="${evos}">
												<section class="blind">
													<label for="activity_no">activity_no:</label><input
														id="activity_no" name="activity_no"
														value="${evos.activity_no}">
												</section>

												<c:if test="${evos eq null}">
													<p id="EventdefaultPheedText">????????? ???????????? ????????????.</p>
												</c:if>

												<c:if test="${evos ne null}">
													<section>
														<div class="content_list_activity event-list event_action"
															idx="${evos.event_no}">
															<section class="blind">
																<label for="event_no">event_no:</label>${evos.event_no}<input
																	id="event_no" name="event_no" value="${evos.event_no}">
															</section>
															<section class="blind">
																<label for="user_no">user_no:</label>${evos.user_no}<input
																	id="usre_no" name="user_no" value="${evos.user_no}">
															</section>
															<section class="blind">
																<label for="activity_no">event_no:</label>${evos.activity_no}<input
																	id="activity_no" name="activity_no"
																	value="${evos.activity_no}" idx="${evos.event_no}">
															</section>
															<div class="event-list-wrap">
																<div class="listCommon">
																	<span class="content_title">${evos.event_title}</span>
																</div>
																<div class="description_list listCommon">
																	<span class="content_description">
																		${evos.event_description}</span>
																</div>
															</div>
														</div>
													</section>
												</c:if>
											</c:forEach>
										</section>
									</section>
								</section>
							</section>
						</c:when>
					</c:choose>

					<!-- ************************************************************* -->
					<!-- ???????????? ???????????? ?????? ?????? -->
					<section class="blind">
						<label for="user_no">user_no:</label> <input type="text"
							id="user_no" name="user_no" value="${avo2.user_no}">
					</section>
					<section class="blind">
						<label for="meet_no">meet_no:</label> <input type="text"
							id="meet_no" name="meet_no" value="${avo2.meet_no}">
					</section>
					<!-- ************************************************************* -->

				</div>
				<!--innerbodywrap end-->
			</div>
			<!--innercontentWrap end-->
		</div>
		<!--contentWrap end-->

		<!--  START HEADER INCLUDE -->
		<jsp:include page="../../views/common/footer.jsp"></jsp:include>
		<!--  END HEADER INCLUDE -->

	</div>
	<!--bodyWrap end-->

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

	<!-- START WARNING POPUP -->
	<div class="warning-layer blind">
		<div class="warning-popup-wrap">
			<div class="warning-img-section">
				<img src="resources/img/warning.svg" alt="?????? ?????????" />
			</div>
			<h1 id="warning-text">????????? ??? ??????????????? ???????????????.</h1>

			<div class="btn-group">
				<button class="warning-close">??????</button>
			</div>
		</div>
	</div>
	<!-- END WARNING POPUP -->

	<!-- popup -->

	<!-- ???????????? ?????? ????????? -->
	<section class="activityDelete-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content">
						<img src="/meet-a-bwa/resources//img/exitwar.svg"
							class="popupIcon">
					</section>
					<!--modal-content1-->
					<section class="modal-content-inner-delete">
						<section class="modal-content-delete1">
							<p>?????? ??????????????? ?????????????????????????</p>
							<p>????????? ??????????????? ???????????? ??? ????????????.</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content-delete2">
							<button class="delete">???????????? ??????</button>
							<button class="cancle">??????</button>
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

	<!-- ???????????? ?????? ????????? -->
	<section class="activityExit-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content">
						<img src="/meet-a-bwa/resources/img/exitwar.svg" class="popupIcon">
					</section>
					<!--modal-content1-->
					<section class="modal-content-inner-withdrawal">
						<section class="modal-content-withdrawal1">
							<p>?????? ??????????????? ?????????????????????????</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content-withdrawal2">
							<button class="withdrawal">???????????? ??????</button>
							<button class="cancle">??????</button>
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

	<!-- ???????????? ?????? ?????? -->
	<section class="joinSuccess-popup blind">
		<div class="modal-bg">
			<div class="modal-wrap">
				<div class="modal-content-wrap">
					<section class="modal-content">
						<img src="/meet-a-bwa/resources/img/meetApplicationSuccess.svg"
							class="popupIcon">
					</section>
					<!--modal-content1-->
					<section class="modal-content-inner-join">
						<section class="modal-content-join1">
							<p>???????????????!</p>
							<p>??????????????? ?????????????????????.</p>
							<p>????????? ?????? ?????????.</p>
						</section>
						<!--modal-content2-->
						<section class="modal-content-join2">
							<button class="go">??????</button>
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

	<!-- START WARNING POPUP -->
	<div class="warning-layer blind">
		<div class="warning-popup-wrap">
			<div class="warning-img-section">
				<img src="/meet-a-bwa/resources/img/warning.svg" alt="?????? ?????????" />
			</div>
			<h1 id="warning-text">????????? ??? ??????????????? ???????????????.</h1>

			<div class="btn-group">
				<button class="warning-close">??????</button>
			</div>
		</div>
	</div>
	<!-- END WARNING POPUP -->

	<!-- *******************  -->
	<!--  ?????? ?????? -->
	<!-- *******************  -->

	<!-- START voteWrap -->
	<div id="voteWrap" class="vote-view-wrap blind">
		<div id="divWrap" class="vote_section">
			<div id="header_wrap" class="wrap_common">
				<span id="view-title"> <!-- ?????? ?????? ????????? ?????? -->
				</span> <img src="/meet-a-bwa/resources/img/more-vertical.png"
					alt="????????? ?????? ?????????" id="more_vertival" />
				<div id="dropdown" class="select_custom blind">
					<img src="/meet-a-bwa/resources/img/vector.png"
						alt="????????? before ?????????" id="select_img" />
					<ul class="v_select_list_wrap">
						<li class="select_list" id="update">??????</li>
						<li class="select_list" id="delete">??????</li>
						<li class="select_list" id="end">????????????</li>
					</ul>
				</div>
			</div>
			<div id="body_wrap" class="wrap_common">
				<fieldset id="description_field">
					<legend class="field_title">?????? ??????</legend>
					<div id="vote_view_description">
						<p id="text_area">
							<!-- ?????? ?????? ????????? ?????? -->
						</p>
					</div>
				</fieldset>
				<!-- END ?????? ????????? -->

				<!-- START ?????? ????????? -->
				<div id="choice_wrap">
					<!-- START choiceList-->
					<div class="choiceList blind">
						<section class="txt_wrap_section">
							<section class="txt_section">
								<span class="txt">?????? ????????? ??????</span>
								<!-- ??????????????? ???, blind ?????? -->
								<span class="choice_mem_cnt blind">0???</span>
							</section>

							<!-- ??????????????? ???, blind ???????????? -->
							<span class="list_percentage_wrap blind"> <!-- ?????? ????????? ???????????? ?????????????????? width??? ????????? ????????? ??????-->
								<span class="list_percentage"></span>
							</span>
						</section>

						<div class="out_circle">
							<!-- ?????? ??? choice ??????-->
							<!-- ?????? ??? choice ??????-->
							<div class="in_circle"></div>
						</div>
					</div>
					<!-- END choiceList -->
				</div>
				<!-- END ?????? ????????? -->
			</div>

			<div id="footer_wrap" class="wrap_common">
				<section id="footer_info">
					<span class="info_common" id="vote_writer">????????? ?????????</span> <span
						class="info_common" id="end_date">????????????:2022-09-01 ??????10:00</span>
				</section>

				<section class="voteBtn btn_section blind">
					<input type="button" id="voteBtn" class="btnCommon" value="????????????" />
					<input type="button" class="btnCommon vote_closeBtn" value="?????????" />
				</section>
				<section class="reVoteBtn btn_section blind">
					<input type="button" id="re_voteBtn" class="btnCommon"
						value="???????????????" /> <input type="button"
						class="btnCommon vote_closeBtn" value="?????????" />
				</section>
				<section class="view_closeBtn btn_section blind">
					<input type="button" id="view_closeBtn2" class="btnCommon"
						value="??????" />
				</section>
			</div>
		</div>

		<div id="confirmWrap" class="blind">
			<div id="confirm_head">
				<img
					src="/meet-a-bwa/resources/img/fluent_more-horizontal-20-regular.png"
					id="more-horizontal" />
			</div>
			<div id="confirm_txt_wrap">
				<span id="confirm_txt">?????????????????????????</span>
			</div>
			<div id="confirm_btn_wrap">
				<input type="button" id="yesBtn" class="yesBtn confirm_btn_common"
					value="???" /> <input type="button" id="noBtn"
					class="noBtn confirm_btn_common" value="?????????" />
			</div>
		</div>
	</div>
	<!-- END voteWrap -->


	<!-- *******************  -->
	<!-- ?????? ?????? / ?????? -->
	<!-- *******************  -->

	<!-- Start voteWrap -->
	<div id="voteWrap" class="vote-create-update-wrap blind">
		<!-- Start vote_popup -->
		<div id="vote_popup">

			<!-- ????????? ????????? ??? SHOW -->
			<div id="event-create" class="blind">
				<h1 id="title">?????? ??????</h1>

				<!-- Start sectionWrap -->
				<div id='sectionWrap'>
					<section id="titleSection" class="section_common">
						<h4 class="section_title">?????? ??????</h4>
						<section id="title_section">
							<input type="text" id="vote_title" class="common"
								placeholder="?????? ??????"> <span id="title_text_length"
								class="text_length">0/15</span>
						</section>
					</section>

					<section id="endDateSection" class="section_common">
						<h4 class="section_title">?????? ?????? ?????? ??????</h4>
						<div class="pickerWrap">
							<input type="text" id="vote_endDate" class="dateCommon"
								autocomplete="off" placeholder="????????? ??????????????????." readonly>
							<!-- START TIMEPICKER -->
							<div id="timepicker_box" class="timepicker_box dateCommon">
								<section class="timeSection">
									<span id="timeValue">--:--:--</span>
								</section>

								<section class="timeImgSection">
									<img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
										alt="???????????????" />
								</section>

								<div id="customTimePicker" class="customTimePicker blind">
									<div id="ampm_choice" class="ampm_choice">
										<ul id="ampm_listWrap">
											<li class="sample ampm-list"></li>
										</ul>
									</div>
									<div id="time_choice" class="choiceCommon">
										<ul id="time_listWrap">
											<li class="sample time-list"></li>
										</ul>
									</div>
									<div id="minute_choice" class="choiceCommon">
										<ul id="minute_listWrap">
											<li class="sample minute-list"></li>
										</ul>
									</div>
								</div>
							</div>
							<!-- END TIMEPICKER -->
						</div>
					</section>

					<section class="section_common">
						<h4 class="section_title">?????? ??????</h4>
						<section>
							<textarea id="vote_description" class="vote_description common"
								placeholder="?????? ??????"></textarea>
							<span id="description_text_length" class="text_length">0/150</span>
						</section>
					</section>

					<section class="voteSection section_common">
						<h4 class="section_title">?????? ??????</h4>

						<div id="vote_list_Wrap">
							<!-- SAMPLE VOTE LIST -->
							<div class="vote_list sample blind">
								<label class="list_title"></label> <input type="text"
									class="list_text" /> <img
									src="/meet-a-bwa/resources/img/close.svg" alt="?????? ?????? ?????????"
									class="removeBtn" />
							</div>
						</div>
					</section>
					<input type="button" id="vote_list_plusBtn" value="?????? ?????? ??????" />
				</div>
				<!-- END sectionWrap -->

				<div class="btnWrap">
					<input type="button" id="vote_createBtn" class="btnCommon"
						value="?????? ?????????"> <input type="button" id="vote_cancleBtn"
						class="btnCommon" value="??????">
				</div>
			</div>
			<!-- END ?????? ?????? -->

			<!--  ?????? ????????? ??? SHOW -->
			<div id="event-update" class="blind">
				<div id="topSection">
					<h1 id="update-title">?????? ??????</h1>
					<img src="/meet-a-bwa/resources/img/close.svg" alt="close?????????"
						id="closeBtn" />
				</div>

				<!-- Start sectionWrap -->
				<div id='sectionWrap'>
					<section id="titleSection" class="section_common">
						<h4 class="section_title">?????? ??????</h4>
						<section id="title_section">
							<input type="text" id="u_vote_title" class="common"
								placeholder="?????? ??????"> <span id="u_title_text_length"
								class="text_length">0/15</span>
						</section>
					</section>

					<section id="endDateSection" class="endDateSection section_common">
						<h4 class="section_title">?????? ?????? ??????/?????? ??????</h4>
						<div class="pickerWrap">
							<input type="text" id="u_vote_endDate"
								class="vote_endDate dateCommon" autocomplete="off"
								placeholder="????????? ??????????????????." readonly>
							<div id="u_timepicker_box" class="timepicker_box dateCommon">
								<section class="timeSection">
									<span id="u_timeValue">--:--:--</span>
								</section>

								<section class="timeImgSection">
									<img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
										alt="???????????????" />
								</section>

								<div id="u_customTimePicker" class="customTimePicker blind">
									<div id="u_ampm_choice" class="ampm_choice">
										<ul id="u_ampm_listWrap">
											<li class="sample ampm-list"></li>
										</ul>
									</div>
									<div id="u_time_choice" class="choiceCommon">
										<ul id="u_time_listWrap">
											<li class="sample time-list"></li>
										</ul>
									</div>
									<div id="u_minute_choice" class="choiceCommon">
										<ul id="u_minute_listWrap">
											<li class="sample minute-list"></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</section>

					<section class="section_common">
						<h4 class="section_title">?????? ??????</h4>
						<section>
							<textarea id="u_vote_description" class="vote_description common"
								placeholder="?????? ??????"></textarea>
							<span id="u_description_text_length" class="text_length">0/150</span>
						</section>
					</section>

					<section class="voteSection section_common">
						<h4 class="section_title">?????? ?????? (* ?????? ??????)</h4>

						<div id="u_vote_list_Wrap">
							<!-- SAMPLE VOTE LIST -->
							<div class="vote_list sample blind">
								<label class="list_title"></label> <input type="text"
									class="list_text" readonly />
							</div>
						</div>
					</section>

				</div>
				<!-- END sectionWrap -->

				<div class="btnWrap">
					<input type="button" id="vote_updateBtn" class="btnCommon"
						value="?????? ??????">
				</div>
			</div>
			<!-- END ?????? ?????? -->
		</div>
		<!-- END vote_popup -->

	</div>
	<div id="confirmWrap" class="update-confirm-wrap blind">
		<div id="confirm_head">
			<img
				src="/meet-a-bwa/resources/img/fluent_more-horizontal-20-regular.png"
				id="more-horizontal" />
		</div>
		<div id="confirm_txt_wrap">
			<span id="confirm_txt">????????? ???????????? ???????????????????</span>
		</div>
		<div id="confirm_btn_wrap">
			<input type="button" id="end_yesBtn"
				class="yesBtn confirm_btn_common" value="???" /> <input type="button"
				id="end_noBtn" class="noBtn confirm_btn_common" value="?????????" />
		</div>
	</div>
	<!-- END voteWrap -->


	<!-- START toastWrap -->
	<!-- ????????? ???, hide ????????? fade-in ????????? ??????-->
	<div id="toastWrap" class="hide">
		<span id="toast_txt"></span>
	</div>
	<!-- END toastWrap -->



	<!-- ************************************************************ -->
	<!-- ********************     EVENT SECTION     ***************** -->
	<!-- ************************************************************ -->

	<!-- ******************************* EVENT VIEW ******************************* -->
	<!-- START popupWrap-->
	<div id="event-view" class="popupWrap blind">
		<!-- START event_popup-->
		<div id="event_show_popup">
			<!-- Start title_wrap -->
			<div id="title_wrap" class="wrap_common">
				<span id="event-view-title">????????? ?????? ???????????????.</span> <img
					src="/meet-a-bwa/resources/img/more-vertical.png" alt="????????? ?????? ?????????"
					id="event_more_vertival" />
				<div id="event_dropdown" class="select_custom blind">
					<img src="/meet-a-bwa/resources/img/vector.png"
						alt="????????? before ?????????" id="event_select_img" />
					<ul class="select_list_wrap">
						<li class="select_list" id="event_update">??????</li>
						<li class="select_list" id="event_delete">??????</li>
					</ul>
				</div>
			</div>
			<!-- END title_wrap -->

			<!-- Start sectionWrap -->
			<div id="section_wrap" class="wrap_common">
				<!-- START info_section -->
				<section id="info_section" class="sectionCommon">
					<ul id="listWrap">
						<li class="list"><label class="e_list_title">??????</label> <span
							id="event_date" class="list_content">2022??? 08??? 28??? 12???00???</span>
						</li>
					</ul>
				</section>
				<!-- END info_section -->

				<!-- START description_section -->
				<section id="description_section" class="sectionCommon">
					<fieldset id="description_field">
						<legend class="field_title">????????? ??????</legend>
						<div class="field_content">
							<textarea id="event_view_description" readonly></textarea>
						</div>
					</fieldset>
				</section>
				<!-- END description_section -->
			</div>
			<!-- END sectionWrap -->

			<!-- Start bottom_wrap -->
			<div id="bottom_wrap">
				<div id="event_w_intfo">
					<p id="event_w_date">????????? :</p>
					<p id="event_writer">????????? : ?????????</p>
				</div>
				<input type="button" id="event_okBtn" class="btnCommon" value="??????" />
			</div>
			<!-- END bottom_wrap -->
		</div>
		<!-- END event_popup-->
		<div id="event_confirmWrap" class="blind">
			<div id="confirm_head">
				<img
					src="/meet-a-bwa/resources/img/fluent_more-horizontal-20-regular.png"
					alt="more-img" />
			</div>
			<div id="confirm_txt_wrap">
				<span id="confirm_txt">?????????????????????????</span>
			</div>
			<div id="confirm_btn_wrap">
				<input type="button" id="e_yesBtn" class="confirm_btn_common"
					value="???" /> <input type="button" id="e_noBtn"
					class="confirm_btn_common" value="?????????" />
			</div>
		</div>
	</div>
	<!-- END EVENT VIEW WRAP-->




	<!-- ******************************* EVENT CREATE_UPDATE ******************************* -->
	<!-- Start popupWrap -->
	<div id="event_cu-wrap" class="popupWrap blind">
		<!-- Start event_popup -->
		<div id="" class="event_popup">
			<div id="event-create-wrap" class="blind">
				<h1 id="event-create-title">????????? ??????</h1>
				<!-- Start sectionWrap -->
				<div class="sectionWrap">
					<section id="" class="e_titleSection event-section_common">
						<h4 class="section_title">????????? ??????</h4>
						<section>
							<input type="text" id="event_title" class="event_title common"
								placeholder="????????? ??????"> <span id="event_title_text_length"
								class="text_length">0/15</span>
						</section>
					</section>

					<section id="" class="choice_date event-section_common">
						<h4 class="section_title">????????? ??????/?????? ??????</h4>
						<div id="" class="e_pickerWrap">
							<input type="text" id="eventDate" class="eventDate dateCommon"
								autocomplete="off" placeholder="????????? ??????????????????.">

							<!-- START TIMEPICKER -->
							<div id="e_timepicker_box" class="e_timepicker_box dateCommon">
								<section id="" class="timeSection">
									<span id="event_timeValue">--:--:--</span>
								</section>

								<section id="" class="timeImgSection">
									<img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
										alt="???????????????" />
								</section>

								<div id="event-customTimePicker" class="customTimePicker blind">
									<div id="e_ampm_choice" class="ampm_choice">
										<ul id="e_ampm_listWrap">
											<li class="sample ampm-list"></li>
										</ul>
									</div>
									<div id="e_time_choice" class="choiceCommon">
										<ul id="e_time_listWrap">
											<li class="sample time-list"></li>
										</ul>
									</div>
									<div id="e_minute_choice" class="choiceCommon">
										<ul id="e_minute_listWrap">
											<li class="sample minute-list"></li>
										</ul>
									</div>
								</div>
							</div>
							<!-- END TIMEPICKER -->
						</div>
					</section>

					<section class="event-section_common">
						<h4 class="section_title">????????? ??????</h4>
						<section>
							<textarea id="event_description" class="event_description common"
								placeholder="????????? ??????"></textarea>
							<span id="event_description_text_length" class="text_length">0/200</span>
						</section>
					</section>
				</div>
				<div class="btnWrap">
					<input type="button" id="event_createBtn" class="btnCommon"
						value="????????? ??????"> <input type="button" id="event_cancleBtn"
						class="btnCommon" value="??????">
				</div>
			</div>
			<!--  END event-create-wrap -->


			<!--  START event-update-wrap -->
			<div id="event-update-wrap" class="blind">
				<div id="topSection">
					<h1 class="u_title">????????? ??????</h1>
					<img src="/meet-a-bwa/resources/img/close.png" id="e_u_closeBtn"
						alt="????????? ????????? ?????? ?????? ?????????" />
				</div>

				<!-- Start sectionWrap -->
				<div class="sectionWrap">
					<section id="" class="e_titleSection event-section_common">
						<h4 class="section_title">????????? ??????</h4>
						<section id="title_section">
							<input type="text" id="event_u_title" class="event_title common"
								placeholder="????????? ??????"> <span
								id="event_u_title_text_length" class="text_length">0/15</span>
						</section>
					</section>

					<section id="" class="choice_date event-section_common">
						<h4 class="section_title">????????? ??????/?????? ??????</h4>
						<div id="" class="e_pickerWrap">
							<input type="text" id="u_eventDate" class="eventDate dateCommon"
								autocomplete="off" placeholder="????????? ??????????????????.">

							<!-- START TIMEPICKER -->
							<div id="eu_t_box" class="e_timepicker_box dateCommon">
								<section id="" class="timeSection">
									<span id="event_u_timeValue">--:--:--</span>
								</section>

								<section id="" class="timeImgSection">
									<img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
										alt="???????????????" />
								</section>

								<div id="eu_customTimePicker" class="customTimePicker blind">
									<div id="eu_ampm_choice" class="ampm_choice">
										<ul id="eu_ampm_listWrap">
											<li class="sample ampm-list"></li>
										</ul>
									</div>
									<div id="eu_time_choice" class="choiceCommon">
										<ul id="eu_time_listWrap">
											<li class="sample time-list"></li>
										</ul>
									</div>
									<div id="eu_minute_choice" class="choiceCommon">
										<ul id="eu_minute_listWrap">
											<li class="sample minute-list"></li>
										</ul>
									</div>
								</div>
							</div>
							<!-- END TIMEPICKER -->
						</div>
					</section>

					<section class="event-section_common">
						<h4 class="section_title">????????? ??????</h4>
						<section>
							<textarea id="event_u_event_description"
								class="event_description common" placeholder="????????? ??????"></textarea>
							<span id="event_u_description_text_length" class="text_length">0/200</span>
						</section>
					</section>

				</div>
				<!-- END sectionWrap -->

				<div class="btnWrap">
					<input type="button" id="event_updateBtn" class="btnCommon"
						value="????????? ??????">
				</div>
			</div>
			<!--  END event-update-wrap -->
		</div>
		<!-- END event_popup -->
	</div>
	<!-- END popupWrap -->
</body>
</html>