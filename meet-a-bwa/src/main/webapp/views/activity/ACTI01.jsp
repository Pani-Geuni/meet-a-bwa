<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>액티비티 리스트</title>
	
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/searchBar.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css"/>
    
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/list/activity-list.css"/>
    
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css"/>
    
    <script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
    <script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
    <script src="/meet-a-bwa/resources/js/common/login.js"></script>
    <script src="/meet-a-bwa/resources/js/common/logout.js"></script>
    <script src="/meet-a-bwa/resources/js/common/header.js"></script>
    <script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
    
    <script>
    	$(function() {
			var user_id = '${user_id}'; //세션값 가져옴
	    	
			// 액티비티 추천 - 카테고리 더보기 버튼 클릭 이벤트
    	    $("#plusImg").click(function(){
    	        $("#fold_tag").removeClass("blind");
    	        $(this).addClass("blind");
    	        $("#foldImg").removeClass("blind");
    	    });
    	    
    	    // 액티비티 추천 - 카테고리 접기 버튼 클릭 이벤트
    	    $("#foldImg").click(function(){
    	        $("#fold_tag").addClass("blind");
    	        $(this).addClass("blind");
    	        $("#plusImg").removeClass("blind");
    	    });
	
    	    // 액티비티 추천 - 카테고리 클릭 이벤트
    	    $(".tagItem").click(function(e){
    	        $(".tagItem").removeClass("check");
    	        $(e.target).addClass("check");
    	        console.log($(this).text());
    	        let category = $(this).text();
    	        location.href = "/meet-a-bwa/activity-list.do?category="+category + "&&searchWord=";
    	    });
    	    
    	    $("#recommend_list_wrap").on("click", ".content-list", function(){
	    		 let idx = $(this).attr("idx");
	    		 console.log("clic")
	    		 location.href = "/meet-a-bwa/activity-main.do?idx="+idx;
	    	 });
    	})	
    </script>
