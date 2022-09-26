<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
	
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/searchBar.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css"/>
    
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css"/>
    <link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css"/>
    
    <script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
    <script>
    	$(function(){
    		var member_id = '${member_id}'; 

    		if(member_id == ''){
	    		$.ajax({
	    			url : "/meet-a-bwa/main_init.do",
	    			type : "POST",
	    			dataType : 'json',
	    			data : {
	    				isLogin : $.cookie('isLogin') == "" ? false : $.cookie('isLogin'), // 추후에 쿠키로 값 가져올거임
	    				userInterest : $.cookie('userInterest'),
	    				userRegion : $.cookie('userRegion')
	    			},
	    			success : function(result) {
	    	            load_meet(result);
	    			},
	    			error : function(error) {
	    			 	console.log(error);
	    			 }
	    		});
   			}
	    		
    	    $("#plusImg").click(function(){
    	        $("#fold_tag").removeClass("blind");
    	        $(this).addClass("blind");
    	        $("#foldImg").removeClass("blind");
    	    });
    	    
    	    $("#foldImg").click(function(){
    	        $("#fold_tag").addClass("blind");
    	        $(this).addClass("blind");
    	        $("#plusImg").removeClass("blind");
    	    });
	
    	    $(".tagItem").click(function(e){
    	        $(".tagItem").removeClass("check");
    	        $(e.target).addClass("check");
    	    })
    	    
    	 	$(".btn-cancel").click(function(){
    	 		$(".logout-layer").addClass("blind");
    	 	});
	    	    
    	    function load_meet(res){
    	        for(var i = 0; i < res.list_length; i++){
    	            let sample = $(".content_list_sample").clone();

    	            sample.removeClass("content_list_sample");
    	            sample.removeClass("blind");
    	            sample.find(".content_title").text(res.list[i].meet_name);
    	            sample.find(".content_description").text(res.list[i].meet_description);
    	            /* prop-flag */
    	            sample.find(".likeCnt").attr("likeCnt", res.list[i].like_cnt);
    	            
    	            if(res.list[i].like_cnt < 100){
    	            	sample.find(".likeCnt").text(res.list[i].like_cnt);
    	        	}
    				else
    	        		sample.find(".likeCnt").text("99+");
    					
    	            $("#meet_recommendSection").append(sample);
    	        }

    	    }
    	});
    </script>
    <script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
    <script src="/meet-a-bwa/resources/js/common/header.js"></script>
    <script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
<!--     <script src="/meet-a-bwa/resources/js/main/main.js"></script> -->

	<title>밋:어봐</title>
