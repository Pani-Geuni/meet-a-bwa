<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.meetboard.model.MeetBoardVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">

<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/toast.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/searchBar.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/meet-detail.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/feed.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-detail.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-writer.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-update.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-delete.css" />

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
    
<script src="/meet-a-bwa/resources/js/meet/delete-popup.js"></script>
<script src="/meet-a-bwa/resources/js/meet/post-write-popup.js"></script>

<script src="/meet-a-bwa/resources/js/vote/vote_common.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_create.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_update.js"></script>
<script src="/meet-a-bwa/resources/js/vote/vote_view.js"></script>

<script>
	$(function(){
		// 오른쪽 섹션 - 투표 생성 버튼 클릭 (+)
		$("#vote_create_btn").click(function(){
			$(".vote-create-update-wrap").removeClass("blind");
			$("#event-create").removeClass("blind");
		});
		
		
	});
</script>

<title>모임 피드</title>
</head>
<body>

	<!--  START HEADER INCLUDE -->
	<jsp:include page="../../views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>

	<div id="bodyWrap">
		<div id="contentWrapRow">
			<aside class="meet-detail-aside">
				<div class="meet-profile-img">
					<img src="/meet-a-bwa/resources/img/sample/sample-img-01.png"
						alt="샘플 대표 이미지" />
				</div>
				<div class="meet-detail-aside-top">
					<h1 class="meet-deatil-aside-title">금요일은 소고기 먹는 날 날날날날날날</h1>
					<div class="heart-common">
						<img class="img-heart-filled"
							src="/meet-a-bwa/resources/img/heart-filled.svg" alt="좋아요 이미지" />
						<img class="img-heart-outlined blind"
							src="/meet-a-bwa/resources/img/heart-outlined.svg"
							alt="좋아요 테두리 이미지" /> <span>9789</span>
					</div>
				</div>
				<div class="meet-summary-info">
					<p>
						<a href="/meet-a-bwa/meet-member.do">멤버 22명</a>
					</p>
					<p>리더 팡근</p>
				</div>

				<div class="tagSection">
					<div class="loca_tag tag">
						<img src="/meet-a-bwa/resources/img/map.png" class="tag_img" /> <span
							class="location_name font_size_10">경안동</span>
					</div>
					<div class="cate_tag tag">
						<span class="category_name font_size_10">자전거</span>
					</div>
				</div>

				<!-- 로그인 전 -->
				<!-- <button type="button" class="btn-meet join"> -->
				<button type="button" class="blind">
					<a href="#">모임 가입하기</a>
				</button>

				<!-- 로그인 후 -->
				<button type="button" class="btn-meet join" onclick="writePopupShow()">
					글쓰기</button>
				<button type="button" class="btn-meet join">
					<a href="">액티비티 개설</a>
				</button>

				<a class="meet-detail-link" href="./meet-info-detail.html">모임
					자세히 보기</a>
			</aside>

			<section class="feedWrap">
				<article>
					<!--  START SEARCHBAR INCLUDE -->
					<jsp:include page="/views/common/searchBar.jsp"></jsp:include>
    				<!--  END SEARCHBAR INCLUDE -->
					<div class="meet-notification">
						<div class="notification-title">
							<h3>공지</h3>
							<a href="./post-detail.html">
								<p>공지내용 공지내용 공지내용 공지내용 공지내용공지내용 공지내용 공지내용 공지내용 공지내용공지내용 공지내용
									공지내용 공지내용 공지내용공지내용 공지내용 공지내용 공지내용 공지내용</p>
							</a>
						</div>
					</div>
					<!-- end meet-notification -->

					<div class="all-feed">
					
						<c:choose>
						<c:when test="${ empty vos }">
							<div class="feed-empty">
				                <h1>현재 모임에 작성된 글이 없어요!</h1>
				                <p>모임에 글을 작성해 소통해봐요!</p>
				            </div>
						</c:when>
						<c:when test="${ not empty vos }">
						<c:forEach var="vo" items="${ vos }">
						<div class="feed">
							<div class="feed-profile">
								<div class="user-info">
									<div>
										<img src="/meet-a-bwa/resources/img/loopy.svg" alt="프로필 이미지" />
									</div>
									<p class="user-nickname">${ vo.user_name }</p>
									<p class="write-date">${ vo.board_date }</p>
								</div>

								<div class="post-more-select">
									<img class="img-more" src="/meet-a-bwa/resources/img/more.svg" alt="" />

									<ul class="post-option-list" idx="${ vo.board_no }">
										<li class="post-option-item" data-popup-open="update">수정하기</li>
										<li class="post-option-item" data-popup-open="delete">
											삭제하기</li>
									</ul>
								</div>
							</div>
							<div class="feed-post">
								<a href="b_selectOne.do?board_no=${ vo.board_no }">
									<p>${ vo.board_content }</p>
								</a>
							</div>
							<div class="feed-options">
								<p>
									<a href="#">댓글</a>
								</p>
							</div>
						</div>
						<!-- end one feed -->
						</c:forEach>
						</c:when>
						</c:choose>
					</div>
					<!-- end all feed -->
				</article>
			</section>
			<aside class="meet-right-aside">
          <div class="right-summary-list" id="event-summary-list">
            <div class="right-summary-list-top">
              <h1>모임 내 액티비티</h1>
              <p><a href="#">+</a></p>
            </div>
            <ul class="right-summary-list-contents">
              <li>
                <a href="">액티비티1</a>
              </li>
              <li>
                <a href="">액티비티2</a>
              </li>
              <li>
                <a href="">액티비티3</a>
              </li>
              <li>
                <a href="">액티비티4</a>
              </li>
              <li>
                <a href="">액티비티5</a>
              </li>
              <li>
                <a href="">액티비티6</a>
              </li>
            </ul>
          </div>
          <div class="right-summary-list" id="vote-summary-list">
            <div class="right-summary-list-top">
              <h1>투표</h1>
              <p id = "vote_create_btn"><!-- <a href="/meet-a-bwa/m_vote_create.do"> -->+<!-- </a> --></p>
            </div>
            <ul class="right-summary-list-contents">
              <li>
                <a href="">투표 1</a>
              </li>
              <li>
                <a href="">투표 2</a>
              </li>
              <li>
                <a href="">투표 3</a>
              </li>
              <li>
                <a href="">투표 4</a>
              </li>
              <li>
                <a href="">투표 5</a>
              </li>
            </ul>
          </div>
        </aside>
		</div>
	</div>
