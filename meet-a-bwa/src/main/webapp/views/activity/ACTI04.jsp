<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
   href="/meet-a-bwa/resources/css/common/common.css" />
<link rel="stylesheet"
   href="/meet-a-bwa/resources/css/common/header.css" />
<link rel="stylesheet"
   href="/meet-a-bwa/resources/css/common/searchBar.css" />
<link rel="stylesheet"
   href="/meet-a-bwa/resources/css/common/footer.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/bin-popup.css" />

<link rel="stylesheet"
   href="/meet-a-bwa/resources/css/activity/update.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>
 <script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
<script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/login.js"></script>
<script src="/meet-a-bwa/resources/js/common/logout.js"></script>

<script>
   function check() {
      let activity_name = $.trim($("#activity_name").val()).length;
      let activity_description = $.trim($("#activity_description").val()).length;
        let nop = $("#numberofpeople").val();

        if(activity_name>0&&activity_description>0&&nop!=0){
            let user_id = $("#id").val();
        } else {
         if (activity_name<=0||activity_description<=0||nop<=0) {
            $(".bin-popup").removeClass("blind");
            $(".ok").on("click", function(){
                 $(".bin-popup").addClass("blind");
            });
         } 
         return false;
      }
   }
</script>

<script src="/meet-a-bwa/resources/js/activity/update/age.js"></script>
<script src="/meet-a-bwa/resources/js/activity/update/region.js"></script>
<script src="/meet-a-bwa/resources/js/activity/update/interest.js"></script>
<script src="/meet-a-bwa/resources/js/activity/update/textCondition.js"></script>
<script src="/meet-a-bwa/resources/js/activity/update/profileImage.js"></script>
<script src="/meet-a-bwa/resources/js/activity/update/updateOK.js"></script>
<title>???????????? ??????</title>
</head>
<body>
   <!--  START HEADER INCLUDE -->
   <jsp:include page="/views/common/header.jsp"></jsp:include>
   <!--  END HEADER INCLUDE -->
   <div id="bodyWrap">
      <form action="/meet-a-bwa/a_updateOK.do" method="post"
         enctype="multipart/form-data" onsubmit="return check();">

         <div class="activityCUDWrap">
            <section class="blind">
               <label for="activity_no">activity_no:</label>${avo2.activity_no}<input
                  id="activity_no" name="activity_no" value="${avo2.activity_no}">
            </section>
            <h2 id="activityTitle">???????????? ??????</h2>
            <hr class="StartLine">
            <div id="img_la">
               <label for="img_header">????????? ??????</label>
            </div>
            <div id="imgWrap">
               <section class="img_body">
                  <div id="input-image">
                     <img src="${avo2.activity_image}" width=300px; height=200px;
                        id="image" name="image" />
                  </div>
                  <div class="img_btn_meet_activity">
                     <label class="input-file-btn" for="input-file"> <img
                        src="/meet-a-bwa/resources/img/imageAddBtn2.svg" width=70px;
                        height=70px;>
                     </label> <input type="file" name="upFile" id="input-file"
                        class="input-file">

                     <button type="button" id="delete-file2" value="??????">
                        <img src="/meet-a-bwa/resources/img/imageDropBtn2.svg"
                           width=70px; height=70px; alt="??????">
                     </button>
                  </div>
               </section>
            </div>
            <div id="namediv">
               <div id="nameLa">
                  <label>???????????? ??????</label>
               </div>
               <input type="text" placeholder="???????????? ????????? ??????????????????. (10??? ??????)"
                  id="activity_name" name="activity_name"
                  value="${avo2.activity_name}" />
               <p class="textCount_name blind">0???</p>
               <div id="toastWrap_name" class="hide">
                  <p class="toastText">???????????? ?????????????????????.</p>
               </div>
            </div>

            <section id="introducediv">
               <section id="introduceLa">
                  <label>???????????? ??????</label>
               </section>
               <section class="textLengthWrap">
                  <textarea rows="8" cols="36" maxlength="500"
                     placeholder="??????????????? ????????? ???????????? ??????????????????." id="activity_description"
                     name="activity_description" value="${avo2.activity_description}">${avo2.activity_description}</textarea>
                  <section class="textLength">
                     <p class="textCount">0???</p>
                     <p class="textTotal">/500???</p>
                  </section>
                  <!--textLength end-->
                  <div id="toastWrap_des" class="hide">
                     <p class="toastText">???????????? ?????????????????????.</p>
                  </div>
               </section>
               <!--textLengthWrap end-->
            </section>
            <!--introducediv end-->

            <div id="city_div">
               <div id="city_la">
                  <label>?????? ??????</label>
               </div>
               <select id="city" name='city' class="input"
                  value="${avo2.activity_city}">
                  <option class="city_list" value='${avo2.activity_city}'>${avo2.activity_city}</option>
                  <option class="city_list" value=''>???/??? ??????</option>
                  <option class="city_list" value='??????'>??????</option>
               </select> <select name='country' id="country" class=select
                  value="${avo2.activity_county}">
                  <option class="country_option" value='${avo2.activity_county}'>${avo2.activity_county}</option>
                  <option class="country_option" value=''>???/??? ??????</option>
                  <option class="country_option" value='??????'>??????</option>
               </select>
            </div>
            <!--citydiv end-->

            <div id="interestdiv">
               <div id="interestLa">
                  <label>?????? ????????????</label>
               </div>
               <select id="interest" value="${avo2.activity_interest_name}" name="interest">
                  <option value="${avo2.activity_interest_name}" class="interest_opt">${avo2.activity_interest_name}</option>
                  <option value="" class="interest_opt">??????</option>
               </select>
            </div>

            <div id="tagWrap">
               <input type="button" class="delete_interest interest_result blind">
            </div>

            <!--*************** ?????? ?????? ??????*************** -->
            <section class="conditionWrap">
               <section class="conditionHeader">
                  <hr class="conditionLine">
                  <h5>*????????? ????????? ???????????? ?????? ?????? ??????(??????,?????? ???, ?????????) ???????????? ???????????????.</h5>
               </section>
               <!--conditionHeader end-->
               <section class="conditionBody">
                  <section id="genderdiv">
                     <section id="genderLa">
                        <label>??????</label>
                     </section>
                     <select id="gender" value="${avo2.activity_gender}" name="gender">
                     <c:if test="${avo2.activity_gender ne '??????'}">
                        <option value="${avo2.activity_gender}">${avo2.activity_gender}</option>
                        </c:if>
                        <option value="??????">??????</option>
                        <option value="???">???</option>
                        <option value="???">???</option>
                     </select>
                  </section>
                  
                  <section id="nop">
                     <section id="nopLa">
                        <label>?????? ??? (????????????)</label>
                     </section>
                     <select id="numberofpeople" class="numberofpeople" name="nop" value="${avo2.activity_nop}">
                           <option value="${avo2.activity_nop}">${avo2.activity_nop}</option>
                           <option value="0">??????</option>
                           <c:forEach  var="i" begin="1" end="20">
                                <option>${i}</option>
                                 </c:forEach> 
                     </select>
                  </section>
                  
                  <section id="ageWrap">
                     <section id="ageHeader">
                        <label>?????????</label>
                     </section>
                     <select id="ageBody" class="ageBody" name="age" value="${avo2.activity_age}">
                        <c:if test="${avo2.activity_age ne 0}">
                        <option value="${avo2.activity_age}">${avo2.activity_age}<span>???</span></option>
                        </c:if>
                        <option value="0" class="age_bin_opt">??????</option>
                           <c:forEach var="i" begin="10" end="100" step="10">
                                <option><span>${i}</span><span>???</span></option>
                                </c:forEach> 
                     </select>
                     <div id="tagWrap_age">
                        <input type="button" class="delete_age age_result blind">
                     </div>
                  </section>
                  <!--ageWrap end-->
               </section>
               <!--conditionBody end-->
            </section>
            <!--conditionWrap end-->

            <!-- ************************************************************* -->
            <!-- ???????????? ???????????? ?????? ?????? -->
            <section class="blind">
               <label for="user_no">user_no:</label>
               <input type="text" id="user_no" name="user_no" value="${avo2.user_no}">
            </section>
            <section class="blind">
               <label for="meet_no">meet_no:</label>
               <input type="text" id="meet_no" name="meet_no" value="${avo2.meet_no }">
            </section>
            <!-- ************************************************************* -->

            
            <input type="submit" id="update_activity_information_btn"
               value="????????????????????????" />

         </div>

         <!--  START HEADER INCLUDE -->
         <jsp:include page="../../views/common/footer.jsp"></jsp:include>
         <!--  END HEADER INCLUDE -->
      </form>
   </div>
