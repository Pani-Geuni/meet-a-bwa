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

<link rel="stylesheet" href="/meet-a-bwa/resources/css/meet/update.css" />

<script src="/meet-a-bwa/resources/js/common/jquery-3.6.1.min.js"></script>

<script src="/meet-a-bwa/resources/js/common/searchBar.js"></script>
<script src="/meet-a-bwa/resources/js/common/header.js"></script>
<script src="/meet-a-bwa/resources/js/common/jquery.cookie.js"></script>
<script src="/meet-a-bwa/resources/js/common/login.js"></script>
<script src="/meet-a-bwa/resources/js/common/logout.js"></script>


<script src="/meet-a-bwa/resources/js/meet/update/update.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/textCondition.js"></script>

<script src="/meet-a-bwa/resources/js/meet/update/region.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/interest.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/profileImage.js"></script>
<script src="/meet-a-bwa/resources/js/meet/update/age.js"></script>

<script>   
   $(function() {
      $("#update_meet_information_btn").submit(function(){
         let meet_name = $.trim($("#meet_name").val()).length;
         let meet_description = $.trim($("#meet_description").val()).length;
         let nop = $("#numberofpeople").val();
         
         if (meet_name > 0 && meet_description > 0 && nop != 0) {
            let user_id = $("#id").val();
         } else {
            if (meet_name <= 0 || meet_description <= 0 || nop <= 0) {
               $(".btn-popup").removeClass("blind");
               $(".ok").on("click", function() {
                  $(".bin-popup").addClass("blind")
               });
            }
            return false;
         }
      });
   });
</script>

