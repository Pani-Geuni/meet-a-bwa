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
<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-detail.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/post-delete.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
<script src="/meet-a-bwa/resources/js/meet/select-list.js"></script>
<script src="/meet-a-bwa/resources/js/meet/delete-popup.js"></script>
<title>게시글 상세 페이지</title>
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
			
			<section class="post-detail">
          <div class="post-detail-top">
            <h1 class="post-detail-title" id="post-detail-title">
              게시글 제목입니당
            </h1>
            <div class="post-user-info">
              <div class="user-info">
                <div class="user-info-profile">
                  <img src="/meet-a-bwa/resources/img/loopy.svg" alt="프로필 이미지" />
                </div>
                <p class="user-nickname">팡팡팡</p>
                <p class="write-date">2022.09.12</p>
              </div>
              <div class="post-more-select">
              	<img class="img-more" src="/meet-a-bwa/resources/img/more.svg" alt="" />
              		<ul class="post-option-list">
              			<li class="post-option-item">수정하기</li>
              			<li class="post-option-item" data-popup-open="delete">삭제하기</li>
					</ul>
			  </div>
            </div>
          </div>

          <pre class="post-detail-content">
게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 
게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글
내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용
게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글
내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용
게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용 ㅁㄴㅇ
내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용 게시글 내용
asdfasd
asdfasd
asdfㄹ
          </pre>

          <div class="coment-wrap">
            <form action="#" class="form-comment">
              <textarea placeholder="댓글을 남겨주세요."></textarea>
              <button type="submit">등록</button>
            </form>

            <div class="user-comments">
              <div class="user-comment">
                <div class="comment-user-info">
                  <div class="comment-user-info-profile">
                    <img src="/meet-a-bwa/resources/img/loopy.svg" alt="프로필 이미지" />
                  </div>
                  <p class="comment-user-nickname">트루</p>
                  <p class="comment-write-date">2022.09.12</p>
                </div>
                <pre class="post-detail-comment">
댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글</pre
                >
              </div>
            </div>
            <div class="user-comments">
              <div class="user-comment">
                <div class="comment-user-info">
                  <div class="comment-user-info-profile">
                    <img src="/meet-a-bwa/resources/img/loopy.svg" alt="프로필 이미지" />
                  </div>
                  <p class="comment-user-nickname">옌두목</p>
                  <p class="comment-write-date">2022.09.12</p>
                </div>
                <pre class="post-detail-comment">
댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글</pre
                >
              </div>
            </div>
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
</body>
<!-- *******************  -->
<!-- delete popup SECTION -->
<!-- *******************  -->
  <div class="logout-popup-layer" data-popup="delete">
    <div class="logout-popup-wrap">
      <img src="/meet-a-bwa/resources/img/worry.svg" alt="" />
      <h1>정말 삭제 하시겠습니까?</h1>

      <div class="btn-group">
        <button class="btn-logout" data-popup-close="delete">삭제</button>
        <button class="btn-cancel" data-popup-close="delete">취소</button>
      </div>
    </div>
  </div>
</html>