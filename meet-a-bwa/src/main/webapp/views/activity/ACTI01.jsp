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
    	        location.href = "/meet-a-bwa/a_selectOne.do?category="+category;
    	    });
    	    
    	    $("#recommend_list_wrap").on("click", ".content_list.activity-list", function(){
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
                	
                </div>
    		</div>
    		<!-- END RECOMMEND ACT SECTION -->
    	</div>
    </div>

</body>
</html>