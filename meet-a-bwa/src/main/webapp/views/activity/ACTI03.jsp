<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/common.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/header.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/searchBar.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/common/footer.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/main/main.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/login.css" />
<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/logout.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/user/bin-popup.css" />

<link rel="stylesheet" href="/meet-a-bwa/resources/css/activity/create.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>

<script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
<script src="/meet-a-bwa/resources/js/common/login.js"></script>
<script src="/meet-a-bwa/resources/js/common/logout.js"></script>
   

<script src="/meet-a-bwa/resources/js/activity/create/create.js"></script>
<script src="/meet-a-bwa/resources/js/activity/create/textCondition.js"></script>
<script>
   function check() {
      let activity_name = $.trim($("#activity_name").val()).length;
      let activity_description = $.trim($("#activity_description").val()).length;
      let nop = $("#numberofpeople").val();
   
   
      if (activity_name > 0 && activity_description > 0 && nop != 0) {
         let user_id = $("#id").val();
      } else {
         if (activity_name <= 0 || activity_description <= 0 || nop <= 0) {
   
            $(".bin-popup").removeClass("blind");
            $(".ok").on("click", function() {
               $(".bin-popup").addClass("blind");
            });
         }
         return false;
      }
   }
</script>


<title>???????????? ??????</title>
</head>
<body>
   <!--  START HEADER INCLUDE -->
   <jsp:include page="../../views/common/header.jsp">
      <jsp:param name="list" value="${list}" />
   </jsp:include>
   
   <!--  END HEADER INCLUDE -->
   <div id="bodyWrap">
      <!-- <div class="innerBodyWrap"> -->
        <form class="innerBodyWrap" name="activity_create_form" action="/meet-a-bwa/a_insertOK.do" method="post"
         enctype="multipart/form-data" onsubmit="return check();">
         <div class="activityCUDWrap">
            <h2 id="activityTitle">???????????? ??????</h2>
            <hr class="StartLine">
            <div id="img_la">
               <label for="img_header">????????? ??????</label>
            </div>
            <div id="imgWrap">
               <section class="img_body">
                  <div id="input-image">
                     <img src="/meet-a-bwa/resources/img/default-image2.png"
                        width=300px; height=200px; id="image" name="image"/>
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
                  id="activity_name" name="activity_name" value="" />
               <p class="textCount_name blind">0???</p>
               <div id="toastWrap_name" class="hide">
                  <p class="toastText">???????????? ?????????????????????.</p>
               </div>
            </div>
            <!--namediv end-->

            <section id="introducediv">
               <section id="introduceLa">
                  <label>???????????? ??????</label>
               </section>
               <section class="textLengthWrap">
                  <textarea rows="8" cols="36" placeholder="??????????????? ????????? ???????????? ??????????????????."
                     id="activity_description" name="activity_description"></textarea>
                  <!-- maxlength="500" -->
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
               <select id="city" name='city' class="input">
                  <option class="city_list" value=''>???/??? ??????</option>
                  <option class="city_list" value='??????'>??????</option>
               </select> <select name='country' id="country" class=select>
                  <option class="country_option" value=''>???/??? ??????</option>
                  <option class="country_option" value='??????'>??????</option>
               </select>
            </div>
            <!--citydiv end-->

            <div id="interestdiv">
               <div id="interestLa">
                  <label>?????? ????????????</label>
               </div>
               <select id="interest" name="interest">
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
                  <h5>* ??????????????? ????????? ???????????? ?????? ?????? ??????(??????,?????? ???, ?????????) ???????????? ???????????????.</h5>
               </section>
               <!--conditionHeader end-->
               <section class="conditionBody">
                  <section id="genderdiv">
                     <section id="genderLa">
                        <label>??????</label>
                     </section>
                     <select id="gender" name="gender">
                        <option value="??????">??????</option>
                        <option value="???">???</option>
                        <option value="???">???</option>
                     </select>
                  </section>
                  
                  <section id="nop">
                     <section id="nopLa">
                        <label>?????? ??? (????????????)</label>
                     </section>
                     <select id="numberofpeople" class="numberofpeople" name="nop">
                        <!-- <optgroup id="num">
                           <option value="0">??????</option>
                        </optgroup> -->
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
                     <select id="ageBody" class="ageBody" name="age">
                           <option value="0">??????</option>
                           <c:forEach  var="i" begin="10" end="100" step="10">
                                <option><span>${i}</span><span>???</span></option>
                                </c:forEach> 
                     </select>
                     <div id="tagWrap_age">
                        <input type="button" class=" delete_age age_result blind">
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
               <input type="text" id="user_no" name="user_no" value="${avo.user_no}">
            </section>
            <section class="blind">
               <label for="meet_no">meet_no:</label>
               <input type="text" id="meet_no" name="meet_no" value="${ avo.meet_no }">
            </section>
            <!-- ************************************************************* -->

            <input type="submit" id="create_activity" value="???????????? ??????" />
         

         </div>

         <!--  START HEADER INCLUDE -->
         <jsp:include page="../../views/common/footer.jsp"></jsp:include>
         <!--  END HEADER INCLUDE -->
      </form> <!-- innerBodyWrap end -->
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