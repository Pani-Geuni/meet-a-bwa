<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/feed.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/meet-detail.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-detail.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-writer.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-update.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-delete.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/vote/vote_common.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/vote/vote_create.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/vote/vote_update.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/vote/vote_view.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>

<!-- DATE PICKER -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/meet-a-bwa/resources/js/common/datePicker_ko.js"></script>

<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>

<script src="/meet-a-bwa/resources/js/meet/meet-detail.js"></script>
<script src="/meet-a-bwa/resources/js/meet/meet-member-list.js"></script>
<script src="/meet-a-bwa/resources/js/meet/delete-popup.js"></script>
<script src="/meet-a-bwa/resources/js/meet/post-write-popup.js"></script>

<script src="/meet-a-bwa/resources/js/meet/comment/comment.js"></script>

<script src="/meet-a-bwa/resources/js/vote/vote_common.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_create.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_update.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_select.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_view.js"></script>

<script>
	$(function() {
		var user_id = '${user_id}'; //????????? ?????????
		
		
		// ????????? ?????? - ?????? ?????? ?????? ?????? (+)
		$("#vote_create_btn").click(function() {
			$(".vote-create-update-wrap").removeClass("blind");
			$("#event-create").removeClass("blind");
		});
		
		$(".btn-meet.join").on("click", function(event) {
			event.stopPropagation();
			
			if ($.cookie("isLogin") != "true") {
				$(".warning-layer").removeClass("blind");
			}
		})
		
		
		$(".heartSection").on("click", function(event) {
			event.stopPropagation();
			
			if($.cookie("isLogin") == "true") {
				// ????????? ??????
				if ($(this).find(".afterLike_heart").hasClass("blind")) {
					location.href = "/meet-a-bwa/meet_like_insert.do?meet_no=" + $(this).attr("idx") + "&user_no=" + $.cookie("user_no");
				} else {
					// ????????? ??????
					location.href = "/meet-a-bwa/meet_like_delete.do?meet_no=" + $(this).attr("idx") + "&user_no=" + $.cookie("user_no");
				}
			} else {
				$(".warning-layer").removeClass("blind");
			}
		})
		
		// ?????? ????????? ??????
	   	 let like_meet_arr = $.cookie('like_meet');
	   	 if(like_meet_arr != undefined){
	  	 	like_meet_arr = like_meet_arr.split("/");
	  	 		
	  	 	for (like_meet of like_meet_arr) {
				if($(".heartSection").attr("idx") == like_meet) {
					$(".heartSection").find(".beforeLike_heart").addClass("blind");
					$(".heartSection").find(".afterLike_heart").removeClass("blind");
				}
	  	 	}
	   	 }
	   	 
	  // ?????? ?????? ?????? ?????? ?????? ?????????
    	 $(".warning-close").click(function(){
    		 $(".warning-layer").addClass("blind");
    	 });

	});