</body>

<!-- ==================================== -->
<!-- 글쓰기 view 팝업 -->
<!-- ==================================== -->
<div class="write-popup-layer">
	<div class="popup-box">
		<div class="popup-top">
        	<h1>글쓰기</h1>
        </div>
        <div class="popup-writer">
          	<form action="b_insertOK.do" method="post" class="popup-writer">
            	<input name="board_title" type="text" placeholder="제목" />
	            <textarea
	              name="board_content"
	              id="content"
	              placeholder="내용을 입력하세요."
	            ></textarea>
	            
	            <div class="popup-btn-group">
		         	<button type="button" class="btn-cancel" onclick="writePopupHide()">취소</button>
		          	<button type="submit" class="btn-submit">게시</button>
		        </div>
          	</form>
        </div>
	</div>
</div>

<!-- ==================================== -->
<!-- 글 업데이트 view 팝업 -->
<!-- ==================================== -->
<div class="update-popup-layer" data-popup="update">
	<div class="popup-box">
		<div class="popup-top">
        	<h1>글 수정</h1>
        </div>
        <div class="popup-writer" id="popup-update">
            	<input name="update_title" id="update_title" type="text" placeholder="제목" value="${ vo.board_title }"/>
	            <textarea
	              name="update_content"
	              id="update_content"
	              placeholder="내용을 입력하세요."
	            >${ vo.board_content }</textarea>
	            
	            <div class="popup-btn-group">
		         	<button type="button" class="btn-cancel" data-popup-close="update">취소</button>
		          	<button type="submit" class="btn-submit-update">게시</button>
		        </div>
        </div>
	</div>