</head>
<body>
	<!--  START HEADER INCLUDE -->
	<jsp:include page="../../views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>
    <!--  END HEADER INCLUDE -->
    
    <div id="bodyWrap">
    	<!--  START SEARCHBAR INCLUDE -->
		<jsp:include page="../../views/common/searchBar.jsp"></jsp:include>
    	<!--  END SEARCHBAR INCLUDE -->
    	
    	<div id = "contentWrap">
    		<div id = "recommendAct" class = "mainContent">
    			<div class = "titleSection">
                    <section class = "title titleLeft">
                        <section id = "beforeLogin_recommend" class = "">
                            <span class = "comment">어떤 액티비티에 관심있으신가요?</span>
                        </section>
                    </section>

                    <section class = "title titleRight">
                        <span id = "plusBtn_act" class = "plusBtn">정렬</span>
                    </section>
                </div>
                <!-- END ACTIVITY TITLE SECTION -->
                
                <div id = "cate_tag_section">
                	<!-- ACTIVITY TAG SECTION -->
                	<div id = "unfold_tag">
                    	<span class = "tagItem <c:if test = "${checkCategory eq '전체'}">check</c:if>">전체</span>
                        <span class = "tagItem <c:if test = "${checkCategory eq '취미'}">check</c:if>">취미</span>
                        <span class = "tagItem <c:if test = "${checkCategory eq '팬클럽'}">check</c:if>">팬클럽</span>
                        <span class = "tagItem <c:if test = "${checkCategory eq '방송/연예'}">check</c:if>">방송/연예</span>
                        <span class = "tagItem <c:if test = "${checkCategory eq '스포츠/레저'}">check</c:if>">스포츠/레저</span>
                        <span class = "tagItem <c:if test = "${checkCategory eq '게임'}">check</c:if>">게임</span>
                        <span class = "tagItem <c:if test = "${checkCategory eq '만화/애니메이션'}">check</c:if>">만화/애니메이션</span>
                        <span class = "tagItem <c:if test = "${checkCategory eq '맛집/요리'}">check</c:if>">맛집/요리</span>
                        <span class = "tagItem <c:if test = "${checkCategory eq '생활정보/인테리어'}">check</c:if>">생활정보/인테리어</span>
                        <span class = "tag_plus">
                            <img src = "resources/img/더보기.svg" alt = "더보기 이미지" id = "plusImg">
                            <img src = "resources/img/fold.svg" alt = "접기 이미지" id = "foldImg" class = "blind">
                        </span>
                    </div>
                    <div id = "fold_tag" class = "blind">
                        <ul id = "tagUl">
                            <li class = "tag_li">
                                <span class = "tagItem <c:if test = "${checkCategory eq '건강/다이어트'}">check</c:if>">건강/다이어트</span>
                                <span class = "tagItem <c:if test = "${checkCategory eq '패션/뷰티'}">check</c:if>">패션/뷰티</span>
                                <span class = "tagItem <c:if test = "${checkCategory eq '여행/캠핑'}">check</c:if>">여행/캠핑</span>
                                <span class = "tagItem <c:if test = "${checkCategory eq '반려동물/동물'}">check</c:if>">반려동물/동물</span>
                                <span class = "tagItem <c:if test = "${checkCategory eq '문화/예술'}">check</c:if>">문화/예술</span>
                                <span class = "tagItem <c:if test = "${checkCategory eq '음악'}">check</c:if>">음악</span>
                                <span class = "tagItem <c:if test = "${checkCategory eq '어학/외국어'}">check</c:if>">어학/외국어</span>
                                <span class = "tagItem <c:if test = "${checkCategory eq '취업/자격증'}">check</c:if>">취업/자격증</span>
                            </li>
                            <li class = "tag_li">
		                        <span class = "tagItem <c:if test = "${checkCategory eq '교육/공부'}">check</c:if>">교육/공부</span>
		                        <span class = "tagItem <c:if test = "${checkCategory eq '어학/외국어'}">check</c:if>">어학/외국어</span>
		                        <span class = "tagItem <c:if test = "${checkCategory eq 'IT/컴퓨터'}">check</c:if>">IT/컴퓨터</span>
		                        <span class = "tagItem <c:if test = "${checkCategory eq '인문/과학'}">check</c:if>">인문/과학</span>
		                        <span class = "tagItem <c:if test = "${checkCategory eq '경제/재테크'}">check</c:if>">경제/재테크</span>
		                        <span class = "tagItem <c:if test = "${checkCategory eq '종교/봉사'}">check</c:if>">종교/봉사</span>
		                        <span class = "tagItem <c:if test = "${checkCategory eq '일상/이야기'}">check</c:if>">일상/이야기</span>
		                        <span class = "tagItem <c:if test = "${checkCategory eq '나이/또래모임'}">check</c:if>">나이/또래모임</span>
		                    </li>
		                    <li class = "tag_li">
		                        <span class = "tagItem <c:if test = "${checkCategory eq '친목/모임'}">check</c:if>">친목/모임</span>
		                        <span class = "tagItem <c:if test = "${checkCategory eq '자연/귀농'}">check</c:if>">자연/귀농</span>
		                    </li>
		                </ul>
		            </div>
                </div>
                <!-- END TAG SECTION -->
                
                <div id = "recommend_list_wrap">
                	<c:if test = "${a_list.size() != 0}">
		                    <c:forEach var="avo" items="${a_list}">
			                   	<div class = "content-list" idx = "${avo.activity_no}">
			                        <div class = "info-list-wrap">
			                            <div class = "listCommon">
			                                <span class = "content_title">${avo.activity_name}</span>
			                            </div>
			
			                            <div class = "description_list listCommon">
			                                <span class = "content_description">
			                                    ${avo.activity_description}
			                                </span>
			                            </div>
			
			                            <div class = "listCommon">
			                                <div class = "tagSection">
			                                	<c:if test = "${avo.activity_county ne null}">
				                                    <div class = "loca_tag tag">
				                                        <img src = "/meet-a-bwa/resources/img/map.png" class = "tag_img">
				                                        <span class = "location_name font_size_10">${avo.activity_county}</span>
				                                    </div>
			                                    </c:if>
			                                    
			                                    <c:if test = "${avo.activity_interest_name ne null}">
				                                    <div class = "cate_tag tag">
				                                        <span class = "category_name font_size_10">${avo.activity_interest_name}</span>
				                                    </div>
			                                    </c:if>
			                                </div>
			                            </div>
			
			                            <div class = "content_img">
			                                <img src = "/meet-a-bwa/resources/img/loopy.svg" class = "list_img">
			                            </div>
			                        </div>
			
			
			                        <div class = "bottomWrap">
			                            <div class = "meet_info">
			                            	<c:if test = "${avo.user_cnt ne null}">
				                                <div class = "meet_member_info">
				                                    <span class = "member_cnt member_ment">${avo.user_cnt}명</span>
				                                    <span class = "member_ment">참여 중</span>
				                                </div>
			                                </c:if>
			                                
			                                <c:if test = "${avo.activity_age != 0}">
			                                	<!-- 조건있는 모임(조건없을 시 hide 클래스 추가) -->
				                                <div class = "meet_condition">
				                                    <img src = "/meet-a-bwa/resources/img/line.svg" alt = "line이미지" class = "divide">
				                                    <span class = "condition_bold condition_common"><b>모집</b></span>
				                                    <span class = "condition_regular condition_common">${avo.activity_age}대</span>
				                                </div>
			                                </c:if>
			                            </div>
			    
			                            <div class = "likeWrap">
			                                <section class = "heartSection" idx = "${avo.activity_no}">
			                                    <img src = "/meet-a-bwa/resources/img/heart-outlined.svg" alt = '라인하트이미지' class = "beforeLike_heart heartCommon"/>
			                                    <img src = "/meet-a-bwa/resources/img/heart-filled.svg" alt = '풀하트이미지' class = "afterLike_heart heartCommon blind"/>
			                                </section>
			                                <span class = "likeCnt">${avo.like_cnt}</span>
			                            </div>
			                        </div>
			                    </div>
			                    <!-- end content_list div -->
		                    </c:forEach>
	                    </c:if>
	                    <c:if test = "${a_list.size() == 0}">
	                    	<div class = "no-list-wrap">
	                    		<img class = "no-list-img" src = "/meet-a-bwa/resources/img/blue_warning.svg" alt = '파란 경고 이미지'/>
	                    		<p class = "no-list-txt">해당 카테고리와 관련된 액티비티가 존재하지 않습니다.</p>
	                    	</div>
	                    </c:if>
                </div>
    		</div>
    		<!-- END ACT recommend SECTION -->
    	</div>
    	<!-- end recommendAct -->
    </div>
    <!-- end contentWrap -->
    
     <!-- START LOGIN POPUP -->
        <c:choose>
	        <c:when test = "${login_result.login_result eq 'fail'}">
		        <div class="login-layer">
	        </c:when>
	        <c:when test = "${login_result.login_result eq null}">
		        <div class="login-layer blind">
	        </c:when>
        </c:choose>
	      <div class="login-popup-wrap">
		    <div class="login-top">
		        <img id="logo" src="resources/img/logo.svg" alt="login logo image" />
		    </div>
	
		    <div class="login-middle">
		      <form action="/meet-a-bwa/m_loginOK.do" class="login-form" method="post" id = "loginForm">
		        <label for="id">아이디</label>
		        <input type="text" id = "idInput" name = "id" placeholder="아이디 입력"/>
		
	            <label for="pw">비밀번호</label>
		        <input type="password" id = "pwInput" name = "pw" placeholder="비밀번호 입력"/>
		        
		        <input type="submit" onsubmit = "check_length();" value = "로그인">
		        <input type = "button" value = "창닫기" id = "login-popup-closeBtn">
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
            <img src="resources/img/worry.svg" alt="logout worry img"/>
            <h1>
              정말 로그아웃 <br />
              하시겠습니까?
            </h1>
      
            <div class="btn-group">
	            <a href = "/meet-a-bwa/logoutOK.do">
	              <button class="btn-logout">로그아웃</button>
	            </a>
              <button class="btn-cancel">취소</button>
            </div>
       	  </div>
        </div>
        <!-- END LOGOUT POPUP -->

</body>
</html>