</script>
<title>????????? ?????? ?????????</title>
</head>
<body>

	<!--  START HEADER INCLUDE -->
	<jsp:include page="../../views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>
	<!--  END HEADER INCLUDE -->
	
	<div id="bodyWrap">
		<div id="contentWrapRow">
		<jsp:include page="../../views/common/meetLeftSideBar.jsp"></jsp:include>
		
			
			<section class="post-detail">
          <div class="post-detail-top">
            <h1 class="post-detail-title" id="post-detail-title">
              ${ bvo2.board_title }
            </h1>
            <div class="post-user-info">
              <div class="user-info">
	            <div class="user-info-profile">
	              <img src="/meet-a-bwa/resources/img/loopy.svg" alt="????????? ?????????" />
	            </div>
	            <p class="user-nickname">${ bvo2.user_name }</p>
                <p class="write-date">${ bvo2.board_date }</p>
              </div>
              
              <c:if test="${ bvo2.user_no eq list.user_no }">
	              <div class="post-more-select">
	              	<img class="img-more" src="/meet-a-bwa/resources/img/more.svg" alt="" />
	              		<ul class="post-option-list" idx="${ bvo2.board_no }">
	              			<li class="post-option-item" data-popup-open="update">????????????</li>
	              			<li class="post-option-item" data-popup-open="delete">????????????</li>
						</ul>
				  </div>
			  </c:if>
            </div>
          </div>

          <pre class="post-detail-content">${ bvo2.board_content }</pre>

          <div class="comment-wrap">
            <form action="c_insertOK.do" method="post" class="form-comment">
              <input name="mother_no" type="text" value="${ NULL }" style="display: none" />
              <textarea name="comment_content" placeholder="????????? ???????????????."></textarea>
              <input name="board_no" value="${ bvo2.board_no }" style="display: none" >
              <input name="user_no" value="${ list.user_no }" style="display: none" >
              <button type="submit">??????</button>
            </form>

			<c:forEach var="cvo" items="${ cvos }">
	            <div class="user-comments">
	              <div class="user-comment">
	                <div class="comment-user-info-top">
	               	  <div class="comment-user-info">
	                    <div class="comment-user-info-profile">
	                      <img src="/meet-a-bwa/resources/img/loopy.svg" alt="????????? ?????????" />
	                    </div>
	                    <p class="comment-user-nickname">${ cvo.user_nickname }</p>
	                    <p class="comment-write-date">${ cvo.comment_date }</p>
	                  </div>
	                  <c:if test="${ cvo.user_no eq list.user_no }">
	                  	<button class="btn-comment-delete" idx="${ cvo.comment_no }">??????</button>
	                  </c:if>
	                </div>
	                <pre class="post-detail-comment">${ cvo.comment_content }</pre>
	              </div>
	            </div>
            </c:forEach>
          </div>
        </section>
        
	        <aside class="meet-right-aside">
				<div class="right-summary-list" id="event-summary-list">
					<div class="right-summary-list-top">
						<h1>?????? ??? ????????????</h1>
						<p>
							<a href="#">+</a>
						</p>
					</div>
					<ul class="right-summary-list-contents" id="activity-summary-list">
						<c:if test="${ avos.size() == 0 }">
							<div class="no-contents-item">
								<p>????????? ??????????????? ????????????.</p>
							</div>
						</c:if>
						<c:if test="${ avos.size() > 0 }">
							<c:forEach var="avo" items="${ avos }">
								<li class="activity_list_item" idx="${ avo.activity_no }"><p>${ avo.activity_name }</p></li>
							</c:forEach>
						</c:if>		
					</ul>
				</div>
				<div class="right-summary-list" id="vote-summary-list">
					<div class="right-summary-list-top">
						<h1>??????</h1>
						<p id="vote_create_btn">+</p>
					</div>
					<ul class="right-summary-list-contents">
						<c:if test="${ vvos.size() == 0 }">
							<div class="no-contents-item">
								<p>????????? ????????? ????????????.</p>
							</div>
						</c:if>
						<c:if test="${ vvos.size() > 0 }">
							<c:forEach var="vvo" items="${ vvos }">
								<li class="vote-list-item" idx= "${ vvo.vote_no }"><p>${ vvo.vote_title }<p></li>
							</c:forEach>
						</c:if>
					</ul>
				</div>
			</aside>
		</div>
	</div>
</body>

<!-- ==================================== -->
<!-- ????????? view ?????? -->
<!-- ==================================== -->
<div class="write-popup-layer" data-popup="update">
	<div class="popup-box">
		<div class="popup-top">
        	<h1>?????????</h1>
        </div>
        <div class="popup-writer">
          	<form action="b_insertOK.do" method="post" class="popup-writer">
            	<input name="board_title" type="text" placeholder="??????" />
	            <textarea
	              name="board_content"
	              id="content"
	              placeholder="????????? ???????????????."
	            ></textarea>
	            
	            <input name="meet_no" value="${ bvo2.meet_no }" style="display: none" >
				<input name="user_no" value="${ list.user_no }" style="display: none" >
	            
	            <div class="popup-btn-group">
		         	<button type="button" class="btn-cancel" onclick="writePopupHide()">??????</button>
		          	<button type="submit" class="btn-submit">??????</button>
		        </div>
          	</form>
        </div>
	</div>
</div>

<!-- ==================================== -->
<!-- ??? ???????????? view ?????? -->
<!-- ==================================== -->
<div class="update-popup-layer" data-popup="update">
	<div class="popup-box">
		<div class="popup-top">
        	<h1>??? ??????</h1>
        </div>
        <div class="popup-writer" id="popup-update">
            	<input name="update_title" id="update_title" type="text" placeholder="??????" value="${ bvo2.board_title }"/>
	            <textarea
	              name="update_content"
	              id="update_content"
	              placeholder="????????? ???????????????."
	            >${ bvo2.board_content }</textarea>
	            
	            <div class="popup-btn-group">
		         	<button type="button" class="btn-cancel" data-popup-close="update">??????</button>
		          	<button type="submit" class="btn-submit-update">??????</button>
		        </div>
        </div>
	</div>
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

<!-- *******************  -->
<!-- delete popup SECTION -->
<!-- *******************  -->
  <div class="delete-popup-layer" data-popup="delete">
    <div class="delete-popup-wrap">
      <img src="/meet-a-bwa/resources/img/worry.svg" alt="" />
      <h1>?????? ?????? ???????????????????</h1>

      <div class="btn-group">
        <button id="btn-delete" class="btn-delete" data-popup-close="delete">??????</button>
        <button class="btn-cancel" data-popup-close="delete">??????</button>
      </div>
    </div>
  </div>
  
 <!-- *******************  -->
<!--  ?????? ?????? -->
<!-- *******************  -->

<div id="vote-view-wrap" class="blind">
	<!-- START voteWrap -->
	<div id="voteWrap">
		<div id="divWrap" class="vote_section">
			<div id="header_wrap" class="wrap_common">
				<span id="view-title">?????? ?????? ???????????????.</span> <img
					src="/meet-a-bwa/resources/img/more-vertical.png" alt="????????? ?????? ?????????"
					id="more_vertival" />
				<!-- ????????? ?????? ???, select_custom ?????? ??? blind ??????-->
				<!-- ????????? ?????? ???, select_custom ?????? ??? blind ??????-->
				<div id="dropdown" class="blind">
					<img src="/meet-a-bwa/resources/img/vector.png"
						alt="????????? before ?????????" id="select_img" />
					<ul class="select_list_wrap">
						<li class="select_list" id="update">??????</li>
						<li class="select_list" id="delete">??????</li>
					</ul>
				</div>
			</div>
			<div id="body_wrap" class="wrap_common">
				<!-- START ?????? ????????? -->
				<!-- START ?????? ???????????????, class blind ?????? -->
				<fieldset id="description_field">
					<legend class="field_title">?????? ??????</legend>
					<div id="vote_view_description">
						<p id="text_area">
							2022??? 8??? 28??? ???????????? ??? ?????? ????????? ?????? ???????????????.<br> 2022??? 8??? 28??? ???????????? ???
							?????? ????????? ?????? ???????????????.<br> 2022??? 8??? 28??? ???????????? ??? ?????? ????????? ?????? ???????????????.<br>
							2022??? 8??? 28??? ???????????? ??? ?????? ????????? ?????? ???????????????.
						</p>
					</div>
				</fieldset>
				<!-- END ?????? ????????? -->

				<!-- START ?????? ????????? -->
				<div id="choice_wrap">
					<!-- START choiceList-->
					<div class="choiceList">
						<section class="txt_wrap_section">
							<section class="txt_section">
								<span class="txt">?????? ????????? ??????</span>
								<!-- ??????????????? ???, blind ?????? -->
								<span class="choice_mem_cnt blind"></span>
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
					<!-- START choiceList-->
					<div class="choiceList">
						<section class="txt_wrap_section">
							<section class="txt_section">
								<span class="txt">?????? ????????? ??????</span>
								<!-- ??????????????? ???, blind ?????? -->
								<span class="choice_mem_cnt blind"></span>
							</section>

							<!-- ??????????????? ???, blind ???????????? -->
							<span class="list_percentage_wrap blind"> <!-- ?????? ????????? ???????????? ?????????????????? width??? ????????? ????????? ??????-->
								<span class="list_percentage"></span>
							</span>
						</section>

						<div class="out_circle">
							<div class="in_circle"></div>
						</div>
					</div>
					<!-- END choiceList -->
				</div>
				<!-- END ?????? ????????? -->
			</div>

			<div id="footer_wrap" class="wrap_common">
				<section id="footer_info">
					<span class="info_common">????????? ?????????</span> <span class="info_common"
						id="end_date">????????????:2022-09-01 ??????10:00</span>
				</section>

				<section class="btn_section blind">
					<input type="button" id="voteBtn" class="btnCommon" value="????????????" />
				</section>
				<section class="btn_section">
					<input type="button" id="re_voteBtn" class="btnCommon"
						value="???????????????" />
				</section>
				<section class="btn_section blind">
					<input type="button" id="re_voteBtn" class="btnCommon" value="??????" />
				</section>
			</div>
		</div>

	</div>
	<!-- END voteWrap -->

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
			<input type="button" id="yesBtn" class="confirm_btn_common" value="???" />
			<input type="button" id="noBtn" class="confirm_btn_common"
				value="?????????" />
		</div>
	</div>