<!-- START LOGIN POPUP -->
<div class="login-layer blind">
   <div class="login-popup-wrap">
      <div class="login-top">
         <img id="logo" src="resources/img/logo.svg" alt="login logo image" />
      </div>

      <div class="login-middle">
         <form action="/meet-a-bwa/m_loginOK.do" class="login-form"
            method="post" id="loginForm">
            <label for="id">?????????</label> <input type="text" id="idInput"
               name="id" placeholder="????????? ??????" /> <label for="pw">????????????</label> <input
               type="password" id="pwInput" name="pw" placeholder="???????????? ??????" /> <input
               type="submit" onsubmit="check_length();" value="?????????"> <input
               type="button" value="?????????" id="login-popup-closeBtn">
         </form>

         <div class="login-bottom">
            <div>
               <a href="">ID ??????</a>
            </div>
            <div>
               <a href="">PW ??????</a>
            </div>
            <div>
               <a href="/meet-a-bwa/u_insert.do">????????????</a>
            </div>
         </div>
      </div>
   </div>
</div>
<!-- END LOGIN POPUP -->

<!-- START LOGOUT POPUP -->
<div class="logout-layer blind">
   <div class="logout-popup-wrap">
      <img src="resources/img/worry.svg" alt="logout worry img" />
      <h1>
         ?????? ???????????? <br /> ???????????????????
      </h1>

      <div class="btn-group">
         <a href="/meet-a-bwa/logoutOK.do">
            <button class="btn-logout">????????????</button>
         </a>
         <button class="btn-cancel">??????</button>
      </div>
   </div>
