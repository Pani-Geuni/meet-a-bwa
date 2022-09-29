<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<div class="meet-summary-info">
		<p>
			<a href="/meet-a-bwa/meet-member.do">멤버 ${ mvo3.user_cnt }명</a>
		</p>
		<p>리더 ${ mvo3.user_nickname }</p>
	</div>

	<div class="tagSection">
		<div class="loca_tag tag">
			<img src="/meet-a-bwa/resources/img/map.png" class="tag_img" /> <span
				class="location_name font_size_10">${ mvo3.meet_county }</span>
		</div>
		<div class="cate_tag tag">
			<span class="category_name font_size_10">${ mvo3.meet_interest_name }</span>
		</div>
	</div>

	<!-- 로그인 전 -->
	<!-- <button type="button" class="btn-meet join"> -->
	<c:choose>
		<c:when test="${ list.isLogin eq false || list.isLogin eq null }">
			<button type="button" class="btn-meet join">
				<a href="#">모임 가입하기</a>
			</button>
		</c:when>


		<c:when test="${list.isLogin eq true}">
			<button type="button" id="btn-meet-write" class="btn-meet" onclick="writePopupShow()" idx="${ mvo3.meet_no }">글쓰기</button>
			<button type="button" class="btn-meet">
				<a href="">액티비티 개설</a>
			</button>

			<a class="meet-detail-link" href="./meet-info-detail.html">모임 자세히
				보기</a>
		</c:when>
	</c:choose>
</aside>