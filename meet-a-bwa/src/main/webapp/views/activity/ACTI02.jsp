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

      $("#recruit_create_btn").click(function() {
         $(".vote-create-update-wrap").removeClass("blind"); // 활동 신청 팝업
         $("#event-create").removeClass("blind");
      });

      let idx = "";
      $(".activityUpdateBtn").click(
            function() {

               console.log("activity update");

               //idx = $(this).attr("idx");

               //location.href = "/meet-a-bwa/a_update.do?activity_no=" + idx;
               location.href = "/meet-a-bwa/a_update.do?activity_no="
                     + $("#activity_no").val();

               //location.href = "ACTI04.jsp?activity_no=" + idx;
               //ajax_load(idx);

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
               console.log("succees")
               console.log(res)
            },

            error : function(res, status, text) {
               console.log("error")
               console.log(text)
            }
         });
      }

      $(".activityDeleteBtn")
            .click(
                  function() {

                     console.log("activity delete");

                     $(".activityDelete-popup").removeClass("blind");
                     $(".delete")
                           .click(
                                 function() {
                                    $(".activityDelete-popup")
                                          .addClass("blind");

                                    //idx = $(this).attr("idx");
                                    location.href = "/meet-a-bwa/a_delete.do?activity_no="
                                          + $("#activity_no")
                                                .val();

                                 });
                     $(".cancle").click(function() {
                        $(".activityDelete-popup").addClass("blind");
                     });
                  });

      $(".activityExitBtn").click(function() {

         $(".activityExit-popup").removeClass("blind");
         $(".withdrawal").click(function() {
            $(".activityExit-popup").addClass("blind");

            //idx = $(this).attr("idx");
            //location.href = "/meet-a-bwa/a_delete.do?activity_no=" + idx;

         });
         $(".cancle").click(function() {
            $(".activityExit-popup").addClass("blind");
         });
      });

      $("#join_activity_btn").click(function() {
         idx = $(this).attr("idx");
         location.href = "/meet-a-bwa/a_registered.do?user_no=" + idx;
      });

      $(".activityExitBtn").click(function() {
         idx = $(this).attr("idx");
         location.href = "/meet-a-bwa/a_withdrawal.do?user_no=" + idx;
      });
      

   });
</script>

