<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css" />
	
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/meet-detail.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/feed.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/meet-info.css" />
	
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
	<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />
	
	<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
	<script src="/meet-a-bwa/resources/js/common/header.js"></script>
	<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
	
	<script src="/meet-a-bwa/resources/js/meet/meet-detail.js"></script>
	<script src="/meet-a-bwa/resources/js/meet/meet-member-list.js"></script>
	<title>모임 자세히 보기</title>
</head>
<body>

	<!--  START HEADER INCLUDE -->
	<jsp:include page="../../views/common/header.jsp">
		<jsp:param name="list" value="${list}" />
	</jsp:include>
	
	<div id="bodyWrap">
		<div id="contentWrapRow">
			<jsp:include page="../../views/common/meetLeftSideBar.jsp"></jsp:include>
			
			
			<section class="meet-info-wrap">
						<div class="meet-info-top">
							<h1 class="meet-info-title">모임소개</h1>
							<c:if test="${ mvo3.user_no eq list.user_no }">
							<button class="btn-meet-info-edit"></button>
							<button class="btn-meet-info-remove"></button>
							</c:if>
						</div>

						<div class="meet-info-tag">
							<h3>모임 정보</h3>
							<div class="tagSection">
								<c:if test="${ mvo3.meet_county ne null }">
									<div class="loca_tag tag">
										<img src="/meet-a-bwa/resources/img/map.png" class="tag_img" />
										<span class="location_name font_size_10">${ mvo3.meet_county }</span>
									</div>
								</c:if>
								<c:if test="${ mvo3.meet_interest_name ne null }">
									<div class="cate_tag tag">
										<span class="category_name font_size_10">${ mvo3.meet_interest_name }</span>
									</div>
								</c:if>
							</div>
						</div>

						<div class="meet-info-content">
							<pre>${ mvo3.meet_description }</pre>
						</div>

						<div class="meet-info-detail">
							<h3>모임 정보</h3>
							<div>
								<p>모임 개설일</p>
								<span>${ mvo3.meet_date }</span>
							</div>
							<div>
								<p>멤버 수</p>
								<span>${ mvo3.user_cnt }명</span>
							</div>
						</div>
					</section>
		</div>
	</div>
</body>
</html>