</div>
<!-- END LOGOUT POPUP -->
   <!-- ?????? -->
   <!-- not null -->
   <section class="bin-popup blind">
      <div class="modal-bg">
         <div class="modal-wrap">
            <div class="modal-content-wrap">
               <section class="modal-content-inner">
                  <section class="modal-content1">
                     <p class="bin_obj">??? ????????? ???????????????!</p>
                  </section>
                  <!--modal-content2-->
                  <section class="modal-content2">
                     <button class="ok">??????</button>
                  </section>
                  <!--modal-content3-->
               </section>
               <!--modal-content-inner end-->
            </div>
            <!--modal-content-wrap end-->
         </div>
         <!--modal-wrap end-->
      </div>
      <!--model-bg end-->
   </section>
   <!-- ????????? ?????? ?????? -->
   <section class="image-popup blind">
      <div class="modal-bg">
         <div class="modal-wrap">
            <div class="modal-content-wrap">
               <section class="modal-content-inner2">
                  <section class="modal-content1">
                     <p class="font">???????????? ?????????</p>
                     <p class="font">10KB ????????? ?????? ??????</p>
                  </section>
                  <!--modal-content2-->
                  <section class="modal-content3">
                     <button class="ok">??????</button>
                  </section>
                  <!--modal-content3-->
               </section>
               <!--modal-content-inner end-->
            </div>
            <!--modal-content-wrap end-->
         </div>
         <!--modal-wrap end-->
      </div>
      <!--model-bg end-->
   </section>
</body>
</html>