</head>
<body>
    <!--  START HEADER INCLUDE -->
	<jsp:include page="../../views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>
    <!--  END HEADER INCLUDE -->
	
	<div id = "bodyWrap">
    	<!--  START SEARCHBAR INCLUDE -->
		<jsp:include page="../../views/common/searchBar.jsp"></jsp:include>
    	<!--  END SEARCHBAR INCLUDE -->
    	

        <!-- START contentWrap-->
        <div id = "contentWrap">
            <!-- 모임 추천-->
            <div id = "recommendMeet" class = "mainContent">
                <div class = "titleSection">
                    <section class = "title titleLeft">
						<c:choose>
							<c:when test="${list.isLogin eq false || list.isLogin eq null}">
	                        	<!-- 로그인 전, 추천-->
		                        <section id = "beforeLogin_recommend">
		                            <span class = "comment">안녕하세요! 현재 가장 인기있는 모임 추천해드려요!</span>
		                        </section>
	                        </c:when>

							<c:when test="${list.isLogin eq true}">
		                        <!-- 로그인 성공 후, 추천 -->
		                        <section id = "afterLogin_recommend">
		                            <span id = "nickname">"${list.nick_name}님"의  </span>
		                            
		                            <c:if test="${list.interest == null}">
		                            	<!-- 회원이 설정한 관심사 없을 때,-->
			                            <span class = "region_comment comment">거주지 주변 모임 추천해드려요!</span>
		                            </c:if>
		                            
		                            <c:if test="${list.interest ne null}">
			                            <!-- 회원이 설정한 관심사 있을 때,-->
			                            <span class = "interest_comment comment">관심사와 관련된 모임 추천해드려요!</span>
		                            </c:if>
		                        </section>
							</c:when>
						</c:choose>
                    </section>

                    <section class = "title titleRight">
                        <span id = "plusBtn_meet" class = "plusBtn">+더보기</span>
                    </section>
                </div>
                
                <!-- START Meet RECOMMEND SECTION -->
                <div id = "meet_recommendSection">
                
                	<c:forEach var="mvo" items="${m_list}">
	                    <!-- start content_list div-->
	                    <div class = "content_list content_list_sample blind">
	                        <div class = "info-list-wrap">
	                            <div class = "listCommon">
	                                <span class = "content_title">경기 광주 다이어트${mvo.meet_name}</span>
	                            </div>
	
	                            <div class = "description_list listCommon">
	                                <span class = "content_description">
	                                    혼자 타도 좋고!! 같이 타면 더 좋다!! 경기도 광주 소개 자전거 모임입니다. 초보부터 중고수까지 솰라솰라
	                                    혼자 타도 좋고!! 같이 타면 더 좋다!! 경기도 광주 소개 자전거 모임입니다. 초보부터 중고수까지 솰라솰라
	                                </span>
	                            </div>
	
	                            <div class = "listCommon">
	                                <div class = "tagSection">
	                                    <div class = "loca_tag tag">
	                                        <img src = "/meet-a-bwa/resources/img/map.png" class = "tag_img">
	                                        <span class = "location_name font_size_10">경안동</span>
	                                    </div>
	                                    <div class = "cate_tag tag">
	                                        <span class = "category_name font_size_10">자전거</span>
	                                    </div>
	                                </div>
	                            </div>
	
	                            <div class = "content_img">
	                                <img src = "/meet-a-bwa/resources/img/loopy.svg" class = "list_img">
	                            </div>
	                        </div>
	
	
	                        <div class = "bottomWrap">
	                            <div class = "meet_info">
	                                <div class = "meet_member_info">
	                                    <span class = "member_cnt member_ment">19명</span>
	                                    <span class = "member_ment">참여 중</span>
	                                </div>
	                                
	                                <!-- 조건있는 모임(조건없을 시 hide 클래스 추가) -->
	                                <div class = "meet_condition">
	                                    <img src = "/meet-a-bwa/resources/img/line.svg" alt = "line이미지" class = "divide">
	                                    <span class = "condition_bold condition_common"><b>모집</b></span>
	                                    <span class = "condition_regular condition_common">20~30대</span>
	                                </div>
	                            </div>
	    
	                            <div class = "likeWrap">
	                                <section class = "heartSection">
	                                    <img src = "/meet-a-bwa/resources/img/heart-outlined.svg" alt = '라인하트이미지' class = "beforeLike_heart heartCommon"/>
	                                    <img src = "/meet-a-bwa/resources/img/heart-filled.svg" alt = '풀하트이미지' class = "afterLike_heart heartCommon blind"/>
	                                </section>
	                                <span class = "likeCnt"></span>
	                            </div>
	                        </div>
	                    </div>
	                    <!-- end content_list div -->
                	</c:forEach>
                </div>
                <!-- end Meet RECOMMEND SECTION -->
            </div>
            <!-- end Meet RECOMMEND -->

            
            <!-- 액티비티 추천-->
            <div id = "recommendAct" class = "mainContent">
                <div class = "titleSection">
                    <section class = "title titleLeft">
                        <section id = "beforeLogin_recommend" class = "">
                            <span class = "comment">어떤 액티비티에 관심있으신가요?</span>
                        </section>
                    </section>

                    <section class = "title titleRight">
                        <span id = "plusBtn_act" class = "plusBtn">+더보기</span>
                    </section>
                </div>
                
                <div id = "act_recommendSection">
                    
                    <!-- 액티비티 태그 SECTION-->
                    <div id = "cate_tag_section">
                        <div id = "unfold_tag">
                            <span class = "tagItem check">전체</span>
                            <span class = "tagItem">취미</span>
                            <span class = "tagItem">팬클럽</span>
                            <span class = "tagItem">방송/연예</span>
                            <span class = "tagItem">스포츠/레저</span>
                            <span class = "tagItem">게임</span>
                            <span class = "tagItem">만화/애니메이션</span>
                            <span class = "tagItem">맛집/요리</span>
                            <span class = "tagItem">생활정보/인테리어</span>
                            <span class = "tag_plus">
                                <img src = "resources/img/더보기.svg" alt = "더보기 이미지" id = "plusImg">
                                <img src = "resources/img/fold.svg" alt = "접기 이미지" id = "foldImg" class = "blind">
                            </span>
                        </div>
                        <div id = "fold_tag" class = "blind">
                            <ul id = "tagUl">
                                <li class = "tag_li">
                                    <span class = "tagItem">건강/다이어트</span>
                                    <span class = "tagItem">패션/뷰티</span>
                                    <span class = "tagItem">여행/캠핑</span>
                                    <span class = "tagItem">반려동물/동물</span>
                                    <span class = "tagItem">문화/예술</span>
                                    <span class = "tagItem">음악</span>
                                    <span class = "tagItem">어학/외국어</span>
                                    <span class = "tagItem">취업/자격증</span>
                                </li>
                                <li class = "tag_li">
                                    <span class = "tagItem">교육/공부</span>
                                    <span class = "tagItem">어학/외국어</span>
                                    <span class = "tagItem">IT/컴퓨터</span>
                                    <span class = "tagItem">인문/과학</span>
                                    <span class = "tagItem">경제/재테크</span>
                                    <span class = "tagItem">종교/봉사</span>
                                    <span class = "tagItem">일상/이야기</span>
                                    <span class = "tagItem">나이/또래모임</span>
                                </li>
                                <li class = "tag_li">
                                    <span class = "tagItem">친목/모임</span>
                                    <span class = "tagItem">자연/귀농</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                    
                    
                    <div class = "content_list blind">
                        <div class = "info-list-wrap">
                            <div class = "listCommon">
                                <span class = "content_title">경기 광주 다이어트</span>
                            </div>

                            <div class = "description_list listCommon">
                                <span class = "content_description">
                                    혼자 타도 좋고!! 같이 타면 더 좋다!! 경기도 광주 소개 자전거 모임입니다. 초보부터 중고수까지 솰라솰라
                                    혼자 타도 좋고!! 같이 타면 더 좋다!! 경기도 광주 소개 자전거 모임입니다. 초보부터 중고수까지 솰라솰라
                                </span>
                            </div>

                            <div class = "listCommon">
                                <div class = "tagSection">
                                    <div class = "loca_tag tag">
                                        <img src = "/meet-a-bwa/resources/img/map.png" class = "tag_img">
                                        <span class = "location_name font_size_10">경안동</span>
                                    </div>
                                    <div class = "cate_tag tag">
                                        <span class = "category_name font_size_10">자전거</span>
                                    </div>
                                </div>
                            </div>

                            <div class = "content_img">
                                <img src = "/meet-a-bwa/resources/img/loopy.svg" class = "list_img">
                            </div>
                        </div>


                        <div class = "bottomWrap">
                            <div class = "meet_info">
                                <div class = "meet_member_info">
                                    <span class = "member_cnt member_ment">19명</span>
                                    <span class = "member_ment">참여 중</span>
                                </div>
                                
                                <!-- 조건있는 모임(조건없을 시 hide 클래스 추가) -->
                                <div class = "meet_condition">
                                    <img src = "/meet-a-bwa/resources/img/line.svg" alt = "line이미지" class = "divide">
                                    <span class = "condition_bold condition_common"><b>모집</b></span>
                                    <span class = "condition_regular condition_common">20~30대</span>
                                </div>
                            </div>
    
                            <div class = "likeWrap">
                                <section class = "heartSection">
                                    <img src = "/meet-a-bwa/resources/img/heart-outlined.svg" alt = '라인하트이미지' class = "beforeLike_heart heartCommon"/>
                                    <img src = "/meet-a-bwa/resources/img/heart-filled.svg" alt = '풀하트이미지' class = "afterLike_heart heartCommon blind"/>
                                </section>
                                <span class = "likeCnt">
                                    0
                                </span>
                            </div>
                        </div>
                    </div>
                    <!-- end content_list div -->

                </div>
                <!-- end act recommend section -->
            </div>
            <!-- end recommendAct -->
        </div>
        <!-- end contentWrap -->
        
        <!-- START LOGIN POPUP -->
        <div class="login-layer blind">
	      <div class="login-popup-wrap">
		    <div class="login-top">
		      <a href="">
		        <img id="logo" src="resources/img/logo.svg" alt="login logo image" />
		      </a>
		    </div>
	
		    <div class="login-middle">
		      <form action="/meet-a-bwa/m_loginOK.do" class="login-form" method="post">
		        <label for="id">아이디</label>
		        <input type="text" name = "id" placeholder="아이디 입력"/>
		
	            <label for="pw">비밀번호</label>
		        <input type="password" name = "pw" placeholder="비밀번호 입력"/>
		        
		        <button type="submit">로그인</button>
		      </form>
		
	        <div class="login-bottom">
		        <div>
		          <a href="">ID 찾기</a>
		        </div>
		        <div>
		          <a href="">PW 찾기</a>
	            </div>
	           	<div>
		          <a href="">회원가입</a>
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
        
        
    
        <!--  START HEADER INCLUDE -->
			<jsp:include page="../../views/common/footer.jsp"></jsp:include>
	    <!--  END HEADER INCLUDE -->
    </div>
</body>
</html>