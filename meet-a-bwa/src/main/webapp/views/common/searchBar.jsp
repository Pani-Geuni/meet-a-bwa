<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- START SEARCH BAR SECTION-->
 <div id = "searchWrap">
     <div id = "searchBar">
         <select id = "category" class = "selectCommon">
             <option class = "optionCommon">모임</option>
             <option class = "optionCommon">액티비티</option>
         </select>
         <img src = "resources/img/line.svg" alt = "line 이미지" class = "line">
         <select id = "detailCategory" class = "selectCommon">
             <option class = "sample optionCommon"></option>
         </select>
         <img src = "resources/img/line.svg" alt = "line 이미지" class = "line">
         <img src = "resources/img/search.svg" alt = "search 이미지" id = "searchImg">
         <input type = "text" id = "searchWord" autocomplete = "off" placeholder="모임/액티비티 검색"/>
     </div>
 </div>
 <!-- END SEARCH BAR SECTION-->