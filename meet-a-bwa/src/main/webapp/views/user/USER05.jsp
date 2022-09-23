<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css"/>
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css"/>
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css"/>

<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/my-meet.css"/>

<title>나의 모임 리스트</title>
</head>
<body>

	<!--  START HEADER INCLUDE -->
	<jsp:include page="/views/common/header.jsp"></jsp:include>
	<!--  END HEADER INCLUDE -->

<section id="bodyWrap">
      <div id="contentWrap">
        <div class="mainContent">
          <h1 class="titleSection">나의 모임</h1>

          <div class="content_list">
            <!-- start content div-->
            <table>
              <tr>
                <td class="content_title">
                  <span class="meet-leader"><p>리더</p></span>경기 광주 평페달
                </td>
                <td rowspan="2" class="content_img">
                  <img src="/meet-a-bwa/resources/img/loopy.svg" class="list_img" />
                </td>
              </tr>
              <tr>
                <td class="content_description">
                  혼자 타도 좋고!! 같이 타면 더 좋다!! 경기도 광주 소개 자전거
                  모임입니다. 초보부터 중고수까지 솰라솰라
                </td>
              </tr>
              <tr>
                <td colspan="3">
                  <div class="tagSection">
                    <div class="loca_tag tag">
                      <img src="/meet-a-bwa/resources/img/map.png" class="tag_img" />
                      <span class="location_name font_size_10">경안동</span>
                    </div>
                    <div class="cate_tag tag">
                      <span class="category_name font_size_10">자전거</span>
                    </div>
                  </div>
                </td>
              </tr>
            </table>
            <div class="meet_info">
              <div class="meet_member_info">
                <span class="member_cnt member_ment">19명</span>
                <span class="member_ment">참여 중</span>
              </div>

              <!-- 조건있는 모임(조건없을 시 hide 클래스 추가) -->
              <div class="meet_condition">
                <img src="img/line.svg" class="divide" />
                <span class="condition_bold condition_common"><b>모집</b></span>
                <span class="condition_regular condition_common">20~30대</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
</body>
</html>