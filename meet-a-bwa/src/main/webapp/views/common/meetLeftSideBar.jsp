<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<aside class="meet-detail-aside">
	<div class="meet-profile-img">
		<img src="/meet-a-bwa/resources/img/sample/sample-img-01.png"
			alt="샘플 대표 이미지" />
	</div>
	<div class="meet-detail-aside-top">
		<h1 class="meet-deatil-aside-title">${ mvo3.meet_name }</h1>
		<div class="heart-common">
			<img class="img-heart-filled"
				src="/meet-a-bwa/resources/img/heart-filled.svg" alt="좋아요 이미지" /> <img
				class="img-heart-outlined blind"
				src="/meet-a-bwa/resources/img/heart-outlined.svg" alt="좋아요 테두리 이미지" />
			<span>${ mvo3.like_cnt }</span>
		</div>
	</div>
	<div class="meet-summary-info" idx="${ mvo3.meet_no }">
		<p class="meet-member-info">멤버 ${ mvo3.user_cnt }명</p>
		<p>리더 ${ mvo3.user_nickname }</p>
	</div>

	<div class="tagSection">
		<c:if test="${ mvo3.meet_county ne null }">
			<div class="loca_tag tag">
				<img src="/meet-a-bwa/resources/img/map.png" class="tag_img" /> 
				<span class="location_name font_size_10">${ mvo3.meet_county }</span>
			</div>
		</c:if>
		
	 	<c:if test="${mvo3.meet_interest_name }">
			<div class="cate_tag tag">
				<span class="category_name font_size_10">${ mvo3.meet_interest_name }</span>
			</div>
		</c:if>
	</div>

	<!-- 로그인 전 혹은 가입 전-->
	<!-- <button type="button" class="btn-meet join"> -->
	<c:choose>
		<c:when test="${ (list.isLogin eq false || list.isLogin eq null) || (not fn:containsIgnoreCase(m_list, list.user_no)) }">
			<button type="button" class="btn-meet join">
				<a href="#">모임 가입하기</a>
			</button>
		</c:when>


		<c:when test="${list.isLogin eq true}">
			<button type="button" id="btn-meet-write" class="btn-meet" onclick="writePopupShow()" idx="${ mvo3.meet_no }">글쓰기</button>
			<button type="button" id="btn-activity-create" class="btn-meet" idx="${ mvo3.meet_no }">액티비티 개설</button>

			<p class="meet-detail-link" idx="${ mvo3.meet_no }">모임 자세히 보기</p>
		</c:when>
	</c:choose>
</aside>