</div>

	<!-- *******************  -->
	<!-- delete popup SECTION -->
	<!-- *******************  -->
	  <div class="delete-popup-layer" data-popup="delete">
	    <div class="delete-popup-wrap">
	      <img src="/meet-a-bwa/resources/img/worry.svg" alt="" />
	      <h1>정말 삭제 하시겠습니까?</h1>
	
	      <div class="btn-group">
	        <button id="btn-delete" class="btn-delete" data-popup-close="delete">삭제</button>
	        <button class="btn-cancel" data-popup-close="delete">취소</button>
	      </div>
	    </div>
	  </div>
	<!-- *******************  -->
	<!-- delete popup SECTION -->
	<!-- *******************  -->
	
	
	

	<!-- *******************  -->
	<!--  투표 확인 -->
	<!-- *******************  -->
	    
	<div id = "vote-view-wrap" class = "blind">
		<!-- START voteWrap -->
		<div id = "voteWrap">
		    <div id = "divWrap" class = "vote_section">
		        <div id = "header_wrap" class = "wrap_common">
		            <span id = "view-title">투표 제목 부분입니다.</span>
		            <img src = "/meet-a-bwa/resources/img/more-vertical.png" alt = "더보기 세로 이미지" id = "more_vertival"/>
		            <!-- 숨기고 싶을 때, select_custom 제거 후 blind 추가-->
		            <!-- 보이고 싶을 때, select_custom 추가 후 blind 제거-->
		            <div id = "dropdown" class = "blind">
		                <img src = "/meet-a-bwa/resources/img/vector.png" alt = "셀렉트 before 이미지" id = "select_img"/>
		                <ul class = "select_list_wrap">
		                    <li class = "select_list" id = "update">수정</li>
		                    <li class = "select_list" id = "delete">삭제</li>
		                </ul>
		            </div>
		        </div>
		        <div id = "body_wrap" class = "wrap_common">
		            <!-- START 투표 설명란 -->
		            <!-- START 투표 설명없으면, class blind 추가 -->
		            <fieldset id = "description_field">
		                <legend class = "field_title">투표 설명</legend>
		                <div id = "vote_view_description">
		                    <p id = "text_area">
		                        2022년 8월 28일 액티비티 후 저녁 메뉴에 관한 투표입니다.<br>
		                        2022년 8월 28일 액티비티 후 저녁 메뉴에 관한 투표입니다.<br>
		                        2022년 8월 28일 액티비티 후 저녁 메뉴에 관한 투표입니다.<br>
		                        2022년 8월 28일 액티비티 후 저녁 메뉴에 관한 투표입니다.
		                    </p>
		                </div>
		            </fieldset>
		            <!-- END 투표 설명란 -->
		
		            <!-- START 투표 선택란 -->
		            <div id = "choice_wrap">
		                <!-- START choiceList-->
		                <div class = "choiceList">
		                    <section class = "txt_wrap_section">
		                        <section class = "txt_section">
		                            <span class = "txt">항목 타이틀 자리</span>
		                            <!-- 결과보여줄 때, blind 제거 -->
		                            <span class = "choice_mem_cnt blind"></span>
		                        </section>
		
		                        <!-- 결과보여줄 때, blind 제거해서 -->
		                        <span class = "list_percentage_wrap blind">
		                            <!-- 해당 항목이 선택받은 퍼센테이지를 width로 대입해 보이게 하기-->
		                            <span class = "list_percentage"></span>
		                        </span>
		                    </section>
		
		                    <div class = "out_circle">
		                        <!-- 보일 때 choice 추가-->
		                        <!-- 가릴 때 choice 삭제-->
		                        <div class = "in_circle">
		
		                        </div>
		                    </div>
		                </div>
		                <!-- END choiceList -->
		                <!-- START choiceList-->
		                <div class = "choiceList">
		                    <section class = "txt_wrap_section">
		                        <section class = "txt_section">
		                            <span class = "txt">항목 타이틀 자리</span>
		                            <!-- 결과보여줄 때, blind 제거 -->
		                            <span class = "choice_mem_cnt blind"></span>
		                        </section>
		
		                        <!-- 결과보여줄 때, blind 제거해서 -->
		                        <span class = "list_percentage_wrap blind">
		                            <!-- 해당 항목이 선택받은 퍼센테이지를 width로 대입해 보이게 하기-->
		                            <span class = "list_percentage"></span>
		                        </span>
		                    </section>
		
		                    <div class = "out_circle">
		                        <div class = "in_circle">
		
		                        </div>
		                    </div>
		                </div>
		                <!-- END choiceList -->
		            </div>
		            <!-- END 투표 선택란 -->
		        </div>
		        
		        <div id = "footer_wrap" class = "wrap_common">
		            <section id = "footer_info">
		                <span class = "info_common">작성자 정상윤</span>
		                <span class = "info_common" id = "end_date">투표마감:2022-09-01 오전10:00</span>
		            </section>
		
		            <section class = "btn_section blind">
		                <input type = "button" id = "voteBtn"  class = "btnCommon" value="투표하기"/>
		            </section>
		            <section class="btn_section">
		                <input type = "button" id = "re_voteBtn"  class = "btnCommon" value="재투표하기"/>
		            </section>
		            <section class="btn_section blind">
		                <input type = "button" id = "re_voteBtn"  class = "btnCommon" value="닫기"/>
		            </section>
		        </div>
		    </div>
		
		</div>
		<!-- END voteWrap -->
		
		<div id = "confirmWrap" class = "blind"> 
		    <div id = "confirm_head">
		        <img src = "/meet-a-bwa/resources/img/fluent_more-horizontal-20-regular.png" id = "more-horizontal"/>
		    </div>
		    <div id = "confirm_txt_wrap">
		        <span id = "confirm_txt">삭제하시겠습니까?</span>
		    </div>
		    <div id = "confirm_btn_wrap">
		        <input type = "button" id = "yesBtn" class = "confirm_btn_common" value = "예"/>
		        <input type = "button" id = "noBtn" class = "confirm_btn_common" value = "아니오"/>
		    </div>
		</div>
	</div>
  
  
  
	<!-- *******************  -->
	<!-- 이벤트 생성 / 수정 --> 
	<!-- *******************  -->
	 
	<!-- Start voteWrap -->
	<div id = "voteWrap" class = "vote-create-update-wrap blind">
	    <!-- Start vote_popup -->
	    <div id = "vote_popup">
	    	
	    	<!-- 이벤트 생성일 때 SHOW -->
	    	<div id = "event-create" class = "blind">
		        <h1 id = "title">투표 생성</h1>
		        
			    <!-- Start sectionWrap -->
		        <div id = 'sectionWrap'>
		            <section id = "titleSection" class = "section_common">
		                <h4 class = "section_title">투표 제목</h4>
		                <section id = "title_section">
		                    <input type = "text" id = "vote_title" class = "common" placeholder="투표 제목">
		                    <span id = "title_text_length" class = "text_length">0/15</span>
		                </section>
		            </section>
		
		            <section id = "endDateSection"  class = "section_common">
		                <h4 class = "section_title">투표 마감 날짜 설정</h4>
		                <div id = "pickerWrap">
		                    <input type = "text" id = "vote_endDate" class = "dateCommon" autocomplete="off" placeholder="날짜를 선택해주세요." readonly>
		                    <!-- START TIMEPICKER -->
		                    <div id = "timepicker_box" class = "dateCommon">
		                        <section id = "timeSection">
		                            <span id = "timeValue">--:--:--</span>
		                        </section>
		
		                        <section id = "timeImgSection">
		                            <img src="/meet-a-bwa/resources/img/clock.svg" id = "timeImg" alt = "시계이미지" />
		                        </section>
		
		                        <div id = "customTimePicker" class = "blind">
		                            <div id = "ampm_choice">
		                                <ul id = "ampm_listWrap">
		                                    <li class = "sample ampm-list"></li>
		                                </ul>
		                            </div>
		                            <div id = "time_choice" class = "choiceCommon">
		                                <ul id = "time_listWrap">
		                                    <li class = "sample time-list"></li>
		                                </ul>
		                            </div>
		                            <div id = "minute_choice" class = "choiceCommon">
		                                <ul id = "minute_listWrap">
		                                    <li class = "sample minute-list"></li>
		                                </ul>
		                            </div>
		                        </div>
		                    </div>
		                    <!-- END TIMEPICKER -->
		                </div>
		            </section>
		
		            <section class = "section_common">
		                <h4 class = "section_title">투표 내용</h4>
		                <section>
		                    <textarea id = "vote_description" class = "common" placeholder="투표 내용"></textarea>
		                    <span id = "description_text_length" class = "text_length">0/150</span>
		                </section>
		            </section>
		
		            <section id = "voteSection"  class = "section_common">
		                <h4 class = "section_title">투표 항목</h4>
		
		                <div id = "vote_list_Wrap">
		                    <!-- SAMPLE VOTE LIST -->
		                    <div class = "vote_list sample blind">
		                        <label class = "list_title"></label>
		                        <input type = "text" class = "list_text"/>
		                        <img src = "/meet-a-bwa/resources/img/close.svg" alt = "항목 삭제 이미지" class = "removeBtn" />
		                    </div>
	                    </div>
		            </section>
		            <input type ="button" id = "vote_list_plusBtn" value="투표 항목 추가"/>
		        </div>
		        <!-- END sectionWrap -->
		        
		        <div id = "btnWrap">
		            <input type ="button" id = "vote_createBtn" class = "btnCommon" value="투표 만들기">
		            <input type ="button" id = "vote_cancleBtn" class = "btnCommon" value="취소">
		        </div>
	    	</div>
	    	<!-- END 투표 생성 -->
	    	
	    	<!--  이벤트 수정일 때 SHOW -->
	    	<div id = "event-update" class = "blind">
	    		<div id = "topSection">
		            <h1 id = "update-title">투표 수정</h1>
		            <img src = "/meet-a-bwa/resources/img/close.svg" alt = "close이미지" id = "closeBtn" />
		        </div>

		        <!-- Start sectionWrap -->
		        <div id = 'sectionWrap'>
		            <section id = "titleSection" class = "section_common">
		                <h4 class = "section_title">투표 제목</h4>
		                <section id = "title_section">
		                    <input type = "text" id = "vote_title" class = "common" placeholder="투표 제목" value="">
		                    <span id = "title_text_length" class = "text_length">0/15</span>
		                </section>
		            </section>
		
		            <section id = "endDateSection"  class = "section_common">
		                <h4 class = "section_title">투표 마감 시간/날짜 설정</h4>
		                <div id = "pickerWrap">
		                    <input type = "text" id = "vote_endDate" class = "dateCommon" autocomplete="off" placeholder="날짜를 선택해주세요." readonly>
		                    <div id = "timepicker_box" class = "dateCommon">
		                        <section id = "timeSection">
		                            <span id = "timeValue">--:--:--</span>
		                        </section>
		
		                        <section id = "timeImgSection">
		                            <img src="/meet-a-bwa/resources/img/clock.svg" id = "timeImg" alt = "시계이미지" />
		                        </section>
		
		                        <div id = "customTimePicker" class = "blind">
		                            <div id = "ampm_choice">
		                                <ul id = "ampm_listWrap">
		                                    <li class = "sample ampm-list"></li>
		                                </ul>
		                            </div>
		                            <div id = "time_choice" class = "choiceCommon">
		                                <ul id = "time_listWrap">
		                                    <li class = "sample time-list"></li>
		                                </ul>
		                            </div>
		                            <div id = "minute_choice" class = "choiceCommon">
		                                <ul id = "minute_listWrap">
		                                    <li class = "sample minute-list"></li>
		                                </ul>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </section>
		
		            <section class = "section_common">
		                <h4 class = "section_title">투표 내용</h4>
		                <section>
		                    <textarea id = "vote_description" class = "common" placeholder="투표 내용"></textarea>
		                    <span id = "description_text_length" class = "text_length">0/150</span>
		                </section>
		            </section>
		
		            <section id = "voteSection"  class = "section_common">
		                <h4 class = "section_title">투표 항목</h4>
		
		                <div id = "vote_list_Wrap">
		                    <!-- SAMPLE VOTE LIST -->
		                    <div class = "vote_list sample blind">
		                        <label class = "list_title"></label>
		                        <input type = "text" class = "list_text" value=""/>
		                        <img src = "/meet-a-bwa/resources/img/close.svg" alt = "항목 삭제 이미지" class = "removeBtn" />
		                    </div>
		                </div>
		            </section>
		            <input type ="button" id = "vote_list_plusBtn" value="투표 항목 추가" />
		                
		        </div>
		        <!-- END sectionWrap -->
        
		        <div id = "btnWrap">
		            <input type ="button" id = "vote_updateBtn" class = "btnCommon" value="투표 수정">
		        </div>
	    	</div>
	    	<!-- END 투표 수정 -->
	    </div>
	    <!-- END vote_popup -->
	
	</div>
	<!-- END voteWrap -->
	

	<!-- START toastWrap -->
	<!-- 필요할 때, hide 없애고 fade-in 클래스 추가-->
	<div id = "toastWrap" class = "hide">
	    <span id = "toast_txt"></span>
	</div>
	<!-- END toastWrap -->
</html>