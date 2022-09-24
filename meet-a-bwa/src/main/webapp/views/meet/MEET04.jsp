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
<title>모임 멤버 리스트</title>
</head>
<body>

	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp"></jsp:include>
	<!--  END HEADER INCLUDE -->
	
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
						<a href="./act-detail-member.html">멤버 22명</a>
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
				<button type="button" class="btn-meet join" onclick="popupShow()">
					글쓰기</button>
				<!-- <input type="button" onclick="popupShow()" value="글쓰기" /> -->
				<button type="button" class="btn-meet join">
					<a href="">액티비티 개설</a>
				</button>

				<!-- <button type="button" class="btn-meet wirte">
            			<a href="#">글 쓰기</a>
          		</button> -->

				<a class="meet-detail-link" href="./meet-info-detail.html">모임
					자세히 보기</a>
			</aside>
			
			<section class="feedWrap feed-member-list">
	          <div class="member-list-title">
	            <h1>멤버</h1>
	            <p id="all-member-count">3</p>
	          </div>
	          <div class="meet-member-list">
	            <ul>
	              <li>
	                <div class="feed-profile member-list">
	                  <div>
	                    <img src="/meet-a-bwa/resources/img/loopy.svg" alt="" />
	                  </div>
	                  <p class="user-nickname">팡팡팡</p>
	                  <span class="meet-user leader">리더</span>
	                  <p></p>
	                </div>
	              </li>
	              <li>
	                <div class="feed-profile member-list">
	                  <div>
	                    <img src="/meet-a-bwa/resources/img/loopy.svg" alt="" />
	                  </div>
	                  <p class="user-nickname">팡팡팡</p>
	                  <span class="meet-user operator">운영자</span>
	                  <p></p>
	                </div>
	              </li>
	              <li>
	                <div class="feed-profile member-list">
	                  <div>
	                    <img src="/meet-a-bwa/resources/img/loopy.svg" alt="" />
	                  </div>
	                  <p class="user-nickname">팡팡팡</p>
	                  <span class="meet-user"></span>
	                </div>
	              </li>
	            </ul>
	          </div>
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
	              <p><a href="#">+</a></p>
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
	<!-- END bodyWrap  -->
</body>
</html>