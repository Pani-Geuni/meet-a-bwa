<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/activity/feed.css" />
	
<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
<script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
<script src="/meet-a-bwa/resources/js/common/login.js"></script>
<script src="/meet-a-bwa/resources/js/common/logout.js"></script>
<script src="/meet-a-bwa/resources/js/activity/feed.js"></script>

<script>
	$(function() {
		// 생성 버튼 클릭 (+)
		$("#vote_create_btn").click(function() {
			$(".vote-create-update-wrap").removeClass("blind"); // 투표 팝업
			$("#event-create").removeClass("blind");
		});
		$("#event_create_btn").click(function() {
			$(".vote-create-update-wrap").removeClass("blind"); // 이벤트 팝업
			$("#event-create").removeClass("blind");
		});
		$("#recruit_create_btn").click(function() {
			$(".vote-create-update-wrap").removeClass("blind"); // 활동 신청 팝업
			$("#event-create").removeClass("blind");
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
                        <img src="/meet-a-bwa/resources/img/default-image2.png" alt="default 이미지" id="meetImg">
                    </div>
                    <div class="act-detail-aside-top">
                        <h1 class="act-deatil-aside-title">
                            액티비티 이름
                        </h1>
                        <div class="heart-common">
                        	<button class="img-heart-outlined_btn">
                            <img class="img-heart-outlined" src="/meet-a-bwa/resources/img/heart-outlined.svg" alt="">
                            </button>
                            <button class="img-heart-filled_btn blind">
                            <img class="img-heart-filled" src="/meet-a-bwa/resources/img/heart-filled.svg" alt="">
                            </button>
                            <span id="like_cnt">0</span>
                        </div>
                    </div>
                    <div class="act-summary-info">
                        <p><a href="/meet-a-bwa/resources/act-detail-member.html">멤버 22명</a></p>
                        <p>리더 팡근</p>
                    </div>

                    <div class="tagSection">
                        <div class="loca_tag tag">
                            <img src="/meet-a-bwa/resources/img/map.png" class="tag_img">
                            <span class="location_name font_size_10">경안동</span>
                        </div>
                        <div class="cate_tag tag">
                            <span class="category_name font_size_10">자전거</span>
                        </div>
                        <div class="age_tag tag">
                            <span class="category_name font_size_10">20대</span>
                        </div>
                        <div class="gen_tag tag">
                            <span class="category_name font_size_10">남여</span>
                        </div>
                    </div>

                    <!-- 가입 전 -->
                    <button type="button" id="join_activity_btn">
                        <a href="#">액티비티 가입하기</a>
                    </button>

                    <!-- 가입후, 개설자 -->
                    <!-- <button type="button"  id="join_activity_btn"  class="hide">
                    <a href="#">액티비티 가입하기</a>
                  </button> -->

                </div>
                <!--meetLeftWrap end-->

                <div id="innerbodyWrap">
                    <section id="intro">
                        <h3 id="introTitle">액티비티 소개</h3>
                        <hr class="firstLine">
                        <section id="innerIntro">
                            <section id="IntroInfo">
                                <h4 class="introInfo">액티비티 정보</h4>
                                <ul class="introInfoUl">
                                    <li class="openDate">액티비티 개설일 : 2022년 9월</li>
                                    <li class="nop">멤버 수 : 22명</li>
                                </ul>
                            </section>
                            <!--introInfo end-->
                            <hr class="secondLine">
                            <section id="IntroDescription">
                                <p class="IntroDescription">액티비티 자세한 설명</p>
                            </section>
                            <!--IntroDescription end-->
                            <!-- <hr class="thirdLine"> -->
                        </section>
                        <!--innerIntro end-->
                    </section>
                    <!--intro end-->

                    <!--///////////////////////////////////////////////가입 전(이벤트, 투표, 모임신청 없을 때)/////////////////////////////////////////////-->
<%--                     <c:set var="account_state" value="" scope="session"/>
                    <c:choose>
                    <c:when test="${account_state}==" 가입전, 비로그인>
                    
                    
                    </c:when>
                    <c:when test="${account_state}==" 가입후, 개설자>
                    
                    </c:when>
                    </c:choose>
                    
                    <c:if test="${yangyag.name == 'yhm' && yangyag.nickname == 'yhm'}">...</c:if> --%>
					
                    <div id="pheed_1">
                        <p id="defaultPheedText_1">액티비티에 가입해서 더 많은 정보를 찾아보세요!</p>
                    </div>
                    <!--pheed_1 end-->

                    <!-- <div id="pheed_1" class="hide">
                        <p id="defaultPheedText_1">액티비티에 가입해서 더 많은 정보를 찾아보세요!</p>
                    </div> -->
                    <!--pheed_1 end-->                    

                    <!--///////////////////////////////////////////////가입 후(이벤트, 투표, 모임신청 없을 때)/////////////////////////////////////////////-->

                    <section id="pheed" class="pheed blind">
                        <section class="pheedEvent">
                            <section class="pheedEventHeader">
                                <h4 class="pheedEventHeaderText">이벤트</h4>
                                <input type="image" src="/meet-a-bwa/resources/img/add.png" class="addBtn" id="event_create_btn">
                            </section>
                            <!--pheedEventHeader end-->
                            <section class="pheedEventBody">
                                <p id="EventdefaultPheedText">생성된 이벤트가 없습니다.</p>
                            </section>
                            <!--pheedEventBody end-->
                        </section>
                        <!--pheedEvent end-->
                        <section class="voteApplication">
                            <section class="pheedVote">
                                <section class="pheedVoteHeader">
                                    <h4 class="pheedVoteHeaderText">투표</h4>
                                    <input type="image" src="/meet-a-bwa/resources/img/add.png" class="addBtn" id="vote_create_btn">
                                </section>
                                <!--pheedVoteHeader end-->
                                <section class="pheedVoteBody">
                                    <p id="VotedefaultPheedText">생성된 투표가 없습니다.</p>
                                </section>
                                <!--pheedVoteBody end -->
                            </section>
                            <!--pheedVote end-->
                            <section class="pheedApplication">
                                <section class="pheedApplicationHeader">
                                    <h4 class="pheedApplicationHeaderText">활동 신청</h4>
                                    <input type="image" src="/meet-a-bwa/resources/img/add.png" class="addBtn" id="recruit_create_btn">
                                </section>
                                <!--pheedApplicationHeader end-->
                                <section class="pheedApplicationBody">
                                    <p id="AppplictiondefaultPheedText">생성된 활동이 없습니다.</p>
                                </section>
                                <!--pheedApplicationBody end-->
                            </section>
                            <!--pheedApplication end-->
                        </section>
                        <!--voteApplication end-->
                    </section>
                    <!--pheed end-->


                    <!--///////////////////////////////////////////////가입 후(이벤트, 투표, 모임신청 있을 때)//////////////////////////////////////////////-->
                    <section id="pheed" class="pheed blind">
                        <section class="pheedEvent">
                            <section class="pheedEventHeader">
                                <h4 class="pheedEventHeaderText">이벤트</h4>
                                <input type="image" src="/meet-a-bwa/resources/img/add.png" class="addBtn" id="event_create_btn">
                            </section><!--pheedEventHeader end-->
                            <section class="pheedEventBody">
                            
                            <%-- <c:forEach var="item" items="${items}"> --%>
                            <div class="content_list event-list" idx="">
		                        <div class="event-list-wrap">
		                            <div class="listCommon">
		                                <span class="content_title">11월 12일 모임</span>
		                            </div>
		                            <div class="description_list listCommon">
		                                <span class="content_description">
		                                    2022년 11월 12일의 모임 정보를 확인하세요!
		                                </span>
		                            </div>
		                        </div>
		                    </div>
		                    <!-- </c:forEach> -->
                            
                            </section><!--pheedEventBody end-->
                        </section> <!--pheedEvent end-->
                        
                        
                        <section class="voteApplication">
                        <section class="pheedVote">
                            <section class="pheedVoteHeader">
                                <h4 class="pheedVoteHeaderText">투표</h4>
                                <input type="image" src="/meet-a-bwa/resources/img/add.png" class="addBtn" id="vote_create_btn">
                            </section><!--pheedVoteHeader end-->
                            <section class="pheedVoteBody">
                            
                            <%-- <c:forEach var="item" items="${items}"> --%>
                            <div class="content_list event-list" idx="">
		                        <div class="vote-list-wrap">
		                            <div class="listCommon">
		                                <span class="content_title">11월 12일 모임</span>
		                            </div>
		                            <div class="description_list listCommon">
		                                <span class="content_description">
		                                    2022년 11월 12일의 모임 정보를 확인하세요!
		                                </span>
		                            </div>
		                            <div class="meet_info">
                                        <div class="meet_member_info">
                                            <span class="member_cnt member_ment">19명</span>
                                            <span class="member_ment">참여 중</span>
                                        </div>
                                        <img src="/meet-a-bwa/resources/img/smallLine.png" class="smallLine">
                                        <div class="period_info">
                                            <span class="member_ment">투표 마감 : </span>
                                            <span class="member_ment">2022년 9월 28일</span>
                                        </div>
                                    </div>
		                        </div>
		                    </div>
		                    <!-- </c:forEach> -->
		                    
                            </section><!--pheedVoteBody end -->
                        </section> <!--pheedVote end-->
                        
                        
                        <section class="pheedApplication">
                            <section class="pheedApplicationHeader">
                                <h4 class="pheedApplicationHeaderText">활동 신청</h4>
                                <input type="image" src="/meet-a-bwa/resources/img/add.png" class="addBtn" id="recruit_create_btn">
                            </section><!--pheedApplicationHeader end-->
                            <section class="pheedApplicationBody">
                            
                             <%-- <c:forEach var="item" items="${items}"> --%>
                            <div class="content_list event-list" idx="">
		                        <div class="recruit-list-wrap">
		                            <div class="listCommon">
		                                <span class="content_title">11월 12일 모임</span>
		                            </div>
		                            <div class="description_list listCommon">
		                                <span class="content_description">
		                                    2022년 11월 12일의 모임 정보를 확인하세요!
		                                </span>
		                            </div>
		                            <div class="meet_info">
                                        <div class="meet_member_info">
                                            <span class="member_cnt member_ment">19명</span>
                                            <span class="member_ment">참여 중</span>
                                        </div>
                                        <img src="/meet-a-bwa/resources/img/smallLine.png" class="smallLine">
                                        <div class="period_info">
                                            <span class="member_ment">신청 마감 : </span>
                                            <span class="member_ment">2022년 9월 28일</span>
                                        </div>
                                    </div>
		                        </div>
		                    </div>
		                    <!-- </c:forEach> -->
		                    
                                
                            </section><!--pheedApplicationBody end-->
                        </section> <!--pheedApplication end-->
                        </section> <!--voteApplication end-->
                    </section> <!--pheed end-->



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
</body>
</html>