<title>?????? ??????</title>
</head>
<body>

   <!--  START HEADER INCLUDE -->
   <jsp:include page="/views/common/header.jsp"></jsp:include>
   <!--  END HEADER INCLUDE -->
   <div id="bodyWrap">
   
   <form action="/meet-a-bwa/m_updateOK.do" method="post" enctype="multipart/form-data" onsubmit="return check();">

      <div class="meetingCUDWrap">
      <section class="blind">
               <label for="meet_no">meet_no:</label>${mvo2.meet_no}<input
                  id="meet_no" name="meet_no" value="${mvo2.meet_no}">
            </section>
         <h2 id="meetTitle">?????? ??????</h2>
         <hr class="StartLine">
         <div id="img_la">
         <label for="img_header">????????? ??????</label>
         </div>
         <div id="imgWrap">
            <section class="img_body">
            <div id="input-image">
            <img src="${mvo2.meet_image}" width=300px; height=200px; id="image" />
            </div>
            <div class="img_btn_meet_activity"> 
               <label class="input-file-btn" for="input-file">
                  <img src="/meet-a-bwa/resources/img//imageAddBtn2.svg" width=70px; height=70px;>
               </label>
               <input type="file" name="upFile" id="input-file" class="input-file">

               <button type="button" id="delete-file2" value="??????">
               <img src="/meet-a-bwa/resources/img/imageDropBtn2.svg" width=70px; height=70px; alt="??????">
               </button>
            </div>
            </section>
         </div>
         <div id="namediv">
            <div id="nameLa">
               <label>?????? ??????</label>
            </div> <input type="text" placeholder="??????????????? ??????????????????. (10??? ??????)" id="meet_name" name="meet_name" value="${mvo2.meet_name}" />
            <p class="textCount_name blind">0???</p>
            <div id = "toastWrap_name" class="hide">
               <p class="toastText">???????????? ?????????????????????.</p>
               </div>
         </div><!--namediv end-->
         
         <section id="introducediv">
            <section id="introduceLa"> <label>?????? ??????</label></section>
            <section class="textLengthWrap">
            <textarea rows="8" cols="36" placeholder="????????? ????????? ???????????? ??????????????????." id="meet_description"
               name="meet_description" value="${mvo2.meet_description}">${mvo2.meet_description}</textarea>
               <section class="textLength">
                  <p class="textCount">0???</p>
                  <p class="textTotal">/500???</p>
               </section><!--textLength end-->
               <div id = "toastWrap_des" class="hide">
                  <p class="toastText">???????????? ?????????????????????.</p>
                  </div>
            </section><!--textLengthWrap end-->
            </section> <!--introducediv end-->

         
            <div id="city_div">
               <div id="city_la">
                  <label>?????? ??????</label>
               </div>
               <select id="city" name='city' class="input" value="${mvo2.meet_city}">
                  <option class="city_list" value='${mvo2.meet_city}'>${mvo2.meet_city}</option>
                  <option class="city_list" value=''>???/??? ??????</option>
                  <option class="city_list" value='??????'>??????</option>
               </select> <select name='country' id="country" class=select value="${mvo2.meet_county}">
                  <option class="country_option" value='${mvo2.meet_county}'>${mvo2.meet_county}</option>
                  <option class="country_option" value=''>???/??? ??????</option>
                  <option class="country_option" value='??????'>??????</option>
               </select>
            </div>
            <!--citydiv end-->

            <div id="interestdiv">
               <div id="interestLa">
                  <label>?????? ????????????</label>
               </div>
               <select id="interest" name="interest" value="${mvo2.meet_interest_name}">
                  <option value="${mvo2.meet_interest_name}" class="interest_opt">${mvo2.meet_interest_name}</option>
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
            </section> <!--conditionHeader end-->
               <section class="conditionBody">
                  <section id="genderdiv">
                     <section id="genderLa">
                        <label>??????</label>
                     </section>
                     <select id="gender" name="gender" value="${mvo2.meet_gender}">
                     <c:if test="${mvo2.meet_gender ne '??????'}">
                        <option value="${mvo2.meet_gender}">${mvo2.meet_gender}</option>
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
                     <select id="numberofpeople" class="numberofpeople" name="nop" value="${mvo2.meet_nop}">
                        <option value="${mvo2.meet_nop}">${mvo2.meet_nop}</option>
                        <option value="0">??????</option>
                        <c:forEach var="i" begin="1" end="20">
                           <option>${i}</option>
                        </c:forEach>
                     </select>
                  </section>

                  <section id="ageWrap">
                     <section id="ageHeader">
                        <label>?????????</label>
                     </section>
                     <select id="ageBody" class="ageBody" name="age" value="${mvo2.meet_age}">
                        <c:if test="${mvo2.meet_age != 0}">
                        <option value="${mvo2.meet_age}">${mvo2.meet_age}<span>???</span></option>
                        </c:if>
                        <option value="0">??????</option>
                        <c:forEach var="i" begin="10" end="100" step="10">
                           <option><span>${i}</span><span>???</span></option>
                        </c:forEach>
                     </select>
                     <div id="tagWrap_age">
                        <input type="button" class=" delete_age age_result blind">
                     </div>
            </section><!--ageWrap end-->
            </section><!--conditionBody end-->
            </section> <!--conditionWrap end-->
   
            <section class="blind">
               <label for="meet_no">meet_no:</label>${mvo2.meet_no}<input
                  id="meet_no" name="meet_no" value="${mvo2.meet_no}">
            </section>
            
            <!-- ************************************************************* -->
            <!-- ???????????? ???????????? ?????? ?????? -->
            <section class="blind">
               <label for="user_no">user_no:</label>
               <input type="text" id="user_no" name="user_no" value="${mvo2.user_no}">
            </section>
            <!-- ************************************************************* -->
         <input type="submit" id="update_meet_information_btn" value="??????????????????" />

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
            <label for="id">?????????</label>
            <input type="text" id="idInput" name="id" placeholder="????????? ??????" /> 
            <label for="pw">????????????</label> 
            <input type="password" id="pwInput" name="pw" placeholder="???????????? ??????" /> 
            <input type="submit" onsubmit="check_length();" value="?????????"> 
            <input type="button" value="?????????" id="login-popup-closeBtn">
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