</div>



<!-- *******************  -->
<!-- ????????? ?????? / ?????? -->
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
					<div id="pickerWrap">
						<input type="text" id="vote_endDate" class="dateCommon"
							autocomplete="off" placeholder="????????? ??????????????????." readonly>
						<!-- START TIMEPICKER -->
						<div id="timepicker_box" class="dateCommon">
							<section id="timeSection">
								<span id="timeValue">--:--:--</span>
							</section>

							<section id="timeImgSection">
								<img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
									alt="???????????????" />
							</section>

							<div id="customTimePicker" class="blind">
								<div id="ampm_choice">
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
						<textarea id="vote_description" class="common" placeholder="?????? ??????"></textarea>
						<span id="description_text_length" class="text_length">0/150</span>
					</section>
				</section>

				<section id="voteSection" class="section_common">
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

			<div id="btnWrap">
				<input type="button" id="vote_createBtn" class="btnCommon"
					value="?????? ?????????"> <input type="button" id="vote_cancleBtn"
					class="btnCommon" value="??????">
			</div>
		</div>
		<!-- END ?????? ?????? -->

		<!--  ????????? ????????? ??? SHOW -->
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
						<input type="text" id="vote_title" class="common"
							placeholder="?????? ??????" value=""> <span
							id="title_text_length" class="text_length">0/15</span>
					</section>
				</section>

				<section id="endDateSection" class="section_common">
					<h4 class="section_title">?????? ?????? ??????/?????? ??????</h4>
					<div id="pickerWrap">
						<input type="text" id="vote_endDate" class="dateCommon"
							autocomplete="off" placeholder="????????? ??????????????????." readonly>
						<div id="timepicker_box" class="dateCommon">
							<section id="timeSection">
								<span id="timeValue">--:--:--</span>
							</section>

							<section id="timeImgSection">
								<img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
									alt="???????????????" />
							</section>

							<div id="customTimePicker" class="blind">
								<div id="ampm_choice">
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
					</div>
				</section>

				<section class="section_common">
					<h4 class="section_title">?????? ??????</h4>
					<section>
						<textarea id="vote_description" class="common" placeholder="?????? ??????"></textarea>
						<span id="description_text_length" class="text_length">0/150</span>
					</section>
				</section>

				<section id="voteSection" class="section_common">
					<h4 class="section_title">?????? ??????</h4>

					<div id="vote_list_Wrap">
						<!-- SAMPLE VOTE LIST -->
						<div class="vote_list sample blind">
							<label class="list_title"></label> <input type="text"
								class="list_text" value="" /> <img
								src="/meet-a-bwa/resources/img/close.svg" alt="?????? ?????? ?????????"
								class="removeBtn" />
						</div>
					</div>
				</section>
				<input type="button" id="vote_list_plusBtn" value="?????? ?????? ??????" />

			</div>
			<!-- END sectionWrap -->

			<div id="btnWrap">
				<input type="button" id="vote_updateBtn" class="btnCommon"
					value="?????? ??????">
			</div>
		</div>
		<!-- END ?????? ?????? -->
	</div>
	<!-- END vote_popup -->

</div>
<!-- END voteWrap -->


<!-- START toastWrap -->
<!-- ????????? ???, hide ????????? fade-in ????????? ??????-->
<div id="toastWrap" class="hide">
	<span id="toast_txt"></span>
</div>

<!-- START WARNING POPUP -->
 <div class="warning-layer blind">
  <div class="warning-popup-wrap">
  	<div class = "warning-img-section">
         <img src="resources/img/warning.svg" alt="?????? ?????????"/>
  	</div>
     <h1 id = "warning-text">
      	????????? ??? ??????????????? ???????????????.
     </h1>

     <div class="btn-group">
       <button class="warning-close">??????</button>
     </div>
	  </div>
 </div>
        <!-- END WARNING POPUP -->
</html>