<title>액티비티 상세 페이지</title>
</head>
<body>
   <!--  START HEADER INCLUDE -->
   <jsp:include page="/views/common/header.jsp"></jsp:include>
   <!--  END HEADER INCLUDE -->

   <div id="bodyWrap" class="bodyWrap">
      <div id="contentWrap" class="bodyWrap">
         <div id="innercontentWrap">
            <div id="meetLeftWrap">
               <div class="act-profile-img">
                  <img src="${avo2.activity_image}" alt="default 이미지" id="meetImg">
               </div>
               <div class="act-detail-aside-top">
                  <h1 class="act-deatil-aside-title">${avo2.activity_name}</h1>
                  <div class="heart-common">
                     <button class="img-heart-outlined_btn">
                        <img class="img-heart-outlined"
                           src="/meet-a-bwa/resources/img/heart-outlined.svg" alt="">
                     </button>
                     <button class="img-heart-filled_btn blind">
                        <img class="img-heart-filled"
                           src="/meet-a-bwa/resources/img/heart-filled.svg" alt="">
                     </button>
                     <span id="like_cnt">${avo2.like_cnt}</span>
                  </div>
               </div>
               <div class="act-summary-info">
                  <p>
                     <a href="/meet-a-bwa/resources/act-detail-member.html">${avo2.user_cnt}</a>
                  </p>
                  <p>${avo2.user_nickname}</p>
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
                  <c:if test="${ avo2.activity_age ne null }">
                     <div class="age_tag tag">
                        <span class="category_name font_size_10">${avo2.activity_age}대</span>
                     </div>
                  </c:if>
                  <c:if test="${ avo2.activity_gender ne null }">
                     <div class="gen_tag tag">
                        <span class="category_name font_size_10">${avo2.activity_gender}</span>
                     </div>
                  </c:if>
               </div>


               <!-- 가입 전 -->
               <!-- 가입후, 개설자 -->
               <c:choose>
                  <c:when
                     test="${(list.isLogin eq false || list.isLogin eq null) || (not fn:containsIgnoreCase(rvos, list.user_no))}">
                     <button type="button" id="join_activity_btn"
                        idx="${list.user_no}">
                        <a>액티비티 가입하기</a>
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
                     <h3 id="introTitle">액티비티 소개</h3>
                     <!--액티비티 개설자만 보이는 수정/삭제 버튼-->
                     <!--user에게 보이는 탈퇴 버튼-->
                     <c:choose>
                        <c:when
                           test="${(list.isLogin eq true) && (avo2.user_no eq list.user_no)}">
                           <input type="image" src="/meet-a-bwa/resources/img/edit.svg"
                              class="activityUpdateBtn font_size_10" value="수정">
                           <input type="image" src="/meet-a-bwa/resources/img/remove.svg"
                              class="activityDeleteBtn font_size_10" value="삭제">
                        </c:when>

                        <c:when
                           test="${(list.isLogin eq true) && (fn:containsIgnoreCase(rvos, list.user_no))}">
                           <input type="image" src="/meet-a-bwa/resources/img/exit.svg"
                              class="activityExitBtn font_size_10" value="탈퇴"
                              idx="${list.user_no}">
                        </c:when>
                     </c:choose>

                  </section>
                  <hr class="firstLine">
                  <section id="innerIntro">
                     <section id="IntroInfo">
                        <h4 class="introInfo">액티비티 정보</h4>
                        <ul class="introInfoUl">
                           <li class="openDate">액티비티 개설일 : ${avo2.activity_date}</li>
                           <li class="nop">멤버 수 : ${avo2.activity_nop}명</li>
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

               <!--///////////////////////////////////////////////가입 전(이벤트, 투표, 모임신청 없을 때)/////////////////////////////////////////////-->


               <c:choose>
                  <c:when test="${(not fn:containsIgnoreCase(rvos, list.user_no))}">
                     <div id="pheed_1">
                        <p id="defaultPheedText_1">액티비티에 가입해서 더 많은 정보를 찾아보세요!</p>
                     </div>
                  </c:when>
               </c:choose>
               <!--pheed_1 end-->


               <!--///////////////////////////////////////////////가입 후(이벤트, 투표, 모임신청 없을 때)/////////////////////////////////////////////-->
               <!--///////////////////////////////////////////////가입 후(이벤트, 투표, 모임신청 있을 때)//////////////////////////////////////////////-->
               <section id="pheed" class="pheed">
                  <section class="pheedEvent">
                     <section class="pheedEventHeader">
                        <h4 class="pheedEventHeaderText">이벤트</h4>
                        <button class="addBtn" id="event_create_btn">
                           <img class="imgBtn" src="/meet-a-bwa/resources/img/add.png"
                              alt="">
                        </button>
                     </section>
                     <!--pheedEventHeader end-->

                     <section class="pheedEventBody">
                        <c:forEach var="evos" items="${evos}">
                           <section class="blind">
                              <label for="activity_no">activity_no:</label>${evos.activity_no}<input
                                 id="activity_no" name="activity_no"
                                 value="${evos.activity_no}">
                           </section>

                           <c:if test="${evos eq null}">
                                 <p id="EventdefaultPheedText">생성된 이벤트가 없습니다.</p>
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
                     <!--pheedEventBody end-->
                  </section>
                  <!--pheedEvent end-->


                  <section class="voteApplication">
                     <section class="pheedVote">
                        <section class="pheedVoteHeader">
                           <h4 class="pheedVoteHeaderText">투표</h4>
                           <button class="addBtn" id="vote_create_btn">
                              <img class="imgBtn" src="/meet-a-bwa/resources/img/add.png"
                                 alt="">
                           </button>
                        </section>
                        <!--pheedVoteHeader end-->

                        <section  class="pheedVoteBody">
                           <c:forEach var="vvos" items="${vvos}">
                              <section class="blind">
                                 <label for="activity_no">activity_no:</label>${vvos.activity_no}<input
                                    id="activity_no" name="activity_no"
                                    value="${vvos.activity_no}">
                              </section>
                              <c:if test="${empty vvos}">
                              <%-- <c:if test="${vvos eq null}"> --%>
                                    <p id="VotedefaultPheedText">생성된 투표가 없습니다.</p>
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
                                             <span class="member_cnt member_ment">${vvos.user_cnt}명</span>
                                             <span class="member_ment">참여 중</span>
                                          </div>
                                          <img src="/meet-a-bwa/resources/img/smallLine.png"
                                             class="smallLine">
                                          <div class="period_info">
                                             <span class="member_ment">투표 마감 : </span> <span
                                                class="member_ment">${vvos.vote_eod}</span>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                                 </section>
                              </c:if>
                           </c:forEach>
                        </section>
                        <!--pheedVoteBody end -->
                     </section>
                     <!--pheedVote end-->


                     <section class="pheedApplication">
                        <section class="pheedApplicationHeader">
                           <h4 class="pheedApplicationHeaderText">활동 신청</h4>
                           <button class="addBtn" id="recruit_create_btn">
                              <img class="imgBtn" src="/meet-a-bwa/resources/img/add.png"
                                 alt="">
                           </button>
                        </section>
                        <!--pheedApplicationHeader end-->
                        <section>

                           <section class="pheedApplicationBody blind">
                              <p id="AppplictiondefaultPheedText">생성된 활동이 없습니다.</p>
                           </section>
                           <!--pheedApplicationBody end-->

                           <div class="content_list_activity event-list" idx="">
                              <div class="recruit-list-wrap">
                                 <div class="listCommon">
                                    <span class="content_title">11월 12일 모임</span>
                                 </div>
                                 <div class="description_list listCommon">
                                    <span class="content_description"> 2022년 11월 12일의 모임
                                       정보를 확인하세요! </span>
                                 </div>
                                 <div class="meet_info">
                                    <div class="meet_member_info">
                                       <span class="member_cnt member_ment">19명</span> <span
                                          class="member_ment">참여 중</span>
                                    </div>
                                    <img src="/meet-a-bwa/resources/img/smallLine.png"
                                       class="smallLine">
                                    <div class="period_info">
                                       <span class="member_ment">신청 마감 : </span> <span
                                          class="member_ment">2022년 9월 28일</span>
                                    </div>
                                 </div>
                              </div>
                           </div>

                        </section>
                        <!--pheedApplicationBody end-->
                     </section>
                     <!--pheedApplication end-->
                  </section>
                  <!--voteApplication end-->
               </section>
               <!--pheed end-->


               <!-- ************************************************************* -->
               <!-- 액티비티 개설자와 해당 모임 -->
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
   <!-- popup -->

   <!-- 액티비티 삭제 재확인 -->
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
                     <p>정말 액티비티를 삭제하시겠습니까?</p>
                     <p>삭제한 액티비티는 복구하실 수 없습니다.</p>
                  </section>
                  <!--modal-content2-->
                  <section class="modal-content-delete2">
                     <button class="delete">액티비티 삭제</button>
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

   <!-- 액티비티 탈퇴 재확인 -->
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
                     <p>정말 액티비티를 탈퇴하시겠습니까?</p>
                  </section>
                  <!--modal-content2-->
                  <section class="modal-content-withdrawal2">
                     <button class="withdrawal">액티비티 탈퇴</button>
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

   <!-- 액티비티 가입 성공 -->
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
                     <p>축하합니다!</p>
                     <p>액티비티에 가입되었습니다.</p>
                     <p>즐거운 활동 되세요.</p>
                  </section>
                  <!--modal-content2-->
                  <section class="modal-content-join2">
                     <button class="go">확인</button>
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


   <!-- *******************  -->
   <!--  투표 확인 -->
   <!-- *******************  -->

   <!-- START voteWrap -->
   <div id="voteWrap" class="vote-view-wrap blind">
      <div id="divWrap" class="vote_section">
         <div id="header_wrap" class="wrap_common">
            <span id="view-title"> <!-- 투표 제목 텍스트 자리 -->
            </span> <img src="/meet-a-bwa/resources/img/more-vertical.png"
               alt="더보기 세로 이미지" id="more_vertival" />
            <div id="dropdown" class="select_custom blind">
               <img src="/meet-a-bwa/resources/img/vector.png"
                  alt="셀렉트 before 이미지" id="select_img" />
               <ul class="select_list_wrap">
                  <li class="select_list" id="update">수정</li>
                  <li class="select_list" id="delete">삭제</li>
                  <li class="select_list" id="end">투표종료</li>
               </ul>
            </div>
         </div>
         <div id="body_wrap" class="wrap_common">
            <fieldset id="description_field">
               <legend class="field_title">투표 설명</legend>
               <div id="vote_view_description">
                  <p id="text_area">
                     <!-- 투표 설명 텍스트 자리 -->
                  </p>
               </div>
            </fieldset>
            <!-- END 투표 설명란 -->

            <!-- START 투표 선택란 -->
            <div id="choice_wrap">
               <!-- START choiceList-->
               <div class="choiceList blind">
                  <section class="txt_wrap_section">
                     <section class="txt_section">
                        <span class="txt">항목 타이틀 자리</span>
                        <!-- 결과보여줄 때, blind 제거 -->
                        <span class="choice_mem_cnt blind">0명</span>
                     </section>

                     <!-- 결과보여줄 때, blind 제거해서 -->
                     <span class="list_percentage_wrap blind"> <!-- 해당 항목이 선택받은 퍼센테이지를 width로 대입해 보이게 하기-->
                        <span class="list_percentage"></span>
                     </span>
                  </section>

                  <div class="out_circle">
                     <!-- 보일 때 choice 추가-->
                     <!-- 가릴 때 choice 삭제-->
                     <div class="in_circle"></div>
                  </div>
               </div>
               <!-- END choiceList -->
            </div>
            <!-- END 투표 선택란 -->
         </div>

         <div id="footer_wrap" class="wrap_common">
            <section id="footer_info">
               <span class="info_common" id="vote_writer">작성자 정상윤</span> <span
                  class="info_common" id="end_date">투표마감:2022-09-01 오전10:00</span>
            </section>

            <section class="voteBtn btn_section blind">
               <input type="button" id="voteBtn" class="btnCommon" value="투표하기" />
               <input type="button" class="btnCommon vote_closeBtn" value="창닫기" />
            </section>
            <section class="reVoteBtn btn_section blind">
               <input type="button" id="re_voteBtn" class="btnCommon"
                  value="재투표하기" /> <input type="button"
                  class="btnCommon vote_closeBtn" value="창닫기" />
            </section>
            <section class="view_closeBtn btn_section blind">
               <input type="button" id="view_closeBtn2" class="btnCommon"
                  value="닫기" />
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
            <span id="confirm_txt">삭제하시겠습니까?</span>
         </div>
         <div id="confirm_btn_wrap">
            <input type="button" id="yesBtn" class="yesBtn confirm_btn_common"
               value="예" /> <input type="button" id="noBtn"
               class="noBtn confirm_btn_common" value="아니오" />
         </div>
      </div>
   </div>
   <!-- END voteWrap -->


   <!-- *******************  -->
   <!-- 투표 생성 / 수정 -->
   <!-- *******************  -->

   <!-- Start voteWrap -->
   <div id="voteWrap" class="vote-create-update-wrap blind">
      <!-- Start vote_popup -->
      <div id="vote_popup">

         <!-- 이벤트 생성일 때 SHOW -->
         <div id="event-create" class="blind">
            <h1 id="title">투표 생성</h1>

            <!-- Start sectionWrap -->
            <div id='sectionWrap'>
               <section id="titleSection" class="section_common">
                  <h4 class="section_title">투표 제목</h4>
                  <section id="title_section">
                     <input type="text" id="vote_title" class="common"
                        placeholder="투표 제목"> <span id="title_text_length"
                        class="text_length">0/15</span>
                  </section>
               </section>

               <section id="endDateSection" class="section_common">
                  <h4 class="section_title">투표 마감 날짜 설정</h4>
                  <div class="pickerWrap">
                     <input type="text" id="vote_endDate" class="dateCommon"
                        autocomplete="off" placeholder="날짜를 선택해주세요." readonly>
                     <!-- START TIMEPICKER -->
                     <div id="timepicker_box" class="timepicker_box dateCommon">
                        <section class="timeSection">
                           <span id="timeValue">--:--:--</span>
                        </section>

                        <section class="timeImgSection">
                           <img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
                              alt="시계이미지" />
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
                  <h4 class="section_title">투표 내용</h4>
                  <section>
                     <textarea id="vote_description" class="vote_description common"
                        placeholder="투표 내용"></textarea>
                     <span id="description_text_length" class="text_length">0/150</span>
                  </section>
               </section>

               <section class="voteSection section_common">
                  <h4 class="section_title">투표 항목</h4>

                  <div id="vote_list_Wrap">
                     <!-- SAMPLE VOTE LIST -->
                     <div class="vote_list sample blind">
                        <label class="list_title"></label> <input type="text"
                           class="list_text" /> <img
                           src="/meet-a-bwa/resources/img/close.svg" alt="항목 삭제 이미지"
                           class="removeBtn" />
                     </div>
                  </div>
               </section>
               <input type="button" id="vote_list_plusBtn" value="투표 항목 추가" />
            </div>
            <!-- END sectionWrap -->

            <div class="btnWrap">
               <input type="button" id="vote_createBtn" class="btnCommon"
                  value="투표 만들기"> <input type="button" id="vote_cancleBtn"
                  class="btnCommon" value="취소">
            </div>
         </div>
         <!-- END 투표 생성 -->

         <!--  투표 수정일 때 SHOW -->
         <div id="event-update" class="blind">
            <div id="topSection">
               <h1 id="update-title">투표 수정</h1>
               <img src="/meet-a-bwa/resources/img/close.svg" alt="close이미지"
                  id="closeBtn" />
            </div>

            <!-- Start sectionWrap -->
            <div id='sectionWrap'>
               <section id="titleSection" class="section_common">
                  <h4 class="section_title">투표 제목</h4>
                  <section id="title_section">
                     <input type="text" id="u_vote_title" class="common"
                        placeholder="투표 제목"> <span id="u_title_text_length"
                        class="text_length">0/15</span>
                  </section>
               </section>

               <section id="endDateSection" class="endDateSection section_common">
                  <h4 class="section_title">투표 마감 시간/날짜 설정</h4>
                  <div class="pickerWrap">
                     <input type="text" id="u_vote_endDate"
                        class="vote_endDate dateCommon" autocomplete="off"
                        placeholder="날짜를 선택해주세요." readonly>
                     <div id="u_timepicker_box" class="timepicker_box dateCommon">
                        <section class="timeSection">
                           <span id="u_timeValue">--:--:--</span>
                        </section>

                        <section class="timeImgSection">
                           <img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
                              alt="시계이미지" />
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
                  <h4 class="section_title">투표 내용</h4>
                  <section>
                     <textarea id="u_vote_description" class="vote_description common"
                        placeholder="투표 내용"></textarea>
                     <span id="u_description_text_length" class="text_length">0/150</span>
                  </section>
               </section>

               <section class="voteSection section_common">
                  <h4 class="section_title">투표 항목 (* 수정 불가)</h4>

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
                  value="투표 수정">
            </div>
         </div>
         <!-- END 투표 수정 -->
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
         <span id="confirm_txt">투표를 종기종료 하시겠습니까?</span>
      </div>
      <div id="confirm_btn_wrap">
         <input type="button" id="end_yesBtn"
            class="yesBtn confirm_btn_common" value="예" /> <input type="button"
            id="end_noBtn" class="noBtn confirm_btn_common" value="아니오" />
      </div>
   </div>
   <!-- END voteWrap -->


   <!-- START toastWrap -->
   <!-- 필요할 때, hide 없애고 fade-in 클래스 추가-->
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
            <span id="event-view-title">이벤트 제목 부분입니다.</span> 
            <img src="/meet-a-bwa/resources/img/more-vertical.png" alt="더보기 세로 이미지" id="event_more_vertival" />
            <div id="event_dropdown" class="select_custom blind">
               <img src="/meet-a-bwa/resources/img/vector.png"
                  alt="셀렉트 before 이미지" id="event_select_img" />
               <ul class="select_list_wrap">
                  <li class="select_list" id="event_update">수정</li>
                  <li class="select_list" id="event_delete">삭제</li>
               </ul>
            </div>
         </div>
         <!-- END title_wrap -->

         <!-- Start sectionWrap -->
         <div id="section_wrap" class="wrap_common">
            <!-- START info_section -->
            <section id="info_section" class="sectionCommon">
               <ul id="listWrap">
                  <li class="list">
                  	<label class="e_list_title">일정</label> 
                  	<span id="event_date" class="list_content">2022년 08월 28일 12시00분</span>
                  </li>
               </ul>
            </section>
            <!-- END info_section -->
            
            <!-- START description_section -->
            <section id="description_section" class="sectionCommon">
               <fieldset id="description_field">
                  <legend class="field_title">이벤트 설명</legend>
                  <div class="field_content">
                     <textarea id = "event_view_description" readonly></textarea>
                  </div>
               </fieldset>
            </section>
            <!-- END description_section -->
         </div>
         <!-- END sectionWrap -->

         <!-- Start bottom_wrap -->
         <div id="bottom_wrap">
            <p id="event_writer">작성자 : 김예은</p>
            <input type="button" id="event_okBtn" class="btnCommon" value="확인" />
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
	         <span id="confirm_txt">삭제하시겠습니까?</span>
	      </div>
	      <div id="confirm_btn_wrap">
	         <input type="button" id="e_yesBtn" class="confirm_btn_common" value="예" />
	         <input type="button" id="e_noBtn" class="confirm_btn_common"
	            value="아니오" />
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
            <h1 id="event-create-title">이벤트 추가</h1>
            <!-- Start sectionWrap -->
            <div class="sectionWrap">
               <section id="" class="e_titleSection event-section_common">
                  <h4 class="section_title">이벤트 제목</h4>
                  <section>
                     <input type="text" id="event_title" class="event_title common"
                        placeholder="이벤트 제목"> <span id="event_title_text_length"
                        class="text_length">0/15</span>
                  </section>
               </section>

               <section id="" class="choice_date event-section_common">
                  <h4 class="section_title">이벤트 시간/날짜 설정</h4>
                  <div id="" class="e_pickerWrap">
                     <input type="text" id="eventDate" class="eventDate dateCommon"
                        autocomplete="off" placeholder="날짜를 선택해주세요.">

                     <!-- START TIMEPICKER -->
                     <div id="" class="e_timepicker_box dateCommon">
                        <section id="" class="timeSection">
                           <span id="event_timeValue">--:--:--</span>
                        </section>

                        <section id="" class="timeImgSection">
                           <img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
                              alt="시계이미지" />
                        </section>

                        <div id="" class="customTimePicker blind">
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
                  <h4 class="section_title">이벤트 내용</h4>
                  <section>
                     <textarea id="event_description" class="event_description common"
                        placeholder="이벤트 내용"></textarea>
                     <span id="event_description_text_length" class="text_length">0/200</span>
                  </section>
               </section>
            </div>
            <div class="btnWrap">
               <input type="button" id="event_createBtn" class="btnCommon"
                  value="이벤트 생성"> <input type="button" id="event_cancleBtn"
                  class="btnCommon" value="취소">
            </div>
         </div>
         <!--  END event-create-wrap -->


         <!--  START event-update-wrap -->
         <div id="event-update-wrap" class="blind">
            <div id="topSection">
               <h1 class="u_title">이벤트 수정</h1>
               <img src="/meet-a-bwa/resources/img/close.png" id="e_u_closeBtn" alt="이벤트 수정창 닫기 버튼 이미지" />
            </div>

            <!-- Start sectionWrap -->
            <div class="sectionWrap">
               <section id="" class="e_titleSection event-section_common">
                  <h4 class="section_title">이벤트 제목</h4>
                  <section id="title_section">
                     <input type="text" id="event_u_title" class="event_title common"
                        placeholder="이벤트 제목"> 
                     <span id="event_u_title_text_length" class="text_length">0/15</span>
                  </section>
               </section>

               <section id="" class="choice_date event-section_common">
                  <h4 class="section_title">이벤트 시간/날짜 설정</h4>
                  <div id="" class="e_pickerWrap">
                     <input type="text" id= "u_eventDate" class="eventDate dateCommon"
                        autocomplete="off" placeholder="날짜를 선택해주세요.">

                     <!-- START TIMEPICKER -->
                     <div id="eu_t_box" class="e_timepicker_box dateCommon">
                        <section id="" class="timeSection">
                           <span id="event_u_timeValue">--:--:--</span>
                        </section>

                        <section id="" class="timeImgSection">
                           <img src="/meet-a-bwa/resources/img/clock.svg" id="timeImg"
                              alt="시계이미지" />
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
                  <h4 class="section_title">이벤트 내용</h4>
                  <section>
                     <textarea id="event_u_event_description"
                        class="event_description common" placeholder="이벤트 내용"></textarea>
                     <span id="event_u_description_text_length" class="text_length">0/200</span>
                  </section>
               </section>

            </div>
            <!-- END sectionWrap -->

            <div class="btnWrap">
               <input type="button" id="event_updateBtn" class="btnCommon" value="이벤트 수정">
            </div>
         </div>
         <!--  END event-update-wrap -->
      </div>
      <!-- END event_popup -->
   </div>
   <!-- END popupWrap -->
